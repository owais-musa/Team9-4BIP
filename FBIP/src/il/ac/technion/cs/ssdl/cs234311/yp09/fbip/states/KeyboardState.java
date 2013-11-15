package il.ac.technion.cs.ssdl.cs234311.yp09.fbip.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller;

public class KeyboardState extends State {

  public static String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
      "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
      "x", "y", "z" };
  public static String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7",
      "8", "9" };
  public static String[] symbols = { "space", ".", ",", "?", "-", "!", "@",
      "_", "/", "(", ")", "&", ":", ";", "$", "`", "<", ">", "^", "~", "[",
      "]", "{", "}", "\"", "+", "%", "=", "#", "*", "\\", "|", "'" };
  public static String[] smileys = { ":)", ":(", ";)", ":D", ":p", ":-)",
      ":-(", ":|" };

  public KeyboardState(Controller c) {
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
  public State onShort1Press() {
    return new LettersState(mController, abc, true);
  }

  // Numbers
  @Override
  public State onShort2Press() {
    return new NumbersState(mController, numbers);
  }

  // Symbols
  @Override
  public State onShort3Press() {
    return new SymbolsState(mController, symbols, true);
  }

  // Operations
  @Override
  public State onShort4Press() {
    return new OperationsState(mController);
  }

  // Back
  @Override
  public State onLong1Press() {
    return new MainState(mController);
  }

  // Done
  @Override
  public State onLong2Press() {
    // OWAIS : message.done();
    return new MainState(mController);
  }

  // <--
  @Override
  public State onLong3Press() {
    Controller.m_Message.MoveCurserToTheLeft();
    return this;
  }

  // -->
  @Override
  public State onLong4Press() {
    Controller.m_Message.MoveCurserToTheRight();
    return this;
  }

}
