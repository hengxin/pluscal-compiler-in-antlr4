// Generated from D:/final/code/src/main/java/com/PlusCal/grammar\PlusCalParser.g4 by ANTLR 4.9.2
package com.PlusCal.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PlusCalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PlusCalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#algorithm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorithm(PlusCalParser.AlgorithmContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(PlusCalParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#macro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro(PlusCalParser.MacroContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(PlusCalParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#globalVardecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVardecls(PlusCalParser.GlobalVardeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(PlusCalParser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#process}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcess(PlusCalParser.ProcessContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#procVardecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcVardecls(PlusCalParser.ProcVardeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#prodVarDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdVarDecls(PlusCalParser.ProdVarDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#prodVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdVarDecl(PlusCalParser.ProdVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PlusCalParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#compoundStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(PlusCalParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(PlusCalParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(PlusCalParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(PlusCalParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(PlusCalParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code either}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEither(PlusCalParser.EitherContext ctx);
	/**
	 * Visit a parse tree produced by the {@code with}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith(PlusCalParser.WithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code await}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAwait(PlusCalParser.AwaitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(PlusCalParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assert}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssert(PlusCalParser.AssertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skip}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(PlusCalParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(PlusCalParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goto}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto(PlusCalParser.GotoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(PlusCalParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callReturn}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallReturn(PlusCalParser.CallReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callGoto}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallGoto(PlusCalParser.CallGotoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code macroCall}
	 * labeled alternative in {@link PlusCalParser#unLabeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroCall(PlusCalParser.MacroCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#inWithVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInWithVarDecl(PlusCalParser.InWithVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(PlusCalParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PlusCalParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(PlusCalParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(PlusCalParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(PlusCalParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#defs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefs(PlusCalParser.DefsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#nonFixLhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonFixLhs(PlusCalParser.NonFixLhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#nonFixLhsParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonFixLhsParameter(PlusCalParser.NonFixLhsParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonFixLhsDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonFixLhsDefinition(PlusCalParser.NonFixLhsDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOpDefinition(PlusCalParser.PrefixOpDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOpDefinition(PlusCalParser.InfixOpDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixOpDefinition}
	 * labeled alternative in {@link PlusCalParser#operatorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOpDefinition(PlusCalParser.PostfixOpDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(PlusCalParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operatorParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorParameter(PlusCalParser.OperatorParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOpParameter(PlusCalParser.PrefixOpParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOpParameter(PlusCalParser.InfixOpParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixOpParameter}
	 * labeled alternative in {@link PlusCalParser#operatorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOpParameter(PlusCalParser.PostfixOpParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#moduleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDefinition(PlusCalParser.ModuleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#instance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstance(PlusCalParser.InstanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#substitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitution(PlusCalParser.SubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#identifierOrTuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierOrTuple(PlusCalParser.IdentifierOrTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#quantifierBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierBound(PlusCalParser.QuantifierBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#generalPrefixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralPrefixOp(PlusCalParser.GeneralPrefixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#generalInfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralInfixOp(PlusCalParser.GeneralInfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#generalPostfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralPostfixOp(PlusCalParser.GeneralPostfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(PlusCalParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#generalIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralIdentifier(PlusCalParser.GeneralIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PlusCalParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#infixOpOrJunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOpOrJunctions(PlusCalParser.InfixOpOrJunctionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tlaChoose}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlaChoose(PlusCalParser.TlaChooseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tlaLet}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlaLet(PlusCalParser.TlaLetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableLiteral(PlusCalParser.VariableLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceLiteral(PlusCalParser.SequenceLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionOrRecordLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOrRecordLiteral(PlusCalParser.FunctionOrRecordLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tlaCase}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlaCase(PlusCalParser.TlaCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(PlusCalParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quantifierExpression}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierExpression(PlusCalParser.QuantifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketedWithSubscript}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedWithSubscript(PlusCalParser.BracketedWithSubscriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quantifierExpression2}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierExpression2(PlusCalParser.QuantifierExpression2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code setLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetLiteral(PlusCalParser.SetLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tlaIf}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlaIf(PlusCalParser.TlaIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(PlusCalParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wfOrSf}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWfOrSf(PlusCalParser.WfOrSfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldCall}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldCall(PlusCalParser.FieldCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(PlusCalParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequencedWithSubscript}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequencedWithSubscript(PlusCalParser.SequencedWithSubscriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operatorCall}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorCall(PlusCalParser.OperatorCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link PlusCalParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(PlusCalParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumerated}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerated(PlusCalParser.EnumeratedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filtering}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFiltering(PlusCalParser.FilteringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mapping}
	 * labeled alternative in {@link PlusCalParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapping(PlusCalParser.MappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listMapping}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListMapping(PlusCalParser.ListMappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setMapping}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetMapping(PlusCalParser.SetMappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colonedRecord}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColonedRecord(PlusCalParser.ColonedRecordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code barArrowedRecord}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarArrowedRecord(PlusCalParser.BarArrowedRecordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exceptConstruct}
	 * labeled alternative in {@link PlusCalParser#functionOrRecord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptConstruct(PlusCalParser.ExceptConstructContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#caseArm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseArm(PlusCalParser.CaseArmContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#instancePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstancePrefix(PlusCalParser.InstancePrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#exceptCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptCase(PlusCalParser.ExceptCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#infixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOp(PlusCalParser.InfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOp(PlusCalParser.PostfixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#prefixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOp(PlusCalParser.PrefixOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PlusCalParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#tlaEscapeWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlaEscapeWord(PlusCalParser.TlaEscapeWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlusCalParser#plusCalReservedWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusCalReservedWord(PlusCalParser.PlusCalReservedWordContext ctx);
}