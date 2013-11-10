package il.ac.technion.yptnine.states;

import java.util.Locale;


public class LettersState extends State {
	
	private boolean lowerCase = true;

	public LettersState(String abc, boolean lowerCase){
		if(lowerCase){
			for(int i = 0; i < 4; i++){
				shortPress[i] = Parser.splitEqually(abc, i, 4).toLowerCase(Locale.ENGLISH);
			}
			lowerCase = true;
			longPress[3] = "A";
		}
		else{
			for(int i = 0; i < 4; i++){
				shortPress[i] = Parser.splitEqually(abc, i, 4).toUpperCase(Locale.ENGLISH);
			}
			lowerCase = false;
			longPress[3] = "a";
		}
		
		longPress[0] = "Back";
		longPress[1] = "UNUSED";
		longPress[2] = "Lang";
		
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
		int size = shortPress[i-1].length(); 
		if(size == 0){
			/* In case some of the windows are empty.
			 * For example: having 3 letters to be shown on 4 windows.
			 * I solved the issue by remaining in the same state.
			 */
			return this;
		}
		else if(size == 1){
			// Owais: message.add(shortPress[i][0]);
			return new KeyboardState();
		}
		else
			return new LettersState(shortPress[i-1], lowerCase);
	}

	// Back
	@Override
	public State onLong1Press() {
		return new KeyboardState();
	}
	
	// UNUSED
	@Override
	public State onLong2Press() {
		// Button is UNUSED in the first iteration
		return this;
	}
	
	// Lang
	@Override
	public State onLong3Press() {
		// We support only the English language for the first iteration
		return this;
	}

	// A/a - upper/lower case format.
	@Override
	public State onLong4Press() {
		lowerCase = !lowerCase;
		String content = "";
		
		for(int i = 0; i < 4; i++){
			content += shortPress[i];
		}
		
		return new LettersState(content, lowerCase);
	}

}
