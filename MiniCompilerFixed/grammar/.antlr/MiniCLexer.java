// Generated from c:/Users/Sucheth Shetty/OneDrive/Desktop/MSRUAS/6th_sem_assignment/compiler/MiniCompiler/grammar/MiniC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, PRINT=3, PLUS=4, MINUS=5, MUL=6, DIV=7, ASSIGN=8, LPAREN=9, 
		RPAREN=10, SEMICOLON=11, FLOAT_NUMBER=12, NUMBER=13, IDENTIFIER=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "PRINT", "PLUS", "MINUS", "MUL", "DIV", "ASSIGN", "LPAREN", 
			"RPAREN", "SEMICOLON", "FLOAT_NUMBER", "NUMBER", "IDENTIFIER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'print'", "'+'", "'-'", "'*'", "'/'", "'='", 
			"'('", "')'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "PRINT", "PLUS", "MINUS", "MUL", "DIV", "ASSIGN", 
			"LPAREN", "RPAREN", "SEMICOLON", "FLOAT_NUMBER", "NUMBER", "IDENTIFIER", 
			"WS"
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


	public MiniCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000f]\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0004\u000bA\b\u000b\u000b\u000b\f\u000bB\u0001\u000b\u0001\u000b"+
		"\u0004\u000bG\b\u000b\u000b\u000b\f\u000bH\u0001\f\u0004\fL\b\f\u000b"+
		"\f\f\fM\u0001\r\u0001\r\u0005\rR\b\r\n\r\f\rU\t\r\u0001\u000e\u0004\u000e"+
		"X\b\u000e\u000b\u000e\f\u000eY\u0001\u000e\u0001\u000e\u0000\u0000\u000f"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u0001\u0000\u0004\u0001\u000009\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0003\u0000\t\n\r\r  a\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001"+
		"\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005)\u0001\u0000\u0000"+
		"\u0000\u0007/\u0001\u0000\u0000\u0000\t1\u0001\u0000\u0000\u0000\u000b"+
		"3\u0001\u0000\u0000\u0000\r5\u0001\u0000\u0000\u0000\u000f7\u0001\u0000"+
		"\u0000\u0000\u00119\u0001\u0000\u0000\u0000\u0013;\u0001\u0000\u0000\u0000"+
		"\u0015=\u0001\u0000\u0000\u0000\u0017@\u0001\u0000\u0000\u0000\u0019K"+
		"\u0001\u0000\u0000\u0000\u001bO\u0001\u0000\u0000\u0000\u001dW\u0001\u0000"+
		"\u0000\u0000\u001f \u0005i\u0000\u0000 !\u0005n\u0000\u0000!\"\u0005t"+
		"\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005f\u0000\u0000$%\u0005"+
		"l\u0000\u0000%&\u0005o\u0000\u0000&\'\u0005a\u0000\u0000\'(\u0005t\u0000"+
		"\u0000(\u0004\u0001\u0000\u0000\u0000)*\u0005p\u0000\u0000*+\u0005r\u0000"+
		"\u0000+,\u0005i\u0000\u0000,-\u0005n\u0000\u0000-.\u0005t\u0000\u0000"+
		".\u0006\u0001\u0000\u0000\u0000/0\u0005+\u0000\u00000\b\u0001\u0000\u0000"+
		"\u000012\u0005-\u0000\u00002\n\u0001\u0000\u0000\u000034\u0005*\u0000"+
		"\u00004\f\u0001\u0000\u0000\u000056\u0005/\u0000\u00006\u000e\u0001\u0000"+
		"\u0000\u000078\u0005=\u0000\u00008\u0010\u0001\u0000\u0000\u00009:\u0005"+
		"(\u0000\u0000:\u0012\u0001\u0000\u0000\u0000;<\u0005)\u0000\u0000<\u0014"+
		"\u0001\u0000\u0000\u0000=>\u0005;\u0000\u0000>\u0016\u0001\u0000\u0000"+
		"\u0000?A\u0007\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DF\u0005.\u0000\u0000EG\u0007\u0000\u0000\u0000FE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000I\u0018\u0001\u0000\u0000\u0000JL\u0007\u0000"+
		"\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u001a\u0001\u0000\u0000"+
		"\u0000OS\u0007\u0001\u0000\u0000PR\u0007\u0002\u0000\u0000QP\u0001\u0000"+
		"\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000T\u001c\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000VX\u0007\u0003\u0000\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[\\\u0006\u000e\u0000\u0000\\\u001e\u0001\u0000\u0000"+
		"\u0000\u0006\u0000BHMSY\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}