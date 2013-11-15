package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller.PressID;

/**
 * @author Itamar
 * 
 */
public interface ControllerListener {
  /**
   * @author Itamar
   * 
   */
  public enum FragmentID {
    /**
     * 
     */
    MESSAGE_FRAG,
    /**
     * 
     */
    SETTINGS_FRAG,
    /**
     * 
     */
    PROTOCOL_FRAG,
    /**
     * 
     */
    HELP_FRAG
  }

  /**
   * @param f
   */
  public void onRequestFragmentSwap(FragmentID f);

  /**
   * @param s
   */
  public void onShortInfoUpdate(String[] s);

  /**
   * @param s
   */
  public void onLongInfoUpdate(String[] s);

  /**
   * @param s
   * @param i
   */
  public void onUpdateMessage(String s, int i);

  /**
   * @param p
   * @param b
   */
  public void emphasizeShort(PressID p, boolean b);

  /**
   * @param p
   * @param b
   */
  public void emphasizeLong(PressID p, boolean b);

  /**
   * 
   */
  public void onUpdateDisplay();

  /**
   * @param t
   * @param n
   */
  public void onSendSMS(String t, String n);
}
