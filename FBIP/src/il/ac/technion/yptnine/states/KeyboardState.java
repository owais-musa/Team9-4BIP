package il.ac.technion.yptnine.states;

import il.ac.technion.yptnine.controller.Controller;

public class KeyboardState extends State {
	
	public static String[] abc = {"a", "b", "c", "d", "e", "f", "g", 
								  "h", "i", "j", "k", "l", "m", "n", 
								  "o", "p", "q", "r", "s", "t", "u", 
								  "v", "w", "x", "y", "z" };
	public static String[] numbers = {"0", "1", "2", "3", 
									  "4", "5", "6", "7", 
									  "8", "9" };
	public static String[] symbols = {"space", ".", ",", "?", "-", "!", 
									  "@", "_", "/", "(", ")", "&", 
									  ":", ";", "$", "`", "<", ">", 
									  "^", "~", "[", "]", "{", "}", 
									  "\"", "+", "%", "=", "#", "*", 
									  "\\", "|", "'" };
	public static String[] smileys = {":)", ":(", ";)", ":D", 
		                              ":p", ":-)", ":-(", ":|"};
	
	
	public KeyboardState(){
		shortPress[0] = "Letters";
		shortPress[1] = "Numbers";
		shortPress[2] = "Symbols";
		shortPress[3] = "Operations";
		
		longPress[0] = "Back";
		longPress[1] = "Done";
		longPress[2] = "<--";
		longPress[3] = "-->";
	}
	
	// Letters
	@Override
	public State onShort1Press() {
		return new LettersState(abc, true);
	}

	// Numbers
	@Override
	public State onShort2Press() {
		return new NumbersState(numbers);
	}

	// Symbols
	@Override
	public State onShort3Press() {
		return new SymbolsState(symbols, true);
	}

	// Operations
	@Override
	public State onShort4Press() {
		return new OperationsState();
	}

	// Back
	@Override
	public State onLong1Press() {
		return new MainState();
	}

	// Done
	@Override
	public State onLong2Press() {
		// OWAIS : message.done();
		return new MainState();
	}

	// <--
	@Override
	public State onLong3Press() {
		Controller.m_Message.MoveCurserToTheLeft();
		return this;
	}

	// -->
	@Override
	public State onLong4Press() {
		Controller.m_Message.MoveCurserToTheRight();
		return this;
	}

}
