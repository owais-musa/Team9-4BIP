package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 9/11/2013
 * 
 */
public final class ParserTest extends TestCase {

  /**
   * Test #1
   */
  public final static void testSplitEqually1() {

    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g", "h" };
    final ArrayList<String> arrList1 = Parser.splitEqually(strArr, 0, 1);
    final ArrayList<String> arrList2 = new ArrayList<String>();
    arrList2.add("a");
    arrList2.add("b");
    arrList2.add("c");
    arrList2.add("d");
    arrList2.add("e");
    arrList2.add("f");
    arrList2.add("g");
    arrList2.add("h");

    assertTrue(arrList2.equals(arrList1));
  }

  /**
   * Test #2
   */
  public final static void testSplitEqually2() {

    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g", "h" };
    final ArrayList<String> arrList1 = Parser.splitEqually(strArr, 0, 2);
    final ArrayList<String> arrList2 = new ArrayList<String>();
    arrList2.add("a");
    arrList2.add("b");
    arrList2.add("c");
    arrList2.add("d");

    assertTrue(arrList2.equals(arrList1));
  }

  /**
   * Test #3
   */
  public final static void testSplitEqually3() {

    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g", "h" };
    final ArrayList<String> arrList1 = Parser.splitEqually(strArr, 1, 2);
    final ArrayList<String> arrList2 = new ArrayList<String>();
    arrList2.add("e");
    arrList2.add("f");
    arrList2.add("g");
    arrList2.add("h");

    assertTrue(arrList2.equals(arrList1));
  }

  /**
   * Test #4
   */
  public final static void testSplitEqually4() {

    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final ArrayList<String> arrList1 = Parser.splitEqually(strArr, 2, 3);
    final ArrayList<String> arrList2 = new ArrayList<String>();
    arrList2.add("g");

    assertTrue(arrList2.equals(arrList1));
  }

  /**
   * Test #5
   */
  public final static void testSplitEqually5() {

    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g", "h" };
    final ArrayList<String> arrList1 = Parser.splitEqually(strArr, 2, 4);
    final ArrayList<String> arrList2 = new ArrayList<String>();
    arrList2.add("e");
    arrList2.add("f");

    assertTrue(arrList2.equals(arrList1));
  }

  /**
   * Test #6
   */
  public final static void testSplitEqually6() {

    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g", "h" };
    final ArrayList<String> arrList1 = Parser.splitEqually(strArr, 3, 4);
    final ArrayList<String> arrList2 = new ArrayList<String>();
    arrList2.add("g");
    arrList2.add("h");

    assertTrue(arrList2.equals(arrList1));
  }

  /**
   * Test #7
   */
  public final static void testAddSpaces1() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g", "h" };
    final String res = Parser.addSpaces(strArr);
    final String expected = "a b c d e f g h";

    assertTrue(expected.equals(res));
  }

  /**
   * Test #8
   */
  public final static void testAddSpaces2() {
    final String[] strArr = { "Muhammad", "Watad", "is", "testing", "his",
        "code" };
    final String res = Parser.addSpaces(strArr);
    final String expected = "Muhammad Watad is testing his code";

    assertTrue(expected.equals(res));
  }

  /**
   * Test #9
   */
  public final static void testSubArray1() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String[] res = Parser.subArray(strArr, 0, 3);
    final String[] expected = { "a", "b", "c", "d" };

    for (int i = 0; i < res.length; i++)
      assertTrue(res[i].equals(expected[i]));
  }

  /**
   * Test #10
   */
  public final static void testSubArray2() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String[] res = Parser.subArray(strArr, 0, 6);

    for (int i = 0; i < res.length; i++)
      assertTrue(res[i].equals(strArr[i]));
  }

  /**
   * Test #11
   */
  public final static void testFindHighPrioContent1() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String str = Parser.findHighPriorityContent(strArr, 0, 2);

    assertTrue(str.equals("a b c"));
  }

  /**
   * Test #12
   */
  public final static void testFindHighPrioContent2() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String str = Parser.findHighPriorityContent(strArr, 0, 0);

    assertTrue(str.equals("a"));
  }

  /**
   * Test #13
   */
  public final static void testFindHighPrioContent3() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String res = Parser.findHighPriorityContent(strArr, 0, 1);

    assertTrue(res.equals("a b"));
  }

  /**
   * Test #14
   */
  public final static void testFindContent1() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String res = Parser.findContent(strArr, 2, 6, 0, 4);

    assertTrue(res.equals("c d"));
  }

  /**
   * Test #15
   */
  public final static void testFindContent2() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String res = Parser.findContent(strArr, 1, 6, 1, 2);

    assertTrue(res.equals("e f g"));
  }

  /**
   * Test #16
   */
  public final static void testFindContent3() {
    final String[] strArr = { "a", "b", "c", "d", "e", "f", "g" };
    final String res = Parser.findContent(strArr, 3, 5, 3, 4);

    assertTrue(res.equals(""));
  }
}
