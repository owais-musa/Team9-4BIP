package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.fbip.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LongPressInfoFragment extends Fragment {
	
	private String[] mText = new String[4];

	@Override
	public void setArguments(Bundle args) {
		if(args != null)
			for(int i = 0; i < 4; i++)
				mText[i] = args.getString(Integer.toString(i));
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.long_press_info_fragment, container, false);
		int[] ids = {R.id.blue_text, R.id.yellow_text, R.id.green_text, R.id.red_text};
		for(int i = 0; i < 4; i++) {
			TextView t = (TextView) v.findViewById(ids[i]);
			t.setText(mText[i]);
		}
        return v;
    }

}
