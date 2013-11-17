package il.ac.technion.cs.ssdl.cs234311.yp09.states;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Muhammad Watad
 * @email Muhammad.Watad@Gmail.com
 * @date 9/11/2013
 * 
 */
public enum Parser {
  ;
  /**
   * @param items
   *          an array of the objects to be split.
   * @param index
   *          the index of the chunk we want to calculate.
   * @param numberOfGroups
   *          number of chunks to be created.
   * @return the items allocated for the group.
   */
  public final static ArrayList<String> splitEqually(final String[] items,
      final int index, final int numberOfGroups) {
    final ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>(
        4);

    final int size = (items.length + numberOfGroups - 1) / numberOfGroups;
    for (int start = 0; start < items.length; start += size) {
      final String[] subSetOfItems = Arrays.copyOfRange(items, start,
          Math.min(items.length, start + size));

      final ArrayList<String> arrList = new ArrayList<String>(
          subSetOfItems.length);
      for (int i = 0; i < subSetOfItems.length; i++)
        arrList.add(subSetOfItems[i]);

      content.add(arrList);
    }
    if (index + 1 > content.size())
      return new ArrayList<String>();
    return content.get(index);
  }

  /**
   * @param items
   *          an array of Strings.
   * @return the Strings from the input concatenated and separated by spaces.
   */
  public final static String addSpaces(final String[] items) {
    String $ = "";

    for (int i = 0; i < items.length; i++) {
      $ += items[i];
      if (i + 1 != items.length)
        $ += " ";
    }

    return $;
  }

  /*
   * Return sub-array of the arr. I suppose that the "from" and "to" args are
   * legal indexes.
   */
  /**
   * @param array
   * @param from
   * @param to
   * @return sub-array of the `array`. I supposed that the "from" and "to"
   *         arguments are legal indexes.
   * 
   */
  public final static String[] subArray(final String[] array, final int from,
      final int to) {
    final String[] $ = new String[to - from + 1];
    int j = 0;
    for (int i = from; i <= to; i++) {
      $[j] = array[i];
      j++;
    }

    return $;
  }

  /**
   * @param items
   *          the Strings to be parsed.
   * @param from
   *          where to start from (included).
   * @param to
   *          where to stop at (included).
   * @return a String representing the content chosen.
   */
  public final static String findHighPriorityContent(final String[] items,
      final int from, final int to) {
    return Parser.addSpaces(Parser.subArray(items, from, to));
  }

  /**
   * @param items
   *          the Strings to be parsed.
   * @param from
   *          where to start from (included).
   * @param to
   *          where to stop at (included).
   * @param index
   *          an identifier of the group (0 to numOfGroups-1).
   * @param numberOfGroups
   *          the number of the groups items will be divided to.
   * @return the chunk allocated for the group.
   */
  public final static String findContent(final String[] items, final int from,
      final int to, final int index, final int numberOfGroups) {
    final ArrayList<String> content = Parser.splitEqually(
        Parser.subArray(items, from, to), index, numberOfGroups);
    final String[] contentArray = new String[content.size()];
    for (int i = 0; i < content.size(); i++)
      contentArray[i] = content.get(i);
    return Parser.addSpaces(contentArray);
  }
}
