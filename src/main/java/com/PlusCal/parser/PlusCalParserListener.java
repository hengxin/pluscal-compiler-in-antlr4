// Generated from D:/final/pluscal-compiler-in-antlr4/src/main/java/com/PlusCal/grammar\PlusCalParser.g4 by ANTLR 4.9.2
package com.PlusCal.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlusCalParser}.
 */
public interface PlusCalParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#algorithm}.
	 * @param ctx the parse tree
	 */
	void enterAlgorithm(PlusCalParser.AlgorithmContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#algorithm}.
	 * @param ctx the parse tree
	 */
	void exitAlgorithm(PlusCalParser.AlgorithmContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(PlusCalParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(PlusCalParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(PlusCalParser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(PlusCalParser.MacroContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(PlusCalParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(PlusCalParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#globalVardecls}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVardecls(PlusCalParser.GlobalVardeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#globalVardecls}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVardecls(PlusCalParser.GlobalVardeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(PlusCalParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(PlusCalParser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#process}.
	 * @param ctx the parse tree
	 */
	void enterProcess(PlusCalParser.ProcessContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#process}.
	 * @param ctx the parse tree
	 */
	void exitProcess(PlusCalParser.ProcessContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#procVardecls}.
	 * @param ctx the parse tree
	 */
	void enterProcVardecls(PlusCalParser.ProcVardeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#procVardecls}.
	 * @param ctx the parse tree
	 */
	void exitProcVardecls(PlusCalParser.ProcVardeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#prodVarDecls}.
	 * @param ctx the parse tree
	 */
	void enterProdVarDecls(PlusCalParser.ProdVarDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#prodVarDecls}.
	 * @param ctx the parse tree
	 */
	void exitProdVarDecls(PlusCalParser.ProdVarDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#prodVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterProdVarDecl(PlusCalParser.ProdVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#prodVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitProdVarDecl(PlusCalParser.ProdVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStmt(PlusCalParser.CompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStmt(PlusCalParser.CompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PlusCalParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PlusCalParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PlusCalParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PlusCalParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterIf(PlusCalParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitIf(PlusCalParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile(PlusCalParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile(PlusCalParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code either}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterEither(PlusCalParser.EitherContext ctx);
	/**
	 * Exit a parse tree produced by the {@code either}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitEither(PlusCalParser.EitherContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterWith(PlusCalParser.WithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitWith(PlusCalParser.WithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code await}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterAwait(PlusCalParser.AwaitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code await}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitAwait(PlusCalParser.AwaitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(PlusCalParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(PlusCalParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assert}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssert(PlusCalParser.AssertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assert}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssert(PlusCalParser.AssertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code skip}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterSkip(PlusCalParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code skip}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitSkip(PlusCalParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callReturn}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallReturn(PlusCalParser.CallReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callReturn}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallReturn(PlusCalParser.CallReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callGoto}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallGoto(PlusCalParser.CallGotoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callGoto}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallGoto(PlusCalParser.CallGotoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterCall(PlusCalParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitCall(PlusCalParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn(PlusCalParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn(PlusCalParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goto}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterGoto(PlusCalParser.GotoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goto}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitGoto(PlusCalParser.GotoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code macroCall}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterMacroCall(PlusCalParser.MacroCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code macroCall}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitMacroCall(PlusCalParser.MacroCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#inWithVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterInWithVarDecl(PlusCalParser.InWithVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#inWithVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitInWithVarDecl(PlusCalParser.InWithVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#lhs}.
	 * @param ctx the parse tree
	 */
	void enterLhs(PlusCalParser.LhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#lhs}.
	 * @param ctx the parse tree
	 */
	void exitLhs(PlusCalParser.LhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PlusCalParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PlusCalParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(PlusCalParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(PlusCalParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(PlusCalParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(PlusCalParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(PlusCalParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(PlusCalParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#defs}.
	 * @param ctx the parse tree
	 */
	void enterDefs(PlusCalParser.DefsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#defs}.
	 * @param ctx the parse tree
	 */
	void exitDefs(PlusCalParser.DefsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#nonFixLhs}.
	 * @param ctx the parse tree
	 */
	void enterNonFixLhs(PlusCalParser.NonFixLhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#nonFixLhs}.
	 * @param ctx the parse tree
	 */
	void exitNonFixLhs(PlusCalParser.NonFixLhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#nonFixLhsParameter}.
	 * @param ctx the parse tree
	 */
	void enterNonFixLhsParameter(PlusCalParser.NonFixLhsParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#nonFixLhsParameter}.
	 * @param ctx the parse tree
	 */
	void exitNonFixLhsParameter(PlusCalParser.NonFixLhsParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonFixLhsDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNonFixLhsDefinition(PlusCalParser.NonFixLhsDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonFixLhsDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNonFixLhsDefinition(PlusCalParser.NonFixLhsDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOpDefinition(PlusCalParser.PrefixOpDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOpDefinition(PlusCalParser.PrefixOpDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterInfixOpDefinition(PlusCalParser.InfixOpDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitInfixOpDefinition(PlusCalParser.InfixOpDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOpDefinition(PlusCalParser.PostfixOpDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOpDefinition(PlusCalParser.PostfixOpDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(PlusCalParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(PlusCalParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operatorParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void enterOperatorParameter(PlusCalParser.OperatorParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operatorParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void exitOperatorParameter(PlusCalParser.OperatorParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOpParameter(PlusCalParser.PrefixOpParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOpParameter(PlusCalParser.PrefixOpParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void enterInfixOpParameter(PlusCalParser.InfixOpParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void exitInfixOpParameter(PlusCalParser.InfixOpParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOpParameter(PlusCalParser.PostfixOpParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOpParameter(PlusCalParser.PostfixOpParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#moduleDefinition}.
	 * @param ctx the parse tree
	 */
	void enterModuleDefinition(PlusCalParser.ModuleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#moduleDefinition}.
	 * @param ctx the parse tree
	 */
	void exitModuleDefinition(PlusCalParser.ModuleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#instance}.
	 * @param ctx the parse tree
	 */
	void enterInstance(PlusCalParser.InstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#instance}.
	 * @param ctx the parse tree
	 */
	void exitInstance(PlusCalParser.InstanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#substitution}.
	 * @param ctx the parse tree
	 */
	void enterSubstitution(PlusCalParser.SubstitutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#substitution}.
	 * @param ctx the parse tree
	 */
	void exitSubstitution(PlusCalParser.SubstitutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#identifierOrTuple}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierOrTuple(PlusCalParser.IdentifierOrTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#identifierOrTuple}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierOrTuple(PlusCalParser.IdentifierOrTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#quantifierBound}.
	 * @param ctx the parse tree
	 */
	void enterQuantifierBound(PlusCalParser.QuantifierBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#quantifierBound}.
	 * @param ctx the parse tree
	 */
	void exitQuantifierBound(PlusCalParser.QuantifierBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#generalPrefixOp}.
	 * @param ctx the parse tree
	 */
	void enterGeneralPrefixOp(PlusCalParser.GeneralPrefixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#generalPrefixOp}.
	 * @param ctx the parse tree
	 */
	void exitGeneralPrefixOp(PlusCalParser.GeneralPrefixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#generalInfixOp}.
	 * @param ctx the parse tree
	 */
	void enterGeneralInfixOp(PlusCalParser.GeneralInfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#generalInfixOp}.
	 * @param ctx the parse tree
	 */
	void exitGeneralInfixOp(PlusCalParser.GeneralInfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#generalPostfixOp}.
	 * @param ctx the parse tree
	 */
	void enterGeneralPostfixOp(PlusCalParser.GeneralPostfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#generalPostfixOp}.
	 * @param ctx the parse tree
	 */
	void exitGeneralPostfixOp(PlusCalParser.GeneralPostfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(PlusCalParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(PlusCalParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#generalIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterGeneralIdentifier(PlusCalParser.GeneralIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#generalIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitGeneralIdentifier(PlusCalParser.GeneralIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PlusCalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PlusCalParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#infixOpOrJunctions}.
	 * @param ctx the parse tree
	 */
	void enterInfixOpOrJunctions(PlusCalParser.InfixOpOrJunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#infixOpOrJunctions}.
	 * @param ctx the parse tree
	 */
	void exitInfixOpOrJunctions(PlusCalParser.InfixOpOrJunctionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tlaChoose}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTlaChoose(PlusCalParser.TlaChooseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tlaChoose}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTlaChoose(PlusCalParser.TlaChooseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tlaLet}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTlaLet(PlusCalParser.TlaLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tlaLet}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTlaLet(PlusCalParser.TlaLetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterVariableLiteral(PlusCalParser.VariableLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitVariableLiteral(PlusCalParser.VariableLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequenceLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterSequenceLiteral(PlusCalParser.SequenceLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitSequenceLiteral(PlusCalParser.SequenceLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionOrRecordLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionOrRecordLiteral(PlusCalParser.FunctionOrRecordLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionOrRecordLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionOrRecordLiteral(PlusCalParser.FunctionOrRecordLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tlaCase}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTlaCase(PlusCalParser.TlaCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tlaCase}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTlaCase(PlusCalParser.TlaCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(PlusCalParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(PlusCalParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantifierExpression}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterQuantifierExpression(PlusCalParser.QuantifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantifierExpression}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitQuantifierExpression(PlusCalParser.QuantifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketedWithSubscript}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBracketedWithSubscript(PlusCalParser.BracketedWithSubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketedWithSubscript}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBracketedWithSubscript(PlusCalParser.BracketedWithSubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantifierExpression2}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterQuantifierExpression2(PlusCalParser.QuantifierExpression2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code quantifierExpression2}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitQuantifierExpression2(PlusCalParser.QuantifierExpression2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code setLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetLiteral(PlusCalParser.SetLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetLiteral(PlusCalParser.SetLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tlaIf}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTlaIf(PlusCalParser.TlaIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tlaIf}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTlaIf(PlusCalParser.TlaIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PlusCalParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PlusCalParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wfOrSf}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterWfOrSf(PlusCalParser.WfOrSfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wfOrSf}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitWfOrSf(PlusCalParser.WfOrSfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldCall}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterFieldCall(PlusCalParser.FieldCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldCall}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitFieldCall(PlusCalParser.FieldCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(PlusCalParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(PlusCalParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequencedWithSubscript}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterSequencedWithSubscript(PlusCalParser.SequencedWithSubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencedWithSubscript}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitSequencedWithSubscript(PlusCalParser.SequencedWithSubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operatorCall}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterOperatorCall(PlusCalParser.OperatorCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operatorCall}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitOperatorCall(PlusCalParser.OperatorCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(PlusCalParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(PlusCalParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enumerated}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 */
	void enterEnumerated(PlusCalParser.EnumeratedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumerated}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 */
	void exitEnumerated(PlusCalParser.EnumeratedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filtering}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 */
	void enterFiltering(PlusCalParser.FilteringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filtering}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 */
	void exitFiltering(PlusCalParser.FilteringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mapping}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 */
	void enterMapping(PlusCalParser.MappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mapping}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 */
	void exitMapping(PlusCalParser.MappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listMapping}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void enterListMapping(PlusCalParser.ListMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listMapping}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void exitListMapping(PlusCalParser.ListMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setMapping}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void enterSetMapping(PlusCalParser.SetMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setMapping}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void exitSetMapping(PlusCalParser.SetMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colonedRecord}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void enterColonedRecord(PlusCalParser.ColonedRecordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colonedRecord}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void exitColonedRecord(PlusCalParser.ColonedRecordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code barArrowedRecord}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void enterBarArrowedRecord(PlusCalParser.BarArrowedRecordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code barArrowedRecord}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void exitBarArrowedRecord(PlusCalParser.BarArrowedRecordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exceptConstruct}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void enterExceptConstruct(PlusCalParser.ExceptConstructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exceptConstruct}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 */
	void exitExceptConstruct(PlusCalParser.ExceptConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#caseArm}.
	 * @param ctx the parse tree
	 */
	void enterCaseArm(PlusCalParser.CaseArmContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#caseArm}.
	 * @param ctx the parse tree
	 */
	void exitCaseArm(PlusCalParser.CaseArmContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#instancePrefix}.
	 * @param ctx the parse tree
	 */
	void enterInstancePrefix(PlusCalParser.InstancePrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#instancePrefix}.
	 * @param ctx the parse tree
	 */
	void exitInstancePrefix(PlusCalParser.InstancePrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#exceptCase}.
	 * @param ctx the parse tree
	 */
	void enterExceptCase(PlusCalParser.ExceptCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#exceptCase}.
	 * @param ctx the parse tree
	 */
	void exitExceptCase(PlusCalParser.ExceptCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#infixOp}.
	 * @param ctx the parse tree
	 */
	void enterInfixOp(PlusCalParser.InfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#infixOp}.
	 * @param ctx the parse tree
	 */
	void exitInfixOp(PlusCalParser.InfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOp(PlusCalParser.PostfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOp(PlusCalParser.PostfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOp(PlusCalParser.PrefixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOp(PlusCalParser.PrefixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PlusCalParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PlusCalParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#tlaEscapeWord}.
	 * @param ctx the parse tree
	 */
	void enterTlaEscapeWord(PlusCalParser.TlaEscapeWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#tlaEscapeWord}.
	 * @param ctx the parse tree
	 */
	void exitTlaEscapeWord(PlusCalParser.TlaEscapeWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlusCalParser#plusCalReservedWord}.
	 * @param ctx the parse tree
	 */
	void enterPlusCalReservedWord(PlusCalParser.PlusCalReservedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusCalParser#plusCalReservedWord}.
	 * @param ctx the parse tree
	 */
	void exitPlusCalReservedWord(PlusCalParser.PlusCalReservedWordContext ctx);
}