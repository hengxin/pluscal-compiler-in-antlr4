// Generated from D:/final/code/src/main/java/com/PlusCal/grammar\PlusCalParser.g4 by ANTLR 4.9.2
package com.PlusCal.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PlusCalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Algorithm=1, While=2, Variables=3, Variable=4, Assert=5, If=6, Else=7, 
		ElseIf=8, Either=9, Or=10, Skip=11, Await=12, With=13, Call=14, Return=15, 
		Print=16, Define=17, Macro=18, Procedure=19, Process=20, Begin=21, End=22, 
		Do=23, Goto=24, Then=25, When=26, Fair=27, BooleanLiteral=28, Plus=29, 
		Minus=30, Aster=31, Slash=32, Assign=33, Equal=34, NotEqual=35, Greater=36, 
		Less=37, GreaterEqual=38, LessEqual=39, Negation=40, RightArrow=41, LeftArrow=42, 
		Caret=43, Mod=44, BarArrow=45, DotDot=46, Subscript=47, Conjunction=48, 
		Disjunction=49, Bang=50, Equivalence=51, EqualEqual=52, In=53, NotIn=54, 
		Any=55, Exist=56, AA=57, EE=58, Implication=59, Diamond=60, Square=61, 
		Ll=62, Gg=63, Prec=64, Preceq=65, Succ=66, Succeq=67, Subset=68, SubsetEq=69, 
		Supset=70, SupsetEq=71, SqSubset=72, SqSubsetEq=73, SqSupset=74, SqSupsetEq=75, 
		BarDash=76, BarEqual=77, EqualBar=78, Cap=79, SqCap=80, Cup=81, SqCup=82, 
		Oplus=83, Ominus=84, Odot=85, Otimes=86, OSlash=87, DashBar=88, Uplus=89, 
		Times=90, Wr=91, PropTo=92, DashPlusArrow=93, Div=94, Cdot=95, Circ=96, 
		Bullet=97, Star=98, BigCirc=99, Sim=100, Simeq=101, Asymp=102, Approx=103, 
		Cong=104, Doteq=105, BangBang=106, SharpSharp=107, Dollar=108, DollarDollar=109, 
		PercentPercent=110, Amp=111, AmpAmp=112, AsterAster=113, PlusPlus=114, 
		MinusMinus=115, DotDotDot=116, SlashSlash=117, Subtract=118, ColonColonEq=119, 
		ColonGt=120, LtColon=121, Query=122, QueryQuery=123, CaretCaret=124, Bar=125, 
		AtAt=126, TildeGt=127, Prime=128, CaretPlus=129, CaretAstar=130, CaretSharp=131, 
		DashDot=132, RightBackWithSubscript=133, RightTupleWithSubscript=134, 
		LeftParen=135, RightParen=136, LeftBrace=137, RightBrace=138, LeftBack=139, 
		RightBack=140, Semi=141, Colon=142, Comma=143, Dot=144, LeftTuple=145, 
		RightTuple=146, BarBar=147, Except_=148, Constant_=149, Constants_=150, 
		Enabled_=151, Unchanged_=152, Union_=153, Subset_=154, Domain_=155, Assume_=156, 
		Assumption_=157, Axiom_=158, Case_=159, Choose_=160, Else_=161, Extends_=162, 
		If_=163, In_=164, Instance_=165, Let_=166, Local_=167, Module_=168, Other_=169, 
		Then_=170, Theorem_=171, Variable_=172, Variables_=173, With_=174, WF=175, 
		SF=176, StringLiteral=177, Integer=178, DecimalInteger=179, OctalInteger=180, 
		HexadecimalInteger=181, BinaryInteger=182, Float=183, Identifier=184, 
		WhiteSpace=185, Newline=186, LineComment=187, BlockComment=188;
	public static final int
		RULE_algorithm = 0, RULE_procedure = 1, RULE_macro = 2, RULE_definitions = 3, 
		RULE_globalVardecls = 4, RULE_vardecl = 5, RULE_process = 6, RULE_procVardecls = 7, 
		RULE_prodVarDecls = 8, RULE_prodVarDecl = 9, RULE_body = 10, RULE_compoundStmt = 11, 
		RULE_stmt = 12, RULE_unLabeledStmt = 13, RULE_inWithVarDecl = 14, RULE_lhs = 15, 
		RULE_variable = 16, RULE_field = 17, RULE_label = 18, RULE_name = 19, 
		RULE_defs = 20, RULE_nonFixLhs = 21, RULE_nonFixLhsParameter = 22, RULE_operatorDefinition = 23, 
		RULE_functionDefinition = 24, RULE_operatorDecl = 25, RULE_moduleDefinition = 26, 
		RULE_instance = 27, RULE_substitution = 28, RULE_identifierOrTuple = 29, 
		RULE_quantifierBound = 30, RULE_generalPrefixOp = 31, RULE_generalInfixOp = 32, 
		RULE_generalPostfixOp = 33, RULE_argument = 34, RULE_generalIdentifier = 35, 
		RULE_expr = 36, RULE_infixOpOrJunctions = 37, RULE_primaryExpr = 38, RULE_set = 39, 
		RULE_functionOrRecord = 40, RULE_caseArm = 41, RULE_instancePrefix = 42, 
		RULE_exceptCase = 43, RULE_infixOp = 44, RULE_postfixOp = 45, RULE_prefixOp = 46, 
		RULE_number = 47, RULE_tlaEscapeWord = 48, RULE_plusCalReservedWord = 49;
	private static String[] makeRuleNames() {
		return new String[] {
			"algorithm", "procedure", "macro", "definitions", "globalVardecls", "vardecl", 
			"process", "procVardecls", "prodVarDecls", "prodVarDecl", "body", "compoundStmt", 
			"stmt", "unLabeledStmt", "inWithVarDecl", "lhs", "variable", "field", 
			"label", "name", "defs", "nonFixLhs", "nonFixLhsParameter", "operatorDefinition", 
			"functionDefinition", "operatorDecl", "moduleDefinition", "instance", 
			"substitution", "identifierOrTuple", "quantifierBound", "generalPrefixOp", 
			"generalInfixOp", "generalPostfixOp", "argument", "generalIdentifier", 
			"expr", "infixOpOrJunctions", "primaryExpr", "set", "functionOrRecord", 
			"caseArm", "instancePrefix", "exceptCase", "infixOp", "postfixOp", "prefixOp", 
			"number", "tlaEscapeWord", "plusCalReservedWord"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algorithm'", "'while'", "'variables'", "'variable'", "'assert'", 
			"'if'", "'else'", "'elsif'", "'either'", "'or'", "'skip'", "'await'", 
			"'with'", "'call'", "'return'", "'print'", "'define'", "'macro'", "'procedure'", 
			"'process'", "'begin'", "'end'", "'do'", "'goto'", "'then'", "'when'", 
			"'fair'", null, "'+'", "'-'", "'*'", "'/'", "':='", "'='", null, "'>'", 
			"'<'", null, null, null, "'->'", "'<-'", "'^'", "'%'", "'|->'", "'..'", 
			"'_'", null, null, "'!'", null, "'=='", "'\\in'", "'\\notin'", "'\\A'", 
			"'\\E'", "'\\AA'", "'\\EE'", "'=>'", "'<>'", "'[]'", "'\\ll'", "'\\gg'", 
			"'\\prec'", "'\\preceq'", "'\\succ'", "'\\succeq'", "'\\subset'", "'\\subseteq'", 
			"'\\supset'", "'\\supseteq'", "'\\sqsubset'", "'\\sqsubseteq'", "'\\sqsupset'", 
			"'\\sqsupseteq'", "'|-'", "'|='", "'=|'", null, "'\\sqcap'", null, "'\\sqcup'", 
			null, null, null, null, null, "'-|'", "'\\uplus'", null, "'\\wr'", "'\\propto'", 
			"'-+->'", "'\\div'", "'\\cdot'", null, "'\\bullet'", "'\\star'", "'\\bigcirc'", 
			"'\\sim'", "'\\simeq'", "'\\asymp'", "'\\approx'", "'\\cong'", "'\\doteq'", 
			"'!!'", "'##'", "'$'", "'$$'", "'%%'", "'&'", "'&&'", "'**'", "'++'", 
			"'--'", "'...'", "'//'", "'\\'", "'::='", "':>'", "'<:'", "'?'", "'??'", 
			"'^^'", "'|'", "'@@'", "'~>'", "'''", "'^+'", "'^*'", "'^#'", "'-.'", 
			"']_'", "'>>_'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "':'", 
			"','", "'.'", "'<<'", "'>>'", "'||'", "'EXCEPT'", "'CONSTANT'", "'CONSTANTS'", 
			"'ENABLED'", "'UNCHANGED'", "'UNION'", "'SUBSET'", "'DOMAIN'", "'ASSUME'", 
			"'ASSUMPTION'", "'AXIOM'", "'CASE'", "'CHOOSE'", "'ELSE'", "'EXTENDS'", 
			"'IF'", "'IN'", "'INSTANCE'", "'LET'", "'LOCAL'", "'MODULE'", "'OTHER'", 
			"'THEN'", "'THEOREM'", "'VARIABLE'", "'VARIABLES'", "'WITH'", "'WF_'", 
			"'SF_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Algorithm", "While", "Variables", "Variable", "Assert", "If", 
			"Else", "ElseIf", "Either", "Or", "Skip", "Await", "With", "Call", "Return", 
			"Print", "Define", "Macro", "Procedure", "Process", "Begin", "End", "Do", 
			"Goto", "Then", "When", "Fair", "BooleanLiteral", "Plus", "Minus", "Aster", 
			"Slash", "Assign", "Equal", "NotEqual", "Greater", "Less", "GreaterEqual", 
			"LessEqual", "Negation", "RightArrow", "LeftArrow", "Caret", "Mod", "BarArrow", 
			"DotDot", "Subscript", "Conjunction", "Disjunction", "Bang", "Equivalence", 
			"EqualEqual", "In", "NotIn", "Any", "Exist", "AA", "EE", "Implication", 
			"Diamond", "Square", "Ll", "Gg", "Prec", "Preceq", "Succ", "Succeq", 
			"Subset", "SubsetEq", "Supset", "SupsetEq", "SqSubset", "SqSubsetEq", 
			"SqSupset", "SqSupsetEq", "BarDash", "BarEqual", "EqualBar", "Cap", "SqCap", 
			"Cup", "SqCup", "Oplus", "Ominus", "Odot", "Otimes", "OSlash", "DashBar", 
			"Uplus", "Times", "Wr", "PropTo", "DashPlusArrow", "Div", "Cdot", "Circ", 
			"Bullet", "Star", "BigCirc", "Sim", "Simeq", "Asymp", "Approx", "Cong", 
			"Doteq", "BangBang", "SharpSharp", "Dollar", "DollarDollar", "PercentPercent", 
			"Amp", "AmpAmp", "AsterAster", "PlusPlus", "MinusMinus", "DotDotDot", 
			"SlashSlash", "Subtract", "ColonColonEq", "ColonGt", "LtColon", "Query", 
			"QueryQuery", "CaretCaret", "Bar", "AtAt", "TildeGt", "Prime", "CaretPlus", 
			"CaretAstar", "CaretSharp", "DashDot", "RightBackWithSubscript", "RightTupleWithSubscript", 
			"LeftParen", "RightParen", "LeftBrace", "RightBrace", "LeftBack", "RightBack", 
			"Semi", "Colon", "Comma", "Dot", "LeftTuple", "RightTuple", "BarBar", 
			"Except_", "Constant_", "Constants_", "Enabled_", "Unchanged_", "Union_", 
			"Subset_", "Domain_", "Assume_", "Assumption_", "Axiom_", "Case_", "Choose_", 
			"Else_", "Extends_", "If_", "In_", "Instance_", "Let_", "Local_", "Module_", 
			"Other_", "Then_", "Theorem_", "Variable_", "Variables_", "With_", "WF", 
			"SF", "StringLiteral", "Integer", "DecimalInteger", "OctalInteger", "HexadecimalInteger", 
			"BinaryInteger", "Float", "Identifier", "WhiteSpace", "Newline", "LineComment", 
			"BlockComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PlusCalParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public static boolean pSyntax = false;
	    public static boolean cSyntax = false;

	public PlusCalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AlgorithmContext extends ParserRuleContext {
		public TerminalNode MinusMinus() { return getToken(PlusCalParser.MinusMinus, 0); }
		public List<TerminalNode> Algorithm() { return getTokens(PlusCalParser.Algorithm); }
		public TerminalNode Algorithm(int i) {
			return getToken(PlusCalParser.Algorithm, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(PlusCalParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(PlusCalParser.RightBrace, 0); }
		public TerminalNode EOF() { return getToken(PlusCalParser.EOF, 0); }
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public TerminalNode Fair() { return getToken(PlusCalParser.Fair, 0); }
		public GlobalVardeclsContext globalVardecls() {
			return getRuleContext(GlobalVardeclsContext.class,0);
		}
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public List<ProcessContext> process() {
			return getRuleContexts(ProcessContext.class);
		}
		public ProcessContext process(int i) {
			return getRuleContext(ProcessContext.class,i);
		}
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public AlgorithmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_algorithm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterAlgorithm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitAlgorithm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitAlgorithm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlgorithmContext algorithm() throws RecognitionException {
		AlgorithmContext _localctx = new AlgorithmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_algorithm);
		int _la;
		try {
			int _alt;
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(MinusMinus);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Fair) {
					{
					setState(101);
					match(Fair);
					}
				}

				setState(104);
				match(Algorithm);
				setState(105);
				name();
				setState(106);
				match(LeftBrace);
				 cSyntax = true; 
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(108);
					globalVardecls();
					}
					break;
				}
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(111);
					definitions();
					}
					break;
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(114);
						macro();
						}
						} 
					}
					setState(119);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(120);
						procedure();
						}
						} 
					}
					setState(125);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(126);
					compoundStmt();
					}
					break;
				case 2:
					{
					setState(128); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(127);
							process();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(130); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				}
				setState(134);
				match(RightBrace);
				setState(135);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(MinusMinus);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Fair) {
					{
					setState(138);
					match(Fair);
					}
				}

				setState(141);
				match(Algorithm);
				setState(142);
				name();
				 pSyntax = true; 
				setState(145);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(144);
					globalVardecls();
					}
					break;
				}
				setState(148);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(147);
					definitions();
					}
					break;
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(150);
						macro();
						}
						} 
					}
					setState(155);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(156);
						procedure();
						}
						} 
					}
					setState(161);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(168);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(162);
					body();
					}
					break;
				case 2:
					{
					setState(164); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(163);
							process();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(166); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				}
				setState(170);
				match(End);
				setState(171);
				match(Algorithm);
				setState(172);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureContext extends ParserRuleContext {
		public TerminalNode Procedure() { return getToken(PlusCalParser.Procedure, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public List<ProdVarDeclContext> prodVarDecl() {
			return getRuleContexts(ProdVarDeclContext.class);
		}
		public ProdVarDeclContext prodVarDecl(int i) {
			return getRuleContext(ProdVarDeclContext.class,i);
		}
		public ProdVarDeclsContext prodVarDecls() {
			return getRuleContext(ProdVarDeclsContext.class,0);
		}
		public TerminalNode Semi() { return getToken(PlusCalParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitProcedure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_procedure);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
				setState(177);
				match(Procedure);
				setState(178);
				name();
				setState(179);
				match(LeftParen);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(180);
					prodVarDecl();
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(181);
						match(Comma);
						setState(182);
						prodVarDecl();
						}
						}
						setState(187);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(190);
				match(RightParen);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Variables || _la==Variable) {
					{
					setState(191);
					prodVarDecls();
					}
				}

				setState(194);
				compoundStmt();
				setState(196);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(195);
					match(Semi);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
				setState(199);
				match(Procedure);
				setState(200);
				name();
				setState(201);
				match(LeftParen);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(202);
					prodVarDecl();
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(203);
						match(Comma);
						setState(204);
						prodVarDecl();
						}
						}
						setState(209);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(212);
				match(RightParen);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Variables || _la==Variable) {
					{
					setState(213);
					prodVarDecls();
					}
				}

				setState(216);
				body();
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(217);
					match(Semi);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroContext extends ParserRuleContext {
		public List<TerminalNode> Macro() { return getTokens(PlusCalParser.Macro); }
		public TerminalNode Macro(int i) {
			return getToken(PlusCalParser.Macro, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode Semi() { return getToken(PlusCalParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitMacro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitMacro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_macro);
		int _la;
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
				setState(223);
				match(Macro);
				setState(224);
				name();
				setState(225);
				match(LeftParen);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(226);
					variable();
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(227);
						match(Comma);
						setState(228);
						variable();
						}
						}
						setState(233);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(236);
				match(RightParen);
				setState(237);
				compoundStmt();
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(238);
					match(Semi);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
				setState(242);
				match(Macro);
				setState(243);
				name();
				setState(244);
				match(LeftParen);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(245);
					variable();
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(246);
						match(Comma);
						setState(247);
						variable();
						}
						}
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(255);
				body();
				setState(256);
				match(End);
				setState(257);
				match(Macro);
				setState(259);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(258);
					match(Semi);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<TerminalNode> Define() { return getTokens(PlusCalParser.Define); }
		public TerminalNode Define(int i) {
			return getToken(PlusCalParser.Define, i);
		}
		public TerminalNode LeftBrace() { return getToken(PlusCalParser.LeftBrace, 0); }
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(PlusCalParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(PlusCalParser.Semi, 0); }
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definitions);
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
				setState(264);
				match(Define);
				setState(265);
				match(LeftBrace);
				setState(266);
				defs();
				setState(267);
				match(RightBrace);
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(268);
					match(Semi);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
				setState(272);
				match(Define);
				setState(273);
				defs();
				setState(274);
				match(End);
				setState(275);
				match(Define);
				setState(277);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(276);
					match(Semi);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalVardeclsContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(PlusCalParser.Variable, 0); }
		public TerminalNode Variables() { return getToken(PlusCalParser.Variables, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public GlobalVardeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVardecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterGlobalVardecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitGlobalVardecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitGlobalVardecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVardeclsContext globalVardecls() throws RecognitionException {
		GlobalVardeclsContext _localctx = new GlobalVardeclsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_globalVardecls);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==Variables || _la==Variable) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(283); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(282);
					vardecl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(285); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public Token relop;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode Semi() { return getToken(PlusCalParser.Semi, 0); }
		public TerminalNode Comma() { return getToken(PlusCalParser.Comma, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Equal() { return getToken(PlusCalParser.Equal, 0); }
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitVardecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			variable();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal || _la==In) {
				{
				setState(288);
				((VardeclContext)_localctx).relop = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Equal || _la==In) ) {
					((VardeclContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(289);
				expr();
				}
			}

			setState(292);
			_la = _input.LA(1);
			if ( !(_la==Semi || _la==Comma) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcessContext extends ParserRuleContext {
		public Token relop;
		public List<TerminalNode> Process() { return getTokens(PlusCalParser.Process); }
		public TerminalNode Process(int i) {
			return getToken(PlusCalParser.Process, i);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public TerminalNode Equal() { return getToken(PlusCalParser.Equal, 0); }
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public TerminalNode Fair() { return getToken(PlusCalParser.Fair, 0); }
		public ProcVardeclsContext procVardecls() {
			return getRuleContext(ProcVardeclsContext.class,0);
		}
		public TerminalNode Semi() { return getToken(PlusCalParser.Semi, 0); }
		public TerminalNode Plus() { return getToken(PlusCalParser.Plus, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public ProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_process; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitProcess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitProcess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessContext process() throws RecognitionException {
		ProcessContext _localctx = new ProcessContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_process);
		int _la;
		try {
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Fair) {
					{
					setState(295);
					match(Fair);
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Plus) {
						{
						setState(296);
						match(Plus);
						}
					}

					}
				}

				setState(301);
				match(Process);
				setState(302);
				match(LeftParen);
				setState(303);
				name();
				setState(304);
				((ProcessContext)_localctx).relop = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Equal || _la==In) ) {
					((ProcessContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(305);
				expr();
				setState(306);
				match(RightParen);
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Variables || _la==Variable) {
					{
					setState(307);
					procVardecls();
					}
				}

				setState(310);
				compoundStmt();
				setState(312);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(311);
					match(Semi);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Fair) {
					{
					setState(315);
					match(Fair);
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Plus) {
						{
						setState(316);
						match(Plus);
						}
					}

					}
				}

				setState(321);
				match(Process);
				setState(322);
				match(LeftParen);
				setState(323);
				name();
				setState(324);
				((ProcessContext)_localctx).relop = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Equal || _la==In) ) {
					((ProcessContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(325);
				expr();
				setState(326);
				match(RightParen);
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Variables || _la==Variable) {
					{
					setState(327);
					procVardecls();
					}
				}

				setState(330);
				body();
				setState(331);
				match(End);
				setState(332);
				match(Process);
				setState(334);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(333);
					match(Semi);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcVardeclsContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(PlusCalParser.Variable, 0); }
		public TerminalNode Variables() { return getToken(PlusCalParser.Variables, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public ProcVardeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procVardecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterProcVardecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitProcVardecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitProcVardecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcVardeclsContext procVardecls() throws RecognitionException {
		ProcVardeclsContext _localctx = new ProcVardeclsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procVardecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !(_la==Variables || _la==Variable) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(340); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(339);
				vardecl();
				}
				}
				setState(342); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProdVarDeclsContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(PlusCalParser.Variable, 0); }
		public TerminalNode Variables() { return getToken(PlusCalParser.Variables, 0); }
		public List<ProdVarDeclContext> prodVarDecl() {
			return getRuleContexts(ProdVarDeclContext.class);
		}
		public ProdVarDeclContext prodVarDecl(int i) {
			return getRuleContext(ProdVarDeclContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(PlusCalParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(PlusCalParser.Semi, i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public ProdVarDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prodVarDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterProdVarDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitProdVarDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitProdVarDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProdVarDeclsContext prodVarDecls() throws RecognitionException {
		ProdVarDeclsContext _localctx = new ProdVarDeclsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_prodVarDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !(_la==Variables || _la==Variable) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(348); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(345);
				prodVarDecl();
				setState(346);
				_la = _input.LA(1);
				if ( !(_la==Semi || _la==Comma) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(350); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProdVarDeclContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode Equal() { return getToken(PlusCalParser.Equal, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProdVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prodVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterProdVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitProdVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitProdVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProdVarDeclContext prodVarDecl() throws RecognitionException {
		ProdVarDeclContext _localctx = new ProdVarDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_prodVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			variable();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(353);
				match(Equal);
				setState(354);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode Begin() { return getToken(PlusCalParser.Begin, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(Begin);
			setState(359); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(358);
					stmt();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(361); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStmtContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(PlusCalParser.LeftBrace, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode RightBrace() { return getToken(PlusCalParser.RightBrace, 0); }
		public List<TerminalNode> Semi() { return getTokens(PlusCalParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(PlusCalParser.Semi, i);
		}
		public CompoundStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterCompoundStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitCompoundStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitCompoundStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStmtContext compoundStmt() throws RecognitionException {
		CompoundStmtContext _localctx = new CompoundStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compoundStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(LeftBrace);
			setState(364);
			stmt();
			setState(369);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(365);
					match(Semi);
					setState(366);
					stmt();
					}
					} 
				}
				setState(371);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Semi) {
				{
				setState(372);
				match(Semi);
				}
			}

			setState(375);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public UnLabeledStmtContext unLabeledStmt() {
			return getRuleContext(UnLabeledStmtContext.class,0);
		}
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PlusCalParser.Colon, 0); }
		public TerminalNode Plus() { return getToken(PlusCalParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(PlusCalParser.Minus, 0); }
		public TerminalNode Semi() { return getToken(PlusCalParser.Semi, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		int _la;
		try {
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
				setState(383);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(378);
					label();
					setState(379);
					match(Colon);
					setState(381);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(380);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					}
					break;
				}
				setState(387);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(385);
					unLabeledStmt();
					}
					break;
				case 2:
					{
					setState(386);
					compoundStmt();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
				setState(395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(390);
					label();
					setState(391);
					match(Colon);
					setState(393);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
					case 1:
						{
						setState(392);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					}
					break;
				}
				setState(397);
				unLabeledStmt();
				setState(398);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnLabeledStmtContext extends ParserRuleContext {
		public UnLabeledStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unLabeledStmt; }
	 
		public UnLabeledStmtContext() { }
		public void copyFrom(UnLabeledStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MacroCallContext extends UnLabeledStmtContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public MacroCallContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterMacroCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitMacroCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitMacroCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallReturnContext extends UnLabeledStmtContext {
		public TerminalNode Call() { return getToken(PlusCalParser.Call, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public TerminalNode Return() { return getToken(PlusCalParser.Return, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public CallReturnContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterCallReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitCallReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitCallReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipContext extends UnLabeledStmtContext {
		public TerminalNode Skip() { return getToken(PlusCalParser.Skip, 0); }
		public SkipContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends UnLabeledStmtContext {
		public List<TerminalNode> While() { return getTokens(PlusCalParser.While); }
		public TerminalNode While(int i) {
			return getToken(PlusCalParser.While, i);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Do() { return getToken(PlusCalParser.Do, 0); }
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public WhileContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallContext extends UnLabeledStmtContext {
		public TerminalNode Call() { return getToken(PlusCalParser.Call, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public CallContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WithContext extends UnLabeledStmtContext {
		public List<TerminalNode> With() { return getTokens(PlusCalParser.With); }
		public TerminalNode With(int i) {
			return getToken(PlusCalParser.With, i);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public List<InWithVarDeclContext> inWithVarDecl() {
			return getRuleContexts(InWithVarDeclContext.class);
		}
		public InWithVarDeclContext inWithVarDecl(int i) {
			return getRuleContext(InWithVarDeclContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Do() { return getToken(PlusCalParser.Do, 0); }
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public List<TerminalNode> Semi() { return getTokens(PlusCalParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(PlusCalParser.Semi, i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public WithContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitWith(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallGotoContext extends UnLabeledStmtContext {
		public TerminalNode Call() { return getToken(PlusCalParser.Call, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public TerminalNode Goto() { return getToken(PlusCalParser.Goto, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public CallGotoContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterCallGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitCallGoto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitCallGoto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EitherContext extends UnLabeledStmtContext {
		public List<TerminalNode> Either() { return getTokens(PlusCalParser.Either); }
		public TerminalNode Either(int i) {
			return getToken(PlusCalParser.Either, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public List<TerminalNode> Or() { return getTokens(PlusCalParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(PlusCalParser.Or, i);
		}
		public EitherContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterEither(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitEither(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitEither(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends UnLabeledStmtContext {
		public TerminalNode Print() { return getToken(PlusCalParser.Print, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GotoContext extends UnLabeledStmtContext {
		public TerminalNode Goto() { return getToken(PlusCalParser.Goto, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public GotoContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitGoto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitGoto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssertContext extends UnLabeledStmtContext {
		public TerminalNode Assert() { return getToken(PlusCalParser.Assert, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssertContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterAssert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitAssert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitAssert(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AwaitContext extends UnLabeledStmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Await() { return getToken(PlusCalParser.Await, 0); }
		public TerminalNode When() { return getToken(PlusCalParser.When, 0); }
		public AwaitContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterAwait(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitAwait(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitAwait(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends UnLabeledStmtContext {
		public List<TerminalNode> If() { return getTokens(PlusCalParser.If); }
		public TerminalNode If(int i) {
			return getToken(PlusCalParser.If, i);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> Then() { return getTokens(PlusCalParser.Then); }
		public TerminalNode Then(int i) {
			return getToken(PlusCalParser.Then, i);
		}
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public TerminalNode Else() { return getToken(PlusCalParser.Else, 0); }
		public List<TerminalNode> ElseIf() { return getTokens(PlusCalParser.ElseIf); }
		public TerminalNode ElseIf(int i) {
			return getToken(PlusCalParser.ElseIf, i);
		}
		public IfContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends UnLabeledStmtContext {
		public TerminalNode Return() { return getToken(PlusCalParser.Return, 0); }
		public ReturnContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends UnLabeledStmtContext {
		public List<LhsContext> lhs() {
			return getRuleContexts(LhsContext.class);
		}
		public LhsContext lhs(int i) {
			return getRuleContext(LhsContext.class,i);
		}
		public List<TerminalNode> Assign() { return getTokens(PlusCalParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(PlusCalParser.Assign, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> BarBar() { return getTokens(PlusCalParser.BarBar); }
		public TerminalNode BarBar(int i) {
			return getToken(PlusCalParser.BarBar, i);
		}
		public AssignContext(UnLabeledStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnLabeledStmtContext unLabeledStmt() throws RecognitionException {
		UnLabeledStmtContext _localctx = new UnLabeledStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unLabeledStmt);
		int _la;
		try {
			int _alt;
			setState(621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				lhs();
				setState(403);
				match(Assign);
				setState(404);
				expr();
				setState(412);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(405);
						match(BarBar);
						setState(406);
						lhs();
						setState(407);
						match(Assign);
						setState(408);
						expr();
						}
						} 
					}
					setState(414);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(415);
					if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
					setState(416);
					match(If);
					setState(417);
					match(LeftParen);
					setState(418);
					expr();
					setState(419);
					match(RightParen);
					setState(420);
					stmt();
					setState(423);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
					case 1:
						{
						setState(421);
						match(Else);
						setState(422);
						stmt();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(425);
					if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
					setState(426);
					match(If);
					setState(427);
					expr();
					setState(428);
					match(Then);
					setState(430); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(429);
							stmt();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(432); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(444);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ElseIf) {
						{
						{
						setState(434);
						match(ElseIf);
						setState(435);
						expr();
						setState(436);
						match(Then);
						setState(438); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(437);
								stmt();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(440); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(446);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(453);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Else) {
						{
						setState(447);
						match(Else);
						setState(449); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(448);
								stmt();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(451); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
					}

					setState(455);
					match(End);
					setState(456);
					match(If);
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(479);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(460);
					if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
					setState(461);
					match(While);
					setState(462);
					match(LeftParen);
					setState(463);
					expr();
					setState(464);
					match(RightParen);
					setState(465);
					stmt();
					}
					break;
				case 2:
					{
					setState(467);
					if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
					setState(468);
					match(While);
					setState(469);
					expr();
					setState(470);
					match(Do);
					setState(472); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(471);
							stmt();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(474); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(476);
					match(End);
					setState(477);
					match(While);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new EitherContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(510);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(481);
					if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
					setState(482);
					match(Either);
					setState(483);
					stmt();
					setState(486); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(484);
							match(Or);
							setState(485);
							stmt();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(488); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case 2:
					{
					setState(490);
					if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
					setState(491);
					match(Either);
					setState(493); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(492);
							stmt();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(495); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(503); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(497);
						match(Or);
						setState(499); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(498);
								stmt();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(501); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(505); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Or );
					setState(507);
					match(End);
					setState(508);
					match(Either);
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new WithContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(547);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(512);
					if (!(cSyntax)) throw new FailedPredicateException(this, "cSyntax");
					setState(513);
					match(With);
					setState(514);
					match(LeftParen);
					setState(515);
					inWithVarDecl();
					setState(520);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(516);
							_la = _input.LA(1);
							if ( !(_la==Semi || _la==Comma) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(517);
							inWithVarDecl();
							}
							} 
						}
						setState(522);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
					}
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Semi || _la==Comma) {
						{
						setState(523);
						_la = _input.LA(1);
						if ( !(_la==Semi || _la==Comma) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					setState(526);
					match(RightParen);
					setState(527);
					stmt();
					}
					break;
				case 2:
					{
					setState(529);
					if (!(pSyntax)) throw new FailedPredicateException(this, "pSyntax");
					setState(530);
					match(With);
					setState(534); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(531);
						inWithVarDecl();
						setState(532);
						_la = _input.LA(1);
						if ( !(_la==Semi || _la==Comma) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(536); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Identifier );
					setState(538);
					match(Do);
					setState(540); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(539);
							stmt();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(542); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(544);
					match(End);
					setState(545);
					match(With);
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new AwaitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(549);
				_la = _input.LA(1);
				if ( !(_la==Await || _la==When) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(550);
				expr();
				}
				break;
			case 7:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(551);
				match(Print);
				setState(552);
				expr();
				}
				break;
			case 8:
				_localctx = new AssertContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(553);
				match(Assert);
				setState(554);
				expr();
				}
				break;
			case 9:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(555);
				match(Skip);
				}
				break;
			case 10:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(556);
				match(Return);
				}
				break;
			case 11:
				_localctx = new GotoContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(557);
				match(Goto);
				setState(558);
				label();
				}
				break;
			case 12:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(559);
				match(Call);
				setState(560);
				name();
				setState(561);
				match(LeftParen);
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Minus) | (1L << Negation) | (1L << Conjunction) | (1L << Disjunction) | (1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (LeftParen - 135)) | (1L << (LeftBrace - 135)) | (1L << (LeftBack - 135)) | (1L << (LeftTuple - 135)) | (1L << (Enabled_ - 135)) | (1L << (Unchanged_ - 135)) | (1L << (Union_ - 135)) | (1L << (Subset_ - 135)) | (1L << (Domain_ - 135)) | (1L << (Case_ - 135)) | (1L << (Choose_ - 135)) | (1L << (If_ - 135)) | (1L << (Let_ - 135)) | (1L << (WF - 135)) | (1L << (SF - 135)) | (1L << (StringLiteral - 135)) | (1L << (Integer - 135)) | (1L << (Float - 135)) | (1L << (Identifier - 135)))) != 0)) {
					{
					setState(562);
					expr();
					setState(567);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(563);
						match(Comma);
						setState(564);
						expr();
						}
						}
						setState(569);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(572);
				match(RightParen);
				}
				break;
			case 13:
				_localctx = new CallReturnContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(574);
				match(Call);
				setState(575);
				name();
				setState(576);
				match(LeftParen);
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Minus) | (1L << Negation) | (1L << Conjunction) | (1L << Disjunction) | (1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (LeftParen - 135)) | (1L << (LeftBrace - 135)) | (1L << (LeftBack - 135)) | (1L << (LeftTuple - 135)) | (1L << (Enabled_ - 135)) | (1L << (Unchanged_ - 135)) | (1L << (Union_ - 135)) | (1L << (Subset_ - 135)) | (1L << (Domain_ - 135)) | (1L << (Case_ - 135)) | (1L << (Choose_ - 135)) | (1L << (If_ - 135)) | (1L << (Let_ - 135)) | (1L << (WF - 135)) | (1L << (SF - 135)) | (1L << (StringLiteral - 135)) | (1L << (Integer - 135)) | (1L << (Float - 135)) | (1L << (Identifier - 135)))) != 0)) {
					{
					setState(577);
					expr();
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(578);
						match(Comma);
						setState(579);
						expr();
						}
						}
						setState(584);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(587);
				match(RightParen);
				setState(588);
				match(Return);
				}
				break;
			case 14:
				_localctx = new CallGotoContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(590);
				match(Call);
				setState(591);
				name();
				setState(592);
				match(LeftParen);
				setState(601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Minus) | (1L << Negation) | (1L << Conjunction) | (1L << Disjunction) | (1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (LeftParen - 135)) | (1L << (LeftBrace - 135)) | (1L << (LeftBack - 135)) | (1L << (LeftTuple - 135)) | (1L << (Enabled_ - 135)) | (1L << (Unchanged_ - 135)) | (1L << (Union_ - 135)) | (1L << (Subset_ - 135)) | (1L << (Domain_ - 135)) | (1L << (Case_ - 135)) | (1L << (Choose_ - 135)) | (1L << (If_ - 135)) | (1L << (Let_ - 135)) | (1L << (WF - 135)) | (1L << (SF - 135)) | (1L << (StringLiteral - 135)) | (1L << (Integer - 135)) | (1L << (Float - 135)) | (1L << (Identifier - 135)))) != 0)) {
					{
					setState(593);
					expr();
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(594);
						match(Comma);
						setState(595);
						expr();
						}
						}
						setState(600);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(603);
				match(RightParen);
				setState(604);
				match(Goto);
				setState(605);
				label();
				}
				break;
			case 15:
				_localctx = new MacroCallContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(607);
				name();
				setState(608);
				match(LeftParen);
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Minus) | (1L << Negation) | (1L << Conjunction) | (1L << Disjunction) | (1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (LeftParen - 135)) | (1L << (LeftBrace - 135)) | (1L << (LeftBack - 135)) | (1L << (LeftTuple - 135)) | (1L << (Enabled_ - 135)) | (1L << (Unchanged_ - 135)) | (1L << (Union_ - 135)) | (1L << (Subset_ - 135)) | (1L << (Domain_ - 135)) | (1L << (Case_ - 135)) | (1L << (Choose_ - 135)) | (1L << (If_ - 135)) | (1L << (Let_ - 135)) | (1L << (WF - 135)) | (1L << (SF - 135)) | (1L << (StringLiteral - 135)) | (1L << (Integer - 135)) | (1L << (Float - 135)) | (1L << (Identifier - 135)))) != 0)) {
					{
					setState(609);
					expr();
					setState(614);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(610);
						match(Comma);
						setState(611);
						expr();
						}
						}
						setState(616);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(619);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InWithVarDeclContext extends ParserRuleContext {
		public Token relop;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Equal() { return getToken(PlusCalParser.Equal, 0); }
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public InWithVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inWithVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInWithVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInWithVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInWithVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InWithVarDeclContext inWithVarDecl() throws RecognitionException {
		InWithVarDeclContext _localctx = new InWithVarDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_inWithVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			variable();
			setState(624);
			((InWithVarDeclContext)_localctx).relop = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Equal || _la==In) ) {
				((InWithVarDeclContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(625);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LhsContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> LeftBack() { return getTokens(PlusCalParser.LeftBack); }
		public TerminalNode LeftBack(int i) {
			return getToken(PlusCalParser.LeftBack, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RightBack() { return getTokens(PlusCalParser.RightBack); }
		public TerminalNode RightBack(int i) {
			return getToken(PlusCalParser.RightBack, i);
		}
		public List<TerminalNode> Dot() { return getTokens(PlusCalParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(PlusCalParser.Dot, i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitLhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			variable();
			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBack || _la==Dot) {
				{
				setState(641);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftBack:
					{
					setState(628);
					match(LeftBack);
					setState(629);
					expr();
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(630);
						match(Comma);
						setState(631);
						expr();
						}
						}
						setState(636);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(637);
					match(RightBack);
					}
					break;
				case Dot:
					{
					setState(639);
					match(Dot);
					setState(640);
					field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(645);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PlusCalParser.Identifier, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PlusCalParser.Identifier, 0); }
		public TlaEscapeWordContext tlaEscapeWord() {
			return getRuleContext(TlaEscapeWordContext.class,0);
		}
		public PlusCalReservedWordContext plusCalReservedWord() {
			return getRuleContext(PlusCalReservedWordContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_field);
		try {
			setState(651);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(648);
				match(Identifier);
				}
				break;
			case Except_:
			case Constant_:
			case Constants_:
			case Enabled_:
			case Unchanged_:
			case Union_:
			case Subset_:
			case Domain_:
			case Assume_:
			case Assumption_:
			case Axiom_:
			case Case_:
			case Choose_:
			case Else_:
			case Extends_:
			case If_:
			case In_:
			case Instance_:
			case Let_:
			case Local_:
			case Module_:
			case Other_:
			case Then_:
			case Theorem_:
			case Variable_:
			case Variables_:
			case With_:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				tlaEscapeWord();
				}
				break;
			case While:
			case Variables:
			case Variable:
			case Assert:
			case If:
			case Else:
			case ElseIf:
			case Either:
			case Or:
			case Skip:
			case Await:
			case With:
			case Call:
			case Return:
			case Print:
			case Define:
			case Macro:
			case Procedure:
			case Process:
			case Begin:
			case End:
			case Do:
			case Goto:
			case Then:
			case When:
				enterOuterAlt(_localctx, 3);
				{
				setState(650);
				plusCalReservedWord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PlusCalParser.Identifier, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PlusCalParser.Identifier, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefsContext extends ParserRuleContext {
		public List<OperatorDefinitionContext> operatorDefinition() {
			return getRuleContexts(OperatorDefinitionContext.class);
		}
		public OperatorDefinitionContext operatorDefinition(int i) {
			return getRuleContext(OperatorDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ModuleDefinitionContext> moduleDefinition() {
			return getRuleContexts(ModuleDefinitionContext.class);
		}
		public ModuleDefinitionContext moduleDefinition(int i) {
			return getRuleContext(ModuleDefinitionContext.class,i);
		}
		public DefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterDefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitDefs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitDefs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefsContext defs() throws RecognitionException {
		DefsContext _localctx = new DefsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(660);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(657);
					operatorDefinition();
					}
					break;
				case 2:
					{
					setState(658);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(659);
					moduleDefinition();
					}
					break;
				}
				}
				setState(662); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Minus) | (1L << Negation) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (Enabled_ - 151)) | (1L << (Unchanged_ - 151)) | (1L << (Union_ - 151)) | (1L << (Subset_ - 151)) | (1L << (Domain_ - 151)) | (1L << (Identifier - 151)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonFixLhsContext extends ParserRuleContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public List<NonFixLhsParameterContext> nonFixLhsParameter() {
			return getRuleContexts(NonFixLhsParameterContext.class);
		}
		public NonFixLhsParameterContext nonFixLhsParameter(int i) {
			return getRuleContext(NonFixLhsParameterContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public NonFixLhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonFixLhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterNonFixLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitNonFixLhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitNonFixLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonFixLhsContext nonFixLhs() throws RecognitionException {
		NonFixLhsContext _localctx = new NonFixLhsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_nonFixLhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			generalIdentifier();
			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(665);
				match(LeftParen);
				setState(666);
				nonFixLhsParameter();
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(667);
					match(Comma);
					setState(668);
					nonFixLhsParameter();
					}
					}
					setState(673);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(674);
				match(RightParen);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonFixLhsParameterContext extends ParserRuleContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public OperatorDeclContext operatorDecl() {
			return getRuleContext(OperatorDeclContext.class,0);
		}
		public NonFixLhsParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonFixLhsParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterNonFixLhsParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitNonFixLhsParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitNonFixLhsParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonFixLhsParameterContext nonFixLhsParameter() throws RecognitionException {
		NonFixLhsParameterContext _localctx = new NonFixLhsParameterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_nonFixLhsParameter);
		try {
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(678);
				generalIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(679);
				operatorDecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorDefinitionContext extends ParserRuleContext {
		public OperatorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorDefinition; }
	 
		public OperatorDefinitionContext() { }
		public void copyFrom(OperatorDefinitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixOpDefinitionContext extends OperatorDefinitionContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public PostfixOpContext postfixOp() {
			return getRuleContext(PostfixOpContext.class,0);
		}
		public TerminalNode EqualEqual() { return getToken(PlusCalParser.EqualEqual, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PostfixOpDefinitionContext(OperatorDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPostfixOpDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPostfixOpDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPostfixOpDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonFixLhsDefinitionContext extends OperatorDefinitionContext {
		public NonFixLhsContext nonFixLhs() {
			return getRuleContext(NonFixLhsContext.class,0);
		}
		public TerminalNode EqualEqual() { return getToken(PlusCalParser.EqualEqual, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NonFixLhsDefinitionContext(OperatorDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterNonFixLhsDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitNonFixLhsDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitNonFixLhsDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InfixOpDefinitionContext extends OperatorDefinitionContext {
		public List<GeneralIdentifierContext> generalIdentifier() {
			return getRuleContexts(GeneralIdentifierContext.class);
		}
		public GeneralIdentifierContext generalIdentifier(int i) {
			return getRuleContext(GeneralIdentifierContext.class,i);
		}
		public InfixOpContext infixOp() {
			return getRuleContext(InfixOpContext.class,0);
		}
		public TerminalNode EqualEqual() { return getToken(PlusCalParser.EqualEqual, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InfixOpDefinitionContext(OperatorDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInfixOpDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInfixOpDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInfixOpDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixOpDefinitionContext extends OperatorDefinitionContext {
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public TerminalNode EqualEqual() { return getToken(PlusCalParser.EqualEqual, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixOpDefinitionContext(OperatorDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPrefixOpDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPrefixOpDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPrefixOpDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorDefinitionContext operatorDefinition() throws RecognitionException {
		OperatorDefinitionContext _localctx = new OperatorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_operatorDefinition);
		try {
			setState(702);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				_localctx = new NonFixLhsDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(682);
				nonFixLhs();
				setState(683);
				match(EqualEqual);
				setState(684);
				expr();
				}
				break;
			case 2:
				_localctx = new PrefixOpDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(686);
				prefixOp();
				setState(687);
				generalIdentifier();
				setState(688);
				match(EqualEqual);
				setState(689);
				expr();
				}
				break;
			case 3:
				_localctx = new InfixOpDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(691);
				generalIdentifier();
				setState(692);
				infixOp();
				setState(693);
				generalIdentifier();
				setState(694);
				match(EqualEqual);
				setState(695);
				expr();
				}
				break;
			case 4:
				_localctx = new PostfixOpDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(697);
				generalIdentifier();
				setState(698);
				postfixOp();
				setState(699);
				match(EqualEqual);
				setState(700);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public List<QuantifierBoundContext> quantifierBound() {
			return getRuleContexts(QuantifierBoundContext.class);
		}
		public QuantifierBoundContext quantifierBound(int i) {
			return getRuleContext(QuantifierBoundContext.class,i);
		}
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public TerminalNode EqualEqual() { return getToken(PlusCalParser.EqualEqual, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			generalIdentifier();
			setState(705);
			match(LeftBack);
			setState(706);
			quantifierBound();
			setState(711);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(707);
				match(Comma);
				setState(708);
				quantifierBound();
				}
				}
				setState(713);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(714);
			match(RightBack);
			setState(715);
			match(EqualEqual);
			setState(716);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorDeclContext extends ParserRuleContext {
		public OperatorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorDecl; }
	 
		public OperatorDeclContext() { }
		public void copyFrom(OperatorDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OperatorParameterContext extends OperatorDeclContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public List<TerminalNode> Subscript() { return getTokens(PlusCalParser.Subscript); }
		public TerminalNode Subscript(int i) {
			return getToken(PlusCalParser.Subscript, i);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public OperatorParameterContext(OperatorDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterOperatorParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitOperatorParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitOperatorParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixOpParameterContext extends OperatorDeclContext {
		public TerminalNode Subscript() { return getToken(PlusCalParser.Subscript, 0); }
		public PostfixOpContext postfixOp() {
			return getRuleContext(PostfixOpContext.class,0);
		}
		public PostfixOpParameterContext(OperatorDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPostfixOpParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPostfixOpParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPostfixOpParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InfixOpParameterContext extends OperatorDeclContext {
		public List<TerminalNode> Subscript() { return getTokens(PlusCalParser.Subscript); }
		public TerminalNode Subscript(int i) {
			return getToken(PlusCalParser.Subscript, i);
		}
		public InfixOpContext infixOp() {
			return getRuleContext(InfixOpContext.class,0);
		}
		public InfixOpParameterContext(OperatorDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInfixOpParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInfixOpParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInfixOpParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixOpParameterContext extends OperatorDeclContext {
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public TerminalNode Subscript() { return getToken(PlusCalParser.Subscript, 0); }
		public PrefixOpParameterContext(OperatorDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPrefixOpParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPrefixOpParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPrefixOpParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorDeclContext operatorDecl() throws RecognitionException {
		OperatorDeclContext _localctx = new OperatorDeclContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_operatorDecl);
		int _la;
		try {
			setState(740);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				_localctx = new OperatorParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(718);
				generalIdentifier();
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(719);
					match(LeftParen);
					setState(720);
					match(Subscript);
					setState(725);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(721);
						match(Comma);
						setState(722);
						match(Subscript);
						}
						}
						setState(727);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(728);
					match(RightParen);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrefixOpParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(731);
				prefixOp();
				setState(732);
				match(Subscript);
				}
				break;
			case 3:
				_localctx = new InfixOpParameterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(734);
				match(Subscript);
				setState(735);
				infixOp();
				setState(736);
				match(Subscript);
				}
				break;
			case 4:
				_localctx = new PostfixOpParameterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(738);
				match(Subscript);
				setState(739);
				postfixOp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleDefinitionContext extends ParserRuleContext {
		public NonFixLhsContext nonFixLhs() {
			return getRuleContext(NonFixLhsContext.class,0);
		}
		public TerminalNode EqualEqual() { return getToken(PlusCalParser.EqualEqual, 0); }
		public InstanceContext instance() {
			return getRuleContext(InstanceContext.class,0);
		}
		public ModuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterModuleDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitModuleDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitModuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleDefinitionContext moduleDefinition() throws RecognitionException {
		ModuleDefinitionContext _localctx = new ModuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_moduleDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742);
			nonFixLhs();
			setState(743);
			match(EqualEqual);
			setState(744);
			instance();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceContext extends ParserRuleContext {
		public TerminalNode Instance_() { return getToken(PlusCalParser.Instance_, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode With_() { return getToken(PlusCalParser.With_, 0); }
		public List<SubstitutionContext> substitution() {
			return getRuleContexts(SubstitutionContext.class);
		}
		public SubstitutionContext substitution(int i) {
			return getRuleContext(SubstitutionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public InstanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceContext instance() throws RecognitionException {
		InstanceContext _localctx = new InstanceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_instance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			match(Instance_);
			setState(747);
			name();
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==With_) {
				{
				setState(748);
				match(With_);
				setState(749);
				substitution();
				setState(754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(750);
					match(Comma);
					setState(751);
					substitution();
					}
					}
					setState(756);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubstitutionContext extends ParserRuleContext {
		public TerminalNode LeftArrow() { return getToken(PlusCalParser.LeftArrow, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public InfixOpContext infixOp() {
			return getRuleContext(InfixOpContext.class,0);
		}
		public PostfixOpContext postfixOp() {
			return getRuleContext(PostfixOpContext.class,0);
		}
		public SubstitutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substitution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterSubstitution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitSubstitution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitSubstitution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubstitutionContext substitution() throws RecognitionException {
		SubstitutionContext _localctx = new SubstitutionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_substitution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(759);
				generalIdentifier();
				}
				break;
			case 2:
				{
				setState(760);
				prefixOp();
				}
				break;
			case 3:
				{
				setState(761);
				infixOp();
				}
				break;
			case 4:
				{
				setState(762);
				postfixOp();
				}
				break;
			}
			setState(765);
			match(LeftArrow);
			setState(766);
			argument();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierOrTupleContext extends ParserRuleContext {
		public List<GeneralIdentifierContext> generalIdentifier() {
			return getRuleContexts(GeneralIdentifierContext.class);
		}
		public GeneralIdentifierContext generalIdentifier(int i) {
			return getRuleContext(GeneralIdentifierContext.class,i);
		}
		public TerminalNode LeftTuple() { return getToken(PlusCalParser.LeftTuple, 0); }
		public TerminalNode RightTuple() { return getToken(PlusCalParser.RightTuple, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public IdentifierOrTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierOrTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterIdentifierOrTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitIdentifierOrTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitIdentifierOrTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierOrTupleContext identifierOrTuple() throws RecognitionException {
		IdentifierOrTupleContext _localctx = new IdentifierOrTupleContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_identifierOrTuple);
		int _la;
		try {
			setState(780);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(768);
				generalIdentifier();
				}
				break;
			case LeftTuple:
				enterOuterAlt(_localctx, 2);
				{
				setState(769);
				match(LeftTuple);
				setState(770);
				generalIdentifier();
				setState(775);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(771);
					match(Comma);
					setState(772);
					generalIdentifier();
					}
					}
					setState(777);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(778);
				match(RightTuple);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierBoundContext extends ParserRuleContext {
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierOrTupleContext identifierOrTuple() {
			return getRuleContext(IdentifierOrTupleContext.class,0);
		}
		public List<GeneralIdentifierContext> generalIdentifier() {
			return getRuleContexts(GeneralIdentifierContext.class);
		}
		public GeneralIdentifierContext generalIdentifier(int i) {
			return getRuleContext(GeneralIdentifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public QuantifierBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterQuantifierBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitQuantifierBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitQuantifierBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierBoundContext quantifierBound() throws RecognitionException {
		QuantifierBoundContext _localctx = new QuantifierBoundContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_quantifierBound);
		int _la;
		try {
			int _alt;
			setState(823);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(791);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					{
					setState(782);
					identifierOrTuple();
					}
					break;
				case 2:
					{
					setState(783);
					generalIdentifier();
					setState(788);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(784);
						match(Comma);
						setState(785);
						generalIdentifier();
						}
						}
						setState(790);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(793);
				match(In);
				setState(794);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(805);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(796);
					identifierOrTuple();
					}
					break;
				case 2:
					{
					setState(797);
					generalIdentifier();
					setState(802);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(798);
						match(Comma);
						setState(799);
						generalIdentifier();
						}
						}
						setState(804);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(807);
				match(In);
				   notifyErrorListeners("'expression' expected"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(819);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(810);
					identifierOrTuple();
					}
					break;
				case 2:
					{
					setState(811);
					generalIdentifier();
					setState(816);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(812);
							match(Comma);
							setState(813);
							generalIdentifier();
							}
							} 
						}
						setState(818);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
					}
					}
					break;
				}
				   notifyErrorListeners("'\\in expression' excepted"); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralPrefixOpContext extends ParserRuleContext {
		public InstancePrefixContext instancePrefix() {
			return getRuleContext(InstancePrefixContext.class,0);
		}
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public GeneralPrefixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalPrefixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterGeneralPrefixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitGeneralPrefixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitGeneralPrefixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralPrefixOpContext generalPrefixOp() throws RecognitionException {
		GeneralPrefixOpContext _localctx = new GeneralPrefixOpContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_generalPrefixOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			instancePrefix();
			setState(826);
			prefixOp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralInfixOpContext extends ParserRuleContext {
		public InstancePrefixContext instancePrefix() {
			return getRuleContext(InstancePrefixContext.class,0);
		}
		public InfixOpContext infixOp() {
			return getRuleContext(InfixOpContext.class,0);
		}
		public GeneralInfixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalInfixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterGeneralInfixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitGeneralInfixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitGeneralInfixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralInfixOpContext generalInfixOp() throws RecognitionException {
		GeneralInfixOpContext _localctx = new GeneralInfixOpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_generalInfixOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			instancePrefix();
			setState(829);
			infixOp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralPostfixOpContext extends ParserRuleContext {
		public InstancePrefixContext instancePrefix() {
			return getRuleContext(InstancePrefixContext.class,0);
		}
		public PostfixOpContext postfixOp() {
			return getRuleContext(PostfixOpContext.class,0);
		}
		public GeneralPostfixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalPostfixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterGeneralPostfixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitGeneralPostfixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitGeneralPostfixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralPostfixOpContext generalPostfixOp() throws RecognitionException {
		GeneralPostfixOpContext _localctx = new GeneralPostfixOpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_generalPostfixOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			instancePrefix();
			setState(832);
			postfixOp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GeneralInfixOpContext generalInfixOp() {
			return getRuleContext(GeneralInfixOpContext.class,0);
		}
		public GeneralPrefixOpContext generalPrefixOp() {
			return getRuleContext(GeneralPrefixOpContext.class,0);
		}
		public GeneralPostfixOpContext generalPostfixOp() {
			return getRuleContext(GeneralPostfixOpContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_argument);
		try {
			setState(838);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(834);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(835);
				generalInfixOp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(836);
				generalPrefixOp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(837);
				generalPostfixOp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralIdentifierContext extends ParserRuleContext {
		public InstancePrefixContext instancePrefix() {
			return getRuleContext(InstancePrefixContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PlusCalParser.Identifier, 0); }
		public GeneralIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterGeneralIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitGeneralIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitGeneralIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralIdentifierContext generalIdentifier() throws RecognitionException {
		GeneralIdentifierContext _localctx = new GeneralIdentifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_generalIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			instancePrefix();
			setState(841);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public List<GeneralPrefixOpContext> generalPrefixOp() {
			return getRuleContexts(GeneralPrefixOpContext.class);
		}
		public GeneralPrefixOpContext generalPrefixOp(int i) {
			return getRuleContext(GeneralPrefixOpContext.class,i);
		}
		public List<GeneralPostfixOpContext> generalPostfixOp() {
			return getRuleContexts(GeneralPostfixOpContext.class);
		}
		public GeneralPostfixOpContext generalPostfixOp(int i) {
			return getRuleContext(GeneralPostfixOpContext.class,i);
		}
		public List<InfixOpOrJunctionsContext> infixOpOrJunctions() {
			return getRuleContexts(InfixOpOrJunctionsContext.class);
		}
		public InfixOpOrJunctionsContext infixOpOrJunctions(int i) {
			return getRuleContext(InfixOpOrJunctionsContext.class,i);
		}
		public List<TerminalNode> Conjunction() { return getTokens(PlusCalParser.Conjunction); }
		public TerminalNode Conjunction(int i) {
			return getToken(PlusCalParser.Conjunction, i);
		}
		public List<TerminalNode> Disjunction() { return getTokens(PlusCalParser.Disjunction); }
		public TerminalNode Disjunction(int i) {
			return getToken(PlusCalParser.Disjunction, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Conjunction || _la==Disjunction) {
				{
				{
				setState(843);
				_la = _input.LA(1);
				if ( !(_la==Conjunction || _la==Disjunction) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(848);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(852);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(849);
					generalPrefixOp();
					}
					} 
				}
				setState(854);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			}
			setState(855);
			primaryExpr(0);
			setState(859);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(856);
					generalPostfixOp();
					}
					} 
				}
				setState(861);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			setState(878);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(862);
					infixOpOrJunctions();
					setState(866);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(863);
							generalPrefixOp();
							}
							} 
						}
						setState(868);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
					}
					setState(869);
					primaryExpr(0);
					setState(873);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(870);
							generalPostfixOp();
							}
							} 
						}
						setState(875);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
					}
					}
					} 
				}
				setState(880);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfixOpOrJunctionsContext extends ParserRuleContext {
		public GeneralInfixOpContext generalInfixOp() {
			return getRuleContext(GeneralInfixOpContext.class,0);
		}
		public List<TerminalNode> Conjunction() { return getTokens(PlusCalParser.Conjunction); }
		public TerminalNode Conjunction(int i) {
			return getToken(PlusCalParser.Conjunction, i);
		}
		public List<TerminalNode> Disjunction() { return getTokens(PlusCalParser.Disjunction); }
		public TerminalNode Disjunction(int i) {
			return getToken(PlusCalParser.Disjunction, i);
		}
		public InfixOpOrJunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixOpOrJunctions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInfixOpOrJunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInfixOpOrJunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInfixOpOrJunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixOpOrJunctionsContext infixOpOrJunctions() throws RecognitionException {
		InfixOpOrJunctionsContext _localctx = new InfixOpOrJunctionsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_infixOpOrJunctions);
		int _la;
		try {
			setState(887);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(881);
				generalInfixOp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(883); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(882);
					_la = _input.LA(1);
					if ( !(_la==Conjunction || _la==Disjunction) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(885); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Conjunction || _la==Disjunction );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExprContext extends ParserRuleContext {
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	 
		public PrimaryExprContext() { }
		public void copyFrom(PrimaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TlaChooseContext extends PrimaryExprContext {
		public TerminalNode Choose_() { return getToken(PlusCalParser.Choose_, 0); }
		public IdentifierOrTupleContext identifierOrTuple() {
			return getRuleContext(IdentifierOrTupleContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PlusCalParser.Colon, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public TlaChooseContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterTlaChoose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitTlaChoose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitTlaChoose(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TlaLetContext extends PrimaryExprContext {
		public TerminalNode Let_() { return getToken(PlusCalParser.Let_, 0); }
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
		}
		public TerminalNode In_() { return getToken(PlusCalParser.In_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TlaLetContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterTlaLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitTlaLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitTlaLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableLiteralContext extends PrimaryExprContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public VariableLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterVariableLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitVariableLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitVariableLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequenceLiteralContext extends PrimaryExprContext {
		public TerminalNode LeftTuple() { return getToken(PlusCalParser.LeftTuple, 0); }
		public TerminalNode RightTuple() { return getToken(PlusCalParser.RightTuple, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public SequenceLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterSequenceLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitSequenceLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitSequenceLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionOrRecordLiteralContext extends PrimaryExprContext {
		public FunctionOrRecordContext functionOrRecord() {
			return getRuleContext(FunctionOrRecordContext.class,0);
		}
		public FunctionOrRecordLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterFunctionOrRecordLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitFunctionOrRecordLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitFunctionOrRecordLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TlaCaseContext extends PrimaryExprContext {
		public TerminalNode Case_() { return getToken(PlusCalParser.Case_, 0); }
		public List<CaseArmContext> caseArm() {
			return getRuleContexts(CaseArmContext.class);
		}
		public CaseArmContext caseArm(int i) {
			return getRuleContext(CaseArmContext.class,i);
		}
		public List<TerminalNode> Square() { return getTokens(PlusCalParser.Square); }
		public TerminalNode Square(int i) {
			return getToken(PlusCalParser.Square, i);
		}
		public TerminalNode Other_() { return getToken(PlusCalParser.Other_, 0); }
		public TerminalNode RightArrow() { return getToken(PlusCalParser.RightArrow, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TlaCaseContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterTlaCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitTlaCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitTlaCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends PrimaryExprContext {
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public ParenthesisContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifierExpressionContext extends PrimaryExprContext {
		public List<QuantifierBoundContext> quantifierBound() {
			return getRuleContexts(QuantifierBoundContext.class);
		}
		public QuantifierBoundContext quantifierBound(int i) {
			return getRuleContext(QuantifierBoundContext.class,i);
		}
		public TerminalNode Colon() { return getToken(PlusCalParser.Colon, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Any() { return getToken(PlusCalParser.Any, 0); }
		public TerminalNode Exist() { return getToken(PlusCalParser.Exist, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public QuantifierExpressionContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterQuantifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitQuantifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitQuantifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketedWithSubscriptContext extends PrimaryExprContext {
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightBackWithSubscript() { return getToken(PlusCalParser.RightBackWithSubscript, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public BracketedWithSubscriptContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterBracketedWithSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitBracketedWithSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitBracketedWithSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifierExpression2Context extends PrimaryExprContext {
		public List<GeneralIdentifierContext> generalIdentifier() {
			return getRuleContexts(GeneralIdentifierContext.class);
		}
		public GeneralIdentifierContext generalIdentifier(int i) {
			return getRuleContext(GeneralIdentifierContext.class,i);
		}
		public TerminalNode Colon() { return getToken(PlusCalParser.Colon, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Any() { return getToken(PlusCalParser.Any, 0); }
		public TerminalNode Exist() { return getToken(PlusCalParser.Exist, 0); }
		public TerminalNode AA() { return getToken(PlusCalParser.AA, 0); }
		public TerminalNode EE() { return getToken(PlusCalParser.EE, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public QuantifierExpression2Context(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterQuantifierExpression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitQuantifierExpression2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitQuantifierExpression2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetLiteralContext extends PrimaryExprContext {
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public SetLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterSetLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitSetLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitSetLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TlaIfContext extends PrimaryExprContext {
		public TerminalNode If_() { return getToken(PlusCalParser.If_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Then_() { return getToken(PlusCalParser.Then_, 0); }
		public TerminalNode Else_() { return getToken(PlusCalParser.Else_, 0); }
		public TlaIfContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterTlaIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitTlaIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitTlaIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends PrimaryExprContext {
		public TerminalNode StringLiteral() { return getToken(PlusCalParser.StringLiteral, 0); }
		public StringLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WfOrSfContext extends PrimaryExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public TerminalNode WF() { return getToken(PlusCalParser.WF, 0); }
		public TerminalNode SF() { return getToken(PlusCalParser.SF, 0); }
		public WfOrSfContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterWfOrSf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitWfOrSf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitWfOrSf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldCallContext extends PrimaryExprContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(PlusCalParser.Dot, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public FieldCallContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterFieldCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitFieldCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitFieldCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends PrimaryExprContext {
		public TerminalNode BooleanLiteral() { return getToken(PlusCalParser.BooleanLiteral, 0); }
		public BooleanLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequencedWithSubscriptContext extends PrimaryExprContext {
		public TerminalNode LeftTuple() { return getToken(PlusCalParser.LeftTuple, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightTupleWithSubscript() { return getToken(PlusCalParser.RightTupleWithSubscript, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public SequencedWithSubscriptContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterSequencedWithSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitSequencedWithSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitSequencedWithSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperatorCallContext extends PrimaryExprContext {
		public GeneralIdentifierContext generalIdentifier() {
			return getRuleContext(GeneralIdentifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PlusCalParser.LeftParen, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(PlusCalParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public OperatorCallContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterOperatorCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitOperatorCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitOperatorCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralContext extends PrimaryExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		return primaryExpr(0);
	}

	private PrimaryExprContext primaryExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, _parentState);
		PrimaryExprContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_primaryExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1000);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(890);
				match(LeftParen);
				setState(891);
				expr();
				setState(892);
				match(RightParen);
				}
				break;
			case 2:
				{
				_localctx = new OperatorCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(894);
				generalIdentifier();
				setState(895);
				match(LeftParen);
				setState(896);
				argument();
				setState(901);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(897);
					match(Comma);
					setState(898);
					argument();
					}
					}
					setState(903);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(904);
				match(RightParen);
				}
				break;
			case 3:
				{
				_localctx = new VariableLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(906);
				generalIdentifier();
				}
				break;
			case 4:
				{
				_localctx = new NumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(907);
				number();
				}
				break;
			case 5:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(908);
				match(BooleanLiteral);
				}
				break;
			case 6:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(909);
				match(StringLiteral);
				}
				break;
			case 7:
				{
				_localctx = new QuantifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(910);
				_la = _input.LA(1);
				if ( !(_la==Any || _la==Exist) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(911);
				quantifierBound();
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(912);
					match(Comma);
					setState(913);
					quantifierBound();
					}
					}
					setState(918);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(919);
				match(Colon);
				setState(920);
				expr();
				}
				break;
			case 8:
				{
				_localctx = new QuantifierExpression2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(922);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(923);
				generalIdentifier();
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(924);
					match(Comma);
					setState(925);
					generalIdentifier();
					}
					}
					setState(930);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(931);
				match(Colon);
				setState(932);
				expr();
				}
				break;
			case 9:
				{
				_localctx = new TlaChooseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(934);
				match(Choose_);
				setState(935);
				identifierOrTuple();
				setState(938);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==In) {
					{
					setState(936);
					match(In);
					setState(937);
					expr();
					}
				}

				setState(940);
				match(Colon);
				setState(941);
				expr();
				}
				break;
			case 10:
				{
				_localctx = new SetLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(943);
				set();
				}
				break;
			case 11:
				{
				_localctx = new FunctionOrRecordLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(944);
				functionOrRecord();
				}
				break;
			case 12:
				{
				_localctx = new SequenceLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(945);
				match(LeftTuple);
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Minus) | (1L << Negation) | (1L << Conjunction) | (1L << Disjunction) | (1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (LeftParen - 135)) | (1L << (LeftBrace - 135)) | (1L << (LeftBack - 135)) | (1L << (LeftTuple - 135)) | (1L << (Enabled_ - 135)) | (1L << (Unchanged_ - 135)) | (1L << (Union_ - 135)) | (1L << (Subset_ - 135)) | (1L << (Domain_ - 135)) | (1L << (Case_ - 135)) | (1L << (Choose_ - 135)) | (1L << (If_ - 135)) | (1L << (Let_ - 135)) | (1L << (WF - 135)) | (1L << (SF - 135)) | (1L << (StringLiteral - 135)) | (1L << (Integer - 135)) | (1L << (Float - 135)) | (1L << (Identifier - 135)))) != 0)) {
					{
					setState(946);
					expr();
					setState(951);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(947);
						match(Comma);
						setState(948);
						expr();
						}
						}
						setState(953);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(956);
				match(RightTuple);
				}
				break;
			case 13:
				{
				_localctx = new BracketedWithSubscriptContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(957);
				match(LeftBack);
				setState(958);
				expr();
				setState(959);
				match(RightBackWithSubscript);
				setState(960);
				primaryExpr(6);
				}
				break;
			case 14:
				{
				_localctx = new SequencedWithSubscriptContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(962);
				match(LeftTuple);
				setState(963);
				expr();
				setState(964);
				match(RightTupleWithSubscript);
				setState(965);
				primaryExpr(5);
				}
				break;
			case 15:
				{
				_localctx = new WfOrSfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(967);
				_la = _input.LA(1);
				if ( !(_la==WF || _la==SF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(968);
				expr();
				setState(969);
				match(LeftParen);
				setState(970);
				expr();
				setState(971);
				match(RightParen);
				}
				break;
			case 16:
				{
				_localctx = new TlaIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(973);
				match(If_);
				setState(974);
				expr();
				setState(975);
				match(Then_);
				setState(976);
				expr();
				setState(977);
				match(Else_);
				setState(978);
				expr();
				}
				break;
			case 17:
				{
				_localctx = new TlaCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(980);
				match(Case_);
				setState(981);
				caseArm();
				setState(986);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(982);
						match(Square);
						setState(983);
						caseArm();
						}
						} 
					}
					setState(988);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
				}
				setState(993);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
				case 1:
					{
					setState(989);
					match(Square);
					setState(990);
					match(Other_);
					setState(991);
					match(RightArrow);
					setState(992);
					expr();
					}
					break;
				}
				}
				break;
			case 18:
				{
				_localctx = new TlaLetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(995);
				match(Let_);
				setState(996);
				defs();
				setState(997);
				match(In_);
				setState(998);
				expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1007);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FieldCallContext(new PrimaryExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_primaryExpr);
					setState(1002);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(1003);
					match(Dot);
					setState(1004);
					field();
					}
					} 
				}
				setState(1009);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
	 
		public SetContext() { }
		public void copyFrom(SetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MappingContext extends SetContext {
		public TerminalNode LeftBrace() { return getToken(PlusCalParser.LeftBrace, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PlusCalParser.Colon, 0); }
		public List<QuantifierBoundContext> quantifierBound() {
			return getRuleContexts(QuantifierBoundContext.class);
		}
		public QuantifierBoundContext quantifierBound(int i) {
			return getRuleContext(QuantifierBoundContext.class,i);
		}
		public TerminalNode RightBrace() { return getToken(PlusCalParser.RightBrace, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public MappingContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitMapping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitMapping(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FilteringContext extends SetContext {
		public TerminalNode LeftBrace() { return getToken(PlusCalParser.LeftBrace, 0); }
		public IdentifierOrTupleContext identifierOrTuple() {
			return getRuleContext(IdentifierOrTupleContext.class,0);
		}
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Colon() { return getToken(PlusCalParser.Colon, 0); }
		public TerminalNode RightBrace() { return getToken(PlusCalParser.RightBrace, 0); }
		public FilteringContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterFiltering(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitFiltering(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitFiltering(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumeratedContext extends SetContext {
		public TerminalNode LeftBrace() { return getToken(PlusCalParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(PlusCalParser.RightBrace, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public EnumeratedContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterEnumerated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitEnumerated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitEnumerated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_set);
		int _la;
		try {
			setState(1043);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				_localctx = new EnumeratedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1010);
				match(LeftBrace);
				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << Minus) | (1L << Negation) | (1L << Conjunction) | (1L << Disjunction) | (1L << Any) | (1L << Exist) | (1L << AA) | (1L << EE) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (LeftParen - 135)) | (1L << (LeftBrace - 135)) | (1L << (LeftBack - 135)) | (1L << (LeftTuple - 135)) | (1L << (Enabled_ - 135)) | (1L << (Unchanged_ - 135)) | (1L << (Union_ - 135)) | (1L << (Subset_ - 135)) | (1L << (Domain_ - 135)) | (1L << (Case_ - 135)) | (1L << (Choose_ - 135)) | (1L << (If_ - 135)) | (1L << (Let_ - 135)) | (1L << (WF - 135)) | (1L << (SF - 135)) | (1L << (StringLiteral - 135)) | (1L << (Integer - 135)) | (1L << (Float - 135)) | (1L << (Identifier - 135)))) != 0)) {
					{
					setState(1011);
					expr();
					setState(1016);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(1012);
						match(Comma);
						setState(1013);
						expr();
						}
						}
						setState(1018);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1021);
				match(RightBrace);
				}
				break;
			case 2:
				_localctx = new FilteringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1022);
				match(LeftBrace);
				setState(1023);
				identifierOrTuple();
				setState(1024);
				match(In);
				setState(1025);
				expr();
				setState(1026);
				match(Colon);
				setState(1027);
				expr();
				setState(1028);
				match(RightBrace);
				}
				break;
			case 3:
				_localctx = new MappingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1030);
				match(LeftBrace);
				setState(1031);
				expr();
				setState(1032);
				match(Colon);
				setState(1033);
				quantifierBound();
				setState(1038);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1034);
					match(Comma);
					setState(1035);
					quantifierBound();
					}
					}
					setState(1040);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1041);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionOrRecordContext extends ParserRuleContext {
		public FunctionOrRecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionOrRecord; }
	 
		public FunctionOrRecordContext() { }
		public void copyFrom(FunctionOrRecordContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColonedRecordContext extends FunctionOrRecordContext {
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(PlusCalParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(PlusCalParser.Colon, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public ColonedRecordContext(FunctionOrRecordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterColonedRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitColonedRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitColonedRecord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExceptConstructContext extends FunctionOrRecordContext {
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Except_() { return getToken(PlusCalParser.Except_, 0); }
		public List<ExceptCaseContext> exceptCase() {
			return getRuleContexts(ExceptCaseContext.class);
		}
		public ExceptCaseContext exceptCase(int i) {
			return getRuleContext(ExceptCaseContext.class,i);
		}
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public ExceptConstructContext(FunctionOrRecordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterExceptConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitExceptConstruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitExceptConstruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListMappingContext extends FunctionOrRecordContext {
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public List<QuantifierBoundContext> quantifierBound() {
			return getRuleContexts(QuantifierBoundContext.class);
		}
		public QuantifierBoundContext quantifierBound(int i) {
			return getRuleContext(QuantifierBoundContext.class,i);
		}
		public TerminalNode BarArrow() { return getToken(PlusCalParser.BarArrow, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public ListMappingContext(FunctionOrRecordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterListMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitListMapping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitListMapping(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetMappingContext extends FunctionOrRecordContext {
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RightArrow() { return getToken(PlusCalParser.RightArrow, 0); }
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public SetMappingContext(FunctionOrRecordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterSetMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitSetMapping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitSetMapping(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BarArrowedRecordContext extends FunctionOrRecordContext {
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> BarArrow() { return getTokens(PlusCalParser.BarArrow); }
		public TerminalNode BarArrow(int i) {
			return getToken(PlusCalParser.BarArrow, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public BarArrowedRecordContext(FunctionOrRecordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterBarArrowedRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitBarArrowedRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitBarArrowedRecord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionOrRecordContext functionOrRecord() throws RecognitionException {
		FunctionOrRecordContext _localctx = new FunctionOrRecordContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_functionOrRecord);
		int _la;
		try {
			setState(1109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				_localctx = new ListMappingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1045);
				match(LeftBack);
				setState(1046);
				quantifierBound();
				setState(1051);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1047);
					match(Comma);
					setState(1048);
					quantifierBound();
					}
					}
					setState(1053);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1054);
				match(BarArrow);
				setState(1055);
				expr();
				setState(1056);
				match(RightBack);
				}
				break;
			case 2:
				_localctx = new SetMappingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1058);
				match(LeftBack);
				setState(1059);
				expr();
				setState(1060);
				match(RightArrow);
				setState(1061);
				expr();
				setState(1062);
				match(RightBack);
				}
				break;
			case 3:
				_localctx = new ColonedRecordContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1064);
				match(LeftBack);
				setState(1065);
				field();
				setState(1066);
				match(Colon);
				setState(1067);
				expr();
				setState(1075);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1068);
					match(Comma);
					setState(1069);
					field();
					setState(1070);
					match(Colon);
					setState(1071);
					expr();
					}
					}
					setState(1077);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1078);
				match(RightBack);
				}
				break;
			case 4:
				_localctx = new BarArrowedRecordContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1080);
				match(LeftBack);
				setState(1081);
				field();
				setState(1082);
				match(BarArrow);
				setState(1083);
				expr();
				setState(1091);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1084);
					match(Comma);
					setState(1085);
					field();
					setState(1086);
					match(BarArrow);
					setState(1087);
					expr();
					}
					}
					setState(1093);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1094);
				match(RightBack);
				}
				break;
			case 5:
				_localctx = new ExceptConstructContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1096);
				match(LeftBack);
				setState(1097);
				expr();
				setState(1098);
				match(Except_);
				setState(1099);
				exceptCase();
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1100);
					match(Comma);
					setState(1101);
					exceptCase();
					}
					}
					setState(1106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1107);
				match(RightBack);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseArmContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RightArrow() { return getToken(PlusCalParser.RightArrow, 0); }
		public CaseArmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseArm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterCaseArm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitCaseArm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitCaseArm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseArmContext caseArm() throws RecognitionException {
		CaseArmContext _localctx = new CaseArmContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_caseArm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111);
			expr();
			setState(1112);
			match(RightArrow);
			setState(1113);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstancePrefixContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(PlusCalParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PlusCalParser.Identifier, i);
		}
		public List<TerminalNode> Bang() { return getTokens(PlusCalParser.Bang); }
		public TerminalNode Bang(int i) {
			return getToken(PlusCalParser.Bang, i);
		}
		public List<TerminalNode> LeftParen() { return getTokens(PlusCalParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(PlusCalParser.LeftParen, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RightParen() { return getTokens(PlusCalParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(PlusCalParser.RightParen, i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public InstancePrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instancePrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInstancePrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInstancePrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInstancePrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstancePrefixContext instancePrefix() throws RecognitionException {
		InstancePrefixContext _localctx = new InstancePrefixContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_instancePrefix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1115);
					match(Identifier);
					setState(1127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftParen) {
						{
						setState(1116);
						match(LeftParen);
						setState(1117);
						expr();
						setState(1122);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(1118);
							match(Comma);
							setState(1119);
							expr();
							}
							}
							setState(1124);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1125);
						match(RightParen);
						}
					}

					setState(1129);
					match(Bang);
					}
					} 
				}
				setState(1134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptCaseContext extends ParserRuleContext {
		public TerminalNode Bang() { return getToken(PlusCalParser.Bang, 0); }
		public TerminalNode Equal() { return getToken(PlusCalParser.Equal, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Dot() { return getTokens(PlusCalParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(PlusCalParser.Dot, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> LeftBack() { return getTokens(PlusCalParser.LeftBack); }
		public TerminalNode LeftBack(int i) {
			return getToken(PlusCalParser.LeftBack, i);
		}
		public List<TerminalNode> RightBack() { return getTokens(PlusCalParser.RightBack); }
		public TerminalNode RightBack(int i) {
			return getToken(PlusCalParser.RightBack, i);
		}
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public ExceptCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterExceptCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitExceptCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitExceptCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptCaseContext exceptCase() throws RecognitionException {
		ExceptCaseContext _localctx = new ExceptCaseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_exceptCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135);
			match(Bang);
			setState(1149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Dot:
					{
					setState(1136);
					match(Dot);
					setState(1137);
					name();
					}
					break;
				case LeftBack:
					{
					setState(1138);
					match(LeftBack);
					setState(1139);
					expr();
					setState(1144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(1140);
						match(Comma);
						setState(1141);
						expr();
						}
						}
						setState(1146);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1147);
					match(RightBack);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBack || _la==Dot );
			setState(1153);
			match(Equal);
			setState(1154);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfixOpContext extends ParserRuleContext {
		public TerminalNode BangBang() { return getToken(PlusCalParser.BangBang, 0); }
		public TerminalNode SharpSharp() { return getToken(PlusCalParser.SharpSharp, 0); }
		public TerminalNode Dollar() { return getToken(PlusCalParser.Dollar, 0); }
		public TerminalNode DollarDollar() { return getToken(PlusCalParser.DollarDollar, 0); }
		public TerminalNode Mod() { return getToken(PlusCalParser.Mod, 0); }
		public TerminalNode Amp() { return getToken(PlusCalParser.Amp, 0); }
		public TerminalNode AmpAmp() { return getToken(PlusCalParser.AmpAmp, 0); }
		public TerminalNode Oplus() { return getToken(PlusCalParser.Oplus, 0); }
		public TerminalNode Ominus() { return getToken(PlusCalParser.Ominus, 0); }
		public TerminalNode Odot() { return getToken(PlusCalParser.Odot, 0); }
		public TerminalNode OSlash() { return getToken(PlusCalParser.OSlash, 0); }
		public TerminalNode Otimes() { return getToken(PlusCalParser.Otimes, 0); }
		public TerminalNode Aster() { return getToken(PlusCalParser.Aster, 0); }
		public TerminalNode AsterAster() { return getToken(PlusCalParser.AsterAster, 0); }
		public TerminalNode Minus() { return getToken(PlusCalParser.Minus, 0); }
		public TerminalNode MinusMinus() { return getToken(PlusCalParser.MinusMinus, 0); }
		public TerminalNode Plus() { return getToken(PlusCalParser.Plus, 0); }
		public TerminalNode PlusPlus() { return getToken(PlusCalParser.PlusPlus, 0); }
		public TerminalNode DashPlusArrow() { return getToken(PlusCalParser.DashPlusArrow, 0); }
		public TerminalNode DashBar() { return getToken(PlusCalParser.DashBar, 0); }
		public TerminalNode DotDot() { return getToken(PlusCalParser.DotDot, 0); }
		public TerminalNode DotDotDot() { return getToken(PlusCalParser.DotDotDot, 0); }
		public TerminalNode Slash() { return getToken(PlusCalParser.Slash, 0); }
		public TerminalNode SlashSlash() { return getToken(PlusCalParser.SlashSlash, 0); }
		public TerminalNode NotEqual() { return getToken(PlusCalParser.NotEqual, 0); }
		public TerminalNode Conjunction() { return getToken(PlusCalParser.Conjunction, 0); }
		public TerminalNode ColonColonEq() { return getToken(PlusCalParser.ColonColonEq, 0); }
		public TerminalNode ColonGt() { return getToken(PlusCalParser.ColonGt, 0); }
		public TerminalNode Less() { return getToken(PlusCalParser.Less, 0); }
		public TerminalNode LtColon() { return getToken(PlusCalParser.LtColon, 0); }
		public TerminalNode Equivalence() { return getToken(PlusCalParser.Equivalence, 0); }
		public TerminalNode Equal() { return getToken(PlusCalParser.Equal, 0); }
		public TerminalNode LessEqual() { return getToken(PlusCalParser.LessEqual, 0); }
		public TerminalNode Implication() { return getToken(PlusCalParser.Implication, 0); }
		public TerminalNode EqualBar() { return getToken(PlusCalParser.EqualBar, 0); }
		public TerminalNode Greater() { return getToken(PlusCalParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(PlusCalParser.GreaterEqual, 0); }
		public TerminalNode Times() { return getToken(PlusCalParser.Times, 0); }
		public TerminalNode QueryQuery() { return getToken(PlusCalParser.QueryQuery, 0); }
		public TerminalNode AtAt() { return getToken(PlusCalParser.AtAt, 0); }
		public TerminalNode Subtract() { return getToken(PlusCalParser.Subtract, 0); }
		public TerminalNode Disjunction() { return getToken(PlusCalParser.Disjunction, 0); }
		public TerminalNode Caret() { return getToken(PlusCalParser.Caret, 0); }
		public TerminalNode CaretCaret() { return getToken(PlusCalParser.CaretCaret, 0); }
		public TerminalNode Bar() { return getToken(PlusCalParser.Bar, 0); }
		public TerminalNode BarDash() { return getToken(PlusCalParser.BarDash, 0); }
		public TerminalNode BarEqual() { return getToken(PlusCalParser.BarEqual, 0); }
		public TerminalNode TildeGt() { return getToken(PlusCalParser.TildeGt, 0); }
		public TerminalNode Approx() { return getToken(PlusCalParser.Approx, 0); }
		public TerminalNode SqSupsetEq() { return getToken(PlusCalParser.SqSupsetEq, 0); }
		public TerminalNode Asymp() { return getToken(PlusCalParser.Asymp, 0); }
		public TerminalNode Gg() { return getToken(PlusCalParser.Gg, 0); }
		public TerminalNode Star() { return getToken(PlusCalParser.Star, 0); }
		public TerminalNode BigCirc() { return getToken(PlusCalParser.BigCirc, 0); }
		public TerminalNode In() { return getToken(PlusCalParser.In, 0); }
		public TerminalNode NotIn() { return getToken(PlusCalParser.NotIn, 0); }
		public TerminalNode Prec() { return getToken(PlusCalParser.Prec, 0); }
		public TerminalNode Subset() { return getToken(PlusCalParser.Subset, 0); }
		public TerminalNode Bullet() { return getToken(PlusCalParser.Bullet, 0); }
		public TerminalNode Cap() { return getToken(PlusCalParser.Cap, 0); }
		public TerminalNode Preceq() { return getToken(PlusCalParser.Preceq, 0); }
		public TerminalNode SubsetEq() { return getToken(PlusCalParser.SubsetEq, 0); }
		public TerminalNode PropTo() { return getToken(PlusCalParser.PropTo, 0); }
		public TerminalNode Succ() { return getToken(PlusCalParser.Succ, 0); }
		public TerminalNode Cdot() { return getToken(PlusCalParser.Cdot, 0); }
		public TerminalNode Sim() { return getToken(PlusCalParser.Sim, 0); }
		public TerminalNode Succeq() { return getToken(PlusCalParser.Succeq, 0); }
		public TerminalNode Circ() { return getToken(PlusCalParser.Circ, 0); }
		public TerminalNode Ll() { return getToken(PlusCalParser.Ll, 0); }
		public TerminalNode Simeq() { return getToken(PlusCalParser.Simeq, 0); }
		public TerminalNode Supset() { return getToken(PlusCalParser.Supset, 0); }
		public TerminalNode Cong() { return getToken(PlusCalParser.Cong, 0); }
		public TerminalNode SqCap() { return getToken(PlusCalParser.SqCap, 0); }
		public TerminalNode SupsetEq() { return getToken(PlusCalParser.SupsetEq, 0); }
		public TerminalNode Cup() { return getToken(PlusCalParser.Cup, 0); }
		public TerminalNode SqCup() { return getToken(PlusCalParser.SqCup, 0); }
		public TerminalNode Div() { return getToken(PlusCalParser.Div, 0); }
		public TerminalNode SqSubset() { return getToken(PlusCalParser.SqSubset, 0); }
		public TerminalNode Uplus() { return getToken(PlusCalParser.Uplus, 0); }
		public TerminalNode Doteq() { return getToken(PlusCalParser.Doteq, 0); }
		public TerminalNode SqSubsetEq() { return getToken(PlusCalParser.SqSubsetEq, 0); }
		public TerminalNode Wr() { return getToken(PlusCalParser.Wr, 0); }
		public TerminalNode SqSupset() { return getToken(PlusCalParser.SqSupset, 0); }
		public InfixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterInfixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitInfixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitInfixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixOpContext infixOp() throws RecognitionException {
		InfixOpContext _localctx = new InfixOpContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_infixOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Aster) | (1L << Slash) | (1L << Equal) | (1L << NotEqual) | (1L << Greater) | (1L << Less) | (1L << GreaterEqual) | (1L << LessEqual) | (1L << Caret) | (1L << Mod) | (1L << DotDot) | (1L << Conjunction) | (1L << Disjunction) | (1L << Equivalence) | (1L << In) | (1L << NotIn) | (1L << Implication) | (1L << Ll) | (1L << Gg))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Prec - 64)) | (1L << (Preceq - 64)) | (1L << (Succ - 64)) | (1L << (Succeq - 64)) | (1L << (Subset - 64)) | (1L << (SubsetEq - 64)) | (1L << (Supset - 64)) | (1L << (SupsetEq - 64)) | (1L << (SqSubset - 64)) | (1L << (SqSubsetEq - 64)) | (1L << (SqSupset - 64)) | (1L << (SqSupsetEq - 64)) | (1L << (BarDash - 64)) | (1L << (BarEqual - 64)) | (1L << (EqualBar - 64)) | (1L << (Cap - 64)) | (1L << (SqCap - 64)) | (1L << (Cup - 64)) | (1L << (SqCup - 64)) | (1L << (Oplus - 64)) | (1L << (Ominus - 64)) | (1L << (Odot - 64)) | (1L << (Otimes - 64)) | (1L << (OSlash - 64)) | (1L << (DashBar - 64)) | (1L << (Uplus - 64)) | (1L << (Times - 64)) | (1L << (Wr - 64)) | (1L << (PropTo - 64)) | (1L << (DashPlusArrow - 64)) | (1L << (Div - 64)) | (1L << (Cdot - 64)) | (1L << (Circ - 64)) | (1L << (Bullet - 64)) | (1L << (Star - 64)) | (1L << (BigCirc - 64)) | (1L << (Sim - 64)) | (1L << (Simeq - 64)) | (1L << (Asymp - 64)) | (1L << (Approx - 64)) | (1L << (Cong - 64)) | (1L << (Doteq - 64)) | (1L << (BangBang - 64)) | (1L << (SharpSharp - 64)) | (1L << (Dollar - 64)) | (1L << (DollarDollar - 64)) | (1L << (Amp - 64)) | (1L << (AmpAmp - 64)) | (1L << (AsterAster - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)) | (1L << (DotDotDot - 64)) | (1L << (SlashSlash - 64)) | (1L << (Subtract - 64)) | (1L << (ColonColonEq - 64)) | (1L << (ColonGt - 64)) | (1L << (LtColon - 64)) | (1L << (QueryQuery - 64)) | (1L << (CaretCaret - 64)) | (1L << (Bar - 64)) | (1L << (AtAt - 64)) | (1L << (TildeGt - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixOpContext extends ParserRuleContext {
		public TerminalNode CaretPlus() { return getToken(PlusCalParser.CaretPlus, 0); }
		public TerminalNode CaretAstar() { return getToken(PlusCalParser.CaretAstar, 0); }
		public TerminalNode CaretSharp() { return getToken(PlusCalParser.CaretSharp, 0); }
		public TerminalNode Prime() { return getToken(PlusCalParser.Prime, 0); }
		public TerminalNode LeftBack() { return getToken(PlusCalParser.LeftBack, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RightBack() { return getToken(PlusCalParser.RightBack, 0); }
		public List<TerminalNode> Comma() { return getTokens(PlusCalParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PlusCalParser.Comma, i);
		}
		public PostfixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPostfixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPostfixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPostfixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixOpContext postfixOp() throws RecognitionException {
		PostfixOpContext _localctx = new PostfixOpContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_postfixOp);
		int _la;
		try {
			setState(1173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CaretPlus:
				enterOuterAlt(_localctx, 1);
				{
				setState(1158);
				match(CaretPlus);
				}
				break;
			case CaretAstar:
				enterOuterAlt(_localctx, 2);
				{
				setState(1159);
				match(CaretAstar);
				}
				break;
			case CaretSharp:
				enterOuterAlt(_localctx, 3);
				{
				setState(1160);
				match(CaretSharp);
				}
				break;
			case Prime:
				enterOuterAlt(_localctx, 4);
				{
				setState(1161);
				match(Prime);
				}
				break;
			case LeftBack:
				enterOuterAlt(_localctx, 5);
				{
				setState(1162);
				match(LeftBack);
				setState(1163);
				expr();
				setState(1168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1164);
					match(Comma);
					setState(1165);
					expr();
					}
					}
					setState(1170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1171);
				match(RightBack);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixOpContext extends ParserRuleContext {
		public TerminalNode Minus() { return getToken(PlusCalParser.Minus, 0); }
		public TerminalNode Negation() { return getToken(PlusCalParser.Negation, 0); }
		public TerminalNode Square() { return getToken(PlusCalParser.Square, 0); }
		public TerminalNode Diamond() { return getToken(PlusCalParser.Diamond, 0); }
		public TerminalNode Domain_() { return getToken(PlusCalParser.Domain_, 0); }
		public TerminalNode Enabled_() { return getToken(PlusCalParser.Enabled_, 0); }
		public TerminalNode Subset_() { return getToken(PlusCalParser.Subset_, 0); }
		public TerminalNode Unchanged_() { return getToken(PlusCalParser.Unchanged_, 0); }
		public TerminalNode Union_() { return getToken(PlusCalParser.Union_, 0); }
		public PrefixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPrefixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPrefixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPrefixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOpContext prefixOp() throws RecognitionException {
		PrefixOpContext _localctx = new PrefixOpContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_prefixOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1175);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Minus) | (1L << Negation) | (1L << Diamond) | (1L << Square))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (Enabled_ - 151)) | (1L << (Unchanged_ - 151)) | (1L << (Union_ - 151)) | (1L << (Subset_ - 151)) | (1L << (Domain_ - 151)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(PlusCalParser.Integer, 0); }
		public TerminalNode Float() { return getToken(PlusCalParser.Float, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1177);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==Float) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TlaEscapeWordContext extends ParserRuleContext {
		public TerminalNode Assume_() { return getToken(PlusCalParser.Assume_, 0); }
		public TerminalNode Assumption_() { return getToken(PlusCalParser.Assumption_, 0); }
		public TerminalNode Axiom_() { return getToken(PlusCalParser.Axiom_, 0); }
		public TerminalNode Case_() { return getToken(PlusCalParser.Case_, 0); }
		public TerminalNode Choose_() { return getToken(PlusCalParser.Choose_, 0); }
		public TerminalNode Constant_() { return getToken(PlusCalParser.Constant_, 0); }
		public TerminalNode Constants_() { return getToken(PlusCalParser.Constants_, 0); }
		public TerminalNode Domain_() { return getToken(PlusCalParser.Domain_, 0); }
		public TerminalNode Else_() { return getToken(PlusCalParser.Else_, 0); }
		public TerminalNode Enabled_() { return getToken(PlusCalParser.Enabled_, 0); }
		public TerminalNode Except_() { return getToken(PlusCalParser.Except_, 0); }
		public TerminalNode Extends_() { return getToken(PlusCalParser.Extends_, 0); }
		public TerminalNode If_() { return getToken(PlusCalParser.If_, 0); }
		public TerminalNode In_() { return getToken(PlusCalParser.In_, 0); }
		public TerminalNode Instance_() { return getToken(PlusCalParser.Instance_, 0); }
		public TerminalNode Let_() { return getToken(PlusCalParser.Let_, 0); }
		public TerminalNode Local_() { return getToken(PlusCalParser.Local_, 0); }
		public TerminalNode Module_() { return getToken(PlusCalParser.Module_, 0); }
		public TerminalNode Other_() { return getToken(PlusCalParser.Other_, 0); }
		public TerminalNode Union_() { return getToken(PlusCalParser.Union_, 0); }
		public TerminalNode Subset_() { return getToken(PlusCalParser.Subset_, 0); }
		public TerminalNode Then_() { return getToken(PlusCalParser.Then_, 0); }
		public TerminalNode Theorem_() { return getToken(PlusCalParser.Theorem_, 0); }
		public TerminalNode Unchanged_() { return getToken(PlusCalParser.Unchanged_, 0); }
		public TerminalNode Variable_() { return getToken(PlusCalParser.Variable_, 0); }
		public TerminalNode Variables_() { return getToken(PlusCalParser.Variables_, 0); }
		public TerminalNode With_() { return getToken(PlusCalParser.With_, 0); }
		public TlaEscapeWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tlaEscapeWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterTlaEscapeWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitTlaEscapeWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitTlaEscapeWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TlaEscapeWordContext tlaEscapeWord() throws RecognitionException {
		TlaEscapeWordContext _localctx = new TlaEscapeWordContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_tlaEscapeWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1179);
			_la = _input.LA(1);
			if ( !(((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (Except_ - 148)) | (1L << (Constant_ - 148)) | (1L << (Constants_ - 148)) | (1L << (Enabled_ - 148)) | (1L << (Unchanged_ - 148)) | (1L << (Union_ - 148)) | (1L << (Subset_ - 148)) | (1L << (Domain_ - 148)) | (1L << (Assume_ - 148)) | (1L << (Assumption_ - 148)) | (1L << (Axiom_ - 148)) | (1L << (Case_ - 148)) | (1L << (Choose_ - 148)) | (1L << (Else_ - 148)) | (1L << (Extends_ - 148)) | (1L << (If_ - 148)) | (1L << (In_ - 148)) | (1L << (Instance_ - 148)) | (1L << (Let_ - 148)) | (1L << (Local_ - 148)) | (1L << (Module_ - 148)) | (1L << (Other_ - 148)) | (1L << (Then_ - 148)) | (1L << (Theorem_ - 148)) | (1L << (Variable_ - 148)) | (1L << (Variables_ - 148)) | (1L << (With_ - 148)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusCalReservedWordContext extends ParserRuleContext {
		public TerminalNode Assert() { return getToken(PlusCalParser.Assert, 0); }
		public TerminalNode Await() { return getToken(PlusCalParser.Await, 0); }
		public TerminalNode Begin() { return getToken(PlusCalParser.Begin, 0); }
		public TerminalNode Call() { return getToken(PlusCalParser.Call, 0); }
		public TerminalNode Define() { return getToken(PlusCalParser.Define, 0); }
		public TerminalNode Do() { return getToken(PlusCalParser.Do, 0); }
		public TerminalNode Either() { return getToken(PlusCalParser.Either, 0); }
		public TerminalNode Else() { return getToken(PlusCalParser.Else, 0); }
		public TerminalNode ElseIf() { return getToken(PlusCalParser.ElseIf, 0); }
		public TerminalNode End() { return getToken(PlusCalParser.End, 0); }
		public TerminalNode Goto() { return getToken(PlusCalParser.Goto, 0); }
		public TerminalNode If() { return getToken(PlusCalParser.If, 0); }
		public TerminalNode Macro() { return getToken(PlusCalParser.Macro, 0); }
		public TerminalNode Or() { return getToken(PlusCalParser.Or, 0); }
		public TerminalNode Print() { return getToken(PlusCalParser.Print, 0); }
		public TerminalNode Procedure() { return getToken(PlusCalParser.Procedure, 0); }
		public TerminalNode Process() { return getToken(PlusCalParser.Process, 0); }
		public TerminalNode Return() { return getToken(PlusCalParser.Return, 0); }
		public TerminalNode Skip() { return getToken(PlusCalParser.Skip, 0); }
		public TerminalNode Then() { return getToken(PlusCalParser.Then, 0); }
		public TerminalNode Variable() { return getToken(PlusCalParser.Variable, 0); }
		public TerminalNode Variables() { return getToken(PlusCalParser.Variables, 0); }
		public TerminalNode When() { return getToken(PlusCalParser.When, 0); }
		public TerminalNode While() { return getToken(PlusCalParser.While, 0); }
		public TerminalNode With() { return getToken(PlusCalParser.With, 0); }
		public PlusCalReservedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusCalReservedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).enterPlusCalReservedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusCalParserListener ) ((PlusCalParserListener)listener).exitPlusCalReservedWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlusCalParserVisitor ) return ((PlusCalParserVisitor<? extends T>)visitor).visitPlusCalReservedWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusCalReservedWordContext plusCalReservedWord() throws RecognitionException {
		PlusCalReservedWordContext _localctx = new PlusCalReservedWordContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_plusCalReservedWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1181);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << While) | (1L << Variables) | (1L << Variable) | (1L << Assert) | (1L << If) | (1L << Else) | (1L << ElseIf) | (1L << Either) | (1L << Or) | (1L << Skip) | (1L << Await) | (1L << With) | (1L << Call) | (1L << Return) | (1L << Print) | (1L << Define) | (1L << Macro) | (1L << Procedure) | (1L << Process) | (1L << Begin) | (1L << End) | (1L << Do) | (1L << Goto) | (1L << Then) | (1L << When))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return procedure_sempred((ProcedureContext)_localctx, predIndex);
		case 2:
			return macro_sempred((MacroContext)_localctx, predIndex);
		case 3:
			return definitions_sempred((DefinitionsContext)_localctx, predIndex);
		case 6:
			return process_sempred((ProcessContext)_localctx, predIndex);
		case 12:
			return stmt_sempred((StmtContext)_localctx, predIndex);
		case 13:
			return unLabeledStmt_sempred((UnLabeledStmtContext)_localctx, predIndex);
		case 38:
			return primaryExpr_sempred((PrimaryExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean procedure_sempred(ProcedureContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return cSyntax;
		case 1:
			return pSyntax;
		}
		return true;
	}
	private boolean macro_sempred(MacroContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return cSyntax;
		case 3:
			return pSyntax;
		}
		return true;
	}
	private boolean definitions_sempred(DefinitionsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return cSyntax;
		case 5:
			return pSyntax;
		}
		return true;
	}
	private boolean process_sempred(ProcessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return cSyntax;
		case 7:
			return pSyntax;
		}
		return true;
	}
	private boolean stmt_sempred(StmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return cSyntax;
		case 9:
			return pSyntax;
		}
		return true;
	}
	private boolean unLabeledStmt_sempred(UnLabeledStmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return cSyntax;
		case 11:
			return pSyntax;
		case 12:
			return cSyntax;
		case 13:
			return pSyntax;
		case 14:
			return cSyntax;
		case 15:
			return pSyntax;
		case 16:
			return cSyntax;
		case 17:
			return pSyntax;
		}
		return true;
	}
	private boolean primaryExpr_sempred(PrimaryExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00be\u04a2\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\5\2i\n\2\3\2\3\2\3\2\3\2\3\2\5\2p\n\2\3\2\5\2s\n\2\3\2\7\2v\n\2\f\2\16"+
		"\2y\13\2\3\2\7\2|\n\2\f\2\16\2\177\13\2\3\2\3\2\6\2\u0083\n\2\r\2\16\2"+
		"\u0084\5\2\u0087\n\2\3\2\3\2\3\2\3\2\3\2\5\2\u008e\n\2\3\2\3\2\3\2\3\2"+
		"\5\2\u0094\n\2\3\2\5\2\u0097\n\2\3\2\7\2\u009a\n\2\f\2\16\2\u009d\13\2"+
		"\3\2\7\2\u00a0\n\2\f\2\16\2\u00a3\13\2\3\2\3\2\6\2\u00a7\n\2\r\2\16\2"+
		"\u00a8\5\2\u00ab\n\2\3\2\3\2\3\2\3\2\5\2\u00b1\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3\u00ba\n\3\f\3\16\3\u00bd\13\3\5\3\u00bf\n\3\3\3\3\3\5\3\u00c3"+
		"\n\3\3\3\3\3\5\3\u00c7\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00d0\n\3\f"+
		"\3\16\3\u00d3\13\3\5\3\u00d5\n\3\3\3\3\3\5\3\u00d9\n\3\3\3\3\3\5\3\u00dd"+
		"\n\3\5\3\u00df\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00e8\n\4\f\4\16\4"+
		"\u00eb\13\4\5\4\u00ed\n\4\3\4\3\4\3\4\5\4\u00f2\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\7\4\u00fb\n\4\f\4\16\4\u00fe\13\4\5\4\u0100\n\4\3\4\3\4\3\4"+
		"\3\4\5\4\u0106\n\4\5\4\u0108\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0110\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0118\n\5\5\5\u011a\n\5\3\6\3\6\6\6\u011e"+
		"\n\6\r\6\16\6\u011f\3\7\3\7\3\7\5\7\u0125\n\7\3\7\3\7\3\b\3\b\3\b\5\b"+
		"\u012c\n\b\5\b\u012e\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0137\n\b\3\b"+
		"\3\b\5\b\u013b\n\b\3\b\3\b\3\b\5\b\u0140\n\b\5\b\u0142\n\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u014b\n\b\3\b\3\b\3\b\3\b\5\b\u0151\n\b\5\b\u0153"+
		"\n\b\3\t\3\t\6\t\u0157\n\t\r\t\16\t\u0158\3\n\3\n\3\n\3\n\6\n\u015f\n"+
		"\n\r\n\16\n\u0160\3\13\3\13\3\13\5\13\u0166\n\13\3\f\3\f\6\f\u016a\n\f"+
		"\r\f\16\f\u016b\3\r\3\r\3\r\3\r\7\r\u0172\n\r\f\r\16\r\u0175\13\r\3\r"+
		"\5\r\u0178\n\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u0180\n\16\5\16\u0182"+
		"\n\16\3\16\3\16\5\16\u0186\n\16\3\16\3\16\3\16\3\16\5\16\u018c\n\16\5"+
		"\16\u018e\n\16\3\16\3\16\3\16\5\16\u0193\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u019d\n\17\f\17\16\17\u01a0\13\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u01aa\n\17\3\17\3\17\3\17\3\17\3\17\6\17"+
		"\u01b1\n\17\r\17\16\17\u01b2\3\17\3\17\3\17\3\17\6\17\u01b9\n\17\r\17"+
		"\16\17\u01ba\7\17\u01bd\n\17\f\17\16\17\u01c0\13\17\3\17\3\17\6\17\u01c4"+
		"\n\17\r\17\16\17\u01c5\5\17\u01c8\n\17\3\17\3\17\3\17\5\17\u01cd\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u01db"+
		"\n\17\r\17\16\17\u01dc\3\17\3\17\3\17\5\17\u01e2\n\17\3\17\3\17\3\17\3"+
		"\17\3\17\6\17\u01e9\n\17\r\17\16\17\u01ea\3\17\3\17\3\17\6\17\u01f0\n"+
		"\17\r\17\16\17\u01f1\3\17\3\17\6\17\u01f6\n\17\r\17\16\17\u01f7\6\17\u01fa"+
		"\n\17\r\17\16\17\u01fb\3\17\3\17\3\17\5\17\u0201\n\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\7\17\u0209\n\17\f\17\16\17\u020c\13\17\3\17\5\17\u020f\n"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u0219\n\17\r\17\16\17"+
		"\u021a\3\17\3\17\6\17\u021f\n\17\r\17\16\17\u0220\3\17\3\17\3\17\5\17"+
		"\u0226\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u0238\n\17\f\17\16\17\u023b\13\17\5\17\u023d"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0247\n\17\f\17\16"+
		"\17\u024a\13\17\5\17\u024c\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u0257\n\17\f\17\16\17\u025a\13\17\5\17\u025c\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0267\n\17\f\17\16\17\u026a\13"+
		"\17\5\17\u026c\n\17\3\17\3\17\5\17\u0270\n\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u027b\n\21\f\21\16\21\u027e\13\21\3\21\3\21"+
		"\3\21\3\21\7\21\u0284\n\21\f\21\16\21\u0287\13\21\3\22\3\22\3\23\3\23"+
		"\3\23\5\23\u028e\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\6\26\u0297\n"+
		"\26\r\26\16\26\u0298\3\27\3\27\3\27\3\27\3\27\7\27\u02a0\n\27\f\27\16"+
		"\27\u02a3\13\27\3\27\3\27\5\27\u02a7\n\27\3\30\3\30\5\30\u02ab\n\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\5\31\u02c1\n\31\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u02c8\n\32\f\32\16\32\u02cb\13\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\7\33\u02d6\n\33\f\33\16\33\u02d9\13\33\3\33\5\33\u02dc"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u02e7\n\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u02f3\n\35\f\35\16"+
		"\35\u02f6\13\35\5\35\u02f8\n\35\3\36\3\36\3\36\3\36\5\36\u02fe\n\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\7\37\u0308\n\37\f\37\16\37\u030b"+
		"\13\37\3\37\3\37\5\37\u030f\n\37\3 \3 \3 \3 \7 \u0315\n \f \16 \u0318"+
		"\13 \5 \u031a\n \3 \3 \3 \3 \3 \3 \3 \7 \u0323\n \f \16 \u0326\13 \5 "+
		"\u0328\n \3 \3 \3 \3 \3 \3 \3 \7 \u0331\n \f \16 \u0334\13 \5 \u0336\n"+
		" \3 \3 \5 \u033a\n \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\5$\u0349"+
		"\n$\3%\3%\3%\3&\7&\u034f\n&\f&\16&\u0352\13&\3&\7&\u0355\n&\f&\16&\u0358"+
		"\13&\3&\3&\7&\u035c\n&\f&\16&\u035f\13&\3&\3&\7&\u0363\n&\f&\16&\u0366"+
		"\13&\3&\3&\7&\u036a\n&\f&\16&\u036d\13&\7&\u036f\n&\f&\16&\u0372\13&\3"+
		"\'\3\'\6\'\u0376\n\'\r\'\16\'\u0377\5\'\u037a\n\'\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\7(\u0386\n(\f(\16(\u0389\13(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\7(\u0395\n(\f(\16(\u0398\13(\3(\3(\3(\3(\3(\3(\3(\7(\u03a1\n(\f(\16("+
		"\u03a4\13(\3(\3(\3(\3(\3(\3(\3(\5(\u03ad\n(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\7(\u03b8\n(\f(\16(\u03bb\13(\5(\u03bd\n(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u03db\n("+
		"\f(\16(\u03de\13(\3(\3(\3(\3(\5(\u03e4\n(\3(\3(\3(\3(\3(\5(\u03eb\n(\3"+
		"(\3(\3(\7(\u03f0\n(\f(\16(\u03f3\13(\3)\3)\3)\3)\7)\u03f9\n)\f)\16)\u03fc"+
		"\13)\5)\u03fe\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u040f"+
		"\n)\f)\16)\u0412\13)\3)\3)\5)\u0416\n)\3*\3*\3*\3*\7*\u041c\n*\f*\16*"+
		"\u041f\13*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7"+
		"*\u0434\n*\f*\16*\u0437\13*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0444"+
		"\n*\f*\16*\u0447\13*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0451\n*\f*\16*\u0454"+
		"\13*\3*\3*\5*\u0458\n*\3+\3+\3+\3+\3,\3,\3,\3,\3,\7,\u0463\n,\f,\16,\u0466"+
		"\13,\3,\3,\5,\u046a\n,\3,\7,\u046d\n,\f,\16,\u0470\13,\3-\3-\3-\3-\3-"+
		"\3-\3-\7-\u0479\n-\f-\16-\u047c\13-\3-\3-\6-\u0480\n-\r-\16-\u0481\3-"+
		"\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\7/\u0491\n/\f/\16/\u0494\13/\3/\3"+
		"/\5/\u0498\n/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\2\3N\64\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bd\2\20\3\2\5\6\4\2$$\67\67\4\2\u008f\u008f\u0091\u0091\3\2\37"+
		" \4\2\16\16\34\34\3\2\62\63\3\29:\3\29<\3\2\u00b1\u00b2\r\2\37\"$)-.\60"+
		"\60\62\63\65\65\678==@oq{}\u0081\6\2  **>?\u0099\u009d\4\2\u00b4\u00b4"+
		"\u00b9\u00b9\3\2\u0096\u00b0\3\2\4\34\2\u0532\2\u00b0\3\2\2\2\4\u00de"+
		"\3\2\2\2\6\u0107\3\2\2\2\b\u0119\3\2\2\2\n\u011b\3\2\2\2\f\u0121\3\2\2"+
		"\2\16\u0152\3\2\2\2\20\u0154\3\2\2\2\22\u015a\3\2\2\2\24\u0162\3\2\2\2"+
		"\26\u0167\3\2\2\2\30\u016d\3\2\2\2\32\u0192\3\2\2\2\34\u026f\3\2\2\2\36"+
		"\u0271\3\2\2\2 \u0275\3\2\2\2\"\u0288\3\2\2\2$\u028d\3\2\2\2&\u028f\3"+
		"\2\2\2(\u0291\3\2\2\2*\u0296\3\2\2\2,\u029a\3\2\2\2.\u02aa\3\2\2\2\60"+
		"\u02c0\3\2\2\2\62\u02c2\3\2\2\2\64\u02e6\3\2\2\2\66\u02e8\3\2\2\28\u02ec"+
		"\3\2\2\2:\u02fd\3\2\2\2<\u030e\3\2\2\2>\u0339\3\2\2\2@\u033b\3\2\2\2B"+
		"\u033e\3\2\2\2D\u0341\3\2\2\2F\u0348\3\2\2\2H\u034a\3\2\2\2J\u0350\3\2"+
		"\2\2L\u0379\3\2\2\2N\u03ea\3\2\2\2P\u0415\3\2\2\2R\u0457\3\2\2\2T\u0459"+
		"\3\2\2\2V\u046e\3\2\2\2X\u0471\3\2\2\2Z\u0486\3\2\2\2\\\u0497\3\2\2\2"+
		"^\u0499\3\2\2\2`\u049b\3\2\2\2b\u049d\3\2\2\2d\u049f\3\2\2\2fh\7u\2\2"+
		"gi\7\35\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\3\2\2kl\5(\25\2lm\7\u008b"+
		"\2\2mo\b\2\1\2np\5\n\6\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qs\5\b\5\2rq\3\2"+
		"\2\2rs\3\2\2\2sw\3\2\2\2tv\5\6\4\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2x}\3\2\2\2yw\3\2\2\2z|\5\4\3\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~"+
		"\3\2\2\2~\u0086\3\2\2\2\177}\3\2\2\2\u0080\u0087\5\30\r\2\u0081\u0083"+
		"\5\16\b\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0082"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\u008c\2\2\u0089\u008a\7\2\2"+
		"\3\u008a\u00b1\3\2\2\2\u008b\u008d\7u\2\2\u008c\u008e\7\35\2\2\u008d\u008c"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\3\2\2\u0090"+
		"\u0091\5(\25\2\u0091\u0093\b\2\1\2\u0092\u0094\5\n\6\2\u0093\u0092\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5\b\5\2\u0096"+
		"\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009b\3\2\2\2\u0098\u009a\5\6"+
		"\4\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u00a1\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\5\4"+
		"\3\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00aa\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00ab\5\26"+
		"\f\2\u00a5\u00a7\5\16\b\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a4\3\2"+
		"\2\2\u00aa\u00a6\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7\30\2\2\u00ad"+
		"\u00ae\7\3\2\2\u00ae\u00af\7\2\2\3\u00af\u00b1\3\2\2\2\u00b0f\3\2\2\2"+
		"\u00b0\u008b\3\2\2\2\u00b1\3\3\2\2\2\u00b2\u00b3\6\3\2\2\u00b3\u00b4\7"+
		"\25\2\2\u00b4\u00b5\5(\25\2\u00b5\u00be\7\u0089\2\2\u00b6\u00bb\5\24\13"+
		"\2\u00b7\u00b8\7\u0091\2\2\u00b8\u00ba\5\24\13\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be\u00b6\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c2\7\u008a\2\2\u00c1\u00c3\5\22\n\2\u00c2\u00c1"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\5\30\r\2"+
		"\u00c5\u00c7\7\u008f\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00df\3\2\2\2\u00c8\u00c9\6\3\3\2\u00c9\u00ca\7\25\2\2\u00ca\u00cb\5"+
		"(\25\2\u00cb\u00d4\7\u0089\2\2\u00cc\u00d1\5\24\13\2\u00cd\u00ce\7\u0091"+
		"\2\2\u00ce\u00d0\5\24\13\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d8\7\u008a\2\2\u00d7\u00d9\5\22\n\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\5\26\f\2\u00db\u00dd\7\u008f"+
		"\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00b2\3\2\2\2\u00de\u00c8\3\2\2\2\u00df\5\3\2\2\2\u00e0\u00e1\6\4\4\2"+
		"\u00e1\u00e2\7\24\2\2\u00e2\u00e3\5(\25\2\u00e3\u00ec\7\u0089\2\2\u00e4"+
		"\u00e9\5\"\22\2\u00e5\u00e6\7\u0091\2\2\u00e6\u00e8\5\"\22\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\u008a\2\2\u00ef\u00f1\5\30\r\2"+
		"\u00f0\u00f2\7\u008f\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u0108\3\2\2\2\u00f3\u00f4\6\4\5\2\u00f4\u00f5\7\24\2\2\u00f5\u00f6\5"+
		"(\25\2\u00f6\u00ff\7\u0089\2\2\u00f7\u00fc\5\"\22\2\u00f8\u00f9\7\u0091"+
		"\2\2\u00f9\u00fb\5\"\22\2\u00fa\u00f8\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00ff\u00f7\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0102\5\26\f\2\u0102\u0103\7\30\2\2\u0103\u0105\7\24\2\2\u0104\u0106"+
		"\7\u008f\2\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2"+
		"\2\u0107\u00e0\3\2\2\2\u0107\u00f3\3\2\2\2\u0108\7\3\2\2\2\u0109\u010a"+
		"\6\5\6\2\u010a\u010b\7\23\2\2\u010b\u010c\7\u008b\2\2\u010c\u010d\5*\26"+
		"\2\u010d\u010f\7\u008c\2\2\u010e\u0110\7\u008f\2\2\u010f\u010e\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110\u011a\3\2\2\2\u0111\u0112\6\5\7\2\u0112\u0113"+
		"\7\23\2\2\u0113\u0114\5*\26\2\u0114\u0115\7\30\2\2\u0115\u0117\7\23\2"+
		"\2\u0116\u0118\7\u008f\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u0109\3\2\2\2\u0119\u0111\3\2\2\2\u011a\t\3\2\2\2"+
		"\u011b\u011d\t\2\2\2\u011c\u011e\5\f\7\2\u011d\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\13\3\2\2\2\u0121"+
		"\u0124\5\"\22\2\u0122\u0123\t\3\2\2\u0123\u0125\5J&\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\t\4\2\2\u0127"+
		"\r\3\2\2\2\u0128\u012d\6\b\b\2\u0129\u012b\7\35\2\2\u012a\u012c\7\37\2"+
		"\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u0129"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7\26\2\2"+
		"\u0130\u0131\7\u0089\2\2\u0131\u0132\5(\25\2\u0132\u0133\t\3\2\2\u0133"+
		"\u0134\5J&\2\u0134\u0136\7\u008a\2\2\u0135\u0137\5\20\t\2\u0136\u0135"+
		"\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\5\30\r\2"+
		"\u0139\u013b\7\u008f\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u0153\3\2\2\2\u013c\u0141\6\b\t\2\u013d\u013f\7\35\2\2\u013e\u0140\7"+
		"\37\2\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141"+
		"\u013d\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\7\26"+
		"\2\2\u0144\u0145\7\u0089\2\2\u0145\u0146\5(\25\2\u0146\u0147\t\3\2\2\u0147"+
		"\u0148\5J&\2\u0148\u014a\7\u008a\2\2\u0149\u014b\5\20\t\2\u014a\u0149"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\5\26\f\2"+
		"\u014d\u014e\7\30\2\2\u014e\u0150\7\26\2\2\u014f\u0151\7\u008f\2\2\u0150"+
		"\u014f\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0128\3\2"+
		"\2\2\u0152\u013c\3\2\2\2\u0153\17\3\2\2\2\u0154\u0156\t\2\2\2\u0155\u0157"+
		"\5\f\7\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\21\3\2\2\2\u015a\u015e\t\2\2\2\u015b\u015c\5\24\13"+
		"\2\u015c\u015d\t\4\2\2\u015d\u015f\3\2\2\2\u015e\u015b\3\2\2\2\u015f\u0160"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\23\3\2\2\2\u0162"+
		"\u0165\5\"\22\2\u0163\u0164\7$\2\2\u0164\u0166\5J&\2\u0165\u0163\3\2\2"+
		"\2\u0165\u0166\3\2\2\2\u0166\25\3\2\2\2\u0167\u0169\7\27\2\2\u0168\u016a"+
		"\5\32\16\2\u0169\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2"+
		"\u016b\u016c\3\2\2\2\u016c\27\3\2\2\2\u016d\u016e\7\u008b\2\2\u016e\u0173"+
		"\5\32\16\2\u016f\u0170\7\u008f\2\2\u0170\u0172\5\32\16\2\u0171\u016f\3"+
		"\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0178\7\u008f\2\2\u0177\u0176"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\7\u008c\2"+
		"\2\u017a\31\3\2\2\2\u017b\u0181\6\16\n\2\u017c\u017d\5&\24\2\u017d\u017f"+
		"\7\u0090\2\2\u017e\u0180\t\5\2\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2"+
		"\2\u0180\u0182\3\2\2\2\u0181\u017c\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0185"+
		"\3\2\2\2\u0183\u0186\5\34\17\2\u0184\u0186\5\30\r\2\u0185\u0183\3\2\2"+
		"\2\u0185\u0184\3\2\2\2\u0186\u0193\3\2\2\2\u0187\u018d\6\16\13\2\u0188"+
		"\u0189\5&\24\2\u0189\u018b\7\u0090\2\2\u018a\u018c\t\5\2\2\u018b\u018a"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\3\2\2\2\u018d\u0188\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\5\34\17\2\u0190\u0191\7"+
		"\u008f\2\2\u0191\u0193\3\2\2\2\u0192\u017b\3\2\2\2\u0192\u0187\3\2\2\2"+
		"\u0193\33\3\2\2\2\u0194\u0195\5 \21\2\u0195\u0196\7#\2\2\u0196\u019e\5"+
		"J&\2\u0197\u0198\7\u0095\2\2\u0198\u0199\5 \21\2\u0199\u019a\7#\2\2\u019a"+
		"\u019b\5J&\2\u019b\u019d\3\2\2\2\u019c\u0197\3\2\2\2\u019d\u01a0\3\2\2"+
		"\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u0270\3\2\2\2\u01a0\u019e"+
		"\3\2\2\2\u01a1\u01a2\6\17\f\2\u01a2\u01a3\7\b\2\2\u01a3\u01a4\7\u0089"+
		"\2\2\u01a4\u01a5\5J&\2\u01a5\u01a6\7\u008a\2\2\u01a6\u01a9\5\32\16\2\u01a7"+
		"\u01a8\7\t\2\2\u01a8\u01aa\5\32\16\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3"+
		"\2\2\2\u01aa\u01cd\3\2\2\2\u01ab\u01ac\6\17\r\2\u01ac\u01ad\7\b\2\2\u01ad"+
		"\u01ae\5J&\2\u01ae\u01b0\7\33\2\2\u01af\u01b1\5\32\16\2\u01b0\u01af\3"+
		"\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01be\3\2\2\2\u01b4\u01b5\7\n\2\2\u01b5\u01b6\5J&\2\u01b6\u01b8\7\33"+
		"\2\2\u01b7\u01b9\5\32\16\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01b4\3\2"+
		"\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01c7\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c3\7\t\2\2\u01c2\u01c4\5\32"+
		"\16\2\u01c3\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c1\3\2\2\2\u01c7\u01c8\3\2"+
		"\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\7\30\2\2\u01ca\u01cb\7\b\2\2\u01cb"+
		"\u01cd\3\2\2\2\u01cc\u01a1\3\2\2\2\u01cc\u01ab\3\2\2\2\u01cd\u0270\3\2"+
		"\2\2\u01ce\u01cf\6\17\16\2\u01cf\u01d0\7\4\2\2\u01d0\u01d1\7\u0089\2\2"+
		"\u01d1\u01d2\5J&\2\u01d2\u01d3\7\u008a\2\2\u01d3\u01d4\5\32\16\2\u01d4"+
		"\u01e2\3\2\2\2\u01d5\u01d6\6\17\17\2\u01d6\u01d7\7\4\2\2\u01d7\u01d8\5"+
		"J&\2\u01d8\u01da\7\31\2\2\u01d9\u01db\5\32\16\2\u01da\u01d9\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01df\7\30\2\2\u01df\u01e0\7\4\2\2\u01e0\u01e2\3\2\2\2\u01e1"+
		"\u01ce\3\2\2\2\u01e1\u01d5\3\2\2\2\u01e2\u0270\3\2\2\2\u01e3\u01e4\6\17"+
		"\20\2\u01e4\u01e5\7\13\2\2\u01e5\u01e8\5\32\16\2\u01e6\u01e7\7\f\2\2\u01e7"+
		"\u01e9\5\32\16\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01e8\3"+
		"\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u0201\3\2\2\2\u01ec\u01ed\6\17\21\2\u01ed"+
		"\u01ef\7\13\2\2\u01ee\u01f0\5\32\16\2\u01ef\u01ee\3\2\2\2\u01f0\u01f1"+
		"\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f9\3\2\2\2\u01f3"+
		"\u01f5\7\f\2\2\u01f4\u01f6\5\32\16\2\u01f5\u01f4\3\2\2\2\u01f6\u01f7\3"+
		"\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9"+
		"\u01f3\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7\30\2\2\u01fe\u01ff\7\13\2\2\u01ff"+
		"\u0201\3\2\2\2\u0200\u01e3\3\2\2\2\u0200\u01ec\3\2\2\2\u0201\u0270\3\2"+
		"\2\2\u0202\u0203\6\17\22\2\u0203\u0204\7\17\2\2\u0204\u0205\7\u0089\2"+
		"\2\u0205\u020a\5\36\20\2\u0206\u0207\t\4\2\2\u0207\u0209\5\36\20\2\u0208"+
		"\u0206\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2"+
		"\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u020f\t\4\2\2\u020e"+
		"\u020d\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\7\u008a"+
		"\2\2\u0211\u0212\5\32\16\2\u0212\u0226\3\2\2\2\u0213\u0214\6\17\23\2\u0214"+
		"\u0218\7\17\2\2\u0215\u0216\5\36\20\2\u0216\u0217\t\4\2\2\u0217\u0219"+
		"\3\2\2\2\u0218\u0215\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u0218\3\2\2\2\u021a"+
		"\u021b\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021e\7\31\2\2\u021d\u021f\5"+
		"\32\16\2\u021e\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u021e\3\2\2\2\u0220"+
		"\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\7\30\2\2\u0223\u0224\7"+
		"\17\2\2\u0224\u0226\3\2\2\2\u0225\u0202\3\2\2\2\u0225\u0213\3\2\2\2\u0226"+
		"\u0270\3\2\2\2\u0227\u0228\t\6\2\2\u0228\u0270\5J&\2\u0229\u022a\7\22"+
		"\2\2\u022a\u0270\5J&\2\u022b\u022c\7\7\2\2\u022c\u0270\5J&\2\u022d\u0270"+
		"\7\r\2\2\u022e\u0270\7\21\2\2\u022f\u0230\7\32\2\2\u0230\u0270\5&\24\2"+
		"\u0231\u0232\7\20\2\2\u0232\u0233\5(\25\2\u0233\u023c\7\u0089\2\2\u0234"+
		"\u0239\5J&\2\u0235\u0236\7\u0091\2\2\u0236\u0238\5J&\2\u0237\u0235\3\2"+
		"\2\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u0234\3\2\2\2\u023c\u023d\3\2"+
		"\2\2\u023d\u023e\3\2\2\2\u023e\u023f\7\u008a\2\2\u023f\u0270\3\2\2\2\u0240"+
		"\u0241\7\20\2\2\u0241\u0242\5(\25\2\u0242\u024b\7\u0089\2\2\u0243\u0248"+
		"\5J&\2\u0244\u0245\7\u0091\2\2\u0245\u0247\5J&\2\u0246\u0244\3\2\2\2\u0247"+
		"\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024c\3\2"+
		"\2\2\u024a\u0248\3\2\2\2\u024b\u0243\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u024d\3\2\2\2\u024d\u024e\7\u008a\2\2\u024e\u024f\7\21\2\2\u024f\u0270"+
		"\3\2\2\2\u0250\u0251\7\20\2\2\u0251\u0252\5(\25\2\u0252\u025b\7\u0089"+
		"\2\2\u0253\u0258\5J&\2\u0254\u0255\7\u0091\2\2\u0255\u0257\5J&\2\u0256"+
		"\u0254\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2"+
		"\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025b\u0253\3\2\2\2\u025b"+
		"\u025c\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\7\u008a\2\2\u025e\u025f"+
		"\7\32\2\2\u025f\u0260\5&\24\2\u0260\u0270\3\2\2\2\u0261\u0262\5(\25\2"+
		"\u0262\u026b\7\u0089\2\2\u0263\u0268\5J&\2\u0264\u0265\7\u0091\2\2\u0265"+
		"\u0267\5J&\2\u0266\u0264\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266\3\2\2"+
		"\2\u0268\u0269\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268\3\2\2\2\u026b\u0263"+
		"\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\7\u008a\2"+
		"\2\u026e\u0270\3\2\2\2\u026f\u0194\3\2\2\2\u026f\u01cc\3\2\2\2\u026f\u01e1"+
		"\3\2\2\2\u026f\u0200\3\2\2\2\u026f\u0225\3\2\2\2\u026f\u0227\3\2\2\2\u026f"+
		"\u0229\3\2\2\2\u026f\u022b\3\2\2\2\u026f\u022d\3\2\2\2\u026f\u022e\3\2"+
		"\2\2\u026f\u022f\3\2\2\2\u026f\u0231\3\2\2\2\u026f\u0240\3\2\2\2\u026f"+
		"\u0250\3\2\2\2\u026f\u0261\3\2\2\2\u0270\35\3\2\2\2\u0271\u0272\5\"\22"+
		"\2\u0272\u0273\t\3\2\2\u0273\u0274\5J&\2\u0274\37\3\2\2\2\u0275\u0285"+
		"\5\"\22\2\u0276\u0277\7\u008d\2\2\u0277\u027c\5J&\2\u0278\u0279\7\u0091"+
		"\2\2\u0279\u027b\5J&\2\u027a\u0278\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a"+
		"\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027f\3\2\2\2\u027e\u027c\3\2\2\2\u027f"+
		"\u0280\7\u008e\2\2\u0280\u0284\3\2\2\2\u0281\u0282\7\u0092\2\2\u0282\u0284"+
		"\5$\23\2\u0283\u0276\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u0287\3\2\2\2\u0285"+
		"\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286!\3\2\2\2\u0287\u0285\3\2\2\2"+
		"\u0288\u0289\7\u00ba\2\2\u0289#\3\2\2\2\u028a\u028e\7\u00ba\2\2\u028b"+
		"\u028e\5b\62\2\u028c\u028e\5d\63\2\u028d\u028a\3\2\2\2\u028d\u028b\3\2"+
		"\2\2\u028d\u028c\3\2\2\2\u028e%\3\2\2\2\u028f\u0290\7\u00ba\2\2\u0290"+
		"\'\3\2\2\2\u0291\u0292\7\u00ba\2\2\u0292)\3\2\2\2\u0293\u0297\5\60\31"+
		"\2\u0294\u0297\5\62\32\2\u0295\u0297\5\66\34\2\u0296\u0293\3\2\2\2\u0296"+
		"\u0294\3\2\2\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0296\3\2"+
		"\2\2\u0298\u0299\3\2\2\2\u0299+\3\2\2\2\u029a\u02a6\5H%\2\u029b\u029c"+
		"\7\u0089\2\2\u029c\u02a1\5.\30\2\u029d\u029e\7\u0091\2\2\u029e\u02a0\5"+
		".\30\2\u029f\u029d\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1"+
		"\u02a2\3\2\2\2\u02a2\u02a4\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a5\7\u008a"+
		"\2\2\u02a5\u02a7\3\2\2\2\u02a6\u029b\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7"+
		"-\3\2\2\2\u02a8\u02ab\5H%\2\u02a9\u02ab\5\64\33\2\u02aa\u02a8\3\2\2\2"+
		"\u02aa\u02a9\3\2\2\2\u02ab/\3\2\2\2\u02ac\u02ad\5,\27\2\u02ad\u02ae\7"+
		"\66\2\2\u02ae\u02af\5J&\2\u02af\u02c1\3\2\2\2\u02b0\u02b1\5^\60\2\u02b1"+
		"\u02b2\5H%\2\u02b2\u02b3\7\66\2\2\u02b3\u02b4\5J&\2\u02b4\u02c1\3\2\2"+
		"\2\u02b5\u02b6\5H%\2\u02b6\u02b7\5Z.\2\u02b7\u02b8\5H%\2\u02b8\u02b9\7"+
		"\66\2\2\u02b9\u02ba\5J&\2\u02ba\u02c1\3\2\2\2\u02bb\u02bc\5H%\2\u02bc"+
		"\u02bd\5\\/\2\u02bd\u02be\7\66\2\2\u02be\u02bf\5J&\2\u02bf\u02c1\3\2\2"+
		"\2\u02c0\u02ac\3\2\2\2\u02c0\u02b0\3\2\2\2\u02c0\u02b5\3\2\2\2\u02c0\u02bb"+
		"\3\2\2\2\u02c1\61\3\2\2\2\u02c2\u02c3\5H%\2\u02c3\u02c4\7\u008d\2\2\u02c4"+
		"\u02c9\5> \2\u02c5\u02c6\7\u0091\2\2\u02c6\u02c8\5> \2\u02c7\u02c5\3\2"+
		"\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca"+
		"\u02cc\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc\u02cd\7\u008e\2\2\u02cd\u02ce"+
		"\7\66\2\2\u02ce\u02cf\5J&\2\u02cf\63\3\2\2\2\u02d0\u02db\5H%\2\u02d1\u02d2"+
		"\7\u0089\2\2\u02d2\u02d7\7\61\2\2\u02d3\u02d4\7\u0091\2\2\u02d4\u02d6"+
		"\7\61\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2"+
		"\u02d7\u02d8\3\2\2\2\u02d8\u02da\3\2\2\2\u02d9\u02d7\3\2\2\2\u02da\u02dc"+
		"\7\u008a\2\2\u02db\u02d1\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02e7\3\2\2"+
		"\2\u02dd\u02de\5^\60\2\u02de\u02df\7\61\2\2\u02df\u02e7\3\2\2\2\u02e0"+
		"\u02e1\7\61\2\2\u02e1\u02e2\5Z.\2\u02e2\u02e3\7\61\2\2\u02e3\u02e7\3\2"+
		"\2\2\u02e4\u02e5\7\61\2\2\u02e5\u02e7\5\\/\2\u02e6\u02d0\3\2\2\2\u02e6"+
		"\u02dd\3\2\2\2\u02e6\u02e0\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e7\65\3\2\2"+
		"\2\u02e8\u02e9\5,\27\2\u02e9\u02ea\7\66\2\2\u02ea\u02eb\58\35\2\u02eb"+
		"\67\3\2\2\2\u02ec\u02ed\7\u00a7\2\2\u02ed\u02f7\5(\25\2\u02ee\u02ef\7"+
		"\u00b0\2\2\u02ef\u02f4\5:\36\2\u02f0\u02f1\7\u0091\2\2\u02f1\u02f3\5:"+
		"\36\2\u02f2\u02f0\3\2\2\2\u02f3\u02f6\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u02f8\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f7\u02ee\3\2"+
		"\2\2\u02f7\u02f8\3\2\2\2\u02f89\3\2\2\2\u02f9\u02fe\5H%\2\u02fa\u02fe"+
		"\5^\60\2\u02fb\u02fe\5Z.\2\u02fc\u02fe\5\\/\2\u02fd\u02f9\3\2\2\2\u02fd"+
		"\u02fa\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fc\3\2\2\2\u02fe\u02ff\3\2"+
		"\2\2\u02ff\u0300\7,\2\2\u0300\u0301\5F$\2\u0301;\3\2\2\2\u0302\u030f\5"+
		"H%\2\u0303\u0304\7\u0093\2\2\u0304\u0309\5H%\2\u0305\u0306\7\u0091\2\2"+
		"\u0306\u0308\5H%\2\u0307\u0305\3\2\2\2\u0308\u030b\3\2\2\2\u0309\u0307"+
		"\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030c\3\2\2\2\u030b\u0309\3\2\2\2\u030c"+
		"\u030d\7\u0094\2\2\u030d\u030f\3\2\2\2\u030e\u0302\3\2\2\2\u030e\u0303"+
		"\3\2\2\2\u030f=\3\2\2\2\u0310\u031a\5<\37\2\u0311\u0316\5H%\2\u0312\u0313"+
		"\7\u0091\2\2\u0313\u0315\5H%\2\u0314\u0312\3\2\2\2\u0315\u0318\3\2\2\2"+
		"\u0316\u0314\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u031a\3\2\2\2\u0318\u0316"+
		"\3\2\2\2\u0319\u0310\3\2\2\2\u0319\u0311\3\2\2\2\u031a\u031b\3\2\2\2\u031b"+
		"\u031c\7\67\2\2\u031c\u031d\5J&\2\u031d\u033a\3\2\2\2\u031e\u0328\5<\37"+
		"\2\u031f\u0324\5H%\2\u0320\u0321\7\u0091\2\2\u0321\u0323\5H%\2\u0322\u0320"+
		"\3\2\2\2\u0323\u0326\3\2\2\2\u0324\u0322\3\2\2\2\u0324\u0325\3\2\2\2\u0325"+
		"\u0328\3\2\2\2\u0326\u0324\3\2\2\2\u0327\u031e\3\2\2\2\u0327\u031f\3\2"+
		"\2\2\u0328\u0329\3\2\2\2\u0329\u032a\7\67\2\2\u032a\u032b\b \1\2\u032b"+
		"\u033a\3\2\2\2\u032c\u0336\5<\37\2\u032d\u0332\5H%\2\u032e\u032f\7\u0091"+
		"\2\2\u032f\u0331\5H%\2\u0330\u032e\3\2\2\2\u0331\u0334\3\2\2\2\u0332\u0330"+
		"\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0336\3\2\2\2\u0334\u0332\3\2\2\2\u0335"+
		"\u032c\3\2\2\2\u0335\u032d\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0338\b "+
		"\1\2\u0338\u033a\3\2\2\2\u0339\u0319\3\2\2\2\u0339\u0327\3\2\2\2\u0339"+
		"\u0335\3\2\2\2\u033a?\3\2\2\2\u033b\u033c\5V,\2\u033c\u033d\5^\60\2\u033d"+
		"A\3\2\2\2\u033e\u033f\5V,\2\u033f\u0340\5Z.\2\u0340C\3\2\2\2\u0341\u0342"+
		"\5V,\2\u0342\u0343\5\\/\2\u0343E\3\2\2\2\u0344\u0349\5J&\2\u0345\u0349"+
		"\5B\"\2\u0346\u0349\5@!\2\u0347\u0349\5D#\2\u0348\u0344\3\2\2\2\u0348"+
		"\u0345\3\2\2\2\u0348\u0346\3\2\2\2\u0348\u0347\3\2\2\2\u0349G\3\2\2\2"+
		"\u034a\u034b\5V,\2\u034b\u034c\7\u00ba\2\2\u034cI\3\2\2\2\u034d\u034f"+
		"\t\7\2\2\u034e\u034d\3\2\2\2\u034f\u0352\3\2\2\2\u0350\u034e\3\2\2\2\u0350"+
		"\u0351\3\2\2\2\u0351\u0356\3\2\2\2\u0352\u0350\3\2\2\2\u0353\u0355\5@"+
		"!\2\u0354\u0353\3\2\2\2\u0355\u0358\3\2\2\2\u0356\u0354\3\2\2\2\u0356"+
		"\u0357\3\2\2\2\u0357\u0359\3\2\2\2\u0358\u0356\3\2\2\2\u0359\u035d\5N"+
		"(\2\u035a\u035c\5D#\2\u035b\u035a\3\2\2\2\u035c\u035f\3\2\2\2\u035d\u035b"+
		"\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0370\3\2\2\2\u035f\u035d\3\2\2\2\u0360"+
		"\u0364\5L\'\2\u0361\u0363\5@!\2\u0362\u0361\3\2\2\2\u0363\u0366\3\2\2"+
		"\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0367\3\2\2\2\u0366\u0364"+
		"\3\2\2\2\u0367\u036b\5N(\2\u0368\u036a\5D#\2\u0369\u0368\3\2\2\2\u036a"+
		"\u036d\3\2\2\2\u036b\u0369\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036f\3\2"+
		"\2\2\u036d\u036b\3\2\2\2\u036e\u0360\3\2\2\2\u036f\u0372\3\2\2\2\u0370"+
		"\u036e\3\2\2\2\u0370\u0371\3\2\2\2\u0371K\3\2\2\2\u0372\u0370\3\2\2\2"+
		"\u0373\u037a\5B\"\2\u0374\u0376\t\7\2\2\u0375\u0374\3\2\2\2\u0376\u0377"+
		"\3\2\2\2\u0377\u0375\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u037a\3\2\2\2\u0379"+
		"\u0373\3\2\2\2\u0379\u0375\3\2\2\2\u037aM\3\2\2\2\u037b\u037c\b(\1\2\u037c"+
		"\u037d\7\u0089\2\2\u037d\u037e\5J&\2\u037e\u037f\7\u008a\2\2\u037f\u03eb"+
		"\3\2\2\2\u0380\u0381\5H%\2\u0381\u0382\7\u0089\2\2\u0382\u0387\5F$\2\u0383"+
		"\u0384\7\u0091\2\2\u0384\u0386\5F$\2\u0385\u0383\3\2\2\2\u0386\u0389\3"+
		"\2\2\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038a\3\2\2\2\u0389"+
		"\u0387\3\2\2\2\u038a\u038b\7\u008a\2\2\u038b\u03eb\3\2\2\2\u038c\u03eb"+
		"\5H%\2\u038d\u03eb\5`\61\2\u038e\u03eb\7\36\2\2\u038f\u03eb\7\u00b3\2"+
		"\2\u0390\u0391\t\b\2\2\u0391\u0396\5> \2\u0392\u0393\7\u0091\2\2\u0393"+
		"\u0395\5> \2\u0394\u0392\3\2\2\2\u0395\u0398\3\2\2\2\u0396\u0394\3\2\2"+
		"\2\u0396\u0397\3\2\2\2\u0397\u0399\3\2\2\2\u0398\u0396\3\2\2\2\u0399\u039a"+
		"\7\u0090\2\2\u039a\u039b\5J&\2\u039b\u03eb\3\2\2\2\u039c\u039d\t\t\2\2"+
		"\u039d\u03a2\5H%\2\u039e\u039f\7\u0091\2\2\u039f\u03a1\5H%\2\u03a0\u039e"+
		"\3\2\2\2\u03a1\u03a4\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3"+
		"\u03a5\3\2\2\2\u03a4\u03a2\3\2\2\2\u03a5\u03a6\7\u0090\2\2\u03a6\u03a7"+
		"\5J&\2\u03a7\u03eb\3\2\2\2\u03a8\u03a9\7\u00a2\2\2\u03a9\u03ac\5<\37\2"+
		"\u03aa\u03ab\7\67\2\2\u03ab\u03ad\5J&\2\u03ac\u03aa\3\2\2\2\u03ac\u03ad"+
		"\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03af\7\u0090\2\2\u03af\u03b0\5J&\2"+
		"\u03b0\u03eb\3\2\2\2\u03b1\u03eb\5P)\2\u03b2\u03eb\5R*\2\u03b3\u03bc\7"+
		"\u0093\2\2\u03b4\u03b9\5J&\2\u03b5\u03b6\7\u0091\2\2\u03b6\u03b8\5J&\2"+
		"\u03b7\u03b5\3\2\2\2\u03b8\u03bb\3\2\2\2\u03b9\u03b7\3\2\2\2\u03b9\u03ba"+
		"\3\2\2\2\u03ba\u03bd\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bc\u03b4\3\2\2\2\u03bc"+
		"\u03bd\3\2\2\2\u03bd\u03be\3\2\2\2\u03be\u03eb\7\u0094\2\2\u03bf\u03c0"+
		"\7\u008d\2\2\u03c0\u03c1\5J&\2\u03c1\u03c2\7\u0087\2\2\u03c2\u03c3\5N"+
		"(\b\u03c3\u03eb\3\2\2\2\u03c4\u03c5\7\u0093\2\2\u03c5\u03c6\5J&\2\u03c6"+
		"\u03c7\7\u0088\2\2\u03c7\u03c8\5N(\7\u03c8\u03eb\3\2\2\2\u03c9\u03ca\t"+
		"\n\2\2\u03ca\u03cb\5J&\2\u03cb\u03cc\7\u0089\2\2\u03cc\u03cd\5J&\2\u03cd"+
		"\u03ce\7\u008a\2\2\u03ce\u03eb\3\2\2\2\u03cf\u03d0\7\u00a5\2\2\u03d0\u03d1"+
		"\5J&\2\u03d1\u03d2\7\u00ac\2\2\u03d2\u03d3\5J&\2\u03d3\u03d4\7\u00a3\2"+
		"\2\u03d4\u03d5\5J&\2\u03d5\u03eb\3\2\2\2\u03d6\u03d7\7\u00a1\2\2\u03d7"+
		"\u03dc\5T+\2\u03d8\u03d9\7?\2\2\u03d9\u03db\5T+\2\u03da\u03d8\3\2\2\2"+
		"\u03db\u03de\3\2\2\2\u03dc\u03da\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03e3"+
		"\3\2\2\2\u03de\u03dc\3\2\2\2\u03df\u03e0\7?\2\2\u03e0\u03e1\7\u00ab\2"+
		"\2\u03e1\u03e2\7+\2\2\u03e2\u03e4\5J&\2\u03e3\u03df\3\2\2\2\u03e3\u03e4"+
		"\3\2\2\2\u03e4\u03eb\3\2\2\2\u03e5\u03e6\7\u00a8\2\2\u03e6\u03e7\5*\26"+
		"\2\u03e7\u03e8\7\u00a6\2\2\u03e8\u03e9\5J&\2\u03e9\u03eb\3\2\2\2\u03ea"+
		"\u037b\3\2\2\2\u03ea\u0380\3\2\2\2\u03ea\u038c\3\2\2\2\u03ea\u038d\3\2"+
		"\2\2\u03ea\u038e\3\2\2\2\u03ea\u038f\3\2\2\2\u03ea\u0390\3\2\2\2\u03ea"+
		"\u039c\3\2\2\2\u03ea\u03a8\3\2\2\2\u03ea\u03b1\3\2\2\2\u03ea\u03b2\3\2"+
		"\2\2\u03ea\u03b3\3\2\2\2\u03ea\u03bf\3\2\2\2\u03ea\u03c4\3\2\2\2\u03ea"+
		"\u03c9\3\2\2\2\u03ea\u03cf\3\2\2\2\u03ea\u03d6\3\2\2\2\u03ea\u03e5\3\2"+
		"\2\2\u03eb\u03f1\3\2\2\2\u03ec\u03ed\f\t\2\2\u03ed\u03ee\7\u0092\2\2\u03ee"+
		"\u03f0\5$\23\2\u03ef\u03ec\3\2\2\2\u03f0\u03f3\3\2\2\2\u03f1\u03ef\3\2"+
		"\2\2\u03f1\u03f2\3\2\2\2\u03f2O\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f4\u03fd"+
		"\7\u008b\2\2\u03f5\u03fa\5J&\2\u03f6\u03f7\7\u0091\2\2\u03f7\u03f9\5J"+
		"&\2\u03f8\u03f6\3\2\2\2\u03f9\u03fc\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa"+
		"\u03fb\3\2\2\2\u03fb\u03fe\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fd\u03f5\3\2"+
		"\2\2\u03fd\u03fe\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff\u0416\7\u008c\2\2\u0400"+
		"\u0401\7\u008b\2\2\u0401\u0402\5<\37\2\u0402\u0403\7\67\2\2\u0403\u0404"+
		"\5J&\2\u0404\u0405\7\u0090\2\2\u0405\u0406\5J&\2\u0406\u0407\7\u008c\2"+
		"\2\u0407\u0416\3\2\2\2\u0408\u0409\7\u008b\2\2\u0409\u040a\5J&\2\u040a"+
		"\u040b\7\u0090\2\2\u040b\u0410\5> \2\u040c\u040d\7\u0091\2\2\u040d\u040f"+
		"\5> \2\u040e\u040c\3\2\2\2\u040f\u0412\3\2\2\2\u0410\u040e\3\2\2\2\u0410"+
		"\u0411\3\2\2\2\u0411\u0413\3\2\2\2\u0412\u0410\3\2\2\2\u0413\u0414\7\u008c"+
		"\2\2\u0414\u0416\3\2\2\2\u0415\u03f4\3\2\2\2\u0415\u0400\3\2\2\2\u0415"+
		"\u0408\3\2\2\2\u0416Q\3\2\2\2\u0417\u0418\7\u008d\2\2\u0418\u041d\5> "+
		"\2\u0419\u041a\7\u0091\2\2\u041a\u041c\5> \2\u041b\u0419\3\2\2\2\u041c"+
		"\u041f\3\2\2\2\u041d\u041b\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0420\3\2"+
		"\2\2\u041f\u041d\3\2\2\2\u0420\u0421\7/\2\2\u0421\u0422\5J&\2\u0422\u0423"+
		"\7\u008e\2\2\u0423\u0458\3\2\2\2\u0424\u0425\7\u008d\2\2\u0425\u0426\5"+
		"J&\2\u0426\u0427\7+\2\2\u0427\u0428\5J&\2\u0428\u0429\7\u008e\2\2\u0429"+
		"\u0458\3\2\2\2\u042a\u042b\7\u008d\2\2\u042b\u042c\5$\23\2\u042c\u042d"+
		"\7\u0090\2\2\u042d\u0435\5J&\2\u042e\u042f\7\u0091\2\2\u042f\u0430\5$"+
		"\23\2\u0430\u0431\7\u0090\2\2\u0431\u0432\5J&\2\u0432\u0434\3\2\2\2\u0433"+
		"\u042e\3\2\2\2\u0434\u0437\3\2\2\2\u0435\u0433\3\2\2\2\u0435\u0436\3\2"+
		"\2\2\u0436\u0438\3\2\2\2\u0437\u0435\3\2\2\2\u0438\u0439\7\u008e\2\2\u0439"+
		"\u0458\3\2\2\2\u043a\u043b\7\u008d\2\2\u043b\u043c\5$\23\2\u043c\u043d"+
		"\7/\2\2\u043d\u0445\5J&\2\u043e\u043f\7\u0091\2\2\u043f\u0440\5$\23\2"+
		"\u0440\u0441\7/\2\2\u0441\u0442\5J&\2\u0442\u0444\3\2\2\2\u0443\u043e"+
		"\3\2\2\2\u0444\u0447\3\2\2\2\u0445\u0443\3\2\2\2\u0445\u0446\3\2\2\2\u0446"+
		"\u0448\3\2\2\2\u0447\u0445\3\2\2\2\u0448\u0449\7\u008e\2\2\u0449\u0458"+
		"\3\2\2\2\u044a\u044b\7\u008d\2\2\u044b\u044c\5J&\2\u044c\u044d\7\u0096"+
		"\2\2\u044d\u0452\5X-\2\u044e\u044f\7\u0091\2\2\u044f\u0451\5X-\2\u0450"+
		"\u044e\3\2\2\2\u0451\u0454\3\2\2\2\u0452\u0450\3\2\2\2\u0452\u0453\3\2"+
		"\2\2\u0453\u0455\3\2\2\2\u0454\u0452\3\2\2\2\u0455\u0456\7\u008e\2\2\u0456"+
		"\u0458\3\2\2\2\u0457\u0417\3\2\2\2\u0457\u0424\3\2\2\2\u0457\u042a\3\2"+
		"\2\2\u0457\u043a\3\2\2\2\u0457\u044a\3\2\2\2\u0458S\3\2\2\2\u0459\u045a"+
		"\5J&\2\u045a\u045b\7+\2\2\u045b\u045c\5J&\2\u045cU\3\2\2\2\u045d\u0469"+
		"\7\u00ba\2\2\u045e\u045f\7\u0089\2\2\u045f\u0464\5J&\2\u0460\u0461\7\u0091"+
		"\2\2\u0461\u0463\5J&\2\u0462\u0460\3\2\2\2\u0463\u0466\3\2\2\2\u0464\u0462"+
		"\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0467\3\2\2\2\u0466\u0464\3\2\2\2\u0467"+
		"\u0468\7\u008a\2\2\u0468\u046a\3\2\2\2\u0469\u045e\3\2\2\2\u0469\u046a"+
		"\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046d\7\64\2\2\u046c\u045d\3\2\2\2"+
		"\u046d\u0470\3\2\2\2\u046e\u046c\3\2\2\2\u046e\u046f\3\2\2\2\u046fW\3"+
		"\2\2\2\u0470\u046e\3\2\2\2\u0471\u047f\7\64\2\2\u0472\u0473\7\u0092\2"+
		"\2\u0473\u0480\5(\25\2\u0474\u0475\7\u008d\2\2\u0475\u047a\5J&\2\u0476"+
		"\u0477\7\u0091\2\2\u0477\u0479\5J&\2\u0478\u0476\3\2\2\2\u0479\u047c\3"+
		"\2\2\2\u047a\u0478\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047d\3\2\2\2\u047c"+
		"\u047a\3\2\2\2\u047d\u047e\7\u008e\2\2\u047e\u0480\3\2\2\2\u047f\u0472"+
		"\3\2\2\2\u047f\u0474\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u047f\3\2\2\2\u0481"+
		"\u0482\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0484\7$\2\2\u0484\u0485\5J&"+
		"\2\u0485Y\3\2\2\2\u0486\u0487\t\13\2\2\u0487[\3\2\2\2\u0488\u0498\7\u0083"+
		"\2\2\u0489\u0498\7\u0084\2\2\u048a\u0498\7\u0085\2\2\u048b\u0498\7\u0082"+
		"\2\2\u048c\u048d\7\u008d\2\2\u048d\u0492\5J&\2\u048e\u048f\7\u0091\2\2"+
		"\u048f\u0491\5J&\2\u0490\u048e\3\2\2\2\u0491\u0494\3\2\2\2\u0492\u0490"+
		"\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u0495\3\2\2\2\u0494\u0492\3\2\2\2\u0495"+
		"\u0496\7\u008e\2\2\u0496\u0498\3\2\2\2\u0497\u0488\3\2\2\2\u0497\u0489"+
		"\3\2\2\2\u0497\u048a\3\2\2\2\u0497\u048b\3\2\2\2\u0497\u048c\3\2\2\2\u0498"+
		"]\3\2\2\2\u0499\u049a\t\f\2\2\u049a_\3\2\2\2\u049b\u049c\t\r\2\2\u049c"+
		"a\3\2\2\2\u049d\u049e\t\16\2\2\u049ec\3\2\2\2\u049f\u04a0\t\17\2\2\u04a0"+
		"e\3\2\2\2\u0096horw}\u0084\u0086\u008d\u0093\u0096\u009b\u00a1\u00a8\u00aa"+
		"\u00b0\u00bb\u00be\u00c2\u00c6\u00d1\u00d4\u00d8\u00dc\u00de\u00e9\u00ec"+
		"\u00f1\u00fc\u00ff\u0105\u0107\u010f\u0117\u0119\u011f\u0124\u012b\u012d"+
		"\u0136\u013a\u013f\u0141\u014a\u0150\u0152\u0158\u0160\u0165\u016b\u0173"+
		"\u0177\u017f\u0181\u0185\u018b\u018d\u0192\u019e\u01a9\u01b2\u01ba\u01be"+
		"\u01c5\u01c7\u01cc\u01dc\u01e1\u01ea\u01f1\u01f7\u01fb\u0200\u020a\u020e"+
		"\u021a\u0220\u0225\u0239\u023c\u0248\u024b\u0258\u025b\u0268\u026b\u026f"+
		"\u027c\u0283\u0285\u028d\u0296\u0298\u02a1\u02a6\u02aa\u02c0\u02c9\u02d7"+
		"\u02db\u02e6\u02f4\u02f7\u02fd\u0309\u030e\u0316\u0319\u0324\u0327\u0332"+
		"\u0335\u0339\u0348\u0350\u0356\u035d\u0364\u036b\u0370\u0377\u0379\u0387"+
		"\u0396\u03a2\u03ac\u03b9\u03bc\u03dc\u03e3\u03ea\u03f1\u03fa\u03fd\u0410"+
		"\u0415\u041d\u0435\u0445\u0452\u0457\u0464\u0469\u046e\u047a\u047f\u0481"+
		"\u0492\u0497";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}