// Generated from MiniJS.g4 by ANTLR 4.13.1
package com.minijs;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJSParser}.
 */
public interface MiniJSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniJSParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniJSParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MiniJSParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MiniJSParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MiniJSParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MiniJSParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniJSParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniJSParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniJSParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniJSParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniJSParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniJSParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniJSParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniJSParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(MiniJSParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(MiniJSParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MiniJSParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MiniJSParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#consoleLogStatement}.
	 * @param ctx the parse tree
	 */
	void enterConsoleLogStatement(MiniJSParser.ConsoleLogStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#consoleLogStatement}.
	 * @param ctx the parse tree
	 */
	void exitConsoleLogStatement(MiniJSParser.ConsoleLogStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MiniJSParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MiniJSParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJSParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJSParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(MiniJSParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(MiniJSParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(MiniJSParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(MiniJSParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(MiniJSParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(MiniJSParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MiniJSParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MiniJSParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(MiniJSParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(MiniJSParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(MiniJSParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(MiniJSParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(MiniJSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(MiniJSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MiniJSParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MiniJSParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(MiniJSParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(MiniJSParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MiniJSParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MiniJSParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(MiniJSParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(MiniJSParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(MiniJSParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(MiniJSParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyAssignment(MiniJSParser.PropertyAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyAssignment(MiniJSParser.PropertyAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJSParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniJSParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJSParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniJSParser.ArgumentListContext ctx);
}