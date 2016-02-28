/* The following code was generated by JFlex 1.6.1 */

package org.lucylang.ljvm.parser;

import org.lucylang.ljvm.value.*;
import org.lucylang.ljvm.parser.Parser.Terminals;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>E:/Development/ljvm/tools/../src/main/java/org/lucylang/ljvm/parser/lexer.flex</tt>
 */
public class Lexer extends beaver.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\51\1\62\1\63\1\63\1\1\22\0\1\51\1\44\1\56"+
    "\3\0\1\46\1\61\1\27\1\30\1\40\1\36\1\34\1\37\1\53"+
    "\1\41\12\52\1\50\1\33\1\43\1\35\1\42\2\0\32\54\1\31"+
    "\1\57\1\32\1\0\1\55\1\0\1\3\1\60\1\4\1\45\1\7"+
    "\1\16\1\6\1\24\1\10\1\54\1\5\1\21\1\11\1\20\1\12"+
    "\1\2\1\54\1\13\1\22\1\14\1\17\1\15\1\23\3\54\1\25"+
    "\1\47\1\26\7\0\1\63\32\0\1\51\u15df\0\1\51\u097f\0\13\51"+
    "\35\0\1\63\1\63\5\0\1\51\57\0\1\51\u0fa0\0\1\51\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\ud00f\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\14\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\3\1\1\24\1\25\1\1"+
    "\1\26\1\27\1\30\1\31\1\1\1\30\1\0\4\3"+
    "\1\32\1\33\7\3\1\34\1\35\1\36\1\37\1\40"+
    "\1\33\1\41\1\0\1\25\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\0\1\3\1\40"+
    "\4\3\1\53\2\3\1\23\2\3\1\0\1\3\1\54"+
    "\2\3\1\55\1\56\1\57\1\3\1\54\3\3\1\60"+
    "\1\3\1\61\1\62\1\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\64\0\150\0\234\0\320\0\u0104\0\u0138\0\u016c"+
    "\0\u01a0\0\u01d4\0\u0208\0\u023c\0\u0270\0\u02a4\0\u02d8\0\u030c"+
    "\0\150\0\150\0\150\0\150\0\150\0\150\0\u0340\0\150"+
    "\0\u0374\0\150\0\150\0\150\0\150\0\u03a8\0\u03dc\0\u0410"+
    "\0\u0444\0\u0478\0\u04ac\0\150\0\u04e0\0\u0514\0\150\0\u0548"+
    "\0\u057c\0\150\0\u05b0\0\150\0\u05e4\0\u0618\0\u064c\0\u0680"+
    "\0\u06b4\0\u0138\0\u0138\0\u06e8\0\u071c\0\u0750\0\u0784\0\u07b8"+
    "\0\u07ec\0\u0820\0\150\0\150\0\150\0\150\0\150\0\150"+
    "\0\150\0\u0514\0\u0514\0\150\0\150\0\150\0\150\0\150"+
    "\0\150\0\150\0\150\0\150\0\u0854\0\u0888\0\u0138\0\u08bc"+
    "\0\u08f0\0\u0924\0\u0958\0\u0138\0\u098c\0\u09c0\0\u0138\0\u09f4"+
    "\0\u0a28\0\u0a5c\0\u0a90\0\u0138\0\u0ac4\0\u0af8\0\u0138\0\u0138"+
    "\0\u0138\0\u0b2c\0\150\0\u0b60\0\u0b94\0\u0bc8\0\u0138\0\u0bfc"+
    "\0\u0138\0\u0138\0\u0138";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\3\7\1\10\1\11\1\7"+
    "\1\12\1\13\1\14\1\15\1\16\1\7\1\17\2\7"+
    "\1\20\1\7\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\7\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\7\1\3\1\47\1\3\1\7\1\3\1\4"+
    "\1\44\1\50\1\51\54\50\1\52\1\53\2\50\1\54"+
    "\1\50\65\0\1\4\5\0\1\55\52\0\1\4\3\0"+
    "\1\7\1\56\21\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\16\7\1\57\4\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\23\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\17\7\1\60\3\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\7\7\1\61"+
    "\4\7\1\62\6\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\11\7\1\63\11\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\5\7\1\64\15\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\11\7\1\65\11\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\1\7\1\66\21\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\1\7\1\67\13\7\1\70"+
    "\5\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\10\7\1\71\12\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\22\7\1\72"+
    "\20\0\1\7\4\0\1\7\1\0\2\7\2\0\1\7"+
    "\36\0\1\27\65\0\1\73\63\0\1\74\63\0\1\75"+
    "\63\0\1\76\74\0\1\77\64\0\1\100\64\0\1\101"+
    "\65\0\1\45\1\102\62\0\1\103\11\0\1\50\1\0"+
    "\54\50\2\0\2\50\1\0\1\50\62\0\1\54\1\0"+
    "\1\104\1\0\11\104\1\105\1\106\1\104\1\107\1\104"+
    "\1\110\35\104\1\111\1\112\1\113\1\114\23\0\1\115"+
    "\44\0\2\7\1\116\20\7\20\0\1\7\4\0\1\7"+
    "\1\0\2\7\2\0\1\7\5\0\23\7\20\0\1\117"+
    "\4\0\1\7\1\0\2\7\2\0\1\7\5\0\20\7"+
    "\1\120\2\7\20\0\1\7\4\0\1\7\1\0\2\7"+
    "\2\0\1\7\5\0\1\121\22\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\12\7\1\122"+
    "\10\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\15\7\1\123\5\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\11\7\1\124"+
    "\11\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\17\7\1\125\3\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\16\7\1\126"+
    "\4\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\12\7\1\127\3\7\1\130\4\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\6\7\1\131\14\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\25\0\1\132\43\0\3\7\1\133"+
    "\17\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\5\7\1\134\15\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\10\7\1\135"+
    "\12\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\15\7\1\136\5\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\5\7\1\137"+
    "\15\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\20\7\1\123\2\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\2\7\1\140"+
    "\20\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\5\0\5\7\1\141\15\7\20\0\1\7\4\0"+
    "\1\7\1\0\2\7\2\0\1\7\5\0\17\7\1\142"+
    "\3\7\20\0\1\7\4\0\1\7\1\0\2\7\2\0"+
    "\1\7\12\0\1\143\56\0\1\7\1\144\21\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\11\7\1\145\11\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\11\7\1\146\11\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\5\7\1\147\15\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\4\7\1\150\16\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\12\7\1\151\10\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\5\0\16\7\1\152\4\7\20\0"+
    "\1\7\4\0\1\7\1\0\2\7\2\0\1\7\5\0"+
    "\5\7\1\153\15\7\20\0\1\7\4\0\1\7\1\0"+
    "\2\7\2\0\1\7\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3120];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\15\1\6\11\1\1\1\11\1\1\4\11"+
    "\6\1\1\11\2\1\1\11\2\1\1\11\1\1\1\11"+
    "\1\0\15\1\7\11\1\0\1\1\11\11\1\0\14\1"+
    "\1\0\10\1\1\11\10\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[107];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    StringBuffer stringBuffer = new StringBuffer();

    private beaver.Symbol token(short id) {
        return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
    }

    private beaver.Symbol token(short id, Object value) {
        return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 192) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public beaver.Symbol nextToken() throws java.io.IOException, beaver.Scanner.Exception {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          {     return new beaver.Symbol(Terminals.EOF, "end-of-file");
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new beaver.Scanner.Exception("unexpected character '" + yytext() + "'");
            }
          case 52: break;
          case 2: 
            { return token(Terminals.STMT_TAIL);
            }
          case 53: break;
          case 3: 
            { return token(Terminals.ID, yytext());
            }
          case 54: break;
          case 4: 
            { return token(Terminals.LCURLY);
            }
          case 55: break;
          case 5: 
            { return token(Terminals.RCURLY);
            }
          case 56: break;
          case 6: 
            { return token(Terminals.LPAREN);
            }
          case 57: break;
          case 7: 
            { return token(Terminals.RPAREN);
            }
          case 58: break;
          case 8: 
            { return token(Terminals.LSBRACKET);
            }
          case 59: break;
          case 9: 
            { return token(Terminals.RSBRACKET);
            }
          case 60: break;
          case 10: 
            { return token(Terminals.SEMICOLON);
            }
          case 61: break;
          case 11: 
            { return token(Terminals.COMMA);
            }
          case 62: break;
          case 12: 
            { return token(Terminals.ASSIGN);
            }
          case 63: break;
          case 13: 
            { return token(Terminals.PLUS);
            }
          case 64: break;
          case 14: 
            { return token(Terminals.MINUS);
            }
          case 65: break;
          case 15: 
            { return token(Terminals.TIMES);
            }
          case 66: break;
          case 16: 
            { return token(Terminals.DIV);
            }
          case 67: break;
          case 17: 
            { return token(Terminals.GT);
            }
          case 68: break;
          case 18: 
            { return token(Terminals.LT);
            }
          case 69: break;
          case 19: 
            { return token(Terminals.NOT);
            }
          case 70: break;
          case 20: 
            { /* return */
            }
          case 71: break;
          case 21: 
            { return token(Terminals.NUMBER_LITERAL, yytext());
            }
          case 72: break;
          case 22: 
            { stringBuffer.setLength(0); yybegin(STRING);
            }
          case 73: break;
          case 23: 
            { stringBuffer.append(yytext());
            }
          case 74: break;
          case 24: 
            { throw new beaver.Scanner.Exception("Unterminated string at end of line");
            }
          case 75: break;
          case 25: 
            { yybegin(YYINITIAL); return token(Terminals.STRING_LITERAL, stringBuffer.toString());
            }
          case 76: break;
          case 26: 
            { return token(Terminals.IF);
            }
          case 77: break;
          case 27: 
            { return token(Terminals.OR);
            }
          case 78: break;
          case 28: 
            { return token(Terminals.EQUAL);
            }
          case 79: break;
          case 29: 
            { return token(Terminals.GEQ);
            }
          case 80: break;
          case 30: 
            { return token(Terminals.LEQ);
            }
          case 81: break;
          case 31: 
            { return token(Terminals.NEQ);
            }
          case 82: break;
          case 32: 
            { return token(Terminals.AND);
            }
          case 83: break;
          case 33: 
            { return token(Terminals.DOUBLE_COLON);
            }
          case 84: break;
          case 34: 
            { throw new beaver.Scanner.Exception("Illegal escape sequence \""+yytext()+"\"");
            }
          case 85: break;
          case 35: 
            { stringBuffer.append('\r');
            }
          case 86: break;
          case 36: 
            { stringBuffer.append('\t');
            }
          case 87: break;
          case 37: 
            { stringBuffer.append('\f');
            }
          case 88: break;
          case 38: 
            { stringBuffer.append('\n');
            }
          case 89: break;
          case 39: 
            { stringBuffer.append('\"');
            }
          case 90: break;
          case 40: 
            { stringBuffer.append('\\');
            }
          case 91: break;
          case 41: 
            { stringBuffer.append('\b');
            }
          case 92: break;
          case 42: 
            { stringBuffer.append('\'');
            }
          case 93: break;
          case 43: 
            { return token(Terminals.VAR);
            }
          case 94: break;
          case 44: 
            { return token(Terminals.ELSE);
            }
          case 95: break;
          case 45: 
            { return token(Terminals.BOOL_LITERAL, yytext());
            }
          case 96: break;
          case 46: 
            { return token(Terminals.FUNC);
            }
          case 97: break;
          case 47: 
            { return token(Terminals.NONE_LITERAL);
            }
          case 98: break;
          case 48: 
            { return token(Terminals.WHILE);
            }
          case 99: break;
          case 49: 
            { return token(Terminals.IMPORT);
            }
          case 100: break;
          case 50: 
            { return token(Terminals.RETURN);
            }
          case 101: break;
          case 51: 
            { return token(Terminals.PACKAGE);
            }
          case 102: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
