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
	
	private MainActivity m_MainActivity;
	private State m_CurrentState;
	
	public Controller(MainActivity in_MainActivity){
		m_MainActivity = in_MainActivity;
		m_CurrentState = new MainState();
	}
	
	public void DisplayState(State m_State) {
		assert(m_State != null);
		
		m_CurrentState = m_State;
		
		m_MainActivity.setShortPressInfo(m_CurrentState.shortPress);
		m_MainActivity.setLongPressInfo(m_CurrentState.longPress);
		m_MainActivity.setBodyFragment(BodyFragment.MESSAGE_FRAG);
		m_MainActivity.updateDisplay();
	}

	public void Start() {
		DisplayState(m_CurrentState);
	}
	
	public void ClickOn(ControllerPressType in_pressType){
		State NextState = null;
		
		switch (in_pressType) {
		case SHORT_PRESS1:
			NextState = m_CurrentState.onShort1Press();
			break;
		case SHORT_PRESS2:
			NextState = m_CurrentState.onShort2Press();
			break;
		case SHORT_PRESS3:
			NextState = m_CurrentState.onShort3Press();
			break;
		case SHORT_PRESS4:
			NextState = m_CurrentState.onShort4Press();
			break;
		case LONG_PRESS1:
			NextState = m_CurrentState.onLong1Press();
			break;
		case LONG_PRESS2:
			NextState = m_CurrentState.onLong2Press();
			break;
		case LONG_PRESS3:
			NextState = m_CurrentState.onLong3Press();
			break;
		case LONG_PRESS4:
			NextState = m_CurrentState.onLong4Press();
			break;	

		default:
			assert(false);
			break;
		}
		
		DisplayState(NextState);
	}
	
	public void changeState(PressType type, PressID id) {
		switch (type){
		case LONG_PRESS:
			switch (id){
			case BLUE_PRESS:
				ClickOn(ControllerPressType.LONG_PRESS1);
				break;
			case YELLOW_PRESS:
				ClickOn(ControllerPressType.LONG_PRESS2);
				break;
			case GREEN_PRESS:
				ClickOn(ControllerPressType.LONG_PRESS3);
				break;
			case RED_PRESS:
				ClickOn(ControllerPressType.LONG_PRESS4);
				break;
			default:
				assert(false);	
			}
			break;
		case SHORT_PRESS:
			switch (id){
			case BLUE_PRESS:
				ClickOn(ControllerPressType.SHORT_PRESS1);
				break;
			case YELLOW_PRESS:
				ClickOn(ControllerPressType.SHORT_PRESS2);
				break;
			case GREEN_PRESS:
				ClickOn(ControllerPressType.SHORT_PRESS3);
				break;
			case RED_PRESS:
				ClickOn(ControllerPressType.SHORT_PRESS4);
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
