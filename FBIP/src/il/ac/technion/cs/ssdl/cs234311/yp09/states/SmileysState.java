package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 9/11/2013
 * 
 */
public final class SmileysState extends State {

  /**
   * @param c
   *          an object mediating between the model and the view.
   * @param smileys
   *          different faces.
   */
  public SmileysState(final Controller c, final String[] smileys) {
    super(c);
    for (int i = 0; i < 4; i++)
      shortPress[i] = Parser.findContent(smileys, 0, smileys.length - 1, i, 4);

    longPress[0] = "Back";
    longPress[1] = "UNUSED";
    longPress[2] = "UNUSED";
    longPress[3] = "UNUSED";
  }

  @Override
  public final State onShort1Press() {
    return calculateNextStateWhenShortPressed(1);
  }

  @Override
  public final State onShort2Press() {
    return calculateNextStateWhenShortPressed(2);
  }

  @Override
  public final State onShort3Press() {
    return calculateNextStateWhenShortPressed(3);
  }

  @Override
  public final State onShort4Press() {
    return calculateNextStateWhenShortPressed(4);
  }

  /**
   * @param index
   *          the index of the button pressed
   * @return the next state.
   */
  public final State calculateNextStateWhenShortPressed(final int index) {
    if (shortPress[index - 1].equals(""))
      /*
       * In case some of the windows are empty. For example: having 3 numbers to
       * be shown on 4 windows. I solved the issue by remaining in the same
       * state.
       */
      return this;
    if (1 == shortPress[index - 1].split(" ").length) {
      Controller.m_message.insertChars(shortPress[index - 1]);
      return new KeyboardState(mController);
    }
    return new SmileysState(mController, shortPress[index - 1].split(" "));
  }

  // Back
  @Override
  public final State onLong1Press() {
    return new KeyboardState(mController);
  }

  // UNUSED
  @Override
  public final State onLong2Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

  // UNUSED
  @Override
  public final State onLong3Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

  // UNUSED
  @Override
  public final State onLong4Press() {
    // Button is UNUSED in the first iteration
    return this;
  }
}
