package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

import java.util.ArrayList;
import java.util.Locale;


public class LettersState extends State {
	
	private boolean lowerCase = true;

	public LettersState(String[] abc, boolean lCase){
		if(lCase){
			for(int i = 0; i < 4; i++){
				shortPress[i] = Parser.findContent(abc, 0, abc.length - 1, i, 4).toLowerCase(Locale.ENGLISH);
			}
			lowerCase = true;
			longPress[3] = "A";
		}
		else{
			for(int i = 0; i < 4; i++){
				shortPress[i] = Parser.findContent(abc, 0, abc.length - 1, i, 4).toUpperCase(Locale.ENGLISH);
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
		if(shortPress[i-1].equals("")){
			/* In case some of the windows are empty.
			 * For example: having 3 letters to be shown on 4 windows.
			 * I solved the issue by remaining in the same state.
			 */
			return this;
		}
		else if(size == 1){
			Controller.m_Message.InsertChar(shortPress[i-1].charAt(0));
			return new KeyboardState();
		}
		else{
			String [] choosenItems = shortPress[i-1].split(" ");
			return new LettersState(choosenItems, lowerCase);
		}
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
		ArrayList<String> content = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++){
			String [] temp = shortPress[i].split(" ");
			for(int j = 0; j < temp.length; j++){
				content.add(temp[j]);
			}
		}
		
		String[] items = new String[content.size()];
		
		for(int i = 0; i < content.size(); i++){
			items[i] = content.get(i);
		}
		
		return new LettersState(items, lowerCase);
	}

}
