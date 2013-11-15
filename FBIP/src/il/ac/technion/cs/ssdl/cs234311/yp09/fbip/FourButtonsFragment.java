package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller.PressID;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author Itamar
 * 
 */
public class FourButtonsFragment extends Fragment {
  protected static final String TAG = "BUTTONS";
  FourButtonsListener mFBListener;

  @Override
  public View onCreateView(final LayoutInflater inflater,
      final ViewGroup container, final Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.buttons_fragment, container,
        false);
    final int[] bIDs = { R.id.blue_button, R.id.yellow_button,
        R.id.green_button, R.id.red_button };
    for (int i = 0; i < 4; i++) {
      final Button b = (Button) view.findViewById(bIDs[i]);
      b.setOnTouchListener(new ButtonListener(PressID.values()[i]));
    }
    return view;
  }

  /**
   * @param l
   */
  public void setListener(final FourButtonsListener l) {
    mFBListener = l;
  }

  class ButtonListener implements OnTouchListener {
    private static final int LONG_PRESS_DELAY = 2000;
    private static final int SHORT_PRESS_DELAY = 500;
    long pressTime, duration;
    PressID buttonID;
    Timer timer;

    public ButtonListener(final PressID id) {
      buttonID = id;
    }

    @Override
    public boolean onTouch(final View v, final MotionEvent event) {
      if (event.getAction() == MotionEvent.ACTION_DOWN) { // button pressed
        pressTime = System.currentTimeMillis();
        Log.d(TAG, "listener: " + mFBListener);
        timer = new Timer();
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            Log.d("TIMER_TASK", "short press "
                + (System.currentTimeMillis() - pressTime));
            mFBListener.onShortPress(buttonID);
          }
        }, SHORT_PRESS_DELAY);
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            Log.d("TIMER_TASK", "long press "
                + (System.currentTimeMillis() - pressTime));
            mFBListener.onLongPress(buttonID);
          }
        }, LONG_PRESS_DELAY);
      } else if (event.getAction() == MotionEvent.ACTION_UP) {
        duration = System.currentTimeMillis() - pressTime;
        timer.cancel();
        timer.purge();
        if (duration >= 500 && duration < 2000) { // short press
          mFBListener.onShortRelease(buttonID);
          return true;
        } else if (duration >= 2000) { // long press
          mFBListener.onLongRelease(buttonID);
          return true;
        }
      }
      return false;
    }
  }
}
