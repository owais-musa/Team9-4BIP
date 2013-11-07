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
		TextView t = (TextView) v.findViewById(R.id.yellowText);
		t.setText(mText[0]);
		t = (TextView) v.findViewById(R.id.redText);
		t.setText(mText[1]);
		t = (TextView) v.findViewById(R.id.blueText);
		t.setText(mText[2]);
		t = (TextView) v.findViewById(R.id.greenText);
		t.setText(mText[3]);
        return v;
    }

}
