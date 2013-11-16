package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller.PressID;

/**
 * @author Itamar Bitton
 * 
 *         Interface definition for a <code>Controller</code> that listens to
 *         events from the <code>FourButtonsFragment</code>.
 */
public interface FourButtonsListener {
  /**
   * Called when a button triggers a long press event.
   * 
   * @param p
   *          The id of the button that triggered the event.
   */
  public void onLongPress(PressID p);

  /**
   * Called when a button is released following a long press event.
   * 
   * @param p
   *          The id of the button that triggered the event.
   */
  public void onLongRelease(PressID p);

  /**
   * Called when a button triggers a short press event.
   * 
   * @param p
   *          The id of the button that triggered the event.
   */
  public void onShortPress(PressID p);

  /**
   * Called when a button is released following a short press event.
   * 
   * @param p
   *          The id of the button that triggered the event.
   */
  public void onShortRelease(PressID p);
}
