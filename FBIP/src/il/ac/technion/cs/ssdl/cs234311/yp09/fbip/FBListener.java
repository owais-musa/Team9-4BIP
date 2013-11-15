package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller.PressID;

public interface FBListener {
  public void onLongPress(PressID p);

  public void onLongRelease(PressID p);

  public void onShortPress(PressID p);

  public void onShortRelease(PressID p);
}
