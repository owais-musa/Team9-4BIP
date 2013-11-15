package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller.PressID;

/**
 * @author Itamar
 * 
 */
public interface FourButtonsListener {
  /**
   * @param p
   */
  public void onLongPress(PressID p);

  /**
   * @param p
   */
  public void onLongRelease(PressID p);

  /**
   * @param p
   */
  public void onShortPress(PressID p);

  /**
   * @param p
   */
  public void onShortRelease(PressID p);
}
