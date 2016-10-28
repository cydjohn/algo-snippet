import java.util.*;
import java.io.*;

class Solution {
  static class HitCounter {
  HashMap<Integer, Integer> map;
  LinkedList<Integer> list;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (!map.containsKey(timestamp)) {
          map.put(timestamp, 1);
          list.add(timestamp);
        }else {
          map.put(timestamp, map.get(timestamp)+1);
        }
        repair(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      repair(timestamp);
      int cnt = 0;
        for (int i : list) cnt += map.get(i);
        return cnt;
    }

    public void repair(int timestamp) {
        while (!list.isEmpty()) {
            if (list.peek() > timestamp - 300) break;
            else map.remove(list.poll());
        }
    }
  }
  public static void main(String[] args) {
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        obj.hit(299);
        int res1 = obj.getHits(300);
        assert res1 == 4;
        int res2 = obj.getHits(301);
        assert res2 == 3;
    }
}

