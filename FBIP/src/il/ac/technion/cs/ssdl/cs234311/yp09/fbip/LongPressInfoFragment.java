package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Itamar Bitton
 * 
 *         Displays the operations to be performed in the event of a long button
 *         press.
 */
public class LongPressInfoFragment extends Fragment implements ActivityListener {

  private String[] mText = new String[4];

  @Override
  public View onCreateView(final LayoutInflater inflater,
      final ViewGroup container, final Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View $ = inflater.inflate(R.layout.long_press_info_fragment,
        container, false);
    final int[] ids = { R.id.blue_text, R.id.yellow_text, R.id.green_text,
        R.id.red_text };
    for (int i = 0; i < 4; i++)
      ((TextView) $.findViewById(ids[i])).setText(mText[i]);
    return $;
  }

  @Override
  public void onUpdateInfo(final String[] s) {
    mText = s;
  }

}
