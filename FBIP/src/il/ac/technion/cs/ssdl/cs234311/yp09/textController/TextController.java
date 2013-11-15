package il.ac.technion.cs.ssdl.cs234311.yp09.textController;

import java.util.ArrayList;
import java.util.List;

public class TextController {
  private List<Character> m_rgText;
  private int m_iCursorPossition;

  // For the Undo operation, save data before the each edit
  private List<Character> m_rgPrevText;
  private int m_iPrevCursorPossition;

  private void SaveData() {
    m_rgPrevText = new ArrayList<Character>(m_rgText);
    m_iPrevCursorPossition = m_iCursorPossition;
  }

  public TextController() {
    m_rgText = new ArrayList<Character>();
    m_iCursorPossition = 0;
  }

  public void InsertChars(String in_NewString) {
    assert (m_iCursorPossition >= 0 && m_iCursorPossition <= m_rgText.size());
    SaveData();

    for(int i = 0; i < in_NewString.length(); i++) {
      m_rgText.add(m_iCursorPossition, in_NewString.charAt(i));
      m_iCursorPossition++;
    }
  }

  public void InsertChar(char in_NewChar) {
    assert (m_iCursorPossition >= 0 && m_iCursorPossition <= m_rgText.size());
    SaveData();

    m_rgText.add(m_iCursorPossition, in_NewChar);
    m_iCursorPossition++;
  }

  public void DeletetChar() {
    assert (m_iCursorPossition >= 0 && m_iCursorPossition <= m_rgText.size());
    SaveData();

    if(m_iCursorPossition == 0) {
      return;
    }

    m_rgText.remove(m_iCursorPossition - 1);
    m_iCursorPossition--;
  }

  public void MoveCurserToTheRight() {
    assert (m_iCursorPossition >= 0 && m_iCursorPossition <= m_rgText.size());
    SaveData();

    if(m_iCursorPossition == m_rgText.size()) {
      return;
    }

    m_iCursorPossition++;
  }

  public void MoveCurserToTheLeft() {
    assert (m_iCursorPossition >= 0 && m_iCursorPossition <= m_rgText.size());
    SaveData();

    if(m_iCursorPossition == 0) {
      return;
    }

    m_iCursorPossition--;
  }

  public void DeleteAll() {
    SaveData();
    m_rgText = new ArrayList<Character>(1);
    m_iCursorPossition = 0;
  }

  public void UndoLastOp() {
    if(m_rgPrevText == null) {
      return;
    }
    m_rgText = m_rgPrevText;
    m_iCursorPossition = m_iPrevCursorPossition;

    m_rgPrevText = null;
    m_iPrevCursorPossition = 0;
  }

  public int GetCursorPossition() {
    return m_iCursorPossition;
  }

  public String GetText() {
    String Str = new String();

    for(int i = 0; i < m_rgText.size(); i++) {
      Str += m_rgText.get(i);
    }

    return Str;
  }

}
