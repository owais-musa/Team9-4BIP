package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * @author Itamar Bitton
 * 
 *         Displays the operations to be performed in the event of a short
 *         button press.
 */
public class ShortPressInfoFragment extends Fragment implements
    ActivityListener {

  private String[] mKeyInfo = new String[4];

  private ShortPressInfoAdapter infoAdapter;

  @Override
  public View onCreateView(final LayoutInflater inflater,
      final ViewGroup container, final Bundle savedInstanceState) {
    infoAdapter = new ShortPressInfoAdapter(mKeyInfo, getActivity());
    final View $ = inflater.inflate(R.layout.short_press_info_fragment,
        container, false);
    ((GridView) $.findViewById(R.id.grid_view)).setAdapter(infoAdapter);
    return $;
  }

  protected ShortPressInfoAdapter getInfoAdapter() {
    return infoAdapter;
  }

  @Override
  public void onUpdateInfo(final String[] s) {
    mKeyInfo = s;
  }
}
