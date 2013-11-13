package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.MainActivity.Color;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.MainActivity.SerialHandler;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.R;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FourButtonsFragment extends Fragment {

	public static enum PressType { SHORT_PRESS, LONG_PRESS };
	public static enum PressID {
		BLUE_PRESS (R.id.blue_text,  R.color.blue),
		YELLOW_PRESS (R.id.yellow_text, R.color.yellow),
		GREEN_PRESS (R.id.green_text, R.color.green),
		RED_PRESS (R.id.red_text, R.color.red);
		
		private final int text, color;
		PressID(int t, int c) { text = t; color = c; }
		int text() { return text; }
		int color() { return color; }
	}
	
	private Controller m_Controller;
	SerialHandler m_Handler;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		m_Controller = (Controller) getArguments().getSerializable("controller");
		m_Handler = (SerialHandler) getArguments().getSerializable("handler");
		
        // Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.buttons_fragment, container, false);
		int[] bIDs = {R.id.blue_button, R.id.yellow_button, R.id.green_button, R.id.red_button};
		for(int i = 0; i < 4; i++) {
			Button b = (Button) view.findViewById(bIDs[i]);
			b.setOnTouchListener(new ButtonListener(PressID.values()[i]));
		}
		
		return view;
    }

	public static FourButtonsFragment newInstance(Controller states, SerialHandler handler) {
		FourButtonsFragment frag = new FourButtonsFragment();
		Bundle bundle = new Bundle();
		bundle.putSerializable("controller", states);
		bundle.putSerializable("handler", handler);
		frag.setArguments(bundle);
		
		return frag;
	}
	
	class ButtonListener implements OnTouchListener {
		long pressTime, duration;
		PressID buttonID;
		Thread thread;
		PressEmphasizer pe;
		
		public ButtonListener(PressID id) {
			buttonID = id;
		}
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction() == MotionEvent.ACTION_DOWN) { //button pressed
				pressTime = System.currentTimeMillis();
				//start thread to update main activity
				thread = new Thread(pe = new PressEmphasizer(this, m_Handler));
				thread.start();
				Log.d("BUTTON", "started thread");
			}
			else if(event.getAction() == MotionEvent.ACTION_UP) {
				duration = System.currentTimeMillis() - pressTime;
				pe.terminate();
				Log.d("BUTTONS", "runnable terminated");
				try {
	                thread.join();
	                Log.d("BUTTONS", "thread joined");
                } catch(InterruptedException e) {
                	//no need to do anything
                }
				if(duration >= 500 && duration < 2000) { //short press
					m_Controller.changeState(PressType.SHORT_PRESS, buttonID);
					return true;
				} else if(duration >= 2000) { //long press
					m_Controller.changeState(PressType.LONG_PRESS, buttonID);
					return true;
				}
			}
			return false;
		}
	}
}
