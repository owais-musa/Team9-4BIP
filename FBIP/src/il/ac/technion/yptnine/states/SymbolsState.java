package il.ac.technion.yptnine.states;

public class SymbolsState extends State {
	
	public SymbolsState(String symbols, boolean levelOne){
		
		if(levelOne){
			shortPress[0] = symbols.substring(0, 4);
			shortPress[1] = Parser.splitEqually(symbols + 4, 0, 3);
			shortPress[1] = Parser.splitEqually(symbols + 4, 1, 3);
			shortPress[1] = Parser.splitEqually(symbols + 4, 2, 3);
		}
		else{
			for(int i = 0; i < 4; i++){
				shortPress[i] = Parser.splitEqually(symbols, i, 4);
			}
		}
		
		longPress[0] = "Back";
		longPress[1] = ":-)";
		longPress[2] = "UNUSED";
		longPress[3] = "UNUSED";
	}

	@Override
	public State onShort1Press() {
		return shortOpLogic(1);
	}

	@Override
	public State onShort2Press() {
		return shortOpLogic(1);
	}

	@Override
	public State onShort3Press() {
		return shortOpLogic(1);
	}

	@Override
	public State onShort4Press() {
		return shortOpLogic(1);
	}
	
	public State shortOpLogic(int i){
		int size = shortPress[i-1].length(); 
		if(size == 0){
			/* In case some of the windows are empty.
			 * For example: having 3 numbers to be shown on 4 windows.
			 * I solved the issue by remaining in the same state.
			 */
			return this;
		}
		else if(size == 1){
			// Owais: message.add(shortPress[i][0]);
			return new KeyboardState();
		}
		else
			return new SymbolsState(shortPress[i-1], false);
	}

	// Back
	@Override
	public State onLong1Press() {
		return new KeyboardState();
	}

	// :-)
	@Override
	public State onLong2Press() {
		// Smileys are NOT supported in the first iteration.
		return this;
	}

	// UNUSED
	@Override
	public State onLong3Press() {
		// Button is UNUSED in the first iteration
		return this;
	}

	// UNUSED
	@Override
	public State onLong4Press() {
		// Button is UNUSED in the first iteration
		return this;
	}

}
