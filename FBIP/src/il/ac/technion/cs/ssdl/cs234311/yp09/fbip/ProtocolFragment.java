package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Itamar Bitton
 * 
 *         Displays the available protocols in which the message can be sent.
 */
public class ProtocolFragment extends Fragment {
  @Override
  public View onCreateView(final LayoutInflater inflater,
      final ViewGroup container, final Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.protocol_body, container, false);
  }
}
