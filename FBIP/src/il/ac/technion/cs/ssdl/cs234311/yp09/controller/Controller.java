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
 * Controls the UI and the logic part
 * 
 * @date 11/5/2013
 * @email owais.musa@gmail.com
 * @author Owais Musa, Itamar
 */
public class Controller implements Serializable, FourButtonsListener {

  /**
   * Holds the current message text
   */
  static public TextController m_message = new TextController();

  private static final long serialVersionUID = 4242079014671416782L;

  private ControllerListener m_controllerListener;
  private static final String TAG = "CONTROLLER";

  static private State m_currentState;

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
   * Setter to m_controllerListener
   * 
   * @param in_controllerListener
   */
  public void setListener(final ControllerListener in_controllerListener) {
    m_controllerListener = in_controllerListener;
  }

  /**
   * Constructs the controller with the main state
   */
  public Controller() {
    m_currentState = new MainState(this);
  }

  /**
   * change the current content on the screen
   * 
   * @param m_State
   *          next state to be shown on the screen
   */
  public void displayState(final State m_State) {
    assert m_State != null;

    m_currentState = m_State;

    m_controllerListener.onShortInfoUpdate(m_currentState.shortPress);
    m_controllerListener.onLongInfoUpdate(m_currentState.longPress);
    m_controllerListener.onUpdateMessage(m_message.getText(),
        m_message.getCursorPosition());
    m_controllerListener.onUpdateDisplay();
  }

  /**
   * Starts the activity of the controller
   */
  public void start() {
    displayState(m_currentState);
  }

  /**
   * To be called from the logic part in order to send the current message as
   * SMS and as a log to the server
   */
  public void sendSMS() {
    m_controllerListener.onSendSMS(m_message.getText(), "+972526225366");
    final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        .permitAll().build();

    StrictMode.setThreadPolicy(policy);

    final ClientCom ClientConnection = new Client();
    ClientConnection.send2Server(m_message.getText());
  }

  /**
   * Extract the contents from the XML file and return it as arrays to strings
   * 
   * @param in_contentFile
   *          the XML file
   * @param out_shortPress
   * @param out_longPress
   */
  public static void getContentFromXMLFile(final String in_contentFile,
      final String[] out_shortPress, final String[] out_longPress) {
    XMLScreenContentParser.parseScreenContent(in_contentFile, out_shortPress,
        out_longPress);
  }

  @Override
  public void onShortPress(final PressID p) {
    Log.d(TAG, "press: emphasizing short " + p);
    m_controllerListener.emphasizeShort(p, true);
  }

  @Override
  public void onShortRelease(final PressID p) {
    Log.d(TAG, "release: de-emphasizing short " + p);
    m_controllerListener.emphasizeShort(p, false);
    State next = null;
    switch (p) {
    case BLUE_PRESS:
      next = m_currentState.onShort1Press();
      break;
    case YELLOW_PRESS:
      next = m_currentState.onShort2Press();
      break;
    case GREEN_PRESS:
      next = m_currentState.onShort3Press();
      break;
    case RED_PRESS:
      next = m_currentState.onShort4Press();
      break;
    default:
      assert false;
    }
    displayState(next);
  }

  @Override
  public void onLongPress(final PressID p) {
    Log.d(TAG, "press: de-emphasizing short " + p);
    m_controllerListener.emphasizeShort(p, false);
    Log.d(TAG, "press: emphasizing long " + p);
    m_controllerListener.emphasizeLong(p, true);
  }

  @Override
  public void onLongRelease(final PressID p) {
    Log.d(TAG, "release: de-emphasizing long " + p);
    m_controllerListener.emphasizeLong(p, false);
    State next = null;
    switch (p) {
    case BLUE_PRESS:
      next = m_currentState.onLong1Press();
      break;
    case YELLOW_PRESS:
      next = m_currentState.onLong2Press();
      break;
    case GREEN_PRESS:
      next = m_currentState.onLong3Press();
      break;
    case RED_PRESS:
      next = m_currentState.onLong4Press();
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
    return m_controllerListener;
  }

}
