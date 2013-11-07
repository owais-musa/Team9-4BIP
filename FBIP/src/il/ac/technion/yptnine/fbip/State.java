package il.ac.technion.yptnine.fbip;

public class State {
	String[] longText = new String[4];
	String[] shortText = new String[4];
	State[][] next = new State[2][4];
	public State(String[] shortText, String[] longText) {
		this.shortText = shortText;
		this.longText = longText;
	}
	public void setNext(FourButtonsFragment.PRESS_TYPE type, FourButtonsFragment.PRESS_ID id, State next) {
		this.next[type.ordinal()][id.ordinal()] = next;
	}
}
