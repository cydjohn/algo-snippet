import java.io.*;
import java.util.*;

//hashmap O(n)
class Solution {
  static public List<List<String>> hostRecord(List<String> data, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();    
    for (String d : data) {
      //split the string to get the ids
      int host = Integer.parseInt(d.substring(0, d.indexOf(',')));
      //store ids to hashmap<id, last_page_contains_id>
      if (!map.containsKey(host)) map.put(host, 0);
      int curPage = map.get(host);
      //traverse throuth the array and put ids into coresponding list
      if (res.size() <= curPage) res.add(new ArrayList<String>());
      //if the list is full, put it into the next list
      while (res.get(curPage).size() >= k) curPage++;
      res.get(curPage).add(d);
      map.put(host, curPage + 1);
    }
    return res;  
  }
  
  public static void main(String[] args) {
    List<String> data = new ArrayList<>();
    data.add("10, 1, 1000.0");
    data.add("10, 3, 999.5");
    data.add("9, 2, 999.0");
    data.add("15, 999, 999.5");
    data.add("10, 4, 999.5");

    List<List<String>> res = hostRecord(data, 3);
    int i = 0;
    for (List<String> r : res) {
      System.out.println("The " + i + " page: ");
      for (String s : r) {
        System.out.println(s);
      }
      i++;
    }
  }
}
