package il.ac.technion.yptnine.controller;
import java.io.Serializable;

import il.ac.technion.yptnine.fbip.MainActivity;
import il.ac.technion.yptnine.fbip.FourButtonsFragment.PressID;
import il.ac.technion.yptnine.fbip.FourButtonsFragment.PressType;
import il.ac.technion.yptnine.fbip.MainActivity.BodyFragment;
import il.ac.technion.yptnine.states.MainState;
import il.ac.technion.yptnine.states.State;
import il.ac.technion.yptnine.textControllerPackage.TextController;


public class Controller implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242079014671416782L;

	static public TextController m_Message = new TextController();
	
	static private MainActivity m_MainActivity;
	static private State m_CurrentState;
	
	public Controller(MainActivity in_MainActivity){
		m_MainActivity = in_MainActivity;
		m_CurrentState = new MainState();
	}
	
	
	// Temp solution for the bug of the upper fragment disappearance 
	boolean m_fAccessedMessageFragment = true;
	
	public void displayState(State m_State) {
		assert(m_State != null);
		
		m_CurrentState = m_State;
		
		m_MainActivity.setShortPressInfo(m_CurrentState.shortPress);
		m_MainActivity.setLongPressInfo(m_CurrentState.longPress);
		if (m_fAccessedMessageFragment == true){
			m_fAccessedMessageFragment = false;
			m_MainActivity.setBodyFragment(BodyFragment.MESSAGE_FRAG);
		}

		m_MainActivity.UpdateMessage(m_Message.GetText()
				, m_Message.GetCursorPossition());
		m_MainActivity.updateDisplay();
	}

	public void start() {
		displayState(m_CurrentState);
	}
	
	public void clickOn(ControllerPressType in_pressType){
		State nextState = null;
		
		switch (in_pressType) {
		case SHORT_PRESS1:
			nextState = m_CurrentState.onShort1Press();
			break;
		case SHORT_PRESS2:
			nextState = m_CurrentState.onShort2Press();
			break;
		case SHORT_PRESS3:
			nextState = m_CurrentState.onShort3Press();
			break;
		case SHORT_PRESS4:
			nextState = m_CurrentState.onShort4Press();
			break;
		case LONG_PRESS1:
			nextState = m_CurrentState.onLong1Press();
			break;
		case LONG_PRESS2:
			nextState = m_CurrentState.onLong2Press();
			break;
		case LONG_PRESS3:
			nextState = m_CurrentState.onLong3Press();
			break;
		case LONG_PRESS4:
			nextState = m_CurrentState.onLong4Press();
			break;	

		default:
			assert(false);
			break;
		}
		
		displayState(nextState);
	}
	
	static public void sendSMS(){
		m_MainActivity.sendSMS(m_Message.GetText(), "0526225366");
	}
	
	public void changeState(PressType type, PressID id) {
		switch (type){
		case LONG_PRESS:
			switch (id){
			case BLUE_PRESS:
				clickOn(ControllerPressType.LONG_PRESS1);
				break;
			case YELLOW_PRESS:
				clickOn(ControllerPressType.LONG_PRESS2);
				break;
			case GREEN_PRESS:
				clickOn(ControllerPressType.LONG_PRESS3);
				break;
			case RED_PRESS:
				clickOn(ControllerPressType.LONG_PRESS4);
				break;
			default:
				assert(false);	
			}
			break;
		case SHORT_PRESS:
			switch (id){
			case BLUE_PRESS:
				clickOn(ControllerPressType.SHORT_PRESS1);
				break;
			case YELLOW_PRESS:
				clickOn(ControllerPressType.SHORT_PRESS2);
				break;
			case GREEN_PRESS:
				clickOn(ControllerPressType.SHORT_PRESS3);
				break;
			case RED_PRESS:
				clickOn(ControllerPressType.SHORT_PRESS4);
				break;
			default:
				assert(false);	
			}
			break;
		default:
			assert(false);
		}
	}
	
}
