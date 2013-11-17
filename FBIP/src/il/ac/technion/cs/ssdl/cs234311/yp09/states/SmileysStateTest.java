package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class SmileysStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    assertTrue(smileys.shortPress[0].equals(":) :("));
    assertTrue(smileys.shortPress[1].equals(";) :D"));
    assertTrue(smileys.shortPress[2].equals(":p :-)"));
    assertTrue(smileys.shortPress[3].equals(":-( :|"));

    assertTrue(smileys.longPress[0].equals("Back"));
    assertTrue(smileys.longPress[1].equals("UNUSED"));
    assertTrue(smileys.longPress[2].equals("UNUSED"));
    assertTrue(smileys.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onShort1Press();

    assertTrue(s.shortPress[0].equals(":)"));
    assertTrue(s.shortPress[1].equals(":("));
    assertTrue(s.shortPress[2].equals(""));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort2Press
   */
  public final static void testOnShort2Press() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onShort2Press();

    assertTrue(s.shortPress[0].equals(";)"));
    assertTrue(s.shortPress[1].equals(":D"));
    assertTrue(s.shortPress[2].equals(""));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort3Press
   */
  public final static void testOnShort3Press() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onShort3Press();

    assertTrue(s.shortPress[0].equals(":p"));
    assertTrue(s.shortPress[1].equals(":-)"));
    assertTrue(s.shortPress[2].equals(""));
    assertTrue(s.shortPress[3].equals(""));

    assertTrue(s.longPress[0].equals("Back"));
    assertTrue(s.longPress[1].equals("UNUSED"));
    assertTrue(s.longPress[2].equals("UNUSED"));
    assertTrue(s.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort4Press
   */
  public final static void testOnShort4Press() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onShort4Press();

    assertTrue(s.shortPress[0].equals(":-("));
    assertTrue(s.shortPress[1].equals(":|"));
    assertTrue(s.shortPress[2].equals(""));
    assertTrue(s.shortPress[3].equals(""));

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
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onLong1Press();

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
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onLong2Press();

    assertTrue(s == smileys);
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onLong3Press();

    assertTrue(s == smileys);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press() {
    final Controller c = new Controller();
    final SmileysState smileys = new SmileysState(c, KeyboardState.smileys);

    final State s = smileys.onLong4Press();

    assertTrue(s == smileys);
  }

}
