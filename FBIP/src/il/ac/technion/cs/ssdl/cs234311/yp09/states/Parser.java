package il.ac.technion.cs.ssdl.cs234311.yp09.states;


import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
	
	public static ArrayList<String> splitEqually(String[] items, int index, int numOfGroups) {
		int size = (items.length + (numOfGroups-1)) / numOfGroups;
		ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>(4);

	    for (int start = 0; start < items.length; start += size) {
	    	String[] subSetOfItems = Arrays.copyOfRange(items, start, Math.min(items.length, start + size));
	    	
	    	ArrayList<String> arrList = new ArrayList<String>(subSetOfItems.length);
	    	for(int i = 0; i < subSetOfItems.length; i++){
	    		arrList.add(subSetOfItems[i]);
	    	}
	    	
	    	content.add(arrList);
	    }
	    if(index + 1 > content.size())
	    	return new ArrayList<String>();
	    else
	    	return content.get(index);
	}
	/*
	public static String arrayListToString(ArrayList<String> arr){
		String res = "";
		for(int i = 0; i < arr.size(); i++){
			res += arr.get(i);
		}
		return res;
	}
	*/
	public static String addSpaces(String[] items) {
		String str = "";
		
		for(int i = 0; i < items.length; i++){
			str += items[i];
			if(i+1 != items.length){
				str += " ";
			}
		}
		
		return str;
	}
	
	/* Return sub-array of the arr.
	 * I suppose that the "from" and "to" args are legal indexes. 
	 */
	public static String[] subArray(String[] arr, int from, int to){
		int size = to - from + 1;
		String[] res = new String[size];
		int j = 0;
		
		for(int i = from; i <= to; i++){
			res[j] = arr[i];
			j++;
		}
		
		return res;
	}
	
	public static String findHighPrioContent(String[] items, int from, int to){
		String[] content = Parser.subArray(items, from, to);
		return Parser.addSpaces(content);
	}
	
	public static String findContent(String[] items, int from, int to, int index, int numOfGroups){
		String[] temp = Parser.subArray(items, from, to);
		ArrayList<String> content = Parser.splitEqually(temp, index, numOfGroups);
		String[] contentArray = new String[content.size()];
		for(int i = 0; i < content.size(); i++){
			contentArray[i] = content.get(i);
		}
		return Parser.addSpaces(contentArray);
	}
}
