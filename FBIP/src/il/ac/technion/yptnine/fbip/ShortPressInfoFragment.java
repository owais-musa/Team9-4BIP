package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.fbip.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ShortPressInfoFragment extends Fragment {

	private String[] mKeyInfo = new String[4];

	@Override
	public void setArguments(Bundle args) {
		if(args != null)
			for(int i = 0; i < 4; i++)
				mKeyInfo[i] = args.getString(Integer.toString(i));
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.short_press_info_fragment, container, false);
		GridView grid = (GridView) view.findViewById(R.id.grid_view);
		grid.setAdapter(new ShortPressInfoAdapter(mKeyInfo, getActivity()));
        return view; 
    }
}
