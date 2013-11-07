package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.fbip.FourButtonsFragment.PRESS_ID;
import il.ac.technion.yptnine.fbip.FourButtonsFragment.PRESS_TYPE;

import il.ac.technion.yptnine.fbip.R;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {
	
	private StateMachine stateMachine;
	
	private LongPressInfoFragment longFrag;
	private BodyFragment bodyFrag;
	private ShortPressInfoFragment shortFrag;
	private FourButtonsFragment buttonsFrag;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MAIN", "setting view");
        setContentView(R.layout.activity_main);
        
        stateMachine = new StateMachine(this);
        
        Log.d("MAIN", "adding fragments");
    	longFrag = new LongPressInfoFragment();
    	getFragmentManager().beginTransaction().add(R.id.long_press_info_frame, longFrag).commit();
    	
    	bodyFrag = new BodyFragment();
    	getFragmentManager().beginTransaction().add(R.id.main_frame, bodyFrag).commit();
    	
    	shortFrag = new ShortPressInfoFragment();
    	getFragmentManager().beginTransaction().add(R.id.short_press_info_frame, shortFrag).commit();
    	
    	buttonsFrag = FourButtonsFragment.newInstance(stateMachine);
    	getFragmentManager().beginTransaction().add(R.id.buttons_frame, buttonsFrag).commit();
    	
    	stateMachine.start();
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
		getFragmentManager().beginTransaction().detach(longFrag).attach(longFrag)
				.detach(shortFrag).attach(shortFrag).commit();
	}
    
}
