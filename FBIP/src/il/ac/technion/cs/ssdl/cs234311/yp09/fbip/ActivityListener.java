package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

/**
 * @author Itamar Bitton
 * 
 *         Interface definition for a <code>Fragment</code> that listens to
 *         events from the main <code>Activity</code>.
 */
public interface ActivityListener {
  /**
   * Called when the <code>Activity</code> would like to update the info.
   * 
   * @param s
   *          The <code>String</code> array that holds the updated info.
   */
  public void onUpdateInfo(String[] s);
}
