/* Generated By:JavaCC: Do not edit this line. JavaCC.java */
package JavaCC;

import java.io.File;
import java.io.FileReader;

import me.FJEY.AST.AST;
import me.FJEY.AST.BinaryOpNode;
import me.FJEY.AST.IntegerLiteralNode;
import me.FJEY.AST.IntegerRandomNode;
import me.FJEY.AST.LiteralNode;
import me.FJEY.AST.Node;
import me.FJEY.AST.VariableNode;
import me.FJEY.Manager.VariableManager;

public class JavaCC implements JavaCCConstants {
  public static void parse(File f) {
        try {
                JavaCC parser = new JavaCC(new FileReader(f));
                parser.compliation_unit();
}catch(Exception e) { System.out.println("Error: " + e.getMessage()); e.printStackTrace();};
  }

  final public void compliation_unit() throws ParseException {
Node x = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BLOCK_IN:
      case IDENTIFIER:
      case CONSTANT:
      case STR:
      case 29:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      x = stmts();
             AST.push(x);
    }
    jj_consume_token(0);
  }

  final public Node stmts() throws ParseException {
        Node n;
        Token x;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      jj_consume_token(29);
        {if (true) return new LiteralNode("String","\u005cn");}
      break;
    default:
      jj_la1[1] = jj_gen;
      if (jj_2_1(2)) {
        n = expr2();
              {if (true) return n;}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BLOCK_IN:
        case IDENTIFIER:
        case CONSTANT:
        case STR:
          n = simplestmts();
                    {if (true) return n;}
          break;
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node simplestmts() throws ParseException {
        Token x;
        Node n;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANT:
      x = jj_consume_token(CONSTANT);
              {if (true) return new LiteralNode("Integer", Integer.parseInt(x.image));}
      break;
    case STR:
      x = jj_consume_token(STR);
            {if (true) return new LiteralNode("String", x.image);}
      break;
    case IDENTIFIER:
      n = var_identifier();
                       {if (true) return n;}
      break;
    case BLOCK_IN:
      jj_consume_token(BLOCK_IN);
      n = stmt();
      jj_consume_token(BlOCK_OUT);
                    {if (true) return n;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node stmt() throws ParseException {
        Node x;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
    case STRING:
      x = literal_stmt();
                           {if (true) return x;}
      break;
    case VAR:
      x = var_stmt();
                   {if (true) return x;}
      break;
    case 29:
      jj_consume_token(29);
           {if (true) return new LiteralNode("String", "\u005cn");}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public LiteralNode literal_stmt() throws ParseException {
                             LiteralNode x,y;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      x = string_stmt();
                          {if (true) return x;}
      break;
    case INTEGER:
      y = int_stmt();
                      {if (true) return y;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public LiteralNode string_stmt() throws ParseException {
                             Token x;
    jj_consume_token(STRING);
    jj_consume_token(30);
    x = jj_consume_token(STR);
                                  {if (true) return new LiteralNode("String", x.image);}
    throw new Error("Missing return statement in function");
  }

  final public LiteralNode int_stmt() throws ParseException {
        Node x=null,y=null;
        Token t;
    if (jj_2_2(2)) {
      jj_consume_token(INTEGER);
      jj_consume_token(31);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 32:
        jj_consume_token(32);
        x = stmts();
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 33:
        jj_consume_token(33);
        y = stmts();
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
                if(x != null && y != null) {
                  int xi = x.getValue() instanceof Integer ? (int)x.getValue() : Integer.parseInt((String)x.getValue());
                int yi = y.getValue() instanceof Integer ? (int)y.getValue() : Integer.parseInt((String)y.getValue());

                        {if (true) return new IntegerRandomNode(yi,xi);}

        }
        if(x == null && y == null) { {if (true) return new IntegerRandomNode();} }
        if(x == null) {
                int yi = y.getValue() instanceof Integer ? (int)y.getValue() : Integer.parseInt((String)y.getValue());
                 {if (true) return new IntegerRandomNode(yi,0);} }
        if(y == null) { int xi = x.getValue() instanceof Integer ? (int)x.getValue() : Integer.parseInt((String)x.getValue());

                {if (true) return new IntegerRandomNode(Integer.MAX_VALUE,xi);} }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
        jj_consume_token(INTEGER);
        jj_consume_token(30);
        t = jj_consume_token(CONSTANT);
                                  {if (true) return new IntegerLiteralNode(Integer.parseInt(t.image));}
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public VariableNode var_identifier() throws ParseException {
        Token t;
    t = jj_consume_token(IDENTIFIER);
                           if(VariableManager.isDeclared(t.image)) {
        {if (true) return VariableManager.getVar(t.image);}
        }else {
        {if (true) throw new ParseException("Variable " + t +" is not declared.");}
        }
    throw new Error("Missing return statement in function");
  }

  final public VariableNode var_stmt() throws ParseException {
  Token x=null;
  Token y=null;
  Node n=null;
    jj_consume_token(VAR);
    x = jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 34:
      jj_consume_token(34);
      n = stmts();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
                                                 VariableNode v = new VariableNode(x.image,n.getType(), n); VariableManager.declareVar(v); {if (true) return v;}
    throw new Error("Missing return statement in function");
  }

  final public Node expr2() throws ParseException {
        Node l,r;
    l = expr1();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        r = expr1();
                                   l = new BinaryOpNode(l,r,"+");
        break;
      case MINUS:
        jj_consume_token(MINUS);
        r = expr1();
                                         l = new BinaryOpNode(l,r,"-");
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
                          {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  final public Node expr1() throws ParseException {
        Node l,r;
    l = simplestmts();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
      case DIVIDE:
      case 35:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        jj_consume_token(MULTIPLY);
        r = simplestmts();
                                                l = new BinaryOpNode(l,r,"*");
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        r = simplestmts();
                                                                l = new BinaryOpNode(l,r,"/");
        break;
      case 35:
        jj_consume_token(35);
        r = simplestmts();
                                                                l = new BinaryOpNode(l,r,"%");
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
                                             {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3R_20() {
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_scan_token(29)) return true;
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_scan_token(INTEGER)) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  private boolean jj_3R_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) return true;
    }
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_3R_7()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_8()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(BLOCK_IN)) return true;
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(STR)) return true;
    return false;
  }

  private boolean jj_3R_7() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_scan_token(CONSTANT)) return true;
    return false;
  }

  private boolean jj_3R_4() {
    if (jj_3R_5()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_6()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_scan_token(35)) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(DIVIDE)) return true;
    return false;
  }

  private boolean jj_3R_28() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(INTEGER)) return true;
    if (jj_scan_token(31)) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(STRING)) return true;
    return false;
  }

  private boolean jj_3R_24() {
    if (jj_scan_token(VAR)) return true;
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_3R_28()) return true;
    return false;
  }

  private boolean jj_3R_25() {
    if (jj_3R_27()) return true;
    return false;
  }

  private boolean jj_3R_23() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) return true;
    }
    return false;
  }

  private boolean jj_3R_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(MULTIPLY)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public JavaCCTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x21060100,0x20000000,0x1060100,0x1060100,0x20010c00,0xc00,0x0,0x0,0x400,0x0,0x30,0x30,0xc0,0xc0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x2,0x0,0x4,0x0,0x0,0x8,0x8,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public JavaCC(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JavaCC(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JavaCCTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public JavaCC(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JavaCCTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public JavaCC(JavaCCTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(JavaCCTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[36];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 36; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
