package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class SymbolsStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    assertTrue(symbols.shortPress[0].equals("space . , ?"));
    assertTrue(symbols.shortPress[1].equals("- ! @ _ / ( ) & : ;"));
    assertTrue(symbols.shortPress[2].equals("$ ` < > ^ ~ [ ] { }"));
    assertTrue(symbols.shortPress[3].equals("\" + % = # * \\ | '"));

    assertTrue(symbols.longPress[0].equals("Back"));
    assertTrue(symbols.longPress[1].equals(":-)"));
    assertTrue(symbols.longPress[2].equals("UNUSED"));
    assertTrue(symbols.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: constructor
   */
  public final static void testConstructor2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    assertTrue(symbols.shortPress[0].equals("space . , ? - ! @ _ /"));
    assertTrue(symbols.shortPress[1].equals("( ) & : ; $ ` < >"));
    assertTrue(symbols.shortPress[2].equals("^ ~ [ ] { } \" + %"));
    assertTrue(symbols.shortPress[3].equals("= # * \\ | '"));

    assertTrue(symbols.longPress[0].equals("Back"));
    assertTrue(symbols.longPress[1].equals(":-)"));
    assertTrue(symbols.longPress[2].equals("UNUSED"));
    assertTrue(symbols.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onShort1Press();

    assertTrue(s.shortPress[0].equals("space"));
    assertTrue(s.shortPress[1].equals("."));
    assertTrue(s.shortPress[2].equals(","));
    assertTrue(s.shortPress[3].equals("?"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onShort1Press();

    assertTrue(s.shortPress[0].equals("space . ,"));
    assertTrue(s.shortPress[1].equals("? - !"));
    assertTrue(s.shortPress[2].equals("@ _ /"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onShort2Press();

    assertTrue(s.shortPress[0].equals("- ! @"));
    assertTrue(s.shortPress[1].equals("_ / ("));
    assertTrue(s.shortPress[2].equals(") & :"));
    assertTrue(s.shortPress[3].equals(";"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onShort2Press();

    assertTrue(s.shortPress[0].equals("( ) &"));
    assertTrue(s.shortPress[1].equals(": ; $"));
    assertTrue(s.shortPress[2].equals("` < >"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort3Press
   */
  public final static void testOnShort3Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onShort3Press();

    assertTrue(s.shortPress[0].equals("$ ` <"));
    assertTrue(s.shortPress[1].equals("> ^ ~"));
    assertTrue(s.shortPress[2].equals("[ ] {"));
    assertTrue(s.shortPress[3].equals("}"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort3Press
   */
  public final static void testOnShort3Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onShort3Press();

    assertTrue(s.shortPress[0].equals("^ ~ ["));
    assertTrue(s.shortPress[1].equals("] { }"));
    assertTrue(s.shortPress[2].equals("\" + %"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onShort4Press();

    assertTrue(s.shortPress[0].equals("\" + %"));
    assertTrue(s.shortPress[1].equals("= # *"));
    assertTrue(s.shortPress[2].equals("\\ | '"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onShort4Press();

    assertTrue(s.shortPress[0].equals("= #"));
    assertTrue(s.shortPress[1].equals("* \\"));
    assertTrue(s.shortPress[2].equals("| '"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onLong1Press
   */
  public final static void testOnLong1Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onLong1Press();

    assertTrue(s.shortPress[0].equals("Letters"));
    assertTrue(s.shortPress[1].equals("Numbers"));
    assertTrue(s.shortPress[2].equals("Symbols"));
    assertTrue(s.shortPress[3].equals("Operations"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("Done"));
    assertTrue(s.longPress[2].equals("<--"));
    assertTrue(s.longPress[3].equals("-->"));
  }

  /**
   * Test: onLong1Press
   */
  public final static void testOnLong1Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onLong1Press();

    assertTrue(s.shortPress[0].equals("Letters"));
    assertTrue(s.shortPress[1].equals("Numbers"));
    assertTrue(s.shortPress[2].equals("Symbols"));
    assertTrue(s.shortPress[3].equals("Operations"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("Done"));
    assertTrue(s.longPress[2].equals("<--"));
    assertTrue(s.longPress[3].equals("-->"));
  }

  /**
   * Test: onLong2Press
   */
  public final static void testOnLong2Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onLong2Press();

    assertTrue(s.shortPress[0].equals(":) :("));
    assertTrue(s.shortPress[1].equals(";) :D"));
    assertTrue(s.shortPress[2].equals(":p :-)"));
    assertTrue(s.shortPress[3].equals(":-( :|"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onLong2Press
   */
  public final static void testOnLong2Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onLong2Press();

    assertTrue(s.shortPress[0].equals(":) :("));
    assertTrue(s.shortPress[1].equals(";) :D"));
    assertTrue(s.shortPress[2].equals(":p :-)"));
    assertTrue(s.shortPress[3].equals(":-( :|"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onLong3Press();

    assertTrue(s == symbols);
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onLong3Press();

    assertTrue(s == symbols);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press1() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        true);

    final State s = symbols.onLong4Press();

    assertTrue(s == symbols);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press2() {
    final Controller c = new Controller();
    final SymbolsState symbols = new SymbolsState(c, KeyboardState.symbols,
        false);

    final State s = symbols.onLong4Press();

    assertTrue(s == symbols);
  }
}
