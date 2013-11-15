package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller.PressID;

public interface ControllerListener {
  public enum FragmentID {
    MESSAGE_FRAG, SETTINGS_FRAG, PROTOCOL_FRAG, HELP_FRAG
  };

  public void onRequestFragmentSwap(FragmentID f);

  public void onShortInfoUpdate(String[] s);

  public void onLongInfoUpdate(String[] s);

  public void onUpdateMessage(String s, int i);

  public void emphasizeShort(PressID p, boolean b);

  public void emphasizeLong(PressID p, boolean b);

  public void onUpdateDisplay();

  public void onSendSMS(String t, String n);
}
