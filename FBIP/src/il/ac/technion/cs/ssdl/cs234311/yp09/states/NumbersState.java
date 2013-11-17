package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public final class NumbersState extends State {

  /**
   * @param c
   *          an object mediating between the model and the view.
   * @param numbers
   *          decimal digits from 0 to 9.
   */
  public NumbersState(final Controller c, final String[] numbers) {
    super(c);
    for (int i = 0; i < 4; i++)
      shortPress[i] = Parser.findContent(numbers, 0, numbers.length - 1, i, 4);

    longPress[0] = "Back";
    longPress[1] = "UNUSED";
    longPress[2] = "Lang";
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
      return this;
    if (1 == shortPress[index - 1].length()) {
      Controller.m_message.insertChar(shortPress[index - 1].charAt(0));
      return new KeyboardState(mController);
    }
    return new NumbersState(mController, shortPress[index - 1].split(" "));
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

  // Lang
  @Override
  public final State onLong3Press() {
    /*
     * The format used for numbers in the first iteration is the regular one. We
     * will support more formats in the next iterations.
     */
    return this;
  }

  // UNUSED
  @Override
  public final State onLong4Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

}
