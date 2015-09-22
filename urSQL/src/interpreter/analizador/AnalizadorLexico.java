/* The following code was generated by JFlex 1.4.3 on 17/09/15 08:15 AM */

package interpreter.analizador;
import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 17/09/15 08:15 AM from the specification file
 * <tt>src/interpreter/analizador/Escaner.flex</tt>
 */
public class AnalizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\10\1\0\1\7"+
    "\5\0\1\14\1\15\1\20\1\0\1\16\3\0\12\4\1\0\1\17"+
    "\1\12\1\13\1\11\2\0\1\24\1\27\1\21\1\26\1\23\1\45"+
    "\1\35\1\42\1\34\1\50\1\44\1\33\1\41\1\40\1\31\1\32"+
    "\1\6\1\22\1\30\1\25\1\36\1\43\1\47\1\46\1\37\1\6"+
    "\4\0\1\5\1\0\32\6\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\24\5"+
    "\1\2\1\5\1\0\5\5\1\16\7\5\1\17\2\5"+
    "\1\20\2\5\1\21\17\5\1\22\5\5\1\23\10\5"+
    "\1\24\12\5\1\25\1\5\1\26\1\5\1\27\1\30"+
    "\2\5\1\31\10\5\1\32\4\5\1\33\10\5\1\34"+
    "\1\5\1\35\1\36\1\5\1\37\4\5\1\40\2\5"+
    "\1\41\2\5\1\42\2\5\1\43\2\5\1\44\1\5"+
    "\1\45\6\5\1\46\3\5\1\47\1\5\1\50\4\5"+
    "\1\51\1\5\1\52\4\5\1\53\3\5\1\54\1\55"+
    "\2\5\1\56\1\57\1\5\1\60\4\5\1\61\1\62"+
    "\2\5\1\63\1\64\1\65\1\66\1\67\3\5\1\70"+
    "\1\71\3\5\1\72\1\5\1\73\1\74\26\5";

  private static int [] zzUnpackAction() {
    int [] result = new int[239];
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
    "\0\0\0\51\0\122\0\173\0\51\0\244\0\315\0\366"+
    "\0\51\0\51\0\51\0\51\0\51\0\51\0\51\0\51"+
    "\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e"+
    "\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386"+
    "\0\u03af\0\u03d8\0\u0401\0\u042a\0\51\0\u0453\0\u047c\0\u04a5"+
    "\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0453\0\u0572\0\u059b\0\u05c4"+
    "\0\u05ed\0\u0616\0\u063f\0\u0668\0\u0453\0\u0691\0\u06ba\0\u0453"+
    "\0\u06e3\0\u070c\0\u0453\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9"+
    "\0\u0802\0\u082b\0\u0854\0\u087d\0\u08a6\0\u08cf\0\u08f8\0\u0921"+
    "\0\u094a\0\u0973\0\51\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40"+
    "\0\u0973\0\u0a69\0\u0a92\0\u0abb\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f"+
    "\0\u0b88\0\u0973\0\u0bb1\0\u0bda\0\u0c03\0\u0c2c\0\u0c55\0\u0c7e"+
    "\0\u0ca7\0\u0cd0\0\u0cf9\0\u0d22\0\u0973\0\u0d4b\0\u0973\0\u0d74"+
    "\0\u0973\0\u0973\0\u0d9d\0\u0dc6\0\u0973\0\u0def\0\u0e18\0\u0e41"+
    "\0\u0e6a\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e\0\u0e93\0\u0f37\0\u0f60"+
    "\0\u0f89\0\u0fb2\0\u0e93\0\u0fdb\0\u1004\0\u102d\0\u1056\0\u107f"+
    "\0\u10a8\0\u10d1\0\u10fa\0\u0e93\0\u1123\0\u0e93\0\u0e93\0\u114c"+
    "\0\u0e93\0\u1175\0\u119e\0\u11c7\0\u11f0\0\u0e93\0\u1219\0\u1242"+
    "\0\u0e93\0\u126b\0\u1294\0\u0e93\0\u12bd\0\u12e6\0\u12bd\0\u130f"+
    "\0\u1338\0\u12bd\0\u1361\0\u12bd\0\u138a\0\u13b3\0\u13dc\0\u1405"+
    "\0\u142e\0\u1457\0\u12bd\0\u1480\0\u14a9\0\u14d2\0\u12bd\0\u14fb"+
    "\0\u12bd\0\u1524\0\u154d\0\u1576\0\u159f\0\u12bd\0\u15c8\0\u15c8"+
    "\0\u15f1\0\u161a\0\u1643\0\u166c\0\u15c8\0\u1695\0\u16be\0\u16e7"+
    "\0\u15c8\0\u15c8\0\u1710\0\u1739\0\u15c8\0\u15c8\0\u1762\0\u15c8"+
    "\0\u178b\0\u17b4\0\u17dd\0\u1806\0\u17b4\0\u17b4\0\u182f\0\u1858"+
    "\0\u17b4\0\u17b4\0\u17b4\0\u17b4\0\u17b4\0\u1881\0\u18aa\0\u18d3"+
    "\0\u1881\0\u18fc\0\u1925\0\u194e\0\u1977\0\u1925\0\u19a0\0\u19a0"+
    "\0\u19a0\0\u19c9\0\u19f2\0\u1a1b\0\u1a44\0\u1a6d\0\u1a96\0\u1abf"+
    "\0\u1ae8\0\u1b11\0\u1b3a\0\u1b63\0\u1b8c\0\u1bb5\0\u1bde\0\u1c07"+
    "\0\u1c30\0\u1c59\0\u1c82\0\u1cab\0\u1cd4\0\u1cfd\0\51";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[239];
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
    "\1\2\1\3\1\4\1\5\1\6\2\7\1\10\1\5"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\7\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\7\1\36"+
    "\1\37\1\7\1\40\1\41\1\42\1\7\1\43\1\44"+
    "\53\0\1\45\47\0\1\45\53\0\1\6\50\0\1\46"+
    "\1\0\1\46\12\0\30\46\4\0\1\47\1\0\1\47"+
    "\1\0\1\47\10\0\30\47\4\0\1\46\1\0\1\46"+
    "\12\0\1\46\1\50\6\46\1\51\10\46\1\52\6\46"+
    "\4\0\1\46\1\0\1\46\12\0\2\46\1\53\25\46"+
    "\4\0\1\46\1\0\1\46\12\0\5\46\1\54\1\46"+
    "\1\55\2\46\1\56\7\46\1\57\5\46\4\0\1\46"+
    "\1\0\1\46\12\0\3\46\1\60\24\46\4\0\1\46"+
    "\1\0\1\46\12\0\1\46\1\61\1\62\1\63\7\46"+
    "\1\64\14\46\4\0\1\46\1\0\1\46\12\0\16\46"+
    "\1\65\11\46\4\0\1\46\1\0\1\46\12\0\2\46"+
    "\1\66\1\46\1\67\23\46\4\0\1\46\1\0\1\46"+
    "\12\0\17\46\1\70\10\46\4\0\1\46\1\0\1\46"+
    "\12\0\1\46\1\71\26\46\4\0\1\46\1\0\1\46"+
    "\12\0\13\46\1\72\14\46\4\0\1\46\1\0\1\46"+
    "\12\0\7\46\1\73\7\46\1\74\10\46\4\0\1\46"+
    "\1\0\1\46\12\0\1\46\1\75\1\76\25\46\4\0"+
    "\1\46\1\0\1\46\12\0\11\46\1\77\16\46\4\0"+
    "\1\46\1\0\1\46\12\0\10\46\1\100\4\46\1\101"+
    "\12\46\4\0\1\46\1\0\1\46\12\0\3\46\1\102"+
    "\7\46\1\103\14\46\4\0\1\46\1\0\1\46\12\0"+
    "\3\46\1\104\24\46\4\0\1\46\1\0\1\46\12\0"+
    "\2\46\1\105\25\46\4\0\1\46\1\0\1\46\12\0"+
    "\1\46\1\106\6\46\1\107\17\46\4\0\1\46\1\0"+
    "\1\46\12\0\21\46\1\110\6\46\4\0\1\46\1\0"+
    "\1\46\12\0\10\46\1\111\17\46\4\0\1\112\1\0"+
    "\1\112\12\0\30\112\4\0\1\47\1\0\1\47\1\113"+
    "\1\47\10\0\30\47\4\0\1\112\1\0\1\112\12\0"+
    "\2\112\1\114\25\112\4\0\1\112\1\0\1\112\12\0"+
    "\15\112\1\115\1\112\1\116\10\112\4\0\1\112\1\0"+
    "\1\112\12\0\3\112\1\117\24\112\4\0\1\112\1\0"+
    "\1\112\12\0\24\112\1\120\3\112\4\0\1\112\1\0"+
    "\1\112\12\0\5\112\1\121\22\112\4\0\1\112\1\0"+
    "\1\112\12\0\4\112\1\122\23\112\4\0\1\112\1\0"+
    "\1\112\12\0\2\112\1\123\25\112\4\0\1\112\1\0"+
    "\1\112\12\0\6\112\1\124\21\112\4\0\1\112\1\0"+
    "\1\112\12\0\10\112\1\125\17\112\4\0\1\112\1\0"+
    "\1\112\12\0\1\126\11\112\1\127\15\112\4\0\1\112"+
    "\1\0\1\112\12\0\4\112\1\130\23\112\4\0\1\112"+
    "\1\0\1\112\12\0\7\112\1\131\20\112\4\0\1\112"+
    "\1\0\1\112\12\0\4\112\1\132\5\112\1\133\15\112"+
    "\4\0\1\112\1\0\1\112\12\0\3\112\1\134\4\112"+
    "\1\135\17\112\4\0\1\112\1\0\1\112\12\0\13\112"+
    "\1\136\14\112\4\0\1\112\1\0\1\112\12\0\7\112"+
    "\1\137\13\112\1\140\4\112\4\0\1\112\1\0\1\112"+
    "\12\0\4\112\1\141\1\142\1\112\1\143\20\112\4\0"+
    "\1\112\1\0\1\112\12\0\10\112\1\144\17\112\4\0"+
    "\1\112\1\0\1\112\12\0\4\112\1\145\23\112\4\0"+
    "\1\112\1\0\1\112\12\0\5\112\1\146\22\112\4\0"+
    "\1\112\1\0\1\112\12\0\4\112\1\147\23\112\4\0"+
    "\1\112\1\0\1\112\12\0\12\112\1\150\15\112\4\0"+
    "\1\112\1\0\1\112\12\0\25\112\1\151\2\112\4\0"+
    "\1\112\1\0\1\112\12\0\17\112\1\152\10\112\4\0"+
    "\1\112\1\0\1\112\12\0\1\112\1\153\10\112\1\154"+
    "\15\112\4\0\1\112\1\0\1\112\12\0\16\112\1\155"+
    "\11\112\4\0\1\112\1\0\1\112\12\0\10\112\1\156"+
    "\17\112\4\0\1\112\1\0\1\112\12\0\1\112\1\157"+
    "\26\112\4\0\1\112\1\0\1\112\12\0\2\112\1\160"+
    "\25\112\4\0\1\112\1\0\1\112\12\0\13\112\1\161"+
    "\14\112\4\0\1\162\1\0\1\162\12\0\30\162\4\0"+
    "\1\162\1\0\1\162\12\0\3\162\1\163\24\162\4\0"+
    "\1\162\1\0\1\162\12\0\17\162\1\164\10\162\4\0"+
    "\1\162\1\0\1\162\12\0\7\162\1\165\20\162\4\0"+
    "\1\162\1\0\1\162\12\0\1\162\1\166\26\162\4\0"+
    "\1\162\1\0\1\162\12\0\2\162\1\167\25\162\4\0"+
    "\1\162\1\0\1\162\12\0\2\162\1\170\25\162\4\0"+
    "\1\162\1\0\1\162\12\0\1\162\1\171\26\162\4\0"+
    "\1\162\1\0\1\162\12\0\12\162\1\172\15\162\4\0"+
    "\1\162\1\0\1\162\12\0\11\162\1\173\16\162\4\0"+
    "\1\162\1\0\1\162\12\0\13\162\1\174\14\162\4\0"+
    "\1\162\1\0\1\162\12\0\2\162\1\175\25\162\4\0"+
    "\1\162\1\0\1\162\12\0\2\162\1\176\1\177\24\162"+
    "\4\0\1\162\1\0\1\162\12\0\11\162\1\200\16\162"+
    "\4\0\1\162\1\0\1\162\12\0\2\162\1\201\25\162"+
    "\4\0\1\162\1\0\1\162\12\0\1\162\1\202\2\162"+
    "\1\203\23\162\4\0\1\162\1\0\1\162\12\0\11\162"+
    "\1\204\16\162\4\0\1\162\1\0\1\162\12\0\20\162"+
    "\1\205\7\162\4\0\1\162\1\0\1\162\12\0\4\162"+
    "\1\206\23\162\4\0\1\162\1\0\1\162\12\0\2\162"+
    "\1\207\25\162\4\0\1\162\1\0\1\162\12\0\2\162"+
    "\1\210\5\162\1\211\17\162\4\0\1\162\1\0\1\162"+
    "\12\0\2\162\1\212\25\162\4\0\1\162\1\0\1\162"+
    "\12\0\2\162\1\213\25\162\4\0\1\162\1\0\1\162"+
    "\12\0\15\162\1\214\12\162\4\0\1\162\1\0\1\162"+
    "\12\0\3\162\1\215\24\162\4\0\1\162\1\0\1\162"+
    "\12\0\12\162\1\216\15\162\4\0\1\162\1\0\1\162"+
    "\12\0\1\217\27\162\4\0\1\162\1\0\1\162\12\0"+
    "\15\162\1\220\12\162\4\0\1\162\1\0\1\162\12\0"+
    "\20\162\1\221\7\162\4\0\1\162\1\0\1\162\12\0"+
    "\2\162\1\222\25\162\4\0\1\162\1\0\1\162\12\0"+
    "\1\162\1\223\26\162\4\0\1\162\1\0\1\162\12\0"+
    "\17\162\1\224\10\162\4\0\1\225\1\0\1\225\12\0"+
    "\30\225\4\0\1\225\1\0\1\225\12\0\4\225\1\226"+
    "\23\225\4\0\1\225\1\0\1\225\12\0\4\225\1\227"+
    "\23\225\4\0\1\225\1\0\1\225\12\0\4\225\1\230"+
    "\23\225\4\0\1\225\1\0\1\225\12\0\1\225\1\231"+
    "\26\225\4\0\1\225\1\0\1\225\12\0\1\225\1\232"+
    "\26\225\4\0\1\225\1\0\1\225\12\0\3\225\1\233"+
    "\24\225\4\0\1\225\1\0\1\225\12\0\2\225\1\234"+
    "\25\225\4\0\1\225\1\0\1\225\12\0\20\225\1\235"+
    "\7\225\4\0\1\225\1\0\1\225\12\0\4\225\1\236"+
    "\23\225\4\0\1\225\1\0\1\225\12\0\4\225\1\237"+
    "\23\225\4\0\1\225\1\0\1\225\12\0\6\225\1\240"+
    "\21\225\4\0\1\225\1\0\1\225\12\0\12\225\1\241"+
    "\15\225\4\0\1\225\1\0\1\225\12\0\1\242\27\225"+
    "\4\0\1\225\1\0\1\225\12\0\4\225\1\243\23\225"+
    "\4\0\1\225\1\0\1\225\12\0\15\225\1\244\12\225"+
    "\4\0\1\225\1\0\1\225\12\0\3\225\1\245\24\225"+
    "\4\0\1\225\1\0\1\225\12\0\14\225\1\246\13\225"+
    "\4\0\1\225\1\0\1\225\12\0\25\225\1\247\2\225"+
    "\4\0\1\225\1\0\1\225\12\0\1\225\1\250\26\225"+
    "\4\0\1\225\1\0\1\225\12\0\11\225\1\251\16\225"+
    "\4\0\1\225\1\0\1\225\12\0\4\225\1\252\23\225"+
    "\4\0\1\225\1\0\1\225\12\0\21\225\1\253\6\225"+
    "\4\0\1\225\1\0\1\225\12\0\2\225\1\254\25\225"+
    "\4\0\1\225\1\0\1\225\12\0\13\225\1\255\14\225"+
    "\4\0\1\225\1\0\1\225\12\0\2\225\1\256\25\225"+
    "\4\0\1\257\1\0\1\257\12\0\30\257\4\0\1\257"+
    "\1\0\1\257\12\0\2\257\1\260\25\257\4\0\1\257"+
    "\1\0\1\257\12\0\1\257\1\261\26\257\4\0\1\257"+
    "\1\0\1\257\12\0\2\257\1\262\25\257\4\0\1\257"+
    "\1\0\1\257\12\0\14\257\1\263\13\257\4\0\1\257"+
    "\1\0\1\257\12\0\3\257\1\264\24\257\4\0\1\257"+
    "\1\0\1\257\12\0\2\257\1\265\25\257\4\0\1\257"+
    "\1\0\1\257\12\0\13\257\1\266\14\257\4\0\1\257"+
    "\1\0\1\257\12\0\3\257\1\267\24\257\4\0\1\257"+
    "\1\0\1\257\12\0\3\257\1\270\24\257\4\0\1\257"+
    "\1\0\1\257\12\0\4\257\1\271\23\257\4\0\1\257"+
    "\1\0\1\257\12\0\7\257\1\272\20\257\4\0\1\257"+
    "\1\0\1\257\12\0\1\257\1\273\26\257\4\0\1\257"+
    "\1\0\1\257\12\0\2\257\1\274\25\257\4\0\1\257"+
    "\1\0\1\257\12\0\4\257\1\275\23\257\4\0\1\257"+
    "\1\0\1\257\12\0\2\257\1\276\25\257\4\0\1\257"+
    "\1\0\1\257\12\0\3\257\1\277\24\257\4\0\1\257"+
    "\1\0\1\257\12\0\7\257\1\300\20\257\4\0\1\257"+
    "\1\0\1\257\12\0\14\257\1\301\13\257\4\0\1\302"+
    "\1\0\1\302\12\0\30\302\4\0\1\302\1\0\1\302"+
    "\12\0\3\302\1\303\24\302\4\0\1\302\1\0\1\302"+
    "\12\0\17\302\1\304\10\302\4\0\1\302\1\0\1\302"+
    "\12\0\2\302\1\305\25\302\4\0\1\302\1\0\1\302"+
    "\12\0\12\302\1\306\15\302\4\0\1\302\1\0\1\302"+
    "\12\0\20\302\1\307\7\302\4\0\1\302\1\0\1\302"+
    "\12\0\7\302\1\310\20\302\4\0\1\302\1\0\1\302"+
    "\12\0\16\302\1\311\11\302\4\0\1\302\1\0\1\302"+
    "\12\0\16\302\1\312\11\302\4\0\1\302\1\0\1\302"+
    "\12\0\1\302\1\313\26\302\4\0\1\302\1\0\1\302"+
    "\12\0\1\302\1\314\26\302\4\0\1\302\1\0\1\302"+
    "\12\0\17\302\1\315\10\302\4\0\1\316\1\0\1\316"+
    "\12\0\30\316\4\0\1\316\1\0\1\316\12\0\13\316"+
    "\1\317\14\316\4\0\1\316\1\0\1\316\12\0\1\320"+
    "\27\316\4\0\1\316\1\0\1\316\12\0\2\316\1\321"+
    "\25\316\4\0\1\316\1\0\1\316\12\0\2\316\1\322"+
    "\25\316\4\0\1\323\1\0\1\323\12\0\30\323\4\0"+
    "\1\323\1\0\1\323\12\0\17\323\1\324\10\323\4\0"+
    "\1\323\1\0\1\323\12\0\2\323\1\325\25\323\4\0"+
    "\1\323\1\0\1\323\12\0\7\323\1\326\20\323\4\0"+
    "\1\327\1\0\1\327\12\0\30\327\4\0\1\327\1\0"+
    "\1\327\12\0\4\327\1\330\23\327\4\0\1\327\1\0"+
    "\1\327\12\0\7\327\1\331\20\327\4\0\1\332\1\0"+
    "\1\332\12\0\30\332\4\0\1\333\1\0\1\333\12\0"+
    "\30\333\4\0\1\334\1\0\1\334\12\0\30\334\4\0"+
    "\1\335\1\0\1\335\12\0\30\335\4\0\1\336\1\0"+
    "\1\336\12\0\30\336\4\0\1\337\1\0\1\337\12\0"+
    "\30\337\4\0\1\340\1\0\1\340\12\0\30\340\4\0"+
    "\1\341\1\0\1\341\12\0\30\341\4\0\1\342\1\0"+
    "\1\342\12\0\30\342\4\0\1\343\1\0\1\343\12\0"+
    "\30\343\4\0\1\344\1\0\1\344\12\0\30\344\4\0"+
    "\1\345\1\0\1\345\12\0\30\345\4\0\1\346\1\0"+
    "\1\346\12\0\30\346\4\0\1\347\1\0\1\347\12\0"+
    "\30\347\4\0\1\350\1\0\1\350\12\0\30\350\4\0"+
    "\1\351\1\0\1\351\12\0\30\351\4\0\1\352\1\0"+
    "\1\352\12\0\30\352\4\0\1\353\1\0\1\353\12\0"+
    "\30\353\4\0\1\354\1\0\1\354\12\0\30\354\4\0"+
    "\1\355\1\0\1\355\12\0\30\355\4\0\1\356\1\0"+
    "\1\356\12\0\30\356\4\0\1\357\1\0\1\357\12\0"+
    "\30\357";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7462];
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
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\3\1\10\11\24\1\1\11"+
    "\1\1\1\0\43\1\1\11\243\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[239];
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
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AnalizadorLexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 110) {
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
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
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
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
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
          yycolumn++;
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


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 42: 
          { return new Symbol(sym.CREATE, new token(yycolumn, yyline, yytext()));
          }
        case 61: break;
        case 6: 
          { return new Symbol(sym.MAYOR, new token(yycolumn, yyline, yytext()));
          }
        case 62: break;
        case 33: 
          { return new Symbol(sym.FROM, new token(yycolumn, yyline, yytext()));
          }
        case 63: break;
        case 15: 
          { return new Symbol(sym.BY, new token(yycolumn, yyline, yytext()));
          }
        case 64: break;
        case 52: 
          { return new Symbol(sym.PRIMARY, new token(yycolumn, yyline, yytext()));
          }
        case 65: break;
        case 31: 
          { return new Symbol(sym.INTO, new token(yycolumn, yyline, yytext()));
          }
        case 66: break;
        case 22: 
          { return new Symbol(sym.NOT, new token(yycolumn, yyline, yytext()));
          }
        case 67: break;
        case 59: 
          { return new Symbol(sym.CONSTRAINT, new token(yycolumn, yyline, yytext()));
          }
        case 68: break;
        case 19: 
          { return new Symbol(sym.ADD, new token(yycolumn, yyline, yytext()));
          }
        case 69: break;
        case 26: 
          { return new Symbol(sym.CHAR, new token(yycolumn, yyline, yytext()));
          }
        case 70: break;
        case 60: 
          { return new Symbol(sym.REFERENCES, new token(yycolumn, yyline, yytext()));
          }
        case 71: break;
        case 43: 
          { return new Symbol(sym.DELETE, new token(yycolumn, yyline, yytext()));
          }
        case 72: break;
        case 54: 
          { return new Symbol(sym.VARCHAR, new token(yycolumn, yyline, yytext()));
          }
        case 73: break;
        case 49: 
          { return new Symbol(sym.AVERAGE, new token(yycolumn, yyline, yytext()));
          }
        case 74: break;
        case 1: 
          { System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");
          }
        case 75: break;
        case 47: 
          { return new Symbol(sym.UPDATE, new token(yycolumn, yyline, yytext()));
          }
        case 76: break;
        case 46: 
          { return new Symbol(sym.INSERT, new token(yycolumn, yyline, yytext()));
          }
        case 77: break;
        case 9: 
          { return new Symbol(sym.ABRIRPAR, new token(yycolumn, yyline, yytext()));
          }
        case 78: break;
        case 3: 
          { /* ignorar */
          }
        case 79: break;
        case 2: 
          { return new Symbol(sym.NEWLINE, new token(yycolumn, yyline, yytext()));
          }
        case 80: break;
        case 57: 
          { return new Symbol(sym.DATABASE, new token(yycolumn, yyline, yytext()));
          }
        case 81: break;
        case 51: 
          { return new Symbol(sym.DISPLAY, new token(yycolumn, yyline, yytext()));
          }
        case 82: break;
        case 40: 
          { return new Symbol(sym.GROUP, new token(yycolumn, yyline, yytext()));
          }
        case 83: break;
        case 5: 
          { return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));
          }
        case 84: break;
        case 13: 
          { return new Symbol(sym.ASTERISCO, new token(yycolumn, yyline, yytext()));
          }
        case 85: break;
        case 24: 
          { return new Symbol(sym.MIN, new token(yycolumn, yyline, yytext()));
          }
        case 86: break;
        case 50: 
          { return new Symbol(sym.DECIMAL, new token(yycolumn, yyline, yytext()));
          }
        case 87: break;
        case 30: 
          { return new Symbol(sym.LIKE, new token(yycolumn, yyline, yytext()));
          }
        case 88: break;
        case 55: 
          { return new Symbol(sym.FOREIGN, new token(yycolumn, yyline, yytext()));
          }
        case 89: break;
        case 28: 
          { return new Symbol(sym.STOP, new token(yycolumn, yyline, yytext()));
          }
        case 90: break;
        case 4: 
          { return new Symbol(sym.NUM, new token(yycolumn, yyline, yytext()));
          }
        case 91: break;
        case 39: 
          { return new Symbol(sym.INDEX, new token(yycolumn, yyline, yytext()));
          }
        case 92: break;
        case 44: 
          { return new Symbol(sym.SELECT, new token(yycolumn, yyline, yytext()));
          }
        case 93: break;
        case 35: 
          { return new Symbol(sym.COUNT, new token(yycolumn, yyline, yytext()));
          }
        case 94: break;
        case 23: 
          { return new Symbol(sym.MAX, new token(yycolumn, yyline, yytext()));
          }
        case 95: break;
        case 21: 
          { return new Symbol(sym.GET, new token(yycolumn, yyline, yytext()));
          }
        case 96: break;
        case 8: 
          { return new Symbol(sym.IGUAL, new token(yycolumn, yyline, yytext()));
          }
        case 97: break;
        case 38: 
          { return new Symbol(sym.START, new token(yycolumn, yyline, yytext()));
          }
        case 98: break;
        case 14: 
          { return new Symbol(sym.AS, new token(yycolumn, yyline, yytext()));
          }
        case 99: break;
        case 16: 
          { return new Symbol(sym.ON, new token(yycolumn, yyline, yytext()));
          }
        case 100: break;
        case 48: 
          { return new Symbol(sym.VALUES, new token(yycolumn, yyline, yytext()));
          }
        case 101: break;
        case 17: 
          { return new Symbol(sym.IS, new token(yycolumn, yyline, yytext()));
          }
        case 102: break;
        case 41: 
          { return new Symbol(sym.WHERE, new token(yycolumn, yyline, yytext()));
          }
        case 103: break;
        case 45: 
          { return new Symbol(sym.STATUS, new token(yycolumn, yyline, yytext()));
          }
        case 104: break;
        case 12: 
          { return new Symbol(sym.PUNTOCOMA, new token(yycolumn, yyline, yytext()));
          }
        case 105: break;
        case 32: 
          { return new Symbol(sym.NULL, new token(yycolumn, yyline, yytext()));
          }
        case 106: break;
        case 18: 
          { return new Symbol(sym.PALABRA, new token(yycolumn, yyline, yytext()));
          }
        case 107: break;
        case 7: 
          { return new Symbol(sym.MENOR, new token(yycolumn, yyline, yytext()));
          }
        case 108: break;
        case 53: 
          { return new Symbol(sym.INTEGER, new token(yycolumn, yyline, yytext()));
          }
        case 109: break;
        case 29: 
          { return new Symbol(sym.LIST, new token(yycolumn, yyline, yytext()));
          }
        case 110: break;
        case 34: 
          { return new Symbol(sym.JOIN, new token(yycolumn, yyline, yytext()));
          }
        case 111: break;
        case 11: 
          { return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));
          }
        case 112: break;
        case 25: 
          { return new Symbol(sym.KEY, new token(yycolumn, yyline, yytext()));
          }
        case 113: break;
        case 56: 
          { return new Symbol(sym.DATETIME, new token(yycolumn, yyline, yytext()));
          }
        case 114: break;
        case 36: 
          { return new Symbol(sym.ALTER, new token(yycolumn, yyline, yytext()));
          }
        case 115: break;
        case 27: 
          { return new Symbol(sym.DROP, new token(yycolumn, yyline, yytext()));
          }
        case 116: break;
        case 20: 
          { return new Symbol(sym.SET, new token(yycolumn, yyline, yytext()));
          }
        case 117: break;
        case 58: 
          { return new Symbol(sym.DATABASES, new token(yycolumn, yyline, yytext()));
          }
        case 118: break;
        case 37: 
          { return new Symbol(sym.TABLE, new token(yycolumn, yyline, yytext()));
          }
        case 119: break;
        case 10: 
          { return new Symbol(sym.CERRARPAR, new token(yycolumn, yyline, yytext()));
          }
        case 120: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
