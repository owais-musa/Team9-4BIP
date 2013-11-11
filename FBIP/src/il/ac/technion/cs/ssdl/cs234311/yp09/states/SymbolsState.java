package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;


public class SymbolsState extends State {
	
	public SymbolsState(String[] symbols, boolean levelOne){
		if(levelOne){
			shortPress[0] = Parser.findHighPrioContent(symbols, 0, 3);
			shortPress[1] = Parser.findContent(symbols, 4, symbols.length - 1, 0, 3); 
			shortPress[2] = Parser.findContent(symbols, 4, symbols.length - 1, 1, 3);
			shortPress[3] = Parser.findContent(symbols, 4, symbols.length - 1, 2, 3);
		}
		else{
			for(int i = 0; i < 4; i++){
				shortPress[i] = Parser.findContent(symbols, 0, symbols.length - 1, i, 4);
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
		return shortOpLogic(2);
	}

	@Override
	public State onShort3Press() {
		return shortOpLogic(3);
	}

	@Override
	public State onShort4Press() {
		return shortOpLogic(4);
	}
	
	public State shortOpLogic(int i){
		int size = shortPress[i-1].split(" ").length; 
		if(size == 0){
			/* In case some of the windows are empty.
			 * For example: having 3 numbers to be shown on 4 windows.
			 * I solved the issue by remaining in the same state.
			 */
			return this;
		}
		else if(size == 1){
			if (shortPress[i-1].equals("space"))
				Controller.m_Message.InsertChar(' ');
			else
				Controller.m_Message.InsertChar(shortPress[i-1].charAt(0));
			return new KeyboardState();
		}
		else{
			String [] choosenItems = shortPress[i-1].split(" ");
			return new SymbolsState(choosenItems, false);
		}
	}

	// Back
	@Override
	public State onLong1Press() {
		return new KeyboardState();
	}

	// :-)
	@Override
	public State onLong2Press() {
		return new SmileysState(KeyboardState.smileys);
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
