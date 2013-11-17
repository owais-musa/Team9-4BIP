package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class LettersStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    assertTrue(l.shortPress[0].equals("a b c d e f g"));
    assertTrue(l.shortPress[1].equals("h i j k l m n"));
    assertTrue(l.shortPress[2].equals("o p q r s t u"));
    assertTrue(l.shortPress[3].equals("v w x y z"));

    assertTrue(l.longPress[0].equals("Back"));
    assertTrue(l.longPress[1].equals("UNUSED"));
    assertTrue(l.longPress[2].equals("Lang"));
    assertTrue(l.longPress[3].equals("A"));
  }

  /**
   * Test: constructor
   */
  public final static void testConstructor2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    assertTrue(l.shortPress[0].equals("A B C D E F G"));
    assertTrue(l.shortPress[1].equals("H I J K L M N"));
    assertTrue(l.shortPress[2].equals("O P Q R S T U"));
    assertTrue(l.shortPress[3].equals("V W X Y Z"));

    assertTrue(l.longPress[0].equals("Back"));
    assertTrue(l.longPress[1].equals("UNUSED"));
    assertTrue(l.longPress[2].equals("Lang"));
    assertTrue(l.longPress[3].equals("a"));

  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onShort1Press();

    assertTrue(s.shortPress[0].equals("a b"));
    assertTrue(s.shortPress[1].equals("c d"));
    assertTrue(s.shortPress[2].equals("e f"));
    assertTrue(s.shortPress[3].equals("g"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("A"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onShort1Press();

    assertTrue(s.shortPress[0].equals("A B"));
    assertTrue(s.shortPress[1].equals("C D"));
    assertTrue(s.shortPress[2].equals("E F"));
    assertTrue(s.shortPress[3].equals("G"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("a"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onShort2Press();

    assertTrue(s.shortPress[0].equals("h i"));
    assertTrue(s.shortPress[1].equals("j k"));
    assertTrue(s.shortPress[2].equals("l m"));
    assertTrue(s.shortPress[3].equals("n"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("A"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onShort2Press();

    assertTrue(s.shortPress[0].equals("H I"));
    assertTrue(s.shortPress[1].equals("J K"));
    assertTrue(s.shortPress[2].equals("L M"));
    assertTrue(s.shortPress[3].equals("N"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("a"));
  }

  /**
   * Test: onShort3Press
   */
  public final static void testOnShort3Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onShort3Press();

    assertTrue(s.shortPress[0].equals("o p"));
    assertTrue(s.shortPress[1].equals("q r"));
    assertTrue(s.shortPress[2].equals("s t"));
    assertTrue(s.shortPress[3].equals("u"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("A"));
  }

  /**
   * Test: onShort3Press
   */
  public final static void testOnShort3Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onShort3Press();

    assertTrue(s.shortPress[0].equals("O P"));
    assertTrue(s.shortPress[1].equals("Q R"));
    assertTrue(s.shortPress[2].equals("S T"));
    assertTrue(s.shortPress[3].equals("U"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("a"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onShort4Press();

    assertTrue(s.shortPress[0].equals("v w"));
    assertTrue(s.shortPress[1].equals("x y"));
    assertTrue(s.shortPress[2].equals("z"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("A"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onShort4Press();

    assertTrue(s.shortPress[0].equals("V W"));
    assertTrue(s.shortPress[1].equals("X Y"));
    assertTrue(s.shortPress[2].equals("Z"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("a"));
  }

  /**
   * Test: onLong1Press
   */
  public final static void testOnLong1Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onLong1Press();

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
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onLong1Press();

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
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onLong2Press();

    assertTrue(l == s);

  }

  /**
   * Test: onLong2Press
   */
  public final static void testOnLong2Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onLong2Press();

    assertTrue(l == s);
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onLong3Press();

    assertTrue(l == s);

  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onLong3Press();

    assertTrue(l == s);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press1() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, true);

    final State s = l.onLong4Press();

    assertTrue(s.shortPress[0].equals("A B C D E F G"));
    assertTrue(s.shortPress[1].equals("H I J K L M N"));
    assertTrue(s.shortPress[2].equals("O P Q R S T U"));
    assertTrue(s.shortPress[3].equals("V W X Y Z"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("a"));
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press2() {
    final Controller c = new Controller();
    final LettersState l = new LettersState(c, KeyboardState.abc, false);

    final State s = l.onLong4Press();

    assertTrue(s.shortPress[0].equals("a b c d e f g"));
    assertTrue(s.shortPress[1].equals("h i j k l m n"));
    assertTrue(s.shortPress[2].equals("o p q r s t u"));
    assertTrue(s.shortPress[3].equals("v w x y z"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("A"));
  }
}
