package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller.PressID;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.MainActivity.FragmentID;

/**
 * @author Itamar Bitton
 * 
 *         Interface definition for an <code>Activity</code> that listens to
 *         events from a <code>Controller</code>.
 */
public interface ControllerListener {
  /**
   * Called when the <code>Controller</code> requests the main
   * <code>Fragment</code> to be swapped.
   * 
   * @param f
   *          The ID of the <code>Fragment</code> to swap in.
   */
  public void onRequestFragmentSwap(FragmentID f);

  /**
   * Called when the <code>Controller</code> requests that the short press
   * operation texts be updated.
   * 
   * @param s
   *          A <code>String</code> array with the new operation texts.
   */
  public void onShortInfoUpdate(String[] s);

  /**
   * Called when the <code>Controller</code> requests that the long press
   * operation texts be updated.
   * 
   * @param s
   *          A <code>String</code> array with the new operation texts.
   */
  public void onLongInfoUpdate(String[] s);

  /**
   * Called when the <code>Controller</code> requests that the message to send
   * be updated.
   * 
   * @param s
   *          The updated message.
   * @param i
   *          The position of the caret in the message's <code>TextView</code>.
   */
  public void onUpdateMessage(String s, int i);

  /**
   * Called to emphasize whether the short operation for an associated button
   * will be performed if the user releases said button.
   * 
   * @param p
   *          The ID of the associated button.
   * @param b
   *          Whether or not the operation should be emphasized that it will be
   *          performed.
   */
  public void emphasizeShort(PressID p, boolean b);

  /**
   * Called to emphasize whether the long operation for an associated button
   * will be performed if the user releases said button.
   * 
   * @param p
   *          The ID of the associated button.
   * @param b
   *          Whether or not the operation should be emphasized that it will be
   *          performed.
   */
  public void emphasizeLong(PressID p, boolean b);

  /**
   * Called when the <code>Controller</code> requests that the main
   * <code>Activity</code> update it's display.
   */
  public void onUpdateDisplay();

  // TODO: change to general onSend message with a given protocol.
  /**
   * Called when the <code>Controller</code> requests to send the entered
   * message via SMS.
   * 
   * @param t
   *          The message to send.
   * @param n
   *          The phone number of the recipient.
   */
  public void onSendSMS(String t, String n);
}
