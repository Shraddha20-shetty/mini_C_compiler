// Generated from grammar/MiniC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, IF=3, ELSE=4, WHILE=5, FOR=6, PRINT=7, LT=8, GT=9, LEQ=10, 
		GEQ=11, EQ=12, NEQ=13, PLUS=14, MINUS=15, MUL=16, DIV=17, ASSIGN=18, LPAREN=19, 
		RPAREN=20, LBRACE=21, RBRACE=22, LBRACKET=23, RBRACKET=24, SEMICOLON=25, 
		FLOAT_NUMBER=26, NUMBER=27, IDENTIFIER=28, WS=29;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_declaration = 2, RULE_arrayDeclaration = 3, 
		RULE_assignment = 4, RULE_arrayAssignment = 5, RULE_ifStatement = 6, RULE_whileStatement = 7, 
		RULE_forStatement = 8, RULE_forInit = 9, RULE_forUpdate = 10, RULE_condition = 11, 
		RULE_relop = 12, RULE_printStatement = 13, RULE_expr = 14, RULE_type = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "declaration", "arrayDeclaration", "assignment", 
			"arrayAssignment", "ifStatement", "whileStatement", "forStatement", "forInit", 
			"forUpdate", "condition", "relop", "printStatement", "expr", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'if'", "'else'", "'while'", "'for'", "'print'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
			"'='", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "IF", "ELSE", "WHILE", "FOR", "PRINT", "LT", "GT", 
			"LEQ", "GEQ", "EQ", "NEQ", "PLUS", "MINUS", "MUL", "DIV", "ASSIGN", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", "SEMICOLON", "FLOAT_NUMBER", 
			"NUMBER", "IDENTIFIER", "WS"
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
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniCParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435694L) != 0)) {
				{
				{
				setState(32);
				statement();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ArrayAssignmentContext arrayAssignment() {
			return getRuleContext(ArrayAssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				arrayDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				arrayAssignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				forStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				printStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniCParser.SEMICOLON, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				type();
				setState(51);
				match(IDENTIFIER);
				setState(52);
				match(ASSIGN);
				setState(53);
				expr(0);
				setState(54);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				type();
				setState(57);
				match(IDENTIFIER);
				setState(58);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniCParser.LBRACKET, 0); }
		public TerminalNode NUMBER() { return getToken(MiniCParser.NUMBER, 0); }
		public TerminalNode RBRACKET() { return getToken(MiniCParser.RBRACKET, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniCParser.SEMICOLON, 0); }
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArrayDeclaration(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arrayDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			type();
			setState(63);
			match(IDENTIFIER);
			setState(64);
			match(LBRACKET);
			setState(65);
			match(NUMBER);
			setState(66);
			match(RBRACKET);
			setState(67);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniCParser.SEMICOLON, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(IDENTIFIER);
			setState(70);
			match(ASSIGN);
			setState(71);
			expr(0);
			setState(72);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniCParser.LBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(MiniCParser.RBRACKET, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniCParser.SEMICOLON, 0); }
		public ArrayAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArrayAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArrayAssignment(this);
		}
	}

	public final ArrayAssignmentContext arrayAssignment() throws RecognitionException {
		ArrayAssignmentContext _localctx = new ArrayAssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(IDENTIFIER);
			setState(75);
			match(LBRACKET);
			setState(76);
			expr(0);
			setState(77);
			match(RBRACKET);
			setState(78);
			match(ASSIGN);
			setState(79);
			expr(0);
			setState(80);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(MiniCParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MiniCParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MiniCParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MiniCParser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(IF);
			setState(83);
			match(LPAREN);
			setState(84);
			condition();
			setState(85);
			match(RPAREN);
			setState(86);
			match(LBRACE);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435694L) != 0)) {
				{
				{
				setState(87);
				statement();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(RBRACE);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(94);
				match(ELSE);
				setState(95);
				match(LBRACE);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435694L) != 0)) {
					{
					{
					setState(96);
					statement();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MiniCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniCParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(WHILE);
			setState(106);
			match(LPAREN);
			setState(107);
			condition();
			setState(108);
			match(RPAREN);
			setState(109);
			match(LBRACE);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435694L) != 0)) {
				{
				{
				setState(110);
				statement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniCParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniCParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniCParser.SEMICOLON, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MiniCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniCParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(FOR);
			setState(119);
			match(LPAREN);
			setState(120);
			forInit();
			setState(121);
			match(SEMICOLON);
			setState(122);
			condition();
			setState(123);
			match(SEMICOLON);
			setState(124);
			forUpdate();
			setState(125);
			match(RPAREN);
			setState(126);
			match(LBRACE);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435694L) != 0)) {
				{
				{
				setState(127);
				statement();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forInit);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				type();
				setState(136);
				match(IDENTIFIER);
				setState(137);
				match(ASSIGN);
				setState(138);
				expr(0);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(IDENTIFIER);
				setState(141);
				match(ASSIGN);
				setState(142);
				expr(0);
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 3);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forUpdate);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(IDENTIFIER);
				setState(147);
				match(ASSIGN);
				setState(148);
				expr(0);
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			expr(0);
			setState(153);
			relop();
			setState(154);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelopContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(MiniCParser.LT, 0); }
		public TerminalNode GT() { return getToken(MiniCParser.GT, 0); }
		public TerminalNode LEQ() { return getToken(MiniCParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(MiniCParser.GEQ, 0); }
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MiniCParser.NEQ, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitRelop(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16128L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MiniCParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniCParser.SEMICOLON, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(PRINT);
			setState(159);
			match(LPAREN);
			setState(160);
			expr(0);
			setState(161);
			match(RPAREN);
			setState(162);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode FLOAT_NUMBER() { return getToken(MiniCParser.FLOAT_NUMBER, 0); }
		public TerminalNode NUMBER() { return getToken(MiniCParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniCParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniCParser.LBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(MiniCParser.RBRACKET, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public TerminalNode MUL() { return getToken(MiniCParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiniCParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(MiniCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniCParser.MINUS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(165);
				match(FLOAT_NUMBER);
				}
				break;
			case 2:
				{
				setState(166);
				match(NUMBER);
				}
				break;
			case 3:
				{
				setState(167);
				match(IDENTIFIER);
				setState(168);
				match(LBRACKET);
				setState(169);
				expr(0);
				setState(170);
				match(RBRACKET);
				}
				break;
			case 4:
				{
				setState(172);
				match(IDENTIFIER);
				}
				break;
			case 5:
				{
				setState(173);
				match(LPAREN);
				setState(174);
				expr(0);
				setState(175);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(191);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(180);
						match(MUL);
						setState(181);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(183);
						match(DIV);
						setState(184);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(186);
						match(PLUS);
						setState(187);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(189);
						match(MINUS);
						setState(190);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MiniCParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00c7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006Y\b\u0006\n\u0006\f\u0006\\\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006b\b\u0006\n\u0006"+
		"\f\u0006e\t\u0006\u0001\u0006\u0003\u0006h\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007p\b\u0007"+
		"\n\u0007\f\u0007s\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0081"+
		"\b\b\n\b\f\b\u0084\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0091\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u0097\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00b2\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c0\b\u000e\n\u000e"+
		"\f\u000e\u00c3\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0001"+
		"\u001c\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e\u0000\u0002\u0001\u0000\b\r\u0001\u0000\u0001"+
		"\u0002\u00cf\u0000#\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000"+
		"\u0004<\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000\u0000\bE\u0001"+
		"\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000"+
		"\u000ei\u0001\u0000\u0000\u0000\u0010v\u0001\u0000\u0000\u0000\u0012\u0090"+
		"\u0001\u0000\u0000\u0000\u0014\u0096\u0001\u0000\u0000\u0000\u0016\u0098"+
		"\u0001\u0000\u0000\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u009e"+
		"\u0001\u0000\u0000\u0000\u001c\u00b1\u0001\u0000\u0000\u0000\u001e\u00c4"+
		"\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000"+
		"\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000\u0000(1\u0003\u0004\u0002"+
		"\u0000)1\u0003\u0006\u0003\u0000*1\u0003\b\u0004\u0000+1\u0003\n\u0005"+
		"\u0000,1\u0003\f\u0006\u0000-1\u0003\u000e\u0007\u0000.1\u0003\u0010\b"+
		"\u0000/1\u0003\u001a\r\u00000(\u0001\u0000\u0000\u00000)\u0001\u0000\u0000"+
		"\u00000*\u0001\u0000\u0000\u00000+\u0001\u0000\u0000\u00000,\u0001\u0000"+
		"\u0000\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00000/\u0001"+
		"\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000023\u0003\u001e\u000f"+
		"\u000034\u0005\u001c\u0000\u000045\u0005\u0012\u0000\u000056\u0003\u001c"+
		"\u000e\u000067\u0005\u0019\u0000\u00007=\u0001\u0000\u0000\u000089\u0003"+
		"\u001e\u000f\u00009:\u0005\u001c\u0000\u0000:;\u0005\u0019\u0000\u0000"+
		";=\u0001\u0000\u0000\u0000<2\u0001\u0000\u0000\u0000<8\u0001\u0000\u0000"+
		"\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0003\u001e\u000f\u0000?@\u0005"+
		"\u001c\u0000\u0000@A\u0005\u0017\u0000\u0000AB\u0005\u001b\u0000\u0000"+
		"BC\u0005\u0018\u0000\u0000CD\u0005\u0019\u0000\u0000D\u0007\u0001\u0000"+
		"\u0000\u0000EF\u0005\u001c\u0000\u0000FG\u0005\u0012\u0000\u0000GH\u0003"+
		"\u001c\u000e\u0000HI\u0005\u0019\u0000\u0000I\t\u0001\u0000\u0000\u0000"+
		"JK\u0005\u001c\u0000\u0000KL\u0005\u0017\u0000\u0000LM\u0003\u001c\u000e"+
		"\u0000MN\u0005\u0018\u0000\u0000NO\u0005\u0012\u0000\u0000OP\u0003\u001c"+
		"\u000e\u0000PQ\u0005\u0019\u0000\u0000Q\u000b\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0003\u0000\u0000ST\u0005\u0013\u0000\u0000TU\u0003\u0016\u000b"+
		"\u0000UV\u0005\u0014\u0000\u0000VZ\u0005\u0015\u0000\u0000WY\u0003\u0002"+
		"\u0001\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]g\u0005\u0016\u0000\u0000^_\u0005\u0004\u0000"+
		"\u0000_c\u0005\u0015\u0000\u0000`b\u0003\u0002\u0001\u0000a`\u0001\u0000"+
		"\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"fh\u0005\u0016\u0000\u0000g^\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000h\r\u0001\u0000\u0000\u0000ij\u0005\u0005\u0000\u0000jk\u0005\u0013"+
		"\u0000\u0000kl\u0003\u0016\u000b\u0000lm\u0005\u0014\u0000\u0000mq\u0005"+
		"\u0015\u0000\u0000np\u0003\u0002\u0001\u0000on\u0001\u0000\u0000\u0000"+
		"ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u0016"+
		"\u0000\u0000u\u000f\u0001\u0000\u0000\u0000vw\u0005\u0006\u0000\u0000"+
		"wx\u0005\u0013\u0000\u0000xy\u0003\u0012\t\u0000yz\u0005\u0019\u0000\u0000"+
		"z{\u0003\u0016\u000b\u0000{|\u0005\u0019\u0000\u0000|}\u0003\u0014\n\u0000"+
		"}~\u0005\u0014\u0000\u0000~\u0082\u0005\u0015\u0000\u0000\u007f\u0081"+
		"\u0003\u0002\u0001\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0084"+
		"\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0016\u0000\u0000\u0086\u0011"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0003\u001e\u000f\u0000\u0088\u0089"+
		"\u0005\u001c\u0000\u0000\u0089\u008a\u0005\u0012\u0000\u0000\u008a\u008b"+
		"\u0003\u001c\u000e\u0000\u008b\u0091\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005\u001c\u0000\u0000\u008d\u008e\u0005\u0012\u0000\u0000\u008e\u0091"+
		"\u0003\u001c\u000e\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u0087"+
		"\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0090\u008f"+
		"\u0001\u0000\u0000\u0000\u0091\u0013\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005\u001c\u0000\u0000\u0093\u0094\u0005\u0012\u0000\u0000\u0094\u0097"+
		"\u0003\u001c\u000e\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0092"+
		"\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0015"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0003\u001c\u000e\u0000\u0099\u009a"+
		"\u0003\u0018\f\u0000\u009a\u009b\u0003\u001c\u000e\u0000\u009b\u0017\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0007\u0000\u0000\u0000\u009d\u0019\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005\u0007\u0000\u0000\u009f\u00a0\u0005"+
		"\u0013\u0000\u0000\u00a0\u00a1\u0003\u001c\u000e\u0000\u00a1\u00a2\u0005"+
		"\u0014\u0000\u0000\u00a2\u00a3\u0005\u0019\u0000\u0000\u00a3\u001b\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0006\u000e\uffff\uffff\u0000\u00a5\u00b2"+
		"\u0005\u001a\u0000\u0000\u00a6\u00b2\u0005\u001b\u0000\u0000\u00a7\u00a8"+
		"\u0005\u001c\u0000\u0000\u00a8\u00a9\u0005\u0017\u0000\u0000\u00a9\u00aa"+
		"\u0003\u001c\u000e\u0000\u00aa\u00ab\u0005\u0018\u0000\u0000\u00ab\u00b2"+
		"\u0001\u0000\u0000\u0000\u00ac\u00b2\u0005\u001c\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0013\u0000\u0000\u00ae\u00af\u0003\u001c\u000e\u0000\u00af\u00b0"+
		"\u0005\u0014\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00a4"+
		"\u0001\u0000\u0000\u0000\u00b1\u00a6\u0001\u0000\u0000\u0000\u00b1\u00a7"+
		"\u0001\u0000\u0000\u0000\u00b1\u00ac\u0001\u0000\u0000\u0000\u00b1\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b2\u00c1\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\n\t\u0000\u0000\u00b4\u00b5\u0005\u0010\u0000\u0000\u00b5\u00c0\u0003"+
		"\u001c\u000e\n\u00b6\u00b7\n\b\u0000\u0000\u00b7\u00b8\u0005\u0011\u0000"+
		"\u0000\u00b8\u00c0\u0003\u001c\u000e\t\u00b9\u00ba\n\u0007\u0000\u0000"+
		"\u00ba\u00bb\u0005\u000e\u0000\u0000\u00bb\u00c0\u0003\u001c\u000e\b\u00bc"+
		"\u00bd\n\u0006\u0000\u0000\u00bd\u00be\u0005\u000f\u0000\u0000\u00be\u00c0"+
		"\u0003\u001c\u000e\u0007\u00bf\u00b3\u0001\u0000\u0000\u0000\u00bf\u00b6"+
		"\u0001\u0000\u0000\u0000\u00bf\u00b9\u0001\u0000\u0000\u0000\u00bf\u00bc"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u001d"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0007\u0001\u0000\u0000\u00c5\u001f\u0001\u0000\u0000\u0000\r#0<Zcgq"+
		"\u0082\u0090\u0096\u00b1\u00bf\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}