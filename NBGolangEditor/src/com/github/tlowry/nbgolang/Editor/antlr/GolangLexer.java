package com.github.tlowry.nbgolang.Editor.antlr;

import org.antlr.runtime.*;

public class GolangLexer extends Lexer {

    public static final int EOF = -1;
    public static final int COMMA = 4;
    public static final int EQUAL = 5;
    public static final int EQUALEQUAL = 6;
    public static final int FOR = 7;
    public static final int ID = 8;
    public static final int INT = 9;
    public static final int LEFTBRACE = 10;
    public static final int LEFTPAREN = 11;
    public static final int LESSTHAN = 12;
    public static final int PLUS = 13;
    public static final int RIGHTBRACE = 14;
    public static final int RIGHTPAREN = 15;
    public static final int SEMICOLON = 16;
    public static final int TYPE_CHAR = 17;
    public static final int TYPE_INT = 18;
    public static final int WS = 19;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[]{};
    }

    public GolangLexer() {
    }

    public GolangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public GolangLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String getGrammarFileName() {
        return "C:\\Users\\tony.lowry\\Desktop\\golang.g";
    }

    // $ANTLR start "TYPE_INT"
    public final void mTYPE_INT() throws RecognitionException {
        try {
            int _type = TYPE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:139:10: ( 'int' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:139:12: 'int'
            {
                match("int");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TYPE_INT"

    // $ANTLR start "TYPE_CHAR"
    public final void mTYPE_CHAR() throws RecognitionException {
        try {
            int _type = TYPE_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:140:11: ( 'char' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:140:13: 'char'
            {
                match("char");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TYPE_CHAR"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:141:5: ( 'for' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:141:7: 'for'
            {
                match("for");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:143:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:143:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
                if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
                // C:\\Users\\tony.lowry\\Desktop\\golang.g:143:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                loop1:
                while (true) {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);
                    if (((LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                        case 1: // C:\\Users\\tony.lowry\\Desktop\\golang.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            break loop1;
                    }
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:146:5: ( ( '0' .. '9' )+ )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:146:7: ( '0' .. '9' )+
            {
                // C:\\Users\\tony.lowry\\Desktop\\golang.g:146:7: ( '0' .. '9' )+
                int cnt2 = 0;
                loop2:
                while (true) {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);
                    if (((LA2_0 >= '0' && LA2_0 <= '9'))) {
                        alt2 = 1;
                    }

                    switch (alt2) {
                        case 1: // C:\\Users\\tony.lowry\\Desktop\\golang.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt2 >= 1) {
                                break loop2;
                            }
                            EarlyExitException eee = new EarlyExitException(2, input);
                            throw eee;
                    }
                    cnt2++;
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:149:7: ( '=' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:149:9: '='
            {
                match('=');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "EQUALEQUAL"
    public final void mEQUALEQUAL() throws RecognitionException {
        try {
            int _type = EQUALEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:150:12: ( '==' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:150:14: '=='
            {
                match("==");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "EQUALEQUAL"

    // $ANTLR start "LESSTHAN"
    public final void mLESSTHAN() throws RecognitionException {
        try {
            int _type = LESSTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:151:10: ( '<' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:151:12: '<'
            {
                match('<');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LESSTHAN"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:152:11: ( ';' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:152:13: ';'
            {
                match(';');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "LEFTPAREN"
    public final void mLEFTPAREN() throws RecognitionException {
        try {
            int _type = LEFTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:153:11: ( '(' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:153:13: '('
            {
                match('(');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LEFTPAREN"

    // $ANTLR start "RIGHTPAREN"
    public final void mRIGHTPAREN() throws RecognitionException {
        try {
            int _type = RIGHTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:154:12: ( ')' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:154:14: ')'
            {
                match(')');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "RIGHTPAREN"

    // $ANTLR start "LEFTBRACE"
    public final void mLEFTBRACE() throws RecognitionException {
        try {
            int _type = LEFTBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:155:11: ( '{' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:155:13: '{'
            {
                match('{');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LEFTBRACE"

    // $ANTLR start "RIGHTBRACE"
    public final void mRIGHTBRACE() throws RecognitionException {
        try {
            int _type = RIGHTBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:156:12: ( '}' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:156:14: '}'
            {
                match('}');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "RIGHTBRACE"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:157:6: ( '+' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:157:8: '+'
            {
                match('+');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:158:7: ( ',' )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:158:9: ','
            {
                match(',');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:163:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // C:\\Users\\tony.lowry\\Desktop\\golang.g:163:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
                // C:\\Users\\tony.lowry\\Desktop\\golang.g:163:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
                int cnt3 = 0;
                loop3:
                while (true) {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);
                    if (((LA3_0 >= '\t' && LA3_0 <= '\n') || LA3_0 == '\r' || LA3_0 == ' ')) {
                        alt3 = 1;
                    }

                    switch (alt3) {
                        case 1: // C:\\Users\\tony.lowry\\Desktop\\golang.g:
                        {
                            if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ') {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt3 >= 1) {
                                break loop3;
                            }
                            EarlyExitException eee = new EarlyExitException(3, input);
                            throw eee;
                    }
                    cnt3++;
                }

                _channel = HIDDEN;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    @Override
    public void mTokens() throws RecognitionException {
        // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:8: ( TYPE_INT | TYPE_CHAR | FOR | ID | INT | EQUAL | EQUALEQUAL | LESSTHAN | SEMICOLON | LEFTPAREN | RIGHTPAREN | LEFTBRACE | RIGHTBRACE | PLUS | COMMA | WS )
        int alt4 = 16;
        switch (input.LA(1)) {
            case 'i': {
                int LA4_1 = input.LA(2);
                if ((LA4_1 == 'n')) {
                    int LA4_16 = input.LA(3);
                    if ((LA4_16 == 't')) {
                        int LA4_21 = input.LA(4);
                        if (((LA4_21 >= '0' && LA4_21 <= '9') || (LA4_21 >= 'A' && LA4_21 <= 'Z') || LA4_21 == '_' || (LA4_21 >= 'a' && LA4_21 <= 'z'))) {
                            alt4 = 4;
                        } else {
                            alt4 = 1;
                        }

                    } else {
                        alt4 = 4;
                    }

                } else {
                    alt4 = 4;
                }

            }
            break;
            case 'c': {
                int LA4_2 = input.LA(2);
                if ((LA4_2 == 'h')) {
                    int LA4_17 = input.LA(3);
                    if ((LA4_17 == 'a')) {
                        int LA4_22 = input.LA(4);
                        if ((LA4_22 == 'r')) {
                            int LA4_25 = input.LA(5);
                            if (((LA4_25 >= '0' && LA4_25 <= '9') || (LA4_25 >= 'A' && LA4_25 <= 'Z') || LA4_25 == '_' || (LA4_25 >= 'a' && LA4_25 <= 'z'))) {
                                alt4 = 4;
                            } else {
                                alt4 = 2;
                            }

                        } else {
                            alt4 = 4;
                        }

                    } else {
                        alt4 = 4;
                    }

                } else {
                    alt4 = 4;
                }

            }
            break;
            case 'f': {
                int LA4_3 = input.LA(2);
                if ((LA4_3 == 'o')) {
                    int LA4_18 = input.LA(3);
                    if ((LA4_18 == 'r')) {
                        int LA4_23 = input.LA(4);
                        if (((LA4_23 >= '0' && LA4_23 <= '9') || (LA4_23 >= 'A' && LA4_23 <= 'Z') || LA4_23 == '_' || (LA4_23 >= 'a' && LA4_23 <= 'z'))) {
                            alt4 = 4;
                        } else {
                            alt4 = 3;
                        }

                    } else {
                        alt4 = 4;
                    }

                } else {
                    alt4 = 4;
                }

            }
            break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'd':
            case 'e':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z': {
                alt4 = 4;
            }
            break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': {
                alt4 = 5;
            }
            break;
            case '=': {
                int LA4_6 = input.LA(2);
                if ((LA4_6 == '=')) {
                    alt4 = 7;
                } else {
                    alt4 = 6;
                }

            }
            break;
            case '<': {
                alt4 = 8;
            }
            break;
            case ';': {
                alt4 = 9;
            }
            break;
            case '(': {
                alt4 = 10;
            }
            break;
            case ')': {
                alt4 = 11;
            }
            break;
            case '{': {
                alt4 = 12;
            }
            break;
            case '}': {
                alt4 = 13;
            }
            break;
            case '+': {
                alt4 = 14;
            }
            break;
            case ',': {
                alt4 = 15;
            }
            break;
            case '\t':
            case '\n':
            case '\r':
            case ' ': {
                alt4 = 16;
            }
            break;
            default:
                NoViableAltException nvae =
                        new NoViableAltException("", 4, 0, input);
                throw nvae;
        }
        switch (alt4) {
            case 1: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:10: TYPE_INT
            {
                mTYPE_INT();

            }
            break;
            case 2: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:19: TYPE_CHAR
            {
                mTYPE_CHAR();

            }
            break;
            case 3: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:29: FOR
            {
                mFOR();

            }
            break;
            case 4: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:33: ID
            {
                mID();

            }
            break;
            case 5: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:36: INT
            {
                mINT();

            }
            break;
            case 6: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:40: EQUAL
            {
                mEQUAL();

            }
            break;
            case 7: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:46: EQUALEQUAL
            {
                mEQUALEQUAL();

            }
            break;
            case 8: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:57: LESSTHAN
            {
                mLESSTHAN();

            }
            break;
            case 9: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:66: SEMICOLON
            {
                mSEMICOLON();

            }
            break;
            case 10: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:76: LEFTPAREN
            {
                mLEFTPAREN();

            }
            break;
            case 11: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:86: RIGHTPAREN
            {
                mRIGHTPAREN();

            }
            break;
            case 12: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:97: LEFTBRACE
            {
                mLEFTBRACE();

            }
            break;
            case 13: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:107: RIGHTBRACE
            {
                mRIGHTBRACE();

            }
            break;
            case 14: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:118: PLUS
            {
                mPLUS();

            }
            break;
            case 15: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:123: COMMA
            {
                mCOMMA();

            }
            break;
            case 16: // C:\\Users\\tony.lowry\\Desktop\\golang.g:1:129: WS
            {
                mWS();

            }
            break;

        }
    }
}
