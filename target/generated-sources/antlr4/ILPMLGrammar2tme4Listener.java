// Generated from ILPMLGrammar2tme4.g4 by ANTLR 4.4

    package antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILPMLGrammar2tme4Parser}.
 */
public interface ILPMLGrammar2tme4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILPMLGrammar2tme4Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalFunDef(@NotNull ILPMLGrammar2tme4Parser.GlobalFunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLGrammar2tme4Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalFunDef(@NotNull ILPMLGrammar2tme4Parser.GlobalFunDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinding(@NotNull ILPMLGrammar2tme4Parser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinding(@NotNull ILPMLGrammar2tme4Parser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop(@NotNull ILPMLGrammar2tme4Parser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop(@NotNull ILPMLGrammar2tme4Parser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull ILPMLGrammar2tme4Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull ILPMLGrammar2tme4Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAlternative(@NotNull ILPMLGrammar2tme4Parser.AlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAlternative(@NotNull ILPMLGrammar2tme4Parser.AlternativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(@NotNull ILPMLGrammar2tme4Parser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(@NotNull ILPMLGrammar2tme4Parser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFloat(@NotNull ILPMLGrammar2tme4Parser.ConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFloat(@NotNull ILPMLGrammar2tme4Parser.ConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssign(@NotNull ILPMLGrammar2tme4Parser.VariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssign(@NotNull ILPMLGrammar2tme4Parser.VariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequence(@NotNull ILPMLGrammar2tme4Parser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequence(@NotNull ILPMLGrammar2tme4Parser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFalse(@NotNull ILPMLGrammar2tme4Parser.ConstFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFalse(@NotNull ILPMLGrammar2tme4Parser.ConstFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLGrammar2tme4Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull ILPMLGrammar2tme4Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLGrammar2tme4Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull ILPMLGrammar2tme4Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull ILPMLGrammar2tme4Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull ILPMLGrammar2tme4Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstTrue(@NotNull ILPMLGrammar2tme4Parser.ConstTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstTrue(@NotNull ILPMLGrammar2tme4Parser.ConstTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstInteger(@NotNull ILPMLGrammar2tme4Parser.ConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstInteger(@NotNull ILPMLGrammar2tme4Parser.ConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstString(@NotNull ILPMLGrammar2tme4Parser.ConstStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstString(@NotNull ILPMLGrammar2tme4Parser.ConstStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(@NotNull ILPMLGrammar2tme4Parser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(@NotNull ILPMLGrammar2tme4Parser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unless}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnless(@NotNull ILPMLGrammar2tme4Parser.UnlessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unless}
	 * labeled alternative in {@link ILPMLGrammar2tme4Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnless(@NotNull ILPMLGrammar2tme4Parser.UnlessContext ctx);
}