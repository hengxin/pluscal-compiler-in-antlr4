package com.PlusCal.interp.symbol;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

import static com.PlusCal.parser.PlusCalParser.*;

public interface BuiltInOperator {

    static final Map<Integer, BuiltInOperator> prefixOpPrecedence = new HashMap<>();
    static final Map<Integer, BuiltInOperator> infixOpPrecedence = new HashMap<>();
    static final Map<Integer, BuiltInOperator> postfixOpPrecedence = new HashMap<>();

    static BuiltInOperator getOperator(int operator, OpType opType) {
        switch (opType) {
            case prefix:
                return prefixOpPrecedence.get(operator);
            case infix:
                return infixOpPrecedence.get(operator);
            case postfix:
                return postfixOpPrecedence.get(operator);
            default:
                throw new IllegalStateException("Unknown builtin operator type " + opType);
        }
    }

    enum OpType {
        prefix, infix, postfix;
    }

    int getOpType();

    Range getRange();

    boolean leftAssociative();

    OpType getType();

    class Range {
        int low;
        int high;

        Range(int low, int high) {
            assert low <= high;
            this.low = low;
            this.high = high;
        }

        static Range of(int low, int high) {
            return new Range(low, high);
        }
    }

    enum PrefixOperator implements BuiltInOperator {
        NEGATION(Negation, Range.of(4, 4)),
        SQUARE(Square, Range.of(4, 15)),
        UNION(Union_, Range.of(8, 8)),
        ENABLED(Enabled_, Range.of(4, 15)),
        DIAMOND(Diamond, Range.of(4, 15)),
        DOMAIN(Domain_, Range.of(9, 9)),
        UNCHANGED(Unchanged_, Range.of(4, 15)),
        SUBSET(Subset, Range.of(8, 8)),
        MINUS(Minus, Range.of(12, 12));
        final int ttype;
        final Range range;
        final boolean leftAssociative;

        PrefixOperator(int ttype, Range range) {
            this(ttype, range, true);
        }

        PrefixOperator(int ttype, Range range, boolean leftAssociative) {
            this.ttype = ttype;
            this.range = range;
            this.leftAssociative = leftAssociative;
            prefixOpPrecedence.put(ttype, this);
        }

        @Override
        public int getOpType() {
            return ttype;
        }

        @Override
        public Range getRange() {
            return range;
        }

        @Override
        public boolean leftAssociative() {
            return leftAssociative;
        }

        @Override
        public OpType getType() {
            return OpType.prefix;
        }

        @Override
        public String toString() {
            return name() + " _";
        }
    }

