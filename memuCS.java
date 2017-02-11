//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
package airbnb;

import java.io.*;
import java.util.*;

public class Solution {
    static List<List<String>> res = new ArrayList<>();
	static List<String> list = new ArrayList<>();
	public static List<List<String>> memuCS(String[] memu, double[] prices, double target) {
		backtrack(memu, prices, (int)(target * 100), 0);
		return res;
	}
	private static void backtrack(String[] memu, double[] p, int target, int cur) {
		if (target <= 0) {
			if (target == 0) res.add(new ArrayList<>(list));
			return;
		}
		for (int i = cur; i < p.length; i++) {
			list.add(memu[i]);
			target -= (int)(p[i]*100);
			backtrack(memu, p, target, i);
			target += (int)(p[i]*100);
			list.remove(list.size()-1);
		}
	}
    public static void main(String[] args) {
        String[] memu = {"apple", "noodle", "water", "juice"};
        double[] prices = {1.55, 1.55, 5.22, 3.10};
        List<List<String>> res = memuCS(memu, prices, 6.20);
        for (List<String> r : res) {
          for (String s : r) {
             System.out.print(s+" ");
          }
           System.out.println();
        }
    }
}


