package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ParserTest extends TestCase{
	
	public static void testSplitEqually1(){
		
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
		ArrayList<String> arrList1 = Parser.splitEqually(strArr, 0, 1);
		ArrayList<String> arrList2 = new ArrayList<String>();
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
	
	public static void testSplitEqually2(){
		
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
		ArrayList<String> arrList1 = Parser.splitEqually(strArr, 0, 2);
		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2.add("a");
		arrList2.add("b");
		arrList2.add("c");
		arrList2.add("d");
		
		assertTrue(arrList2.equals(arrList1));
	}

	public static void testSplitEqually3(){
		
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
		ArrayList<String> arrList1 = Parser.splitEqually(strArr, 1, 2);
		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2.add("e");
		arrList2.add("f");
		arrList2.add("g");
		arrList2.add("h");
		
		assertTrue(arrList2.equals(arrList1));
	}
	
	public static void testSplitEqually4(){
		
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		ArrayList<String> arrList1 = Parser.splitEqually(strArr, 2, 3);
		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2.add("g");
		
		assertTrue(arrList2.equals(arrList1));
	}
	
	public static void testSplitEqually5(){
		
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
		ArrayList<String> arrList1 = Parser.splitEqually(strArr, 2, 4);
		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2.add("e");
		arrList2.add("f");
		
		assertTrue(arrList2.equals(arrList1));
	}
	
	public static void testSplitEqually6(){
		
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
		ArrayList<String> arrList1 = Parser.splitEqually(strArr, 3, 4);
		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2.add("g");
		arrList2.add("h");
		
		assertTrue(arrList2.equals(arrList1));
	}
	
	public static void testAddSpaces1(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
		String res = Parser.addSpaces(strArr);
		String expected = "a b c d e f g h";
		
		assertTrue(expected.equals(res));
	}
	
	public static void testAddSpaces2(){
		String[] strArr = {"Muhammad", "Watad", "is", "testing", "his", "code"};
		String res = Parser.addSpaces(strArr);
		String expected = "Muhammad Watad is testing his code";
		
		assertTrue(expected.equals(res));
	}
	
	public static void testSubArray1(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String[] res = Parser.subArray(strArr, 0, 3);
		String[] expected = {"a", "b", "c", "d"};
		
		for(int i = 0; i < res.length; i++){
			assertTrue(res[i].equals(expected[i]));
		}
	}
	
	public static void testSubArray2(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String[] res = Parser.subArray(strArr, 0, 6);
		
		for(int i = 0; i < res.length; i++){
			assertTrue(res[i].equals(strArr[i]));
		}
	}
	
	public static void testFindHighPrioContent1(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String str = Parser.findHighPrioContent(strArr, 0, 2);
		
		assertTrue(str.equals("a b c"));
	}
	
	public static void testFindHighPrioContent2(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String str = Parser.findHighPrioContent(strArr, 0, 0);
		
		assertTrue(str.equals("a"));
	}
	
	public static void testFindHighPrioContent3(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String res = Parser.findHighPrioContent(strArr, 0, 1);
		
		assertTrue(res.equals("a b"));
	}
	
	public static void testFindContent1(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String res = Parser.findContent(strArr, 2, 6, 0, 4);
		
		assertTrue(res.equals("c d"));
	}
	
	public static void testFindContent2(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String res = Parser.findContent(strArr, 1, 6, 1, 2);
		
		
		System.out.println(res);
		assertTrue(res.equals("e f g"));
	}
	
	public static void testFindContent3(){
		String[] strArr = {"a", "b", "c", "d", "e", "f", "g"};
		String res = Parser.findContent(strArr, 3, 5, 3, 4);
		
		System.out.println(res);
		assertTrue(res.equals(""));
	}
}
