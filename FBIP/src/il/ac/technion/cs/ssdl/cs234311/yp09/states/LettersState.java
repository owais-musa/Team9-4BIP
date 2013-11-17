package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import il.ac.technion.cs.ssdl.cs234311.yp09.controller.Controller;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 6/11/2013
 * 
 */
public final class LettersState extends State {

  private boolean lowerCase = true;

  /**
   * @param c
   *          an object mediating between the model and the view.
   * @param abc
   *          the letters of the language used.
   * @param lCase
   *          an indication whether the state contains small/capital letter
   */
  public LettersState(final Controller c, final String[] abc,
      final boolean lCase) {
    super(c);
    if (lCase) {
      for (int i = 0; i < 4; i++)
        shortPress[i] = Parser.findContent(abc, 0, abc.length - 1, i, 4)
            .toLowerCase(Locale.ENGLISH);
      lowerCase = true;
      longPress[3] = "A";
    } else {
      for (int i = 0; i < 4; i++)
        shortPress[i] = Parser.findContent(abc, 0, abc.length - 1, i, 4)
            .toUpperCase(Locale.ENGLISH);
      lowerCase = false;
      longPress[3] = "a";
    }

    longPress[0] = "Back";
    longPress[1] = "UNUSED";
    longPress[2] = "Lang";

  }

  @Override
  public final State onShort1Press() {
    return calculateNextStateWhenShortPressed(1);
  }

  @Override
  public final State onShort2Press() {
    return calculateNextStateWhenShortPressed(2);
  }

  @Override
  public final State onShort3Press() {
    return calculateNextStateWhenShortPressed(3);
  }

  @Override
  public final State onShort4Press() {
    return calculateNextStateWhenShortPressed(4);
  }

  /**
   * @param index
   *          the index of the button pressed
   * @return the next state.
   */
  public final State calculateNextStateWhenShortPressed(final int index) {
    if (shortPress[index - 1].equals(""))
      return this;
    if (1 == shortPress[index - 1].length()) {
      Controller.m_message.insertChar(shortPress[index - 1].charAt(0));
      return new KeyboardState(mController);
    }
    final String[] choosenItems = shortPress[index - 1].split(" ");
    return new LettersState(mController, choosenItems, lowerCase);
  }

  // Back
  @Override
  public final State onLong1Press() {
    return new KeyboardState(mController);
  }

  // UNUSED
  @Override
  public final State onLong2Press() {
    // Button is UNUSED in the first iteration
    return this;
  }

  // Lang
  @Override
  public final State onLong3Press() {
    // We support only the English language for the first iteration
    return this;
  }

  // A/a - upper/lower case format.
  @Override
  public final State onLong4Press() {
    lowerCase = !lowerCase;
    final ArrayList<String> content = new ArrayList<String>();

    for (int i = 0; i < 4; i++) {
      final String[] letters = shortPress[i].split(" ");
      for (int j = 0; j < letters.length; j++)
        content.add(letters[j]);
    }

    final String[] items = new String[content.size()];

    for (int i = 0; i < content.size(); i++)
      items[i] = content.get(i);

    return new LettersState(mController, items, lowerCase);
  }

}
