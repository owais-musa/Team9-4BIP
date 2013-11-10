package il.ac.technion.yptnine.states;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public static String splitEqually(String text, int index, int numOfGroups) {
		int size = (text.length() + (numOfGroups-1)) / numOfGroups;
	    List<String> content = new ArrayList<String>(numOfGroups);

	    for (int start = 0; start < text.length(); start += size) {
	        content.add(text.substring(start, Math.min(text.length(), start + size)));
	    }
	    if(index + 1 > content.size())
	        return "";
	    else
	        return content.get(index);

	}
	
}
