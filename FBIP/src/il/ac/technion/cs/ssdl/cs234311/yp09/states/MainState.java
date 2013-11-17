package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.ControllerListener.FragmentID;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public final class MainState extends State {

  /**
   * @param c
   *          an object mediating between the model and the view.
   */
  public MainState(final Controller c) {
    super(c);
    shortPress[0] = "Keyboard";
    shortPress[1] = "Protocol";
    shortPress[2] = "Recipient";
    shortPress[3] = "Settings";

    longPress[0] = "Exit";
    longPress[1] = "Send";
    longPress[2] = "UNUSED";
    longPress[3] = "UNUSED";
  }

  // Keyboard was "clicked"
  @Override
  public final State onShort1Press() {
    return new KeyboardState(mController);
  }

  // Protocol
  @Override
  public final State onShort2Press() {
    /*
     * Important: this method should be changed in the future. Meanwhile our App
     * supports SMS protocol only.
     */
    mController.getListener().onRequestFragmentSwap(FragmentID.PROTOCOL_FRAG);
    return this;

  }

  // Recipient
  @Override
  public final State onShort3Press() {
    /*
     * Important: this method should be changed in the future. Meanwhile our App
     * supports inserting numbers manually.
     */
    return this;

  }

  // Settings
  @Override
  public final State onShort4Press() {
    /*
     * Important: this method should be changed in the future. Meanwhile we do
     * NOT enable changing settings.
     */
    return this;

  }

  // Exit
  @Override
  public final State onLong1Press() {
    /*
     * Important: this method should be changed in the future. Meanwhile we just
     * exit the application. No backup/other operations are done.
     */
    // TODO: consider a better way of exiting the app (calling destroy() on the
    // activity for instance)
    System.exit(0);
    return this;

  }

  // Send
  @Override
  public final State onLong2Press() {
    mController.sendSMS();
    return this;

  }

  // UNUSED
  @Override
  public final State onLong3Press() {
    // Left for future use.
    return this;

  }

  // UNUSED
  @Override
  public final State onLong4Press() {
    // Left for future use.
    return this;

  }

}
