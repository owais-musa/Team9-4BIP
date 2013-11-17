package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class KeyboardStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    assertTrue(kb.shortPress[0].equals("Letters"));
    assertTrue(kb.shortPress[1].equals("Numbers"));
    assertTrue(kb.shortPress[2].equals("Symbols"));
    assertTrue(kb.shortPress[3].equals("Operations"));

    assertTrue(kb.longPress[0].equals("Back"));
    assertTrue(kb.longPress[1].equals("Done"));
    assertTrue(kb.longPress[2].equals("<--"));
    assertTrue(kb.longPress[3].equals("-->"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onShort1Press();

    assertTrue(s.shortPress[0].equals("a b c d e f g"));
    assertTrue(s.shortPress[1].equals("h i j k l m n"));
    assertTrue(s.shortPress[2].equals("o p q r s t u"));
    assertTrue(s.shortPress[3].equals("v w x y z"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("A"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onShort2Press();

    assertTrue(s.shortPress[0].equals("0 1 2"));
    assertTrue(s.shortPress[1].equals("3 4 5"));
    assertTrue(s.shortPress[2].equals("6 7 8"));
    assertTrue(s.shortPress[3].equals("9"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort3Press
   */
  public final static void testOnShort3Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onShort3Press();

    assertTrue(s.shortPress[0].equals("space . , ?"));
    assertTrue(s.shortPress[1].equals("- ! @ _ / ( ) & : ;"));
    assertTrue(s.shortPress[2].equals("$ ` < > ^ ~ [ ] { }"));
    assertTrue(s.shortPress[3].equals("\" + % = # * \\ | '"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals(":-)"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onShort4Press();

    assertTrue(s.shortPress[0].equals("Delete"));
    assertTrue(s.shortPress[1].equals("Delete All"));
    assertTrue(s.shortPress[2].equals("New Line"));
    assertTrue(s.shortPress[3].equals("Undo"));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onLong1Press
   */
  public final static void testOnLong1Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onLong1Press();

    assertTrue(s.shortPress[0].equals("Keyboard"));
    assertTrue(s.shortPress[1].equals("Protocol"));
    assertTrue(s.shortPress[2].equals("Recipient"));
    assertTrue(s.shortPress[3].equals("Settings"));

    assertTrue(s.longPress[0].equals("Exit"));
    assertTrue(s.longPress[1].equals("Send"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onLong2Press
   */
  public final static void testOnLong2Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onLong2Press();

    assertTrue(s.shortPress[0].equals("Keyboard"));
    assertTrue(s.shortPress[1].equals("Protocol"));
    assertTrue(s.shortPress[2].equals("Recipient"));
    assertTrue(s.shortPress[3].equals("Settings"));

    assertTrue(s.longPress[0].equals("Exit"));
    assertTrue(s.longPress[1].equals("Send"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onLong3Press();

    assertTrue(s == kb);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press() {
    final Controller c = new Controller();
    final KeyboardState kb = new KeyboardState(c);

    final State s = kb.onLong4Press();

    assertTrue(s == kb);
  }
}
