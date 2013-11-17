package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public abstract class State {

  /**
   * Content of the short pressed operations.
   */
  public final String[] shortPress = new String[4];
  /**
   * Content of the long pressed operations.
   */
  public final String[] longPress = new String[4];
  protected final Controller mController;

  /**
   * @param c
   *          an object mediating between the model and the view.
   */
  public State(final Controller c) {
    mController = c;
  }

  /**
   * @return next state when the short operation #1 is chosen.
   */
  public abstract State onShort1Press();

  /**
   * @return next state when the short operation #2 is chosen.
   */
  public abstract State onShort2Press();

  /**
   * @return next state when the short operation #3 is chosen.
   */
  public abstract State onShort3Press();

  /**
   * @return next state when the short operation #4 is chosen.
   */
  public abstract State onShort4Press();

  /**
   * @return next state when the long operation #1 is chosen.
   */
  public abstract State onLong1Press();

  /**
   * @return next state when the long operation #2 is chosen.
   */
  public abstract State onLong2Press();

  /**
   * @return next state when the long operation #3 is chosen.
   */
  public abstract State onLong3Press();

  /**
   * @return next state when the long operation #4 is chosen.
   */
  public abstract State onLong4Press();
}
