package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class MainStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor() {
    final Controller c = new Controller();
    final MainState m = new MainState(c);

    assertTrue(m.shortPress[0].equals("Keyboard"));
    assertTrue(m.shortPress[1].equals("Protocol"));
    assertTrue(m.shortPress[2].equals("Recipient"));
    assertTrue(m.shortPress[3].equals("Settings"));

    assertTrue(m.longPress[0].equals("Exit"));
    assertTrue(m.longPress[1].equals("Send"));
    assertTrue(m.longPress[2].equals("UNUSED"));
    assertTrue(m.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press() {
    final Controller c = new Controller();
    final MainState m = new MainState(c);

    final State s = m.onShort1Press();

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
   * Test: onShort3Press
   */
  public final static void testOnShort3Press() {
    final Controller c = new Controller();
    final MainState m = new MainState(c);

    final State s = m.onShort3Press();

    assertTrue(s == m);
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press() {
    final Controller c = new Controller();
    final MainState m = new MainState(c);

    final State s = m.onShort4Press();

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
    final MainState m = new MainState(c);

    final State s = m.onLong3Press();

    assertTrue(s == m);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press() {
    final Controller c = new Controller();
    final MainState m = new MainState(c);

    final State s = m.onLong4Press();

    assertTrue(s == m);
  }
}
