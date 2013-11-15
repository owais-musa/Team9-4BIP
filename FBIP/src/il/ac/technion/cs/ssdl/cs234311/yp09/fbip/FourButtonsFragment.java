package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import java.util.Timer;
import java.util.TimerTask;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.R;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller.PressID;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FourButtonsFragment extends Fragment {
  protected static final String TAG = "BUTTONS";
  FBListener mFBListener;
  Controller m_Controller;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    m_Controller = (Controller) getArguments().getSerializable("controller");

    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.buttons_fragment, container, false);
    int[] bIDs = { R.id.blue_button, R.id.yellow_button, R.id.green_button,
        R.id.red_button };
    for(int i = 0; i < 4; i++) {
      Button b = (Button) view.findViewById(bIDs[i]);
      b.setOnTouchListener(new ButtonListener(PressID.values()[i]));
    }

    return view;
  }

  public static FourButtonsFragment newInstance(Controller states) {
    FourButtonsFragment frag = new FourButtonsFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("controller", states);
    frag.setArguments(bundle);

    return frag;
  }

  public void setListener(FBListener l) {
    mFBListener = l;
  }

  class ButtonListener implements OnTouchListener {
    long pressTime, duration;
    PressID buttonID;
    Timer timer;

    public ButtonListener(PressID id) {
      buttonID = id;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
      if(event.getAction() == MotionEvent.ACTION_DOWN) { // button pressed
        pressTime = System.currentTimeMillis();
        Log.d(TAG, "listener: " + mFBListener);
        timer = new Timer();
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            Log.d("TIMER_TASK", "listener: " + mFBListener);
            Log.d("TIMER_TASK", "short press "
                + (System.currentTimeMillis() - pressTime));
            mFBListener.onShortPress(buttonID);
          }
        }, 500);
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            Log.d("TIMER_TASK", "long press "
                + (System.currentTimeMillis() - pressTime));
            mFBListener.onLongPress(buttonID);
          }
        }, 2000);
      } else if(event.getAction() == MotionEvent.ACTION_UP) {
        duration = System.currentTimeMillis() - pressTime;
        timer.cancel();
        timer.purge();
        if(duration >= 500 && duration < 2000) { // short press
          mFBListener.onShortRelease(buttonID);
          return true;
        } else if(duration >= 2000) { // long press
          mFBListener.onLongRelease(buttonID);
          return true;
        }
      }
      return false;
    }
  }
}
