package il.ac.technion.cs.ssdl.cs234311.yp09.textController;

import java.util.ArrayList;
import java.util.List;

/**
 * A data structure that represents the message text
 * 
 * @date 11/4/2013
 * @email owais.musa@gmail.com
 * @author Owais Musa
 * 
 */
public class TextController {
  private List<Character> m_text;
  private int m_cursorPosition;

  // For the Undo operation, save data before each edit
  private List<Character> m_prevText;
  private int m_prevCursorPosition;

  private void saveData() {
    m_prevText = new ArrayList<Character>(m_text);
    m_prevCursorPosition = m_cursorPosition;
  }

  /**
   * constructs the class with an empty text
   */
  public TextController() {
    m_text = new ArrayList<Character>();
    m_cursorPosition = 0;
  }

  /**
   * inserts list of chars to the text starting the the current cursor position
   * 
   * @param in_newString
   *          the string to be added
   */
  public void insertChars(final String in_newString) {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    for (int i = 0; i < in_newString.length(); i++) {
      final Character NewChar = Character.valueOf(in_newString.charAt(i));
      m_text.add(m_cursorPosition, NewChar);
      m_cursorPosition++;
    }
  }

  /**
   * inserts a new character to the text at the current cursor position
   * 
   * @param in_newChar
   *          the new character to be added to the text
   */
  public void insertChar(final char in_newChar) {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    m_text.add(m_cursorPosition, Character.valueOf(in_newChar));
    m_cursorPosition++;
  }

  /**
   * deletes the character behind the cursor
   */
  public void deletetChar() {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    if (m_cursorPosition == 0)
      return;

    m_text.remove(m_cursorPosition - 1);
    m_cursorPosition--;
  }

  /**
   * moves the cursor one step to the right
   */
  public void moveCurserToTheRight() {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    if (m_cursorPosition == m_text.size())
      return;

    m_cursorPosition++;
  }

  /**
   * moves the cursor one step to the left
   */
  public void moveCurserToTheLeft() {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    if (m_cursorPosition == 0)
      return;

    m_cursorPosition--;
  }

  /**
   * deletes all the text, the text after this operation will be empty
   */
  public void deleteAll() {
    saveData();
    m_text = new ArrayList<Character>(1);
    m_cursorPosition = 0;
  }

  /**
   * undo the last operation was done on the text
   */
  public void undoLastOp() {
    if (m_prevText == null)
      return;

    m_text = m_prevText;
    m_cursorPosition = m_prevCursorPosition;

    m_prevText = null;
    m_prevCursorPosition = 0;
  }

  /**
   * getter to the field that represents the cursor position
   * 
   * @return the cursor position
   */
  public int getCursorPossition() {
    return m_cursorPosition;
  }

  /**
   * returns the text as string
   * 
   * @return the text string
   */
  public String getText() {
    String Str = new String();

    for (int i = 0; i < m_text.size(); i++)
      Str += m_text.get(i);

    return Str;
  }

}
