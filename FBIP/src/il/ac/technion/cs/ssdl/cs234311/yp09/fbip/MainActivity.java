package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.R;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.Controller.PressID;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
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

public class MainActivity extends Activity implements ControllerListener {

  public static enum BodyFragment {
    HELP_FRAG, MESSAGE_FRAG, PROTOCOL_FRAG, SETTINGS_FRAG;
  }

  public static enum Color {
    BLUE, YELLOW, GREEN, RED
  }

  private Controller m_Controller;

  private LongPressInfoFragment longFrag;

  private HelpFragment helpFrag;
  private MessageFragment messageFrag;
  private ProtocolFragment protocolFrag;
  private SettingsFragment settingsFrag;

  private ShortPressInfoFragment shortFrag;
  private FourButtonsFragment buttonsFrag;

  private ActivityListener mShortListener;
  private ActivityListener mLongListener;

  private static final String TAG = "MAIN";

  public void setShortListener(ActivityListener al) {
    mShortListener = al;
  }

  public void setLongListener(ActivityListener al) {
    mLongListener = al;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Log.d("MAIN", "setting view");
    setContentView(R.layout.activity_main);

    m_Controller = new Controller();

    Log.d("MAIN", "adding fragments");
    longFrag = new LongPressInfoFragment();
    getFragmentManager().beginTransaction()
        .add(R.id.long_press_info_frame, longFrag).commit();

    helpFrag = new HelpFragment();
    messageFrag = new MessageFragment();
    protocolFrag = new ProtocolFragment();
    settingsFrag = new SettingsFragment();
    getFragmentManager().beginTransaction().add(R.id.main_frame, messageFrag)
        .commit();

    shortFrag = new ShortPressInfoFragment();
    getFragmentManager().beginTransaction()
        .add(R.id.short_press_info_frame, shortFrag).commit();

    buttonsFrag = FourButtonsFragment.newInstance(m_Controller);
    buttonsFrag.setListener(m_Controller);
    getFragmentManager().beginTransaction()
        .add(R.id.buttons_frame, buttonsFrag).commit();

    setShortListener(shortFrag);
    setLongListener(longFrag);

    Log.d(TAG, "starting controller");
    m_Controller.setListener(this);
    m_Controller.start();
  }

  /*
   * @Override
   * public boolean onCreateOptionsMenu(Menu menu) {
   * // Inflate the menu; this adds items to the action bar if it is present.
   * getMenuInflater().inflate(R.menu.main, menu);
   * return true;
   * }
   */

  /*
   * public void setShortPressInfo(String[] shortText) {
   * Bundle args = new Bundle();
   * for(int i = 0; i < 4; i++)
   * args.putString(Integer.toString(i), shortText[i]);
   * shortFrag.setArguments(args);
   * }
   * 
   * public void setLongPressInfo(String[] longText) {
   * Bundle args = new Bundle();
   * for(int i = 0; i < 4; i++)
   * args.putString(Integer.toString(i), longText[i]);
   * longFrag.setArguments(args);
   * }
   */

  /*
   * public void updateDisplay() {
   * getFragmentManager().beginTransaction().detach(longFrag)
   * .attach(longFrag).detach(shortFrag).attach(shortFrag).commit();
   * }
   */

  /*
   * public void setBodyFragment(BodyFragment frag) {
   * FragmentTransaction t = getFragmentManager().beginTransaction();
   * switch(frag) {
   * case HELP_FRAG:
   * t.replace(R.id.main_frame, helpFrag);
   * break;
   * case MESSAGE_FRAG:
   * t.replace(R.id.main_frame, messageFrag);
   * break;
   * case PROTOCOL_FRAG:
   * t.replace(R.id.main_frame, protocolFrag);
   * break;
   * case SETTINGS_FRAG:
   * t.replace(R.id.main_frame, settingsFrag);
   * break;
   * default:
   * break;
   * }
   * t.commit();
   * }
   */

  /*
   * public void setCurrentFragmentToBackstack() {
   * 
   * }
   * 
   * public void removeAndSetLastFragmentInBackstack() {
   * 
   * }
   */

  /*
   * public void updateMessage(String in_Message, int in_iCursorPossition){
   * EditText MessageEditText = (EditText) findViewById(R.id.recipients_data);
   * if (MessageEditText == null)
   * return;
   * MessageEditText.setText(in_Message);
   * MessageEditText.setSelection(in_iCursorPossition);
   * }
   */

