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
		
		if (iCursorPossition != 8 ||
				!MessageText.equals(" !!tes:(t:)")){
			fail();
		}
		
	}
	
	static public void testInsertChars() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("good test:)");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 11 || !MessageText.equals("good test:)")){
			fail();
		}
		
		for (int i=0; i<5; i++)
			Message.MoveCurserToTheLeft();
		Message.InsertChars("!!!!");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 10 ||
				!MessageText.equals("good t!!!!est:)")){
			fail();
		}
	}
	
	static public void testDeletetChar() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("good test:)");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 11 ||
				!MessageText.equals("good test:)")){
			fail();
		}
		
		for (int i=0; i< 5; i++)
			Message.DeletetChar();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 6 || !MessageText.equals("good t")){
			fail();
		}
		
		for (int i=0; i<10; i++)
			Message.MoveCurserToTheLeft(); // now cursor = 0
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("good t")){
			fail();
		}
		
		for (int i=0; i< 5; i++)
			Message.DeletetChar(); // do nothing!
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("good t")){
			fail();
		}
		
		Message.DeleteAll();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		for (int i=0; i< 5; i++)
			Message.DeletetChar(); // do nothing!
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
	}
	
	static public void testMoveCurserToTheRightAndLeft() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		for (int i=0; i<20; i++)
			Message.MoveCurserToTheRight(); // do nothing!
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		for (int i=0; i<20; i++)
			Message.MoveCurserToTheLeft(); // do nothing!
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("my test!!!");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 10 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
		for (int i=0; i<20; i++)
			Message.MoveCurserToTheRight(); // do nothing!
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 10 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
		for (int i=0; i<5; i++)
			Message.MoveCurserToTheLeft();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 5 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
		for (int i=0; i<4; i++)
			Message.MoveCurserToTheRight();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 9 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
		for (int i=0; i<5; i++)
			Message.MoveCurserToTheRight();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 10 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
		for (int i=0; i<50; i++)
			Message.MoveCurserToTheLeft();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
		Message.MoveCurserToTheRight();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 1 ||
				!MessageText.equals("my test!!!")){
			fail();
		}
		
	}
	
	static public void testDeleteAll() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("good test:)");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 11 ||
				!MessageText.equals("good test:)")){
			fail();
		}
		
		Message.DeleteAll();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		for (int i=0; i<5; i++)
			Message.DeleteAll(); // do nothing!
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("interesting test!");
		for (int i=0; i<10; i++)
			Message.MoveCurserToTheLeft();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 7 ||
				!MessageText.equals("interesting test!")){
			fail();
		}
		
		Message.DeleteAll();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
	}
	
	static public void testUndoLastOp() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.UndoLastOp(); // do nothing
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 ||
				!MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("interesting test");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 16 ||
				!MessageText.equals("interesting test")){
			fail();
		}
		
		Message.UndoLastOp();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 ||
				!MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("interesting test");
		for (int i=0; i<10; i++)
			Message.MoveCurserToTheLeft();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 6 ||
				!MessageText.equals("interesting test")){
			fail();
		}
		
		Message.UndoLastOp();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 7 ||
				!MessageText.equals("interesting test")){
			fail();
		}
		
		Message.DeleteAll();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 0 ||
				!MessageText.equals("")){
			fail();
		}
		
		Message.UndoLastOp();
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 7 ||
				!MessageText.equals("interesting test")){
			fail();
		}
		
	}
	
	static public void testGetCursorPossition() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("simple test");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 11 ||
				!MessageText.equals("simple test")){
			fail();
		}
	}
	
	static public void testGetText() throws Exception {
		TextController Message = new TextController();
		
		int iCursorPossition = Message.GetCursorPossition();
		String MessageText = Message.GetText();
		
		if (iCursorPossition != 0 || !MessageText.equals("")){
			fail();
		}
		
		Message.InsertChars("simple test");
		
		iCursorPossition = Message.GetCursorPossition();
		MessageText = Message.GetText();
		
		if (iCursorPossition != 11 ||
				!MessageText.equals("simple test")){
			fail();
		}
	}
}
