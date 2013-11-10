package il.ac.technion.yptnine.fbip;

import il.ac.technion.yptnine.fbip.FourButtonsFragment.PressID;
import il.ac.technion.yptnine.fbip.FourButtonsFragment.PressType;
import il.ac.technion.yptnine.fbip.MainActivity.BodyFragment;

public class State {
	String[] longText = new String[4];
	String[] shortText = new String[4];
	BodyFragment frag;
	State[][] next = new State[2][4];
	public State(String[] shortText, String[] longText, BodyFragment frag) {
		this.shortText = shortText;
		this.longText = longText;
		this.frag = frag;
	}
	public void setNext(PressType type, PressID id, State next) {
		this.next[type.ordinal()][id.ordinal()] = next;
	}
}
