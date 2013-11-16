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

  /**
   * Test the method parseScreenContent
   */
  public static void testParseScreenContent() {
    final String mainStateFilePath = "contents\\en\\MainState.xml";
    final String[] shortPress = new String[4];
    final String[] longPress = new String[4];

    XMLScreenContentParser.parseScreenContent(mainStateFilePath, shortPress,
        longPress);

    System.out.println(shortPress[0]);
    System.out.println(shortPress[1]);
    System.out.println(shortPress[2]);
    System.out.println(shortPress[3]);
    System.out.println(longPress[0]);
    System.out.println(longPress[1]);
    System.out.println(longPress[2]);
    System.out.println(longPress[3]);

  }
}
