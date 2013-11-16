package il.ac.technion.cs.ssdl.cs234311.yp09.controller;

import junit.framework.TestCase;

/**
 * Unit test for XMLScreenContentParser class
 * 
 * @date 11/16/2013
 * @email owais.musa@gmail.com
 * @author Owais Musa
 * 
 */
public class XMLScreenContentParserTest extends TestCase {

  private static final String LONG_PRESS0 = "long press test 0";
  private static final String LONG_PRESS1 = "long press test 1";
  private static final String LONG_PRESS2 = "long press test 2";
  private static final String LONG_PRESS3 = "long press test 3";

  private static final String SHORT_PRESS0 = "short press test 0";
  private static final String SHORT_PRESS1 = "short press test 1";
  private static final String SHORT_PRESS2 = "short press test 2";
  private static final String SHORT_PRESS3 = "short press test 3";

  /**
   * Test the method parseScreenContent
   */
  public static void testParseScreenContent() {
    final String mainStateFilePath = "contents\\test\\TestState.xml";
    final String[] longPress = new String[4];
    final String[] shortPress = new String[4];

    XMLScreenContentParser.parseScreenContent(mainStateFilePath, shortPress,
        longPress);

    if (!shortPress[0].equals(SHORT_PRESS0))
      fail();

    if (!shortPress[1].equals(SHORT_PRESS1))
      fail();

    if (!shortPress[2].equals(SHORT_PRESS2))
      fail();

    if (!shortPress[3].equals(SHORT_PRESS3))
      fail();

    if (!longPress[0].equals(LONG_PRESS0))
      fail();

    if (!longPress[1].equals(LONG_PRESS1))
      fail();

    if (!longPress[2].equals(LONG_PRESS2))
      fail();

    if (!longPress[3].equals(LONG_PRESS3))
      fail();
  }
}
