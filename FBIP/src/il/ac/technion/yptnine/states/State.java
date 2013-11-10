package il.ac.technion.yptnine.states;

public abstract class State {
	
	public String[] shortPress = new String[4];
	public String[] longPress = new String[4];
	
	// The lower operations (triggered in 0.5 - 2 seconds)
	public abstract State onShort1Press();
	public abstract State onShort2Press();
	public abstract State onShort3Press();
	public abstract State onShort4Press();
	
	// The upper operations (triggered in 2+ seconds)
	public abstract State onLong1Press();
	public abstract State onLong2Press();
	public abstract State onLong3Press();
	public abstract State onLong4Press();
}
