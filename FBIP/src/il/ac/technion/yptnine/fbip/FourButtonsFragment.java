package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.fbip.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FourButtonsFragment extends Fragment {

	public static enum PRESS_TYPE {SHORT_PRESS, LONG_PRESS};
	public static enum PRESS_ID {BLUE_PRESS, YELLOW_PRESS, GREEN_PRESS, RED_PRESS};
	
	private StateMachine mSM;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		mSM = (StateMachine) getArguments().getSerializable("sm");
		
        // Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.buttons_fragment, container, false);
		int[] bIDs = {R.id.blue_button, R.id.yellow_button, R.id.green_button, R.id.red_button};
		for(int i = 0; i < 4; i++) {
			Button b = (Button) view.findViewById(bIDs[i]);
			b.setOnTouchListener(new ButtonListener(PRESS_ID.values()[i]));
		}
		
		return view;
    }

	public static FourButtonsFragment newInstance(StateMachine states) {
		FourButtonsFragment frag = new FourButtonsFragment();
		Bundle bundle = new Bundle();
		bundle.putSerializable("sm", states);
		frag.setArguments(bundle);
		
		return frag;
	}
	
	class ButtonListener implements OnTouchListener {
		long pressTime, duration;
		FourButtonsFragment.PRESS_ID buttonID;
		
		public ButtonListener(FourButtonsFragment.PRESS_ID id) {
			buttonID = id;
		}
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction() == MotionEvent.ACTION_DOWN) //button pressed
				pressTime = System.currentTimeMillis();
			else if(event.getAction() == MotionEvent.ACTION_UP) {
				duration = System.currentTimeMillis() - pressTime;
				if(duration >= 500 && duration < 2000) { //short press
					Toast.makeText(getActivity(), "short " + buttonID, Toast.LENGTH_SHORT).show();
					mSM.changeState(FourButtonsFragment.PRESS_TYPE.SHORT_PRESS, buttonID);
					return true;
				} else if(duration >= 2000) { //long press
					Toast.makeText(getActivity(), "long " + buttonID, Toast.LENGTH_SHORT).show();
					mSM.changeState(FourButtonsFragment.PRESS_TYPE.LONG_PRESS, buttonID);
					return true;
				}
				//DEBUG
				else
					Toast.makeText(getActivity(), "touch " + buttonID, Toast.LENGTH_SHORT).show();
			}
			return false;
		}
	}
}
