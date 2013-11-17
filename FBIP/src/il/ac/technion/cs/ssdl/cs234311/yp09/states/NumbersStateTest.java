package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class NumbersStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    assertTrue(n.shortPress[0].equals("0 1 2"));
    assertTrue(n.shortPress[1].equals("3 4 5"));
    assertTrue(n.shortPress[2].equals("6 7 8"));
    assertTrue(n.shortPress[3].equals("9"));

    assertTrue(n.longPress[0].equals("Back"));
    assertTrue(n.longPress[1].equals("UNUSED"));
    assertTrue(n.longPress[2].equals("Lang"));
    assertTrue(n.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onShort1Press();

    assertTrue(s.shortPress[0].equals("0"));
    assertTrue(s.shortPress[1].equals("1"));
    assertTrue(s.shortPress[2].equals("2"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onShort2Press();

    assertTrue(s.shortPress[0].equals("3"));
    assertTrue(s.shortPress[1].equals("4"));
    assertTrue(s.shortPress[2].equals("5"));
    assertTrue(s.shortPress[3].equals(""));

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
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onShort3Press();

    assertTrue(s.shortPress[0].equals("6"));
    assertTrue(s.shortPress[1].equals("7"));
    assertTrue(s.shortPress[2].equals("8"));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("Lang"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onShort4Press();

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
  public final static void testOnLong1Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onLong1Press();

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
  public final static void testOnLong2Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onLong2Press();

    assertTrue(s == n);
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onLong3Press();

    assertTrue(s == n);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press() {
    final Controller c = new Controller();
    final NumbersState n = new NumbersState(c, KeyboardState.numbers);

    final State s = n.onLong4Press();

    assertTrue(s == n);
  }
}
