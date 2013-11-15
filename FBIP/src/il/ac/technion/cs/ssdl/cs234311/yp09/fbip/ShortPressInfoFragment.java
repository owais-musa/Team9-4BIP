package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * @author Itamar
 * 
 */
public class ShortPressInfoFragment extends Fragment implements
    ActivityListener {

  private String[] mKeyInfo = new String[4];

  private ShortPressInfoAdapter infoAdapter;

  @Override
  public View onCreateView(final LayoutInflater inflater,
      final ViewGroup container, final Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.short_press_info_fragment,
        container, false);
    final GridView grid = (GridView) view.findViewById(R.id.grid_view);
    infoAdapter = new ShortPressInfoAdapter(mKeyInfo, getActivity());
    grid.setAdapter(infoAdapter);
    return view;
  }

  protected ShortPressInfoAdapter getInfoAdapter() {
    return infoAdapter;
  }

  @Override
  public void onUpdateInfo(final String[] s) {
    mKeyInfo = s;
  }
}
