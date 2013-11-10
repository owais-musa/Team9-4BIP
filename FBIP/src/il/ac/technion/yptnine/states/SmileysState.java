package il.ac.technion.yptnine.states;

import il.ac.technion.yptnine.controller.Controller;

public class SmileysState extends State {

	public SmileysState(String[] smileys) {
		for (int i = 0; i < 4; i++) {
			shortPress[i] = Parser.findContent(smileys, 0, smileys.length - 1,
					i, 4);
		}

		longPress[0] = "Back";
		longPress[1] = "UNUSED";
		longPress[2] = "UNUSED";
		longPress[3] = "UNUSED";
	}

	@Override
	public State onShort1Press() {
		return shortOpLogic(1);
	}

	@Override
	public State onShort2Press() {
		return shortOpLogic(2);
	}

	@Override
	public State onShort3Press() {
		return shortOpLogic(3);
	}

	@Override
	public State onShort4Press() {
		return shortOpLogic(4);
	}

	public State shortOpLogic(int i) {
		int size = shortPress[i - 1].split(" ").length;
		if (size == 0) {
			/*
			 * In case some of the windows are empty. For example: having 3
			 * numbers to be shown on 4 windows. I solved the issue by remaining
			 * in the same state.
			 */
			return this;
		} else if (size == 1) {
			Controller.m_Message.InsertChars(shortPress[i-1]);
			return new KeyboardState();
		} else {
			String[] choosenItems = shortPress[i - 1].split(" ");
			return new SmileysState(choosenItems);
		}
	}

	// Back
	@Override
	public State onLong1Press() {
		return new KeyboardState();
	}

	// UNUSED
	@Override
	public State onLong2Press() {
		// Button is UNUSED in the first iteration
		return this;
	}

	// UNUSED
	@Override
	public State onLong3Press() {
		// Button is UNUSED in the first iteration
		return this;
	}

	// UNUSED
	@Override
	public State onLong4Press() {
		// Button is UNUSED in the first iteration
		return this;
	}
}
