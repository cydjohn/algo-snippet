import java.io.*;
import java.util.*;

//hashmap O(n)
class Solution {
  static public List<List<String>> hostRecord(List<String> data, int k) {
    Map<Integer, Integer> map = new HashMap<>(); //<host_id, next page to hold is host_id>
    List<List<String>> res = new ArrayList<>();    
    for (String d : data) {
      //split the string to get the ids
      int host = Integer.parseInt(d.substring(0, d.indexOf(',')));
      //store ids to hashmap<id, last_page_contains_id>
      if (!map.containsKey(host)) map.put(host, 0);
      int curPage = map.get(host);
      //Case 1: if the page size is not enough
      if (res.size() <= curPage) res.add(new ArrayList<String>());
      //Case 2: if the list is full, put it into the next list
      while (res.get(curPage).size() >= k) curPage++;
      res.get(curPage).add(d);
      map.put(host, curPage + 1);
    }
    return res;  
  }
  
  public static void main(String[] args) {
    String[] strs = new String[]{
      "1,28,300.1,SanFrancisco",
      "4,5,209.1,SanFrancisco",
      "20,7,208.1,SanFrancisco",
      "23,8,207.1,SanFrancisco",
      "16,10,206.1,Oakland",
      "1,16,205.1,SanFrancisco",
      "6,29,204.1,SanFrancisco",
      "7,20,203.1,SanFrancisco",
      "8,21,202.1,SanFrancisco",
      "2,18,201.1,SanFrancisco",
      "2,30,200.1,SanFrancisco",
      "15,27,109.1,Oakland",
      "10,13,108.1,Oakland",
      "11,26,107.1,Oakland",
      "12,9,106.1,Oakland",
      "13,1,105.1,Oakland",
      "22,17,104.1,Oakland",
      "1,2,103.1,Oakland",
      "28,24,102.1,Oakland",
      "18,14,11.1,SanJose",
      "6,25,10.1,Oakland",
      "19,15,9.1,SanJose",
      "3,19,8.1,SanJose",
      "3,11,7.1,Oakland",
      "27,12,6.1,Oakland",
      "1,3,5.1,Oakland",
      "25,4,4.1,SanJose",
      "5,6,3.1,SanJose",
      "29,22,2.1,SanJose",
      "30,23,1.1,SanJose"
    };

    List<String> data = new ArrayList<>(Arrays.asList(strs));
    List<List<String>> res = hostRecord(data, 12);
    int i = 0;
    for (List<String> r : res) {
      System.out.println("\n The " + i + " page: ");
      for (String s : r) {
        System.out.println(s);
      }
      i++;
    }
  }
}

