package il.ac.technion.cs.ssdl.cs234311.yp09.states;

public class MainState extends State {
	
	public MainState(){
		shortPress[0] = "Keyboard";
		shortPress[1] = "Protocol";
		shortPress[2] = "Recipient";
		shortPress[3] = "Settings";
		
		longPress[0] = "Exit";
		longPress[1] = "Send";
		longPress[2] = "UNUSED";
		longPress[3] = "UNUSED";
	}
	
	// Keyboard was "clicked"
	@Override
	public State onShort1Press() {
		return new KeyboardState();
	}

	@Override
	public State onShort2Press() {
		// Protocol
		/*
		 * Important: this method should be changed in the future.
		 *            Meanwhile our App supports SMS protocol only. 
		 */
		return this;
		
	}

	// Recipient
	@Override
	public State onShort3Press() {
		/*
		 * Important: this method should be changed in the future.
		 *            Meanwhile our App supports inserting numbers manually.
		 */
		return this;
		
	}

	// Settings
	@Override
	public State onShort4Press() {
		/*
		 * Important: this method should be changed in the future.
		 *            Meanwhile we do NOT enable changing settings.
		 */
		return this;
		
	}

	// Exit
	@Override
	public State onLong1Press() {
		/*
		 * Important: this method should be changed in the future.
		 *            Meanwhile we just exit the application.
		 *            No backup/other operations are done.
		 */
		//TODO: consider a better way of exiting the app (calling destroy() on the activity for instance)
		System.exit(0);
		return this;
		
	}

	// Send
	@Override
	public State onLong2Press() {
		/*
		 * To be Integrated with Daniel's part.
		 */
		return this;
		
	}

	// UNUSED
	@Override
	public State onLong3Press() {
		// Left for future use.
		return this;
		
	}

	// UNUSED
	@Override
	public State onLong4Press() {
		// Left for future use.
		return this;
		
	}

}