    enum InfixOperator implements BuiltInOperator {
        IMPLICATION(Implication, Range.of(1, 1)),
        DASH_PLUS_ARROW(DashPlusArrow, Range.of(2, 2)),
        EQUIVALENCE(Equivalence, Range.of(2, 2)),
        TILDE_GT(TildeGt, Range.of(2, 2)),
        CONJUNCTION(Conjunction, Range.of(3, 3), true),
        DISJUNCTION(Disjunction, Range.of(3, 3), true),
        NOTEQUAL(NotEqual, Range.of(5, 5)),
        DASH_BAR(DashBar, Range.of(5, 5)),
        COLON_COLON_EQ(ColonColonEq, Range.of(5, 5)),
        ASSIGN(Assign, Range.of(5, 5)),
        LESS(Less, Range.of(5, 5)),
        EQUAL(Equal, Range.of(5, 5)),
        EQUAL_BAR(EqualBar, Range.of(5, 5)),
        GREATER(Greater, Range.of(5, 5)),
        APPROX(Approx, Range.of(5, 5)),
        ASYMP(Asymp, Range.of(5, 5)),
        CONG(Cong, Range.of(5, 5)),
        DOT_EQ(Doteq, Range.of(5, 5)),
        GREATER_EQUAL(GreaterEqual, Range.of(5, 5)),
        GG(Gg, Range.of(5, 5)),
        IN(In, Range.of(5, 5)),
        NOTIN(NotIn, Range.of(5, 5)),
        LESS_EQUAL(LessEqual, Range.of(5, 5)),
        LL(Ll, Range.of(5, 5)),
        PREC(Prec, Range.of(5, 5)),
        PREC_EQ(Preceq, Range.of(5, 5)),
        PROP_TO(PropTo, Range.of(5, 5)),
        SIM(Sim, Range.of(5, 5)),
        SIM_EQ(Simeq, Range.of(5, 5)),
        SQ_SUBSET(SqSubset, Range.of(5, 5)),
        SQ_SUBSET_EQ(SqSubsetEq, Range.of(5, 5)),
        SQ_SUPSET(SqSupset, Range.of(5, 5)),
        SQ_SUPSET_EQ(SqSupsetEq, Range.of(5, 5)),
        SUBSET(Subset, Range.of(5, 5)),
        SUBSET_EQ(SubsetEq, Range.of(5, 5)),
        SUCC(Succ, Range.of(5, 5)),
        SUCC_EQ(Succeq, Range.of(5, 5)),
        SUPSET(Supset, Range.of(5, 5)),
        SUPSET_EQ(SupsetEq, Range.of(5, 5)),
        BAR_DASH(BarDash, Range.of(5, 5)),
        BAR_EQUAL(BarEqual, Range.of(5, 5)),
        CDOT(Cdot, Range.of(5, 14)),
        AT_AT(AtAt, Range.of(6, 6)),
        COLON_GT(ColonGt, Range.of(7, 7)),
        LT_COLON(LtColon, Range.of(7, 7)),
        SUBTRACT(Subtract, Range.of(8, 8)),
        CAP(Cap, Range.of(8, 8), true),
        CUP(Cup, Range.of(8, 8), true),
        DOTDOT(DotDot, Range.of(9, 9)),
        DOTDOTDOT(DotDotDot, Range.of(9, 9)),
        BANGBANG(BangBang, Range.of(9, 13)),
        SHARPSHARP(SharpSharp, Range.of(9, 13), true),
        DOLLAR(Dollar, Range.of(9, 13), true),
        DOLLARDOLLAR(DollarDollar, Range.of(9, 13), true),
        QUERYQUERY(QueryQuery, Range.of(9, 13), true),
        SQ_CAP(SqCap, Range.of(9, 13), true),
        SQ_CUP(SqCup, Range.of(9, 13), true),
        UPLUS(Uplus, Range.of(9, 13), true),
        WR(Wr, Range.of(9, 14)),
        OPLUS(Oplus, Range.of(10, 10), true),
        PLUS(Plus, Range.of(10, 10), true),
        PLUSPLUS(PlusPlus, Range.of(10, 10), true),
        MOD(Mod, Range.of(10, 11)),
        PERCENTPERCENT(PercentPercent, Range.of(10, 11), true),
        BAR(Bar, Range.of(10, 11), true),
        BARBAR(BarBar, Range.of(10, 11), true),
        OMINUS(Ominus, Range.of(11, 11), true),
        MINUS(Minus, Range.of(11, 11), true),
        MINUSMINUS(MinusMinus, Range.of(11, 11), true),
        AMP(Amp, Range.of(13, 13), true),
        AMPAMP(AmpAmp, Range.of(13, 13), true),
        ODOT(Odot, Range.of(13, 13), true),
        OSLASH(OSlash, Range.of(13, 13)),
        OTIMES(Otimes, Range.of(13, 13), true),
        ASTER(Aster, Range.of(13, 13), true),
        ASTERASTER(AsterAster, Range.of(13, 13), true),
        SLASH(Slash, Range.of(13, 13)),
        SLASHSLASH(SlashSlash, Range.of(13, 13)),
        BIG_CIRC(BigCirc, Range.of(13, 13), true),
        BULLET(Bullet, Range.of(13, 13), true),
        DIV(Div, Range.of(13, 13)),
        CIRC(Circ, Range.of(13, 13), true),
        STAR(Star, Range.of(13, 13), true),
        CARET(Caret, Range.of(14, 14)),
        CARETCARET(CaretCaret, Range.of(14, 14));
        final int ttype;
        final Range range;
        final boolean leftAssociative;

        InfixOperator(int ttype, Range range) {
            this(ttype, range, false);
        }

        InfixOperator(int ttype, Range range, boolean leftAssociative) {
            this.ttype = ttype;
            this.range = range;
            this.leftAssociative = leftAssociative;
            infixOpPrecedence.put(ttype, this);
        }

        @Override
        public int getOpType() {
            return ttype;
        }

        @Override
        public Range getRange() {
            return range;
        }

        @Override
        public boolean leftAssociative() {
            return leftAssociative;
        }

        @Override
        public OpType getType() {
            return OpType.infix;
        }

        @Override
        public String toString() {
            return "_ " + name() + " _";
        }
    }

    enum PostfixOperator implements BuiltInOperator {
        CARET_PLUS(CaretPlus, Range.of(15, 15)),
        CARET_ASTER(CaretAstar, Range.of(15, 15)),
        CARET_SHARP(CaretSharp, Range.of(15, 15)),
        PRIME(Prime, Range.of(15, 15));
        final int ttype;
        final Range range;
        final boolean leftAssociative;

        PostfixOperator(int ttype, Range range) {
            this(ttype, range, false);
        }

        PostfixOperator(int ttype, Range range, boolean leftAssociative) {
            this.ttype = ttype;
            this.range = range;
            this.leftAssociative = leftAssociative;
            postfixOpPrecedence.put(ttype, this);
        }

        @Override
        public int getOpType() {
            return ttype;
        }

        @Override
        public Range getRange() {
            return range;
        }

        @Override
        public boolean leftAssociative() {
            return leftAssociative;
        }

        @Override
        public OpType getType() {
            return OpType.postfix;
        }

        @Override
        public String toString() {
            return "_ " + name();
        }
    }

}
