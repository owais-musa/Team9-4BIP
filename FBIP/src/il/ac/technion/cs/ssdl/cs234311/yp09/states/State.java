package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.ControllerListener;

public abstract class State {

  public String[] shortPress = new String[4];
  public String[] longPress = new String[4];
  protected Controller mController;

  public State(Controller c) {
    mController = c;
  }

  // The lower operations (triggered in 0.5 - 2 seconds)
  public abstract State onShort1Press();

  public abstract State onShort2Press();

  public abstract State onShort3Press();

  public abstract State onShort4Press();

  // The upper operations (triggered in 2+ seconds)
  public abstract State onLong1Press();

  public abstract State onLong2Press();

  public abstract State onLong3Press();

  public abstract State onLong4Press();
}
