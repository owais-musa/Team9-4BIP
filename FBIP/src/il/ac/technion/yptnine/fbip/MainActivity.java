package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.controller.Controller;
import il.ac.technion.yptnine.fbip.R;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.app.Activity;
import android.app.FragmentTransaction;

public class MainActivity extends Activity {

	public static enum BodyFragment {
		HELP_FRAG,
		MESSAGE_FRAG,
		PROTOCOL_FRAG,
		SETTINGS_FRAG;
	}
	private Controller m_Controller;

	private LongPressInfoFragment longFrag;
	
	private HelpFragment helpFrag;
	private MessageFragment messageFrag;
	private ProtocolFragment protocolFrag;
	private SettingsFragment settingsFrag;
	
	private ShortPressInfoFragment shortFrag;
	private FourButtonsFragment buttonsFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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

		buttonsFrag = FourButtonsFragment.newInstance(m_Controller);
		getFragmentManager().beginTransaction()
		        .add(R.id.buttons_frame, buttonsFrag).commit();

		m_Controller.Start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
}
