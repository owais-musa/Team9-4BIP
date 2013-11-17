package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public final class KeyboardState extends State {

  /**
   * Will be replaced in an XML file.
   */
  public static String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
      "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
      "x", "y", "z" };
  /**
   * Will be replaced in an XML file.
   */
  public static String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7",
      "8", "9" };
  /**
   * Will be replaced in an XML file.
   */
  public static String[] symbols = { "space", ".", ",", "?", "-", "!", "@",
      "_", "/", "(", ")", "&", ":", ";", "$", "`", "<", ">", "^", "~", "[",
      "]", "{", "}", "\"", "+", "%", "=", "#", "*", "\\", "|", "'" };
  /**
   * Will be replaced in an XML file.
   */
  public static String[] smileys = { ":)", ":(", ";)", ":D", ":p", ":-)",
      ":-(", ":|" };

  /**
   * @param c
   *          an object mediating between the model and the view.
   */
  public KeyboardState(final Controller c) {
    super(c);
    shortPress[0] = "Letters";
    shortPress[1] = "Numbers";
    shortPress[2] = "Symbols";
    shortPress[3] = "Operations";

    longPress[0] = "Back";
    longPress[1] = "Done";
    longPress[2] = "<--";
    longPress[3] = "-->";
  }

  // Letters
  @Override
  public final State onShort1Press() {
    return new LettersState(mController, abc, true);
  }

  // Numbers
  @Override
  public final State onShort2Press() {
    return new NumbersState(mController, numbers);
  }

  // Symbols
  @Override
  public final State onShort3Press() {
    return new SymbolsState(mController, symbols, true);
  }

  // Operations
  @Override
  public final State onShort4Press() {
    return new OperationsState(mController);
  }

  // Back
  @Override
  public final State onLong1Press() {
    return new MainState(mController);
  }

  // Done
  @Override
  public final State onLong2Press() {
    // OWAIS : message.done();
    return new MainState(mController);
  }

  // <--
  @Override
  public final State onLong3Press() {
    Controller.m_message.moveCurserToTheLeft();
    return this;
  }

  // -->
  @Override
  public final State onLong4Press() {
    Controller.m_message.moveCurserToTheRight();
    return this;
  }

}
