package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 15/11/2013
 * 
 */
public class OperationsStateTest extends TestCase {
  /**
   * Test: constructor
   */
  public final static void testConstructor() {
    final Controller c = new Controller();
    final OperationsState o = new OperationsState(c);

    assertTrue(o.shortPress[0].equals("Delete"));
    assertTrue(o.shortPress[1].equals("Delete All"));
    assertTrue(o.shortPress[2].equals("New Line"));
    assertTrue(o.shortPress[3].equals("Undo"));

    assertTrue(o.longPress[0].equals("Back"));
    assertTrue(o.longPress[1].equals("UNUSED"));
    assertTrue(o.longPress[2].equals("UNUSED"));
    assertTrue(o.longPress[3].equals("UNUSED"));
  }

  /**
   * Test: onShort1Press
   */
  public final static void testOnShort1Press() {
    final Controller c = new Controller();
    final OperationsState o = new OperationsState(c);

    final State s = o.onShort1Press();

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
   * Test: onShort2Press
   */
  public final static void testOnShort2Press() {
    final Controller c = new Controller();
    final OperationsState o = new OperationsState(c);

    final State s = o.onShort2Press();

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
    final OperationsState o = new OperationsState(c);

    final State s = o.onShort3Press();

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
   * Test: onShort4Press
   */
  public final static void testOnShort4Press() {
    final Controller c = new Controller();
    final OperationsState o = new OperationsState(c);

    final State s = o.onShort4Press();

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
    final OperationsState o = new OperationsState(c);

    final State s = o.onLong1Press();

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
    final OperationsState o = new OperationsState(c);

    final State s = o.onLong2Press();

    assertTrue(s == o);
  }

  /**
   * Test: onLong3Press
   */
  public final static void testOnLong3Press() {
    final Controller c = new Controller();
    final OperationsState o = new OperationsState(c);

    final State s = o.onLong3Press();

    assertTrue(s == o);
  }

  /**
   * Test: onLong4Press
   */
  public final static void testOnLong4Press() {
    final Controller c = new Controller();
    final OperationsState o = new OperationsState(c);

    final State s = o.onLong4Press();

    assertTrue(s == o);
  }

}
