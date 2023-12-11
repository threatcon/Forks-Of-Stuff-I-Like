// Generated from c:/Users/otek/OneDrive/Documents/Coding/proleap-vb6-parser/src/main/antlr4/io/proleap/vb6/Common.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CommonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, IntegerLiteral=9, 
		FloatLiteral=10, StringLiteral=11, And=12, Const=13, Else=14, ElseIf=15, 
		End=16, Eqv=17, Empty=18, False=19, If=20, Imp=21, Like=22, Mod=23, Not=24, 
		Nothing=25, Null=26, Or=27, True=28, Then=29, Xor=30, ID=31, WS=32, NL=33, 
		COMMENT=34, AMP=35, MINUS=36, PLUS=37, FS=38, BS=39, CARET=40, STAR=41, 
		EQ=42;
	public static final int
		RULE_expression = 0, RULE_comparisonOperator = 1, RULE_impExpression = 2, 
		RULE_eqvExpression = 3, RULE_stringExpression = 4, RULE_arithmeticExpression = 5, 
		RULE_boolExpression = 6, RULE_boolLiteral = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "comparisonOperator", "impExpression", "eqvExpression", 
			"stringExpression", "arithmeticExpression", "boolExpression", "boolLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'<'", "'>'", "'<='", "'>='", "'<>'", "'><'", null, 
			null, null, "'And'", "'Const'", "'Else'", "'ElseIf'", "'End'", "'Eqv'", 
			"'Empty'", "'False'", "'If'", "'Imp'", "'Like'", "'Mod'", "'Not'", "'Nothing'", 
			"'Null'", "'Or'", "'True'", "'Then'", "'Xor'", null, null, null, null, 
			"'&'", "'-'", "'+'", "'/'", "'\\'", "'^'", "'*'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "IntegerLiteral", 
			"FloatLiteral", "StringLiteral", "And", "Const", "Else", "ElseIf", "End", 
			"Eqv", "Empty", "False", "If", "Imp", "Like", "Mod", "Not", "Nothing", 
			"Null", "Or", "True", "Then", "Xor", "ID", "WS", "NL", "COMMENT", "AMP", 
			"MINUS", "PLUS", "FS", "BS", "CARET", "STAR", "EQ"
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
	public String getGrammarFileName() { return "Common.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CommonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CommonParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CommonParser.WS, i);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public EqvExpressionContext eqvExpression() {
			return getRuleContext(EqvExpressionContext.class,0);
		}
		public ImpExpressionContext impExpression() {
			return getRuleContext(ImpExpressionContext.class,0);
		}
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommonParser.ID, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(17);
				match(T__0);
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(18);
					match(WS);
					}
					}
					setState(23);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(24);
				expression(0);
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(25);
					match(WS);
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(31);
				match(T__1);
				}
				break;
			case 2:
				{
				setState(33);
				arithmeticExpression(0);
				}
				break;
			case 3:
				{
				setState(34);
				stringExpression(0);
				}
				break;
			case 4:
				{
				setState(35);
				eqvExpression();
				}
				break;
			case 5:
				{
				setState(36);
				impExpression();
				}
				break;
			case 6:
				{
				setState(37);
				boolExpression(0);
				}
				break;
			case 7:
				{
				setState(38);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(41);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(42);
						match(WS);
						}
						}
						setState(47);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(48);
					comparisonOperator();
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(49);
						match(WS);
						}
						}
						setState(54);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(55);
					expression(7);
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(CommonParser.EQ, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511608L) != 0)) ) {
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
	public static class ImpExpressionContext extends ParserRuleContext {
		public TerminalNode Imp() { return getToken(CommonParser.Imp, 0); }
		public List<BoolExpressionContext> boolExpression() {
			return getRuleContexts(BoolExpressionContext.class);
		}
		public BoolExpressionContext boolExpression(int i) {
			return getRuleContext(BoolExpressionContext.class,i);
		}
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CommonParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CommonParser.WS, i);
		}
		public ImpExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impExpression; }
	}

	public final ImpExpressionContext impExpression() throws RecognitionException {
		ImpExpressionContext _localctx = new ImpExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_impExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case False:
			case Not:
			case True:
				{
				setState(64);
				boolExpression(0);
				}
				break;
			case IntegerLiteral:
			case FloatLiteral:
			case MINUS:
				{
				setState(65);
				arithmeticExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(68);
				match(WS);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(Imp);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(75);
				match(WS);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case False:
			case Not:
			case True:
				{
				setState(81);
				boolExpression(0);
				}
				break;
			case IntegerLiteral:
			case FloatLiteral:
			case MINUS:
				{
				setState(82);
				arithmeticExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class EqvExpressionContext extends ParserRuleContext {
		public TerminalNode Eqv() { return getToken(CommonParser.Eqv, 0); }
		public List<BoolExpressionContext> boolExpression() {
			return getRuleContexts(BoolExpressionContext.class);
		}
		public BoolExpressionContext boolExpression(int i) {
			return getRuleContext(BoolExpressionContext.class,i);
		}
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CommonParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CommonParser.WS, i);
		}
		public EqvExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqvExpression; }
	}

	public final EqvExpressionContext eqvExpression() throws RecognitionException {
		EqvExpressionContext _localctx = new EqvExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_eqvExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case False:
			case Not:
			case True:
				{
				setState(85);
				boolExpression(0);
				}
				break;
			case IntegerLiteral:
			case FloatLiteral:
			case MINUS:
				{
				setState(86);
				arithmeticExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(89);
				match(WS);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			match(Eqv);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(96);
				match(WS);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case False:
			case Not:
			case True:
				{
				setState(102);
				boolExpression(0);
				}
				break;
			case IntegerLiteral:
			case FloatLiteral:
			case MINUS:
				{
				setState(103);
				arithmeticExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class StringExpressionContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(CommonParser.StringLiteral, 0); }
		public List<StringExpressionContext> stringExpression() {
			return getRuleContexts(StringExpressionContext.class);
		}
		public StringExpressionContext stringExpression(int i) {
			return getRuleContext(StringExpressionContext.class,i);
		}
		public TerminalNode AMP() { return getToken(CommonParser.AMP, 0); }
		public TerminalNode PLUS() { return getToken(CommonParser.PLUS, 0); }
		public List<TerminalNode> WS() { return getTokens(CommonParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CommonParser.WS, i);
		}
		public TerminalNode Like() { return getToken(CommonParser.Like, 0); }
		public StringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpression; }
	}

	public final StringExpressionContext stringExpression() throws RecognitionException {
		return stringExpression(0);
	}

	private StringExpressionContext stringExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringExpressionContext _localctx = new StringExpressionContext(_ctx, _parentState);
		StringExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stringExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			match(StringLiteral);
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(139);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new StringExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_stringExpression);
						setState(109);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(110);
							match(WS);
							}
							}
							setState(115);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(116);
						_la = _input.LA(1);
						if ( !(_la==AMP || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(117);
							match(WS);
							}
							}
							setState(122);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(123);
						stringExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new StringExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_stringExpression);
						setState(124);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(125);
							match(WS);
							}
							}
							setState(130);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(131);
						match(Like);
						setState(135);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(132);
							match(WS);
							}
							}
							setState(137);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(138);
						stringExpression(3);
						}
						break;
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(CommonParser.MINUS, 0); }
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode FloatLiteral() { return getToken(CommonParser.FloatLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(CommonParser.IntegerLiteral, 0); }
		public TerminalNode CARET() { return getToken(CommonParser.CARET, 0); }
		public List<TerminalNode> WS() { return getTokens(CommonParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CommonParser.WS, i);
		}
		public TerminalNode FS() { return getToken(CommonParser.FS, 0); }
		public TerminalNode BS() { return getToken(CommonParser.BS, 0); }
		public TerminalNode Mod() { return getToken(CommonParser.Mod, 0); }
		public TerminalNode STAR() { return getToken(CommonParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(CommonParser.PLUS, 0); }
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		return arithmeticExpression(0);
	}

	private ArithmeticExpressionContext arithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, _parentState);
		ArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_arithmeticExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(145);
				match(MINUS);
				setState(146);
				arithmeticExpression(10);
				}
				break;
			case FloatLiteral:
				{
				setState(147);
				match(FloatLiteral);
				}
				break;
			case IntegerLiteral:
				{
				setState(148);
				match(IntegerLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(151);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(155);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(152);
							match(WS);
							}
							}
							setState(157);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(158);
						match(CARET);
						setState(162);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(159);
							match(WS);
							}
							}
							setState(164);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(165);
						arithmeticExpression(9);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(166);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(170);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(167);
							match(WS);
							}
							}
							setState(172);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(173);
						match(FS);
						setState(177);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(174);
							match(WS);
							}
							}
							setState(179);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(180);
						arithmeticExpression(9);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(181);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(182);
							match(WS);
							}
							}
							setState(187);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(188);
						match(BS);
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(189);
							match(WS);
							}
							}
							setState(194);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(195);
						arithmeticExpression(8);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(196);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(197);
							match(WS);
							}
							}
							setState(202);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(203);
						match(Mod);
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(204);
							match(WS);
							}
							}
							setState(209);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(210);
						arithmeticExpression(7);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(211);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(215);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(212);
							match(WS);
							}
							}
							setState(217);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(218);
						match(STAR);
						setState(222);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(219);
							match(WS);
							}
							}
							setState(224);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(225);
						arithmeticExpression(6);
						}
						break;
					case 6:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(226);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(227);
							match(WS);
							}
							}
							setState(232);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(233);
						match(PLUS);
						setState(237);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(234);
							match(WS);
							}
							}
							setState(239);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(240);
						arithmeticExpression(5);
						}
						break;
					case 7:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(241);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(245);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(242);
							match(WS);
							}
							}
							setState(247);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(248);
						match(MINUS);
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(249);
							match(WS);
							}
							}
							setState(254);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(255);
						arithmeticExpression(4);
						}
						break;
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	public static class BoolExpressionContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(CommonParser.Not, 0); }
		public List<BoolExpressionContext> boolExpression() {
			return getRuleContexts(BoolExpressionContext.class);
		}
		public BoolExpressionContext boolExpression(int i) {
			return getRuleContext(BoolExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CommonParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CommonParser.WS, i);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public TerminalNode And() { return getToken(CommonParser.And, 0); }
		public TerminalNode Or() { return getToken(CommonParser.Or, 0); }
		public TerminalNode Xor() { return getToken(CommonParser.Xor, 0); }
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		return boolExpression(0);
	}

	private BoolExpressionContext boolExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, _parentState);
		BoolExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_boolExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Not:
				{
				setState(262);
				match(Not);
				setState(264); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(263);
					match(WS);
					}
					}
					setState(266); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(268);
				boolExpression(5);
				}
				break;
			case False:
			case True:
				{
				setState(269);
				boolLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(311);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpression);
						setState(272);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(274); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(273);
							match(WS);
							}
							}
							setState(276); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WS );
						setState(278);
						match(And);
						setState(280); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(279);
							match(WS);
							}
							}
							setState(282); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WS );
						setState(284);
						boolExpression(5);
						}
						break;
					case 2:
						{
						_localctx = new BoolExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpression);
						setState(285);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(287); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(286);
							match(WS);
							}
							}
							setState(289); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WS );
						setState(291);
						match(Or);
						setState(293); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(292);
							match(WS);
							}
							}
							setState(295); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WS );
						setState(297);
						boolExpression(4);
						}
						break;
					case 3:
						{
						_localctx = new BoolExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpression);
						setState(298);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(300); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(299);
							match(WS);
							}
							}
							setState(302); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WS );
						setState(304);
						match(Xor);
						setState(306); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(305);
							match(WS);
							}
							}
							setState(308); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WS );
						setState(310);
						boolExpression(3);
						}
						break;
					}
					} 
				}
				setState(315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(CommonParser.True, 0); }
		public TerminalNode False() { return getToken(CommonParser.False, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !(_la==False || _la==True) ) {
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
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 4:
			return stringExpression_sempred((StringExpressionContext)_localctx, predIndex);
		case 5:
			return arithmeticExpression_sempred((ArithmeticExpressionContext)_localctx, predIndex);
		case 6:
			return boolExpression_sempred((BoolExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean stringExpression_sempred(StringExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arithmeticExpression_sempred(ArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean boolExpression_sempred(BoolExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u013f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000"+
		"\u0017\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001b\b\u0000\n\u0000"+
		"\f\u0000\u001e\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000(\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000,\b\u0000\n\u0000\f\u0000/\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002"+
		"\u0001\u0002\u0005\u0002F\b\u0002\n\u0002\f\u0002I\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002M\b\u0002\n\u0002\f\u0002P\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002T\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"X\b\u0003\u0001\u0003\u0005\u0003[\b\u0003\n\u0003\f\u0003^\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003b\b\u0003\n\u0003\f\u0003e\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003i\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004p\b\u0004\n\u0004\f\u0004s\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004w\b\u0004\n\u0004\f\u0004z\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u007f\b\u0004\n"+
		"\u0004\f\u0004\u0082\t\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0086"+
		"\b\u0004\n\u0004\f\u0004\u0089\t\u0004\u0001\u0004\u0005\u0004\u008c\b"+
		"\u0004\n\u0004\f\u0004\u008f\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0096\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u009a\b\u0005\n\u0005\f\u0005\u009d\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u00a1\b\u0005\n\u0005\f\u0005\u00a4\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00a9\b\u0005\n\u0005\f\u0005\u00ac"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00b0\b\u0005\n\u0005\f\u0005"+
		"\u00b3\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00b8\b"+
		"\u0005\n\u0005\f\u0005\u00bb\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00bf\b\u0005\n\u0005\f\u0005\u00c2\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u00c7\b\u0005\n\u0005\f\u0005\u00ca\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00ce\b\u0005\n\u0005\f\u0005\u00d1\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00d6\b\u0005\n\u0005\f\u0005"+
		"\u00d9\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00dd\b\u0005\n\u0005"+
		"\f\u0005\u00e0\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00e5\b\u0005\n\u0005\f\u0005\u00e8\t\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u00ec\b\u0005\n\u0005\f\u0005\u00ef\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00f4\b\u0005\n\u0005\f\u0005\u00f7\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u00fb\b\u0005\n\u0005\f\u0005\u00fe\t\u0005"+
		"\u0001\u0005\u0005\u0005\u0101\b\u0005\n\u0005\f\u0005\u0104\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u0109\b\u0006\u000b\u0006\f"+
		"\u0006\u010a\u0001\u0006\u0001\u0006\u0003\u0006\u010f\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0004\u0006\u0113\b\u0006\u000b\u0006\f\u0006\u0114\u0001"+
		"\u0006\u0001\u0006\u0004\u0006\u0119\b\u0006\u000b\u0006\f\u0006\u011a"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u0120\b\u0006\u000b\u0006"+
		"\f\u0006\u0121\u0001\u0006\u0001\u0006\u0004\u0006\u0126\b\u0006\u000b"+
		"\u0006\f\u0006\u0127\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u012d"+
		"\b\u0006\u000b\u0006\f\u0006\u012e\u0001\u0006\u0001\u0006\u0004\u0006"+
		"\u0133\b\u0006\u000b\u0006\f\u0006\u0134\u0001\u0006\u0005\u0006\u0138"+
		"\b\u0006\n\u0006\f\u0006\u013b\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0000\u0004\u0000\b\n\f\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0003"+
		"\u0002\u0000\u0003\b**\u0002\u0000##%%\u0002\u0000\u0013\u0013\u001c\u001c"+
		"\u0171\u0000\'\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000\u0000"+
		"\u0004B\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000\u0000\bj\u0001"+
		"\u0000\u0000\u0000\n\u0095\u0001\u0000\u0000\u0000\f\u010e\u0001\u0000"+
		"\u0000\u0000\u000e\u013c\u0001\u0000\u0000\u0000\u0010\u0011\u0006\u0000"+
		"\uffff\uffff\u0000\u0011\u0015\u0005\u0001\u0000\u0000\u0012\u0014\u0005"+
		" \u0000\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014\u0017\u0001\u0000"+
		"\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000"+
		"\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000"+
		"\u0000\u0000\u0018\u001c\u0003\u0000\u0000\u0000\u0019\u001b\u0005 \u0000"+
		"\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000"+
		"\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000"+
		"\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000"+
		"\u0000\u001f \u0005\u0002\u0000\u0000 (\u0001\u0000\u0000\u0000!(\u0003"+
		"\n\u0005\u0000\"(\u0003\b\u0004\u0000#(\u0003\u0006\u0003\u0000$(\u0003"+
		"\u0004\u0002\u0000%(\u0003\f\u0006\u0000&(\u0005\u001f\u0000\u0000\'\u0010"+
		"\u0001\u0000\u0000\u0000\'!\u0001\u0000\u0000\u0000\'\"\u0001\u0000\u0000"+
		"\u0000\'#\u0001\u0000\u0000\u0000\'$\u0001\u0000\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000\'&\u0001\u0000\u0000\u0000(;\u0001\u0000\u0000\u0000"+
		")-\n\u0006\u0000\u0000*,\u0005 \u0000\u0000+*\u0001\u0000\u0000\u0000"+
		",/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000"+
		"\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000004\u0003\u0002"+
		"\u0001\u000013\u0005 \u0000\u000021\u0001\u0000\u0000\u000036\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0003\u0000\u0000\u0007"+
		"8:\u0001\u0000\u0000\u00009)\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0001\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0007\u0000\u0000\u0000"+
		"?\u0003\u0001\u0000\u0000\u0000@C\u0003\f\u0006\u0000AC\u0003\n\u0005"+
		"\u0000B@\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CG\u0001\u0000"+
		"\u0000\u0000DF\u0005 \u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JN\u0005\u0015\u0000\u0000"+
		"KM\u0005 \u0000\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OS\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000QT\u0003\f\u0006\u0000RT\u0003\n\u0005"+
		"\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000T\u0005\u0001"+
		"\u0000\u0000\u0000UX\u0003\f\u0006\u0000VX\u0003\n\u0005\u0000WU\u0001"+
		"\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X\\\u0001\u0000\u0000\u0000"+
		"Y[\u0005 \u0000\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000_c\u0005\u0011\u0000\u0000`b\u0005 \u0000"+
		"\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000dh\u0001\u0000\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000fi\u0003\f\u0006\u0000gi\u0003\n\u0005\u0000hf\u0001"+
		"\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\u0007\u0001\u0000\u0000"+
		"\u0000jk\u0006\u0004\uffff\uffff\u0000kl\u0005\u000b\u0000\u0000l\u008d"+
		"\u0001\u0000\u0000\u0000mq\n\u0003\u0000\u0000np\u0005 \u0000\u0000on"+
		"\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000tx\u0007\u0001\u0000\u0000uw\u0005 \u0000\u0000vu\u0001\u0000"+
		"\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000"+
		"{\u008c\u0003\b\u0004\u0004|\u0080\n\u0002\u0000\u0000}\u007f\u0005 \u0000"+
		"\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0087"+
		"\u0005\u0016\u0000\u0000\u0084\u0086\u0005 \u0000\u0000\u0085\u0084\u0001"+
		"\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008c\u0003"+
		"\b\u0004\u0003\u008bm\u0001\u0000\u0000\u0000\u008b|\u0001\u0000\u0000"+
		"\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\t\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0006\u0005\uffff\uffff"+
		"\u0000\u0091\u0092\u0005$\u0000\u0000\u0092\u0096\u0003\n\u0005\n\u0093"+
		"\u0096\u0005\n\u0000\u0000\u0094\u0096\u0005\t\u0000\u0000\u0095\u0090"+
		"\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0102\u0001\u0000\u0000\u0000\u0097\u009b"+
		"\n\t\u0000\u0000\u0098\u009a\u0005 \u0000\u0000\u0099\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a2\u0005(\u0000"+
		"\u0000\u009f\u00a1\u0005 \u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u0101\u0003\n\u0005\t\u00a6"+
		"\u00aa\n\b\u0000\u0000\u00a7\u00a9\u0005 \u0000\u0000\u00a8\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b1\u0005"+
		"&\u0000\u0000\u00ae\u00b0\u0005 \u0000\u0000\u00af\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u0101\u0003\n\u0005\t"+
		"\u00b5\u00b9\n\u0007\u0000\u0000\u00b6\u00b8\u0005 \u0000\u0000\u00b7"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc"+
		"\u00c0\u0005\'\u0000\u0000\u00bd\u00bf\u0005 \u0000\u0000\u00be\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u0101"+
		"\u0003\n\u0005\b\u00c4\u00c8\n\u0006\u0000\u0000\u00c5\u00c7\u0005 \u0000"+
		"\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cf\u0005\u0017\u0000\u0000\u00cc\u00ce\u0005 \u0000\u0000"+
		"\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d2\u0101\u0003\n\u0005\u0007\u00d3\u00d7\n\u0005\u0000\u0000\u00d4"+
		"\u00d6\u0005 \u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00da\u00de\u0005)\u0000\u0000\u00db\u00dd\u0005"+
		" \u0000\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000"+
		"\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000"+
		"\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"+
		"\u0000\u0000\u00e1\u0101\u0003\n\u0005\u0006\u00e2\u00e6\n\u0004\u0000"+
		"\u0000\u00e3\u00e5\u0005 \u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ed\u0005%\u0000\u0000\u00ea"+
		"\u00ec\u0005 \u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef\u00ed"+
		"\u0001\u0000\u0000\u0000\u00f0\u0101\u0003\n\u0005\u0005\u00f1\u00f5\n"+
		"\u0003\u0000\u0000\u00f2\u00f4\u0005 \u0000\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fc\u0005$\u0000"+
		"\u0000\u00f9\u00fb\u0005 \u0000\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00ff\u0001\u0000\u0000\u0000"+
		"\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0101\u0003\n\u0005\u0004\u0100"+
		"\u0097\u0001\u0000\u0000\u0000\u0100\u00a6\u0001\u0000\u0000\u0000\u0100"+
		"\u00b5\u0001\u0000\u0000\u0000\u0100\u00c4\u0001\u0000\u0000\u0000\u0100"+
		"\u00d3\u0001\u0000\u0000\u0000\u0100\u00e2\u0001\u0000\u0000\u0000\u0100"+
		"\u00f1\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102"+
		"\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u000b\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0006\u0006\uffff\uffff\u0000\u0106\u0108\u0005\u0018\u0000\u0000"+
		"\u0107\u0109\u0005 \u0000\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c"+
		"\u010f\u0003\f\u0006\u0005\u010d\u010f\u0003\u000e\u0007\u0000\u010e\u0105"+
		"\u0001\u0000\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0139"+
		"\u0001\u0000\u0000\u0000\u0110\u0112\n\u0004\u0000\u0000\u0111\u0113\u0005"+
		" \u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000"+
		"\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0005\f\u0000"+
		"\u0000\u0117\u0119\u0005 \u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000"+
		"\u011c\u0138\u0003\f\u0006\u0005\u011d\u011f\n\u0003\u0000\u0000\u011e"+
		"\u0120\u0005 \u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0125"+
		"\u0005\u001b\u0000\u0000\u0124\u0126\u0005 \u0000\u0000\u0125\u0124\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0125\u0001"+
		"\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0129\u0001"+
		"\u0000\u0000\u0000\u0129\u0138\u0003\f\u0006\u0004\u012a\u012c\n\u0002"+
		"\u0000\u0000\u012b\u012d\u0005 \u0000\u0000\u012c\u012b\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000"+
		"\u0000\u0130\u0132\u0005\u001e\u0000\u0000\u0131\u0133\u0005 \u0000\u0000"+
		"\u0132\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000"+
		"\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138\u0003\f\u0006\u0003\u0137"+
		"\u0110\u0001\u0000\u0000\u0000\u0137\u011d\u0001\u0000\u0000\u0000\u0137"+
		"\u012a\u0001\u0000\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139"+
		"\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a"+
		"\r\u0001\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013d"+
		"\u0007\u0002\u0000\u0000\u013d\u000f\u0001\u0000\u0000\u0000/\u0015\u001c"+
		"\'-4;BGNSW\\chqx\u0080\u0087\u008b\u008d\u0095\u009b\u00a2\u00aa\u00b1"+
		"\u00b9\u00c0\u00c8\u00cf\u00d7\u00de\u00e6\u00ed\u00f5\u00fc\u0100\u0102"+
		"\u010a\u010e\u0114\u011a\u0121\u0127\u012e\u0134\u0137\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}