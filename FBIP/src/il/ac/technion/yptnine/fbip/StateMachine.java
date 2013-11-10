package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.fbip.FourButtonsFragment.PressID;
import il.ac.technion.yptnine.fbip.FourButtonsFragment.PressType;
import il.ac.technion.yptnine.fbip.MainActivity.BodyFragment;

import java.io.Serializable;

public class StateMachine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242079014671416782L;
	private State current;
	private MainActivity main;
	
	private State state1 = new State(new String[] {"S1_1", "S1_2", "S1_3", "S1_4"},
			new String[] {"L1_1", "L1_2", "L1_3", "L1_4"},
			BodyFragment.MESSAGE_FRAG);
	private State state2 = new State(new String[] {"S2_1", "S2_2", "S2_3", "S2_4"},
			new String[] {"L2_1", "L2_2", "L2_3", "L2_4"},
			BodyFragment.PROTOCOL_FRAG);
	public StateMachine(MainActivity main) {
		this.main = main;
		current = state1;
		state1.setNext(PressType.SHORT_PRESS, PressID.BLUE_PRESS, state2);
	}
	
	public void setState(State state) {
		current = state;
		if(state != null) {
			main.setShortPressInfo(state.shortText);
			main.setLongPressInfo(state.longText);
			main.setBodyFragment(state.frag);
			main.updateDisplay();
		}
	}
	
	public void changeState(PressType type, PressID id) {
		if(current != null) {
			current = current.next[type.ordinal()][id.ordinal()];
			setState(current);
		}
	}

	public void start() {
		setState(state1);
	}
}
