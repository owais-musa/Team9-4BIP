package il.ac.technion.cs.ssdl.cs234311.yp09.textController;

import junit.framework.TestCase;

public class TextControllerTest extends TestCase {
	static public void testInsertChar() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChar(' ');
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 1 || !MessageText.equals(" ")){
			fail();
		}
		
		Message.InsertChar('!');
		Message.InsertChar('!');
		Message.InsertChar('t');
		Message.InsertChar('e');
		Message.InsertChar('s');
		Message.InsertChar('t');
		Message.InsertChar(':');
		Message.InsertChar(')');
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 9 ||
				!MessageText.equals(" !!test:)")){
			fail();
		}
		
		Message.MoveCurserToTheLeft();
		Message.MoveCurserToTheLeft();
		Message.MoveCurserToTheLeft();
		
		Message.InsertChar(':');
		Message.InsertChar('(');
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 11 ||
				!MessageText.equals(" !!tes:(t:)")){
			fail();
		}
		
	}
	
	static public void testInsertChars() throws Exception {
		/*
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		*/
		
		fail();
	}
	
	static public void testDeletetChar() throws Exception {
		fail();
	}
	
	static public void testMoveCurserToTheRight() throws Exception {
		fail();
	}
	
	static public void testMoveCurserToTheLeft() throws Exception {
		fail();
	}
	
	static public void testDeleteAll() throws Exception {
		fail();
	}
	
	static public void testUndoLastOp() throws Exception {
		fail();
	}
	
	static public void testGetCursorPossition() throws Exception {
		fail();
	}
	
	static public void testGetText() throws Exception {
		fail();
	}
}
