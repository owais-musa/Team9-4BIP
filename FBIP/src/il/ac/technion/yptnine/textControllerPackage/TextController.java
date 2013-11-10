package il.ac.technion.yptnine.textControllerPackage;


import java.util.ArrayList;
import java.util.List;


public class TextController {
	private List<Character> m_rgText;
	private int m_iCursorPossition;
	
	// For the Undo operation, save data before the each edit
	private List<Character> m_rgPrevText;
	private int m_iPrevCursorPossition;
	
	private void SaveData(){
		m_rgPrevText = new ArrayList<Character>(m_rgText);
		m_iPrevCursorPossition = m_iCursorPossition;
	}
	
	public TextController(){
		m_rgText = new ArrayList<Character>(1);
		//m_rgText.set(0, ' ');
		m_iCursorPossition = 0;
	}
	
	public void InsertChar(char in_NewChar) {
		assert(m_iCursorPossition >= 0 && m_iCursorPossition < m_rgText.size());
		SaveData();
		
		m_rgText.set(m_iCursorPossition, in_NewChar);
		
		if (m_iCursorPossition == m_rgText.size() - 1){
			m_rgText.add(' ');
		}
	}
	
	public void DeletetChar() {
		assert(m_iCursorPossition >= 0 && m_iCursorPossition < m_rgText.size());
		SaveData();
		
		if (m_iCursorPossition == 0){
			return;
		}
		
		m_rgText.remove(m_iCursorPossition - 1);
	}
	
	public void MoveCurserToTheRight() {
		assert(m_iCursorPossition >= 0 && m_iCursorPossition < m_rgText.size());
		SaveData();
		
		if (m_iCursorPossition == m_rgText.size() - 1){
			return;
		}
		
		m_iCursorPossition++;
	}
	
	public void MoveCurserToTheLeft() {
		assert(m_iCursorPossition >= 0 && m_iCursorPossition < m_rgText.size());
		SaveData();
		
		if (m_iCursorPossition == 0){
			return;
		}
		
		m_iCursorPossition--;
	}
	
	public void DeleteAll() {
		SaveData();
		m_rgText = new ArrayList<Character>(1);
		m_rgText.set(1, ' ');
		m_iCursorPossition = 0;
	}
	
	public void UndoLastOp() {
		if (m_rgPrevText == null){
			return;
		}
		m_rgText = m_rgPrevText;
		m_iCursorPossition = m_iPrevCursorPossition;
			
		m_rgPrevText = null;
		m_iPrevCursorPossition = 0;
	}
	
	public int GetCursorPossition(){
		return m_iCursorPossition;
	}
	
	public String GetText(){
		return m_rgText.toString();
	}	
	
}


