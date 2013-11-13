package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.FourButtonsFragment.PressType;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

class PressEmphasizer implements Runnable {
	/**
	 * 
	 */
    private final FourButtonsFragment.ButtonListener buttonListener;
	volatile boolean running = true;
	boolean emphasizingShort = false;
	boolean emphasizingLong = false;
	Handler handler;
	public PressEmphasizer(FourButtonsFragment.ButtonListener buttonListener, Handler h) {
		this.buttonListener = buttonListener;
		handler = h;
	}
	public void terminate() {
		running = false;
		if(emphasizingShort)
			resetShort();
		else if(emphasizingLong)
			resetLong();
	}
	private void sendMessage(boolean emphasize, FourButtonsFragment.PressType type, int id) {
		Message msg = handler.obtainMessage();
		Bundle b = new Bundle();
		b.putBoolean("emphasize", emphasize);
		b.putString("type", type.toString());
		b.putInt("id", id);
		msg.setData(b);
		handler.sendMessage(msg);
	}
	private void emphasizeShort() {
		Log.d("BUTTONS", "emphasizing short");
		emphasizingShort = true;
		sendMessage(true, PressType.SHORT_PRESS, this.buttonListener.buttonID.ordinal());
	}
	private void resetShort() {
		Log.d("BUTTONS", "resetting short");
		emphasizingShort = false;
		sendMessage(false, PressType.SHORT_PRESS, this.buttonListener.buttonID.ordinal());
	}
	private void emphasizeLong() {
		Log.d("BUTTONS", "emphasizing long");
		emphasizingLong = true;
		sendMessage(true, PressType.LONG_PRESS, this.buttonListener.buttonID.ordinal());
	}
	private void resetLong() {
		Log.d("BUTTONS", "resetting long");
		emphasizingLong = false;
		sendMessage(false, PressType.LONG_PRESS, this.buttonListener.buttonID.ordinal());
	}
	@Override
    public void run() {
		while(running) {
			long holdTime = System.currentTimeMillis() - this.buttonListener.pressTime;
			if(holdTime >= 500 && holdTime < 2000 && !emphasizingShort) {
				Log.d("PRESS_EMPH", "holdtime = " + holdTime);
				emphasizeShort();
			} else if(holdTime >= 2000 && !emphasizingLong) {
				Log.d("PRESS_EMPH", "holdtime = " + holdTime);
				resetShort();
				emphasizeLong();
			}
		}
    }
}