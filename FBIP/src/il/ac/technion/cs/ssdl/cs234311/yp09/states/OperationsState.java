package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public final class OperationsState extends State {

  /**
   * @param c
   *          an object mediating between the model and the view.
   */
  public OperationsState(final Controller c) {
    super(c);
    shortPress[0] = "Delete";
    shortPress[1] = "Delete All";
    shortPress[2] = "New Line";
    shortPress[3] = "Undo";

    longPress[0] = "Back";
    longPress[1] = "UNUSED";
    longPress[2] = "UNUSED";
    longPress[3] = "UNUSED";
  }

  // Delete
  @Override
  public final State onShort1Press() {
    Controller.m_message.deletetChar();
    return new KeyboardState(mController);
  }

  // Delete All
  @Override
  public final State onShort2Press() {
    Controller.m_message.deleteAll();
    return new KeyboardState(mController);
  }

  // New Line
  @Override
  public final State onShort3Press() {
    // Owais: message.newLine();
    return new KeyboardState(mController);
  }

  // Restore Previous
  @Override
  public final State onShort4Press() {
    Controller.m_message.undoLastOp();
    return new KeyboardState(mController);
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
