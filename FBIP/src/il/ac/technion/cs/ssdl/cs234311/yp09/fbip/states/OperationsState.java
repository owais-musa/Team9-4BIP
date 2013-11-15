package il.ac.technion.cs.ssdl.cs234311.yp09.fbip.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller;

public class OperationsState extends State {

  public OperationsState(Controller c) {
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
  public State onShort1Press() {
    Controller.m_Message.DeletetChar();
    return new KeyboardState(mController);
  }

  // Delete All
  @Override
  public State onShort2Press() {
    Controller.m_Message.DeleteAll();
    return new KeyboardState(mController);
  }

  // New Line
  @Override
  public State onShort3Press() {
    // Owais: message.newLine();
    return new KeyboardState(mController);
  }

  // Restore Previous
  @Override
  public State onShort4Press() {
    Controller.m_Message.UndoLastOp();
    return new KeyboardState(mController);
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

  // UNUSED
  @Override
  public State onLong3Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

  // UNUSED
  @Override
  public State onLong4Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

}
