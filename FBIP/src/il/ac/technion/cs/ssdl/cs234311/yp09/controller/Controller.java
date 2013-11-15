package il.ac.technion.cs.ssdl.cs234311.yp09.controller;

import il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer.Client;
import il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer.ClientCom;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.ControllerListener;
import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.FourButtonsListener;
import il.ac.technion.cs.ssdl.cs234311.yp09.states.MainState;
import il.ac.technion.cs.ssdl.cs234311.yp09.states.State;
import il.ac.technion.cs.ssdl.cs234311.yp09.textController.TextController;

import java.io.Serializable;

import android.os.StrictMode;
import android.util.Log;

/**
 *
 */
public class Controller implements Serializable, FourButtonsListener {
  /**
	 * 
	 */
  private static final long serialVersionUID = 4242079014671416782L;
  private ControllerListener mControllerListener;
  private static final String TAG = "CONTROLLER";

  /**
   *
   */
  public static enum PressID {
    /**
     * 
     */
    BLUE_PRESS,
    /**
     * 
     */
    YELLOW_PRESS,
    /**
     * 
     */
    GREEN_PRESS,
    /**
     * 
     */
    RED_PRESS
  }

  /**
   * 
   */
  static public TextController m_Message = new TextController();

  static private State m_CurrentState;

  /**
   * @param cl
   */
  public void setListener(final ControllerListener cl) {
    mControllerListener = cl;
  }

  /**
   * 
   */
  public Controller() {
    // m_MainActivity = in_MainActivity;
    m_CurrentState = new MainState(this);
  }

  // Temp solution for the bug of the upper fragment disappearance
  // boolean m_fAccessedMessageFragment = true;

  /**
   * @param m_State
   */
  public void displayState(final State m_State) {
    assert m_State != null;

    m_CurrentState = m_State;

    mControllerListener.onShortInfoUpdate(m_CurrentState.shortPress);
    mControllerListener.onLongInfoUpdate(m_CurrentState.longPress);
    mControllerListener.onUpdateMessage(m_Message.getText(),
        m_Message.getCursorPossition());
    mControllerListener.onUpdateDisplay();
  }

  /**
   * 
   */
  public void start() {
    displayState(m_CurrentState);
  }

  /*
   * public void clickOn(ControllerPressType in_pressType) { State nextState =
   * null;
   * 
   * switch (in_pressType) { case SHORT_PRESS1: nextState =
   * m_CurrentState.onShort1Press(); break; case SHORT_PRESS2: nextState =
   * m_CurrentState.onShort2Press(); break; case SHORT_PRESS3: nextState =
   * m_CurrentState.onShort3Press(); break; case SHORT_PRESS4: nextState =
   * m_CurrentState.onShort4Press(); break; case LONG_PRESS1: nextState =
   * m_CurrentState.onLong1Press(); break; case LONG_PRESS2: nextState =
   * m_CurrentState.onLong2Press(); break; case LONG_PRESS3: nextState =
   * m_CurrentState.onLong3Press(); break; case LONG_PRESS4: nextState =
   * m_CurrentState.onLong4Press(); break;
   * 
   * default: assert (false); break; }
   * 
   * displayState(nextState); }
   */

  /**
   * 
   */
  public void sendSMS() {
    mControllerListener.onSendSMS(m_Message.getText(), "+972526225366");
    final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        .permitAll().build();

    StrictMode.setThreadPolicy(policy);

    final ClientCom ClientConnection = new Client();
    ClientConnection.send2Server(m_Message.getText());
  }

  /*
   * public void changeState(PressType type, PressID id) { switch (type) { case
   * LONG_PRESS: switch (id) { case BLUE_PRESS:
   * clickOn(ControllerPressType.LONG_PRESS1); break; case YELLOW_PRESS:
   * clickOn(ControllerPressType.LONG_PRESS2); break; case GREEN_PRESS:
   * clickOn(ControllerPressType.LONG_PRESS3); break; case RED_PRESS:
   * clickOn(ControllerPressType.LONG_PRESS4); break; default: assert (false); }
   * break; case SHORT_PRESS: switch (id) { case BLUE_PRESS:
   * clickOn(ControllerPressType.SHORT_PRESS1); break; case YELLOW_PRESS:
   * clickOn(ControllerPressType.SHORT_PRESS2); break; case GREEN_PRESS:
   * clickOn(ControllerPressType.SHORT_PRESS3); break; case RED_PRESS:
   * clickOn(ControllerPressType.SHORT_PRESS4); break; default: assert (false);
   * } break; default: assert (false); } }
   */

  @Override
  public void onShortPress(final PressID p) {
    Log.d(TAG, "press: emphasizing short " + p);
    mControllerListener.emphasizeShort(p, true);
  }

  @Override
  public void onShortRelease(final PressID p) {
    Log.d(TAG, "release: de-emphasizing short " + p);
    mControllerListener.emphasizeShort(p, false);
    State next = null;
    switch (p) {
    case BLUE_PRESS:
      next = m_CurrentState.onShort1Press();
      break;
    case YELLOW_PRESS:
      next = m_CurrentState.onShort2Press();
      break;
    case GREEN_PRESS:
      next = m_CurrentState.onShort3Press();
      break;
    case RED_PRESS:
      next = m_CurrentState.onShort4Press();
      break;
    default:
      assert false;
    }
    displayState(next);
  }

  @Override
  public void onLongPress(final PressID p) {
    Log.d(TAG, "press: de-emphasizing short " + p);
    mControllerListener.emphasizeShort(p, false);
    Log.d(TAG, "press: emphasizing long " + p);
    mControllerListener.emphasizeLong(p, true);
  }

  @Override
  public void onLongRelease(final PressID p) {
    Log.d(TAG, "release: de-emphasizing long " + p);
    mControllerListener.emphasizeLong(p, false);
    State next = null;
    switch (p) {
    case BLUE_PRESS:
      next = m_CurrentState.onLong1Press();
      break;
    case YELLOW_PRESS:
      next = m_CurrentState.onLong2Press();
      break;
    case GREEN_PRESS:
      next = m_CurrentState.onLong3Press();
      break;
    case RED_PRESS:
      next = m_CurrentState.onLong4Press();
      break;
    default:
      assert false;
    }
    displayState(next);
  }

  /**
   * @return the listener registered to handle controller requests
   */
  public ControllerListener getListener() {
    return mControllerListener;
  }

}
