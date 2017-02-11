//[3,5,4,2,1]
//[5,4,3,2,1]
//Hence,

//ans = Σi = 1k(cycle_size – 1)
//where k is the number of cycles
import java.io.*;
import java.util.*;

public class Solution {
    public static int minSwap(int[] nums) {
        int swap = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] || nums[i] == n-i) continue;
            int cycle = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                j = map.get(n-j);
                cycle++;
            }
            
            swap += (cycle - 1);
        }
        return swap;
    }
    public static void main(String[] args) {
        int[] nums = {3,5,4,2,1};
        System.out.println(minSwap(nums));
    }
}