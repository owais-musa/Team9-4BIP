package il.ac.technion.cs.ssdl.cs234311.yp09.textController;

import junit.framework.TestCase;

/**
 * Test class for TextController
 * 
 * @date 11/10/2013
 * @email owais.musa@gmail.com
 * @author Owais Musa
 * 
 */
public class TextControllerTest extends TestCase {

  /**
   * Testing the method insertChar
   */
  static public void testInsertChar() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChar(' ');

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 1 || !MessageText.equals(" "))
      fail();

    Message.insertChar('!');
    Message.insertChar('!');
    Message.insertChar('t');
    Message.insertChar('e');
    Message.insertChar('s');
    Message.insertChar('t');
    Message.insertChar(':');
    Message.insertChar(')');

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 9 || !MessageText.equals(" !!test:)"))
      fail();

    Message.moveCurserToTheLeft();
    Message.moveCurserToTheLeft();
    Message.moveCurserToTheLeft();

    Message.insertChar(':');
    Message.insertChar('(');

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 8 || !MessageText.equals(" !!tes:(t:)"))
      fail();

  }

  /**
   * Testing the method insertChars
   */
  static public void testInsertChars() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("good test:)");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 11 || !MessageText.equals("good test:)"))
      fail();

    for (int i = 0; i < 5; i++)
      Message.moveCurserToTheLeft();
    Message.insertChars("!!!!");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 10 || !MessageText.equals("good t!!!!est:)"))
      fail();
  }

  /**
   * Testing the method deleteChar
   */
  static public void testDeletetChar() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("good test:)");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 11 || !MessageText.equals("good test:)"))
      fail();

    for (int i = 0; i < 5; i++)
      Message.deletetChar();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 6 || !MessageText.equals("good t"))
      fail();

    for (int i = 0; i < 10; i++)
      Message.moveCurserToTheLeft(); // now cursor = 0

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals("good t"))
      fail();

    for (int i = 0; i < 5; i++)
      Message.deletetChar(); // do nothing!

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals("good t"))
      fail();

    Message.deleteAll();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    for (int i = 0; i < 5; i++)
      Message.deletetChar(); // do nothing!

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

  }

  /**
   * Testing the method moveCursorToTheRight and moveCursorToTheLeft
   */
  static public void testMoveCurserToTheRightAndLeft() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    for (int i = 0; i < 20; i++)
      Message.moveCurserToTheRight(); // do nothing!

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    for (int i = 0; i < 20; i++)
      Message.moveCurserToTheLeft(); // do nothing!

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("my test!!!");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 10 || !MessageText.equals("my test!!!"))
      fail();

    for (int i = 0; i < 20; i++)
      Message.moveCurserToTheRight(); // do nothing!

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 10 || !MessageText.equals("my test!!!"))
      fail();

    for (int i = 0; i < 5; i++)
      Message.moveCurserToTheLeft();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 5 || !MessageText.equals("my test!!!"))
      fail();

    for (int i = 0; i < 4; i++)
      Message.moveCurserToTheRight();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 9 || !MessageText.equals("my test!!!"))
      fail();

    for (int i = 0; i < 5; i++)
      Message.moveCurserToTheRight();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 10 || !MessageText.equals("my test!!!"))
      fail();

    for (int i = 0; i < 50; i++)
      Message.moveCurserToTheLeft();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals("my test!!!"))
      fail();

    Message.moveCurserToTheRight();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 1 || !MessageText.equals("my test!!!"))
      fail();

  }

  /**
   * Testing the method deleteAll
   */
  static public void testDeleteAll() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("good test:)");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 11 || !MessageText.equals("good test:)"))
      fail();

    Message.deleteAll();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    for (int i = 0; i < 5; i++)
      Message.deleteAll(); // do nothing!

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("interesting test!");
    for (int i = 0; i < 10; i++)
      Message.moveCurserToTheLeft();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 7 || !MessageText.equals("interesting test!"))
      fail();

    Message.deleteAll();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

  }

  /**
   * Testing the method undoLastOp
   */
  static public void testUndoLastOp() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.undoLastOp(); // do nothing

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("interesting test");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 16 || !MessageText.equals("interesting test"))
      fail();

    Message.undoLastOp();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("interesting test");
    for (int i = 0; i < 10; i++)
      Message.moveCurserToTheLeft();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 6 || !MessageText.equals("interesting test"))
      fail();

    Message.undoLastOp();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 7 || !MessageText.equals("interesting test"))
      fail();

    Message.deleteAll();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.undoLastOp();

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 7 || !MessageText.equals("interesting test"))
      fail();

  }

  /**
   * Testing the method getCursorPosition
   */
  static public void testGetCursorPosition() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("simple test");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 11 || !MessageText.equals("simple test"))
      fail();
  }

  /**
   * Testing the method getText
   */
  static public void testGetText() {
    final TextController Message = new TextController();

    int iCursorPossition = Message.getCursorPosition();
    String MessageText = Message.getText();

    if (iCursorPossition != 0 || !MessageText.equals(""))
      fail();

    Message.insertChars("simple test");

    iCursorPossition = Message.getCursorPosition();
    MessageText = Message.getText();

    if (iCursorPossition != 11 || !MessageText.equals("simple test"))
      fail();
  }
}
