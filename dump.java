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
  static int[] addW; //the number of W added to each column
  static int sum = 0; //current water amount 
  public static List<List<Character>> dump_water(int[] terrain, int water_amount, int dump_location) {  
      addW = new int[terrain.length];
      if (water_amount <= 0) return print(terrain, addW);
      if (terrain.length == 0) return null;
      //travel toward left and right to find local minimum height
      while (sum < water_amount) {
          boolean ok = false;//mark for if we could dump water anymore
          for (int i = dump_location - 1, j = dump_location; i > 0 || j < terrain.length - 1; i--, j++) {
          if (i > 0 && addW[i] == 0 && terrain[i - 1] + addW[i - 1] >= terrain[i] + addW[i] && terrain[i] + addW[i] <= terrain[i + 1] + + addW[i + 1]) {
              if (startFromCur(terrain, water_amount, terrain[i], i - 1, i + 1)) ok = true;
              if (sum == water_amount) break;
          }
          if (j < terrain.length - 1 && addW[j] == 0 && terrain[j - 1] + addW[j - 1] >= terrain[j] + addW[j] && terrain[j] + addW[j] <= terrain[j + 1] + addW[j + 1]) {
              if (startFromCur(terrain, water_amount, terrain[j], j - 1, j + 1)) ok = true;
              if (sum == water_amount) break;
          }
        }
        if (!ok) break;
      }
      
      List<List<Character>> res = print(terrain, addW);
      return res;
  }
    //start dumpping water from current index
  private static boolean startFromCur(int[] h, int max, int curHeight, int l, int r) {
      while (l > 0 && h[l + 1] + addW[l + 1] == h[l] + addW[l]) l--;
      if (h[l] + addW[l] <= h[l + 1] + addW[l + 1]) return false;
      while (r < h.length - 1 && h[r - 1] + addW[r - 1]== h[r] + addW[r]) r++;
      if (h[r] + addW[r] <= h[r - 1] + addW[r - 1]) return false;
      int diff = Math.min(h[l] - curHeight, h[r] - curHeight);
      for (int i = l + 1; i < r && sum < max; i++) {
          addW[i]++;
          sum++;
      }
      if (sum == max) return true;
      //if left pointer and right pointer reach the border
      if (l < 1 || h[l - 1] + addW[l - 1] < h[l] + addW[l]) return true;
      if (r > h.length - 2 || h[r + 1] + addW[r + 1] < h[r] + addW[r + 1]) return true;
      //update left pointer and right pointer
      if (h[l] + addW[l] > h[r] + addW[r]) r++;
      else if (h[l] + addW[l] < h[r] + addW[r]) l--;
      else {
          l--; r++;
      }
      startFromCur(h, max, curHeight + diff, l, r);
      return true;
  }
  //print out the final result
  public static List<List<Character>> print(int[] h, int[] addW) {
      List<List<Character>> res = new ArrayList<>();
      int max = Integer.MIN_VALUE;
      for (int n : h) {
          if (n > max) max = n;
      }
      for (int i = 0; i <= max; i++) {
          res.add(new ArrayList<Character>());
      }
      for (int i = 0; i < h.length; i++) {
          //start to print 'W' from index sw, and start to print '+' from index sp 
          int sp = max - h[i], sw = sp - addW[i];
          for (int j = 0; j <= max; j++) {
              if (j < sw) res.get(j).add(' ');
              else if (j < sp) res.get(j).add('W');
              else res.get(j).add('+');
          }
      }
      return res;
  }
  public static void main(String[] args) {
      int[] h = {5,4,2,1,2,3,2,1,0,0,2,6};
      List<List<Character>> res = dump_water(h, 0, 11);
      for (List<Character> r : res) {
          for (char ch : r) {
              System.out.print(ch);
          }
          System.out.println();
     }
  }
}

