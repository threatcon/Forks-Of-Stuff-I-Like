// Generated from c:/Users/otek/OneDrive/Documents/Coding/proleap-vb6-parser/src/main/antlr4/io/proleap/vb6/Preprocessor.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PreprocessorParser}.
 */
public interface PreprocessorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#headerLine}.
	 * @param ctx the parse tree
	 */
	void enterHeaderLine(PreprocessorParser.HeaderLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#headerLine}.
	 * @param ctx the parse tree
	 */
	void exitHeaderLine(PreprocessorParser.HeaderLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#classHeaderLine}.
	 * @param ctx the parse tree
	 */
	void enterClassHeaderLine(PreprocessorParser.ClassHeaderLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#classHeaderLine}.
	 * @param ctx the parse tree
	 */
	void exitClassHeaderLine(PreprocessorParser.ClassHeaderLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#moduleAttribute}.
	 * @param ctx the parse tree
	 */
	void enterModuleAttribute(PreprocessorParser.ModuleAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#moduleAttribute}.
	 * @param ctx the parse tree
	 */
	void exitModuleAttribute(PreprocessorParser.ModuleAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#optionalAttributes}.
	 * @param ctx the parse tree
	 */
	void enterOptionalAttributes(PreprocessorParser.OptionalAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#optionalAttributes}.
	 * @param ctx the parse tree
	 */
	void exitOptionalAttributes(PreprocessorParser.OptionalAttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#preprocessorStatement}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorStatement(PreprocessorParser.PreprocessorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#preprocessorStatement}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorStatement(PreprocessorParser.PreprocessorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(PreprocessorParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(PreprocessorParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PreprocessorParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PreprocessorParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(PreprocessorParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(PreprocessorParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(PreprocessorParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(PreprocessorParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#endIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndIfStatement(PreprocessorParser.EndIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#endIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndIfStatement(PreprocessorParser.EndIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PreprocessorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PreprocessorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(PreprocessorParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(PreprocessorParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#impExpression}.
	 * @param ctx the parse tree
	 */
	void enterImpExpression(PreprocessorParser.ImpExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#impExpression}.
	 * @param ctx the parse tree
	 */
	void exitImpExpression(PreprocessorParser.ImpExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#eqvExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqvExpression(PreprocessorParser.EqvExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#eqvExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqvExpression(PreprocessorParser.EqvExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(PreprocessorParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(PreprocessorParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(PreprocessorParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(PreprocessorParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(PreprocessorParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(PreprocessorParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreprocessorParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(PreprocessorParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreprocessorParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(PreprocessorParser.BoolLiteralContext ctx);
}