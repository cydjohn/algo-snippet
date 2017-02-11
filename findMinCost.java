//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
package airbnb;

import java.io.*;
import java.util.*;

public class Solution {
    public static List<Integer> findMinCost(List<List<Integer>> people) {
		int[] dist = new int[10];
        int[] parent = new int[10];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		dist[0] = 0;
        parent[0] = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				for (int w : people.get(cur)) {
					if (dist[w] > dist[cur] + getDist(cur, w)) {
						dist[w] = dist[cur] + getDist(cur, w);
                        parent[w] = cur;
						queue.add(w);
					}
				}
			}
		}
        int i = 3;
      	List<Integer> res = new ArrayList<>();
        while (i != -1) {
          	res.add(0, i);
            i = parent[i];
        }
      	return res;
	}
    private static int getDist(int i, int j) {
        return (i - j) * (i - j);
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        list.add(new ArrayList<Integer>(Arrays.asList(0,2,3)));
        list.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        list.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        List<Integer> res = findMinCost(list);
        for (int r : res) {
            System.out.println(r);
        }
    }
}


