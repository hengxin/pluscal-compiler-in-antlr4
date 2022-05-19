package com.PlusCal.interp.pretreatment;

import com.PlusCal.interp.PlusCalLogger;
import com.PlusCal.interp.SemanticException;
import com.PlusCal.parser.PlusCalParser;
import com.PlusCal.parser.PlusCalParserBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.Interval;

import java.util.List;

import static com.PlusCal.parser.PlusCalParser.*;
import static com.PlusCal.interp.PlusCalParams.*;

/**
 * Pretreatment includes the expanding of macros and
 * necessary parenthesis adding.
 */
public class PlusCalPretreatmentAnalyser extends PlusCalParserBaseListener {

    private final TokenStreamRewriter rewriter;

    private final ParenthesisFiller filler;

    public PlusCalPretreatmentAnalyser(TokenStreamRewriter rewriter) {
        super();
        this.rewriter = rewriter;
        filler = new ParenthesisFiller(rewriter);
    }

    @Override
    public void exitAlgorithm(PlusCalParser.AlgorithmContext ctx) {
        /*
         * all macro definitions should be deleted because it won't be used
         */
        List<MacroContext> macros = ctx.macro();
        for (MacroContext macro: macros) {
            rewriter.delete(macro.start, macro.stop);
        }
    }

    @Override
    public void exitMacro(MacroContext ctx) {
        Macros.define(ctx.name().getText(), ctx);
    }

    @Override
    public void exitNonFixLhsDefinition(NonFixLhsDefinitionContext ctx) {
        filler.exec(ctx.expr());
    }

    @Override
    public void exitPrefixOpDefinition(PrefixOpDefinitionContext ctx) {
        filler.exec(ctx.expr());
    }

    @Override
    public void exitInfixOpDefinition(InfixOpDefinitionContext ctx) {
        filler.exec(ctx.expr());
    }

    @Override
    public void exitPostfixOpDefinition(PostfixOpDefinitionContext ctx) {
        filler.exec(ctx.expr());
    }

    @Override
    public void exitFunctionDefinition(FunctionDefinitionContext ctx) {
        filler.exec(ctx.expr());
    }

    @Override
    public void exitMacroCall(MacroCallContext ctx) {
        try{
            String[] params = new String[ctx.expr().size()];
            int i = 0;
            for (ExprContext expr: ctx.expr()) {
                filler.exec(expr);
                params[i++] = filler.getRewriter()
                        .getText(Interval.of(expr.start.getTokenIndex(), expr.stop.getTokenIndex()));
            }
            Macros.expandMacro(rewriter, ctx, params);
        }
        catch (SemanticException e){

            PlusCalLogger.reportError(e.getMessage(), ctx);
        }
    }

    @Override
    public void exitExpr(ExprContext ctx) {
        filler.exec(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.exception != null) pretreatmentError = true;
    }

}