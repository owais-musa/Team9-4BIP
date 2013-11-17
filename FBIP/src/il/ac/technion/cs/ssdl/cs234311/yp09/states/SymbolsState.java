package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public final class SymbolsState extends State {

  /**
   * @param c
   *          an object mediating between the model and the view.
   * @param symbols
   *          commonly used characters.
   * @param levelOne
   *          an indication whether we are dividing the symbols for the first
   *          time. This is used as some symbols are used more than others.
   */
  public SymbolsState(final Controller c, final String[] symbols,
      final boolean levelOne) {
    super(c);
    if (levelOne) {
      shortPress[0] = Parser.findHighPriorityContent(symbols, 0, 3);
      shortPress[1] = Parser.findContent(symbols, 4, symbols.length - 1, 0, 3);
      shortPress[2] = Parser.findContent(symbols, 4, symbols.length - 1, 1, 3);
      shortPress[3] = Parser.findContent(symbols, 4, symbols.length - 1, 2, 3);
    } else
      for (int i = 0; i < 4; i++)
        shortPress[i] = Parser
            .findContent(symbols, 0, symbols.length - 1, i, 4);

    longPress[0] = "Back";
    longPress[1] = ":-)";
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
      return this;
    if (1 == shortPress[index - 1].split(" ").length) {
      if (shortPress[index - 1].equals("space"))
        Controller.m_message.insertChar(' ');
      else
        Controller.m_message.insertChar(shortPress[index - 1].charAt(0));
      return new KeyboardState(mController);
    }
    return new SymbolsState(mController, shortPress[index - 1].split(" "),
        false);
  }

  // Back
  @Override
  public final State onLong1Press() {
    return new KeyboardState(mController);
  }

  // :-)
  @Override
  public final State onLong2Press() {
    return new SmileysState(mController, KeyboardState.smileys);
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
