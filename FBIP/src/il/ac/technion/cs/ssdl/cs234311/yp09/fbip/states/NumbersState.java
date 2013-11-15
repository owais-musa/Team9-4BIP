package il.ac.technion.cs.ssdl.cs234311.yp09.fbip.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller;

public class NumbersState extends State {

  public NumbersState(Controller c, String[] numbers) {
    super(c);
    for(int i = 0; i < 4; i++) {
      shortPress[i] = Parser.findContent(numbers, 0, numbers.length - 1, i, 4);
    }

    longPress[0] = "Back";
    longPress[1] = "UNUSED";
    longPress[2] = "Lang";
    longPress[3] = "UNUSED";
  }

  @Override
  public State onShort1Press() {
    return shortOpLogic(1);
  }

  @Override
  public State onShort2Press() {
    return shortOpLogic(2);
  }

  @Override
  public State onShort3Press() {
    return shortOpLogic(3);
  }

  @Override
  public State onShort4Press() {
    return shortOpLogic(4);
  }

  public State shortOpLogic(int i) {
    int size = shortPress[i - 1].length();
    if(shortPress[i - 1].equals("")) {
      /*
       * In case some of the windows are empty.
       * For example: having 3 numbers to be shown on 4 windows.
       * I solved the issue by remaining in the same state.
       */
      return this;
    } else if(size == 1) {
      Controller.m_Message.InsertChar(shortPress[i - 1].charAt(0));
      return new KeyboardState(mController);
    } else {
      String[] choosenItems = shortPress[i - 1].split(" ");
      return new NumbersState(mController, choosenItems);
    }
  }

  // Back
  @Override
  public State onLong1Press() {
    return new KeyboardState(mController);
  }

  // UNUSED
  @Override
  public State onLong2Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

  // Lang
  @Override
  public State onLong3Press() {
    /*
     * The format used for numbers in the first iteration is the regular one.
     * We will support more formats in the next iterations.
     */
    return this;
  }

  // UNUSED
  @Override
  public State onLong4Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

}
