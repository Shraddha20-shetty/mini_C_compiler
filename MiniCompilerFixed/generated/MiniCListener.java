// Generated from grammar/MiniC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniCParser}.
 */
public interface MiniCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MiniCParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MiniCParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(MiniCParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(MiniCParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniCParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniCParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(MiniCParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(MiniCParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniCParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniCParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniCParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniCParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniCParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniCParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MiniCParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MiniCParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(MiniCParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(MiniCParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiniCParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiniCParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(MiniCParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(MiniCParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MiniCParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MiniCParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniCParser.TypeContext ctx);
}