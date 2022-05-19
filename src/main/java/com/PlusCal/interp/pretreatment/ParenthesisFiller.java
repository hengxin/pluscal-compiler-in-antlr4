package com.PlusCal.interp.pretreatment;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

import static com.PlusCal.parser.PlusCalParser.*;

final class ParenthesisFiller {
    private Token lastDetected, current;
    private boolean allowAlignment;
    private Stack<Alignment> alignments;
    private Stack<Token> leftDelimiters;
    private final TokenStreamRewriter rewriter;

    ParenthesisFiller(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    public void exec(ExprContext expr) {
        if (expr.exception != null) throw expr.exception;
        begin();
        try {
            detect(expr);
        }
        finally {
            end();
        }
    }

    private void begin() {
        lastDetected = null;
        current = null;
        allowAlignment = false;
        alignments = new Stack<>();
        leftDelimiters = new Stack<>();
    }

    private void detect(ParseTree ctx) {
       if (!(ctx instanceof TerminalNode)) {
           if (ctx instanceof ParserRuleContext) {
               RecognitionException e;
               if ((e = ((ParserRuleContext) ctx).exception) != null)
                   throw e;
           }
           if (ctx instanceof ExprContext
                   && isPossibleIndentationToken(firstToken(ctx)))
                   allowAlignment = true;
           for (int i = 0; i < ctx.getChildCount(); i++) {
               detect(ctx.getChild(i));
           }
       }
       else {
           if (ctx instanceof ErrorNode)
               throw new RuntimeException();
           detect(((TerminalNode) ctx).getSymbol());
       }
    }

    private static Token firstToken(ParseTree tree) {
        if (tree instanceof TerminalNode) return ((TerminalNode) tree).getSymbol();
        else if (tree instanceof ParserRuleContext) return ((ParserRuleContext) tree).start;
        else return null;
    }

    private static boolean isPossibleIndentationToken(Token token) {
        return token.getType() == Conjunction || token.getType() == Disjunction;
    }

    private void detect(Token token) {
        current = token;
        // processed only when alignment is allowed
        if (!allowAlignment) {
            lastDetected = current;
            return;
        }
        /*
         * A list beginning from column c is ended by ant one of the following cases:
         *  1. Another /\ or \/ in column c and is the first non-space character on the line;
         *  2. A right delimiter whose left counterpart occurs before the beginning of the list;
         *  3. Any non-space character in column c or a column left to the column c.
         */
        switch (token.getType()) {
            case LeftParen:
            case LeftBack:
            case LeftBrace:
            {
                leftDelimiters.push(token);
            }
                break;
            case RightParen:
            case RightBack:
            case RightBrace:
            {
                Token t = leftDelimiters.pop();
                assert paired(t.getType(), token.getType());

                Token junction = alignments.peek().first();
                if (t.getTokenIndex() < junction.getTokenIndex()) {
                    endMatchDelimiter(t);
                }
            }
                break;

            case Conjunction:
            case Disjunction:
            {

                if (alignments.isEmpty()) {
                    alignments.push(new Alignment(token));
                } else {
                    Alignment a = alignments.peek();
                    Token t = a.last();
                    int column = token.getCharPositionInLine() - t.getCharPositionInLine();;
                    if (t.getLine() == token.getLine() || column > 0) {
                        alignments.push(new Alignment(token));
                    }
                    else {
                        endMatchJunction(token);
                    }

                }

                break;
            }
            default:
            {
                Token junction = alignments.peek().last();
                if (token.getLine() > lastDetected.getLine()
                        && token.getCharPositionInLine() < junction.getCharPositionInLine()) {
                    endMatchLeftMore(token);
                }
            }
            break;
        }
        lastDetected = token;
        if (alignments.isEmpty()) allowAlignment = false;
    }

    /**
     * end the conjunction/disjunction from begin to end
     * @param begin the beginning token of the conjunction/disjunction
     * @param end the last token of the conjunction/disjunction
     */
    private void endJunction(Token begin, Token end) {
        assert isPossibleIndentationToken(begin);
        rewriter.insertAfter(begin, "(");
        rewriter.insertAfter(end, ")");
    }

    /**
     * end the conjunction/disjunction list from begin to end
     * @param begin the beginning token of the conjunction/disjunction
     * @param end the last token of the conjunction/disjunction
     */
    private void endJunctionList(Token begin, Token end) {
        assert isPossibleIndentationToken(begin);
//        rewriter.insertAfter(begin, "(");
//        rewriter.insertAfter(end, ")");
        rewriter.delete(begin);
    }

    /**
     * end the junction list when match a non-space character
     * left or at the column
     * @param endToken the token that causes the end of the junction list
     */
    private void endMatchLeftMore(Token endToken) {
        int rightBound = endToken.getCharPositionInLine();
        Alignment a;
        while (!alignments.isEmpty()) {
            if ((a = alignments.pop()).charPositionInLine < rightBound) {
                alignments.push(a);
                break;
            }
            else {
                endJunction(a.last(), lastDetected);
                endJunctionList(a.first(), lastDetected);
            }
        }
    }

    /**
     * end the junction list when match a delimiter
     * @param token the left delimiter token paired with the matched token
     */
    private void endMatchDelimiter(Token token) {
        Alignment a;
        while ((!alignments.isEmpty()) &&
                (a = alignments.peek()).first().getTokenIndex() < token.getTokenIndex()) {
            a = alignments.pop();
            endJunction(a.last(), lastDetected);
            endJunctionList(a.first(), lastDetected);
        }
    }

    /**
     * end the junction list when match a conjunction/disjunction
     * @param token
     */
    private void endMatchJunction(Token token) {
        assert isPossibleIndentationToken(token);
        // TODO
        int rightBound = token.getCharPositionInLine();
        Alignment a = null;
        while ((!alignments.isEmpty()) &&
                (a = alignments.peek()).charPositionInLine > rightBound) {
            alignments.pop();
            endJunction(a.last(), lastDetected);
            endJunctionList(a.first(), lastDetected);
        }
        if ((!alignments.isEmpty()) && a.charPositionInLine == rightBound) {
            endJunction(a.last(), lastDetected);
            a.add(token);
        }
    }


    private static boolean paired(final int left, final int right) {
        switch (left) {
            case LeftParen:
            case LeftBack:
            case LeftBrace:
                return right - left == 1;
            default:
                return false;
        }
    }

    void end() {
        Alignment a = null;
        while (!alignments.isEmpty()) {
            a = alignments.pop();
            endJunction(a.last(), lastDetected);
            endJunctionList(a.first(), lastDetected);
        }
    }

    private static class Alignment {
        int charPositionInLine;
        List<Token> tokens;
        int symbolType; // must be Conjunction or Disjunction
        int size;
        Alignment(Token begin) {
            this.charPositionInLine = begin.getCharPositionInLine();
            tokens = new ArrayList<>();
            this.symbolType = begin.getType();
            size = 1;
            tokens.add(begin);
        }
        void add(Token t) {
            assert t.getCharPositionInLine() == charPositionInLine && t.getType() == symbolType;
            tokens.add(t);
            size++;
        }
        Token first() {
            return tokens.get(0);
        }
        Token last() {
            return tokens.get(size - 1);
        }
    }

}