  private void sendSMS(String message, String phoneNo) {
    if(phoneNo.length() <= 0 || message.length() <= 0) {
      Toast.makeText(getBaseContext(),
          "Please enter both phone number and message.", Toast.LENGTH_SHORT)
          .show();
      return;
    }
    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";
    PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
        new Intent(SENT), 0);

    PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(
        DELIVERED), 0);
    registerReceiver(new BroadcastReceiver() {
      @Override
      public void onReceive(Context arg0, Intent arg1) {
        switch (getResultCode()) {
        case Activity.RESULT_OK:
          Toast.makeText(getBaseContext(), "SMS sent", Toast.LENGTH_SHORT)
              .show();
          break;
        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
          Toast.makeText(getBaseContext(), "Generic failure",
              Toast.LENGTH_SHORT).show();
          break;
        case SmsManager.RESULT_ERROR_NO_SERVICE:
          Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_SHORT)
              .show();
          break;
        case SmsManager.RESULT_ERROR_NULL_PDU:
          Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT)
              .show();
          break;
        case SmsManager.RESULT_ERROR_RADIO_OFF:
          Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_SHORT)
              .show();
          break;
        }
      }
    }, new IntentFilter(SENT));

    registerReceiver(new BroadcastReceiver() {
      @Override
      public void onReceive(Context arg0, Intent arg1) {
        switch (getResultCode()) {
        case Activity.RESULT_OK:
          Toast.makeText(getBaseContext(), "SMS delivered", Toast.LENGTH_SHORT)
              .show();
          break;
        case Activity.RESULT_CANCELED:
          Toast.makeText(getBaseContext(), "SMS not delivered",
              Toast.LENGTH_SHORT).show();
          break;
        }
      }
    }, new IntentFilter(DELIVERED));
    SmsManager SMgr = SmsManager.getDefault();
    TelephonyManager phoneManager = (TelephonyManager) getApplicationContext()
        .getSystemService(Context.TELEPHONY_SERVICE);
    String myPhoneNo = phoneManager.getLine1Number();
    SMgr.sendTextMessage(phoneNo, myPhoneNo, message, sentPI, deliveredPI);
    ContentValues values = new ContentValues();
    values.put("address", phoneNo);
    values.put("body", message);
    getContentResolver().insert(Uri.parse("content://sms/sent"), values);
  }

  protected TextView getLongTextView(PressID p) {
    switch (p) {
    case BLUE_PRESS:
      return (TextView) findViewById(R.id.blue_text);
    case YELLOW_PRESS:
      return (TextView) findViewById(R.id.yellow_text);
    case GREEN_PRESS:
      return (TextView) findViewById(R.id.green_text);
    case RED_PRESS:
      return (TextView) findViewById(R.id.red_text);
    default:
      return null;
    }
  }

  protected TextView getShortTextView(PressID p) {
    return shortFrag.getInfoAdapter().getTextView(p.ordinal());
  }

  @Override
  public void onRequestFragmentSwap(FragmentID f) {
    FragmentTransaction t = getFragmentManager().beginTransaction();
    switch (f) {
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

  @Override
  public void emphasizeShort(final PressID p, final boolean b) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if(b) {
          Log.d(TAG, "setting short " + p + " to black");
          getShortTextView(p).setTextColor(
              getResources().getColor(R.color.black));
        } else {
          Log.d(TAG, "setting short " + p + " to white");
          getShortTextView(p).setTextColor(
              getResources().getColor(R.color.white));
        }
      }
    });
  }

  @Override
  public void emphasizeLong(final PressID p, final boolean b) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if(b) {
          Log.d(TAG, "setting long " + p + " to black");
          getLongTextView(p).setTextColor(
              getResources().getColor(R.color.black));
        } else {
          Log.d(TAG, "setting long " + p + " to white");
          getLongTextView(p).setTextColor(
              getResources().getColor(R.color.white));
        }
      }
    });
  }

  @Override
  public void onUpdateMessage(String s, int i) {
    EditText et = (EditText) findViewById(R.id.message_data);
    if(et == null)
      return;
    et.setText(s);
    et.setSelection(i);
  }

  @Override
  public void onShortInfoUpdate(String[] s) {
    mShortListener.onUpdateInfo(s);
  }

  @Override
  public void onLongInfoUpdate(String[] s) {
    mLongListener.onUpdateInfo(s);
  }

  @Override
  public void onUpdateDisplay() {
    getFragmentManager().beginTransaction().detach(longFrag).attach(longFrag)
        .detach(shortFrag).attach(shortFrag).commit();
  }

  @Override
  public void onSendSMS(String t, String n) {
    sendSMS(t, n);
  }
}
