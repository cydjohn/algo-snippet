package airbnb;

import java.io.*;
import java.util.*;

/*
A terrain of `[5,4,2,1,2,3,2,1,0,1,2,4]` will look like
+           
++         +
++   +     +
+++ +++   ++
++++++++ +++
++++++++++++

water_amount = 8
dump_location = 1

dump_water(terrain, water_amount, dump_location)

=>
+           
++         +
++WWW+     +
+++W+++WWWW+
++++++++WW++
++++++++++++

water_amount = 8
dump_location = 10

dump_water(terrain, water_amount, dump_location)
         =>
+           
++         +
++   +WWWW +
+++ +++WWW++
++++++++W+++
++++++++++++

 */

class Solution {
    static int[] rain, height, tmp;
    static int x, y;
    public static List<List<Character>> dump_water(int[] land, int amount, int pos) {
        rain = new int[land.length];
        tmp = new int[land.length];
        height = Arrays.copyOf(land, land.length);
        dump_helper(land, amount, pos);
        List<List<Character>> res = print(land, rain);
        return res;
    }
    public static void dump_helper(int[] land, int amount, int pos) {
            while (amount > 0) {
            int minPos = findNearMin(height, pos);
            findBound(height, minPos);
            int maxPos = height[x] > height[y] ? x : y;
            int sum = dump(height, x, y, maxPos);
            if (sum <= amount) {
                for (int i = x; i < y; i++) {
                    rain[i] += tmp[i];
                    height[i] += tmp[i];
                }
                amount -= sum;
            } else {
                while (amount > 0) {
                    int i = findMax(tmp, x, y);
                    int water = tmp[i];
                    while (amount > 0 && tmp[i] == water) {
                        rain[i]++;
                        height[i]++;
                        amount--;
                        tmp[i]--;
                        i++;
                    }
                }
            }
        }
    }
    public static List<List<Character>> print (int[] land, int[] rain) {
        List<List<Character>> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int h : land) {
            if (h > max) max = h;
        }
        for (int i = 0; i <= max; i++) {
            res.add(new ArrayList<Character>());
        }
        for (int i = 0; i < land.length; i++) {
            int sp = max - land[i], sw = sp - rain[i];
               for (int j = 0; j <= max; j++) {
               if (j < sw) res.get(j).add(' ');
               else if (j < sp) res.get(j).add('W');
               else res.get(j).add('+');
            }
        }
        return res;
    }
    public static int dump(int[] height, int x, int y, int maxPos) {
        int pre = 0, sum = 0;
        Arrays.fill(tmp, 0);
        for (int i = x; i < maxPos; i++) {
            if (height[i] < pre) {
                sum += pre - height[i];
                tmp[i] += pre - height[i];
            }
            else pre = height[i];
        }
        pre = 0;
        for (int i = y; i > maxPos; i--) {
            if (height[i] < pre) {
                sum += pre - height[i];
                tmp[i] += pre - height[i];
            }
            else pre = height[i];
        }
        return sum;
    }
    public static int findNearMin(int[] height, int pos) {
        if (pos < height.length-1 && height[pos] > height[pos+1]) {
            while (pos < height.length-1 && height[pos] >= height[pos+1]) pos++;
        } else {
            while (pos > 0 && height[pos] > height[pos-1]) pos--;
        }
        return pos;
    }
    public static void findBound(int[] height, int minPos) {
        x = minPos; y = minPos;
        while (x > 0 && height[x-1] >= height[x]) x--;
        while (y < height.length-1 && height[y] <= height[y+1]) y++;
    }
    public static int findMax(int[] tmp, int l, int r) {
        int max = l;
        for (int i = l; i <= r; i++) {
            if (tmp[i] > tmp[max]) max = i;
        }
        return max;
    }
  public static void main(String[] args) {
      int[] h = {5,4,2,1,2,3,2,1,0,0,2,6};
      List<List<Character>> res = dump_water(h, 30, 5);
      for (List<Character> r : res) {
          for (char ch : r) {
              System.out.print(ch);
          }
          System.out.println();
     }
  }
}