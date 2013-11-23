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

  private final boolean m_justNumbers;

  private void saveData() {
    m_prevText = new ArrayList<Character>(m_text);
    m_prevCursorPosition = m_cursorPosition;
  }

  private static boolean isNumber(final char in_char) {
    final int value = in_char - '0';

    if (value >= 0 && value <= 9)
      return true;

    return false;
  }

  private static boolean containsJustNumbers(final String in_string) {
    for (int i = 0; i < in_string.length(); i++)
      if (!isNumber(in_string.charAt(i)))
        return false;

    return true;
  }

  /**
   * 
   * @author Owais Musa
   * 
   */
  public static class JustNumbersException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

  }

  /**
   * Constructs the class with an empty text
   * 
   * @param in_justNumbers
   *          true if and only if this text will contain just numbers
   */
  public TextController(final boolean in_justNumbers) {
    m_justNumbers = in_justNumbers;

    m_text = new ArrayList<Character>();
    m_cursorPosition = 0;
  }

  /**
   * Inserts list of chars to the text starting the the current cursor position
   * 
   * @param in_newString
   *          The string to be added
   * @throws JustNumbersException
   */
  public void insertChars(final String in_newString)
      throws JustNumbersException {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    if (m_justNumbers && !containsJustNumbers(in_newString))
      throw new JustNumbersException();

    saveData();

    for (int i = 0; i < in_newString.length(); i++) {
      final Character NewChar = Character.valueOf(in_newString.charAt(i));
      m_text.add(m_cursorPosition, NewChar);
      m_cursorPosition++;
    }
  }

  /**
   * Inserts a new character to the text at the current cursor position
   * 
   * @param in_newChar
   *          The new character to be added to the text
   * @throws JustNumbersException
   */
  public void insertChar(final char in_newChar) throws JustNumbersException {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    if (m_justNumbers && !isNumber(in_newChar))
      throw new JustNumbersException();

    saveData();

    m_text.add(m_cursorPosition, Character.valueOf(in_newChar));
    m_cursorPosition++;
  }

  /**
   * Deletes the character behind the cursor
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
   * Moves the cursor one step to the right
   */
  public void moveCurserToTheRight() {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    if (m_cursorPosition == m_text.size())
      return;

    m_cursorPosition++;
  }

  /**
   * Moves the cursor one step to the left
   */
  public void moveCurserToTheLeft() {
    assert m_cursorPosition >= 0 && m_cursorPosition <= m_text.size();
    saveData();

    if (m_cursorPosition == 0)
      return;

    m_cursorPosition--;
  }

  /**
   * Deletes all the text, the text after this operation will be empty
   */
  public void deleteAll() {
    saveData();
    m_text = new ArrayList<Character>(1);
    m_cursorPosition = 0;
  }

  /**
   * Undo the last operation was done on the text
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
   * Getter to the field that represents the cursor position
   * 
   * @return The cursor position
   */
  public int getCursorPosition() {
    return m_cursorPosition;
  }

  /**
   * Returns the text as string
   * 
   * @return The text string
   */
  public String getText() {
    String $ = new String();

    for (int i = 0; i < m_text.size(); i++)
      $ += m_text.get(i);

    return $;
  }

}
