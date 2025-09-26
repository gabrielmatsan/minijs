// Generated from MiniJS.g4 by ANTLR 4.13.1
package com.minijs;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniJSParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJSParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJSParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MiniJSParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MiniJSParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MiniJSParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniJSParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniJSParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MiniJSParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(MiniJSParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MiniJSParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#consoleLogStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsoleLogStatement(MiniJSParser.ConsoleLogStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MiniJSParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJSParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(MiniJSParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(MiniJSParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(MiniJSParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(MiniJSParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(MiniJSParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(MiniJSParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(MiniJSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(MiniJSParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(MiniJSParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MiniJSParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(MiniJSParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(MiniJSParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyAssignment(MiniJSParser.PropertyAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJSParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MiniJSParser.ArgumentListContext ctx);
}