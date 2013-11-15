package il.ac.technion.cs.ssdl.cs234311.yp09.controller;

import il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer.Client;
import il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer.ClientCom;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.FourButtonsFragment.PressID;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.FourButtonsFragment.PressType;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.MainActivity;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.MainActivity.BodyFragment;
import il.ac.technion.cs.ssdl.cs234311.yp09.states.MainState;
import il.ac.technion.cs.ssdl.cs234311.yp09.states.State;
import il.ac.technion.cs.ssdl.cs234311.yp09.textController.TextController;

import java.io.Serializable;

import android.os.StrictMode;

/**
 * This class is responsible for controlling the UI and the logic parts
 * 
 * @date 11/5/2013
 * @email owais.musa@gmail.com
 * @author Owais Musa
 */
public class Controller implements Serializable {

  private static final long serialVersionUID = 4242079014671416782L;

  /**
   * holds the message to be sent by the application
   */
  static public TextController m_message = new TextController();

  static private MainActivity m_mainActivity;
  static private State m_currentState;

  /**
   * Constructs the controller with the appropriate activity and the main state
   * 
   * @param in_mainActivity
   *          the activity to be controlled
   */
  public Controller(final MainActivity in_mainActivity) {
    m_mainActivity = in_mainActivity;
    m_currentState = new MainState();
  }

  boolean m_accessedMessageFragment = true;

  /**
   * display new state on the screen
   * 
   * @param in_state
   *          the new state to be displayed on the screen
   */
  public void displayState(final State in_state) {
    assert in_state != null;

    m_currentState = in_state;

    m_mainActivity.setShortPressInfo(m_currentState.shortPress);
    m_mainActivity.setLongPressInfo(m_currentState.longPress);
    if (m_accessedMessageFragment) {
      m_accessedMessageFragment = false;
      m_mainActivity.setBodyFragment(BodyFragment.MESSAGE_FRAG);
    }

    m_mainActivity.UpdateMessage(m_message.getText(),
        m_message.getCursorPossition());
    m_mainActivity.updateDisplay();
  }

  /**
   * starts the controller activity
   */
  public void start() {
    displayState(m_currentState);
  }

  /**
   * Checks the type of the press and request from the current state to return
   * the next state accordingly
   * 
   * @param in_pressType
   *          the type of the press (for example: long 1)
   */
  public void clickOn(final ControllerPressType in_pressType) {
    State nextState = null;

    switch (in_pressType) {
    case SHORT_PRESS1:
      nextState = m_currentState.onShort1Press();
      break;
    case SHORT_PRESS2:
      nextState = m_currentState.onShort2Press();
      break;
    case SHORT_PRESS3:
      nextState = m_currentState.onShort3Press();
      break;
    case SHORT_PRESS4:
      nextState = m_currentState.onShort4Press();
      break;
    case LONG_PRESS1:
      nextState = m_currentState.onLong1Press();
      break;
    case LONG_PRESS2:
      nextState = m_currentState.onLong2Press();
      break;
    case LONG_PRESS3:
      nextState = m_currentState.onLong3Press();
      break;
    case LONG_PRESS4:
      nextState = m_currentState.onLong4Press();
      break;

    default:
      assert false;
      break;
    }

    displayState(nextState);
  }

  /**
   * send the current text message as SMS
   */
  static public void sendSMS() {
    m_mainActivity.sendSMS(m_message.getText(), "+972526225366");
    final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        .permitAll().build();

    StrictMode.setThreadPolicy(policy);

    final ClientCom ClientConnection = new Client();
    ClientConnection.send2Server(m_message.getText());
  }

  /**
   * receives from the main activity the press type and maps it to the
   * controller types
   * 
   * @param type
   * @param id
   */
  public void changeState(final PressType type, final PressID id) {
    switch (type) {
    case LONG_PRESS:
      switch (id) {
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
        assert false;
      }
      break;
    case SHORT_PRESS:
      switch (id) {
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
        assert false;
      }
      break;
    default:
      assert false;
    }
  }

}
