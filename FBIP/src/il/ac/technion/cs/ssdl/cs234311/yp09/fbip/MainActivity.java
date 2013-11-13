package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import java.io.Serializable;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.R;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public class MainActivity extends Activity {

	public static enum BodyFragment {
		HELP_FRAG,
		MESSAGE_FRAG,
		PROTOCOL_FRAG,
		SETTINGS_FRAG;
	}
	public static enum Color { BLUE, YELLOW, GREEN, RED };
		
	private Controller m_Controller;

	private LongPressInfoFragment longFrag;
	
	private HelpFragment helpFrag;
	private MessageFragment messageFrag;
	private ProtocolFragment protocolFrag;
	private SettingsFragment settingsFrag;
	
	private ShortPressInfoFragment shortFrag;
	private FourButtonsFragment buttonsFrag;

	class SerialHandler extends Handler implements Serializable {
        private static final long serialVersionUID = 8484722986747130474L;
        @Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			String type = bundle.getString("type");
			Log.d("MAIN", "Type: " + type);
			int id = bundle.getInt("id");
			Log.d("MAIN", "ID: " + id);
			int color = bundle.getBoolean("emphasize") ? getResources().getColor(R.color.black) : getResources().getColor(R.color.white);
			Log.d("MAIN", "Color: " + color);
			if(type.equals("SHORT_PRESS"))
				getShortTextView(Color.values()[id]).setTextColor(color);
			else if(type.equals("LONG_PRESS"))
				getLongTextView(Color.values()[id]).setTextColor(color);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//register handler
		SerialHandler handler = new SerialHandler();
		
		Log.d("MAIN", "setting view");
		setContentView(R.layout.activity_main);

		m_Controller = new Controller(this);

		Log.d("MAIN", "adding fragments");
		longFrag = new LongPressInfoFragment();
		getFragmentManager().beginTransaction()
		        .add(R.id.long_press_info_frame, longFrag).commit();

		helpFrag = new HelpFragment();
		messageFrag = new MessageFragment();
		protocolFrag = new ProtocolFragment();
		settingsFrag = new SettingsFragment();

		shortFrag = new ShortPressInfoFragment();
		getFragmentManager().beginTransaction()
		        .add(R.id.short_press_info_frame, shortFrag).commit();

		buttonsFrag = FourButtonsFragment.newInstance(m_Controller, handler);
		getFragmentManager().beginTransaction()
		        .add(R.id.buttons_frame, buttonsFrag).commit();

		m_Controller.start();
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	public void setShortPressInfo(String[] shortText) {
		Bundle args = new Bundle();
		for(int i = 0; i < 4; i++)
			args.putString(Integer.toString(i), shortText[i]);
		shortFrag.setArguments(args);
	}

	public void setLongPressInfo(String[] longText) {
		Bundle args = new Bundle();
		for(int i = 0; i < 4; i++)
			args.putString(Integer.toString(i), longText[i]);
		longFrag.setArguments(args);
	}

	public void updateDisplay() {
		getFragmentManager().beginTransaction().detach(longFrag)
		        .attach(longFrag).detach(shortFrag).attach(shortFrag).commit();
	}
	
	public void setBodyFragment(BodyFragment frag) {
		FragmentTransaction t = getFragmentManager().beginTransaction();
		switch(frag) {
		case HELP_FRAG:
			t.replace(R.id.main_frame, helpFrag);
			break;
		case MESSAGE_FRAG:
			t.replace(R.id.main_frame, messageFrag);
			break;
		case PROTOCOL_FRAG:
			t.replace(R.id.main_frame, protocolFrag);
			break;
		case SETTINGS_FRAG:
			t.replace(R.id.main_frame, settingsFrag);
			break;
		default:
			break;
		}
		t.commit();
	}
	
	public void setCurrentFragmentToBackstack() {
		
	}

	public void removeAndSetLastFragmentInBackstack() {
		
	}
	
	public void UpdateMessage(String in_Message, int in_iCursorPossition){
		EditText MessageEditText = (EditText) findViewById(R.id.recipients_data);
		if (MessageEditText == null)
			return;
		MessageEditText.setText(in_Message);
		MessageEditText.setSelection(in_iCursorPossition);
	}
	
	
    public void sendSMS(String message, String phoneNo){
    	if (phoneNo.length()<=0 || message.length()<=0){                
    		Toast.makeText(getBaseContext(), 
                    "Please enter both phone number and message.", 
                    Toast.LENGTH_SHORT).show();
    		return;
        }
    	String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";
    	PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);
     
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS sent", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off", 
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));
 
        
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS delivered", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS not delivered", 
                                Toast.LENGTH_SHORT).show();
                        break;                        
                }
            }
        }, new IntentFilter(DELIVERED));
    	SmsManager SMgr = SmsManager.getDefault();
        TelephonyManager phoneManager = (TelephonyManager) 
        	    getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
        String myPhoneNo = phoneManager.getLine1Number();
        SMgr.sendTextMessage(phoneNo, myPhoneNo, message, sentPI, deliveredPI);
        ContentValues values = new ContentValues();
        values.put("address", phoneNo);
        values.put("body", message);
        getContentResolver().insert(Uri.parse("content://sms/sent"), values);
    }
	
    protected TextView getLongTextView(Color c) {
    	switch(c) {
    	case BLUE:
    		return (TextView) findViewById(R.id.blue_text);
    	case YELLOW:
    		return (TextView) findViewById(R.id.yellow_text);
    	case GREEN:
    		return (TextView) findViewById(R.id.green_text);
    	case RED:
    		return (TextView) findViewById(R.id.red_text);
		default:
			return null;
    	}
    }
    
    protected TextView getShortTextView(Color c) {
    	return shortFrag.getInfoAdapter().getTextView(c.ordinal());
    }
}
