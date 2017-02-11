import java.io.*;
import java.util.*;

//heapify -- O(m)
//total -- O(m + nlogn)
public class Solution {
  public static class Pair {
  	int val;
  	int idx;
  	public Pair(int val, int idx) {
  		this.val = val;
  		this.idx = idx;
  	}
  }
  public static List<Integer> topNinM(int[] nums, int n) {
    heapify(nums);
    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
    	public int compare(Pair a, Pair b) {
    		return b.val - a.val;
    	}
    });
    List<Integer> res = new ArrayList<>();
    pq.add(new Pair(nums[0], 0));
    while (res.size() < n) {
      Pair cur = pq.poll();
      res.add(cur.val);
      pq.add(new Pair(nums[cur.idx * 2 + 1], cur.idx * 2 + 1));
      pq.add(new Pair(nums[cur.idx * 2 + 2], cur.idx * 2 + 2));
    }
    return res;
  }
  public static void heapify(int[] nums) {
    for (int i = nums.length / 2; i >= 0; i--) {
      siftdown(nums, i);
    }
  }
  private static void siftdown(int[] nums, int k) {
    while (k < nums.length) {
      int largest = k;
      if (k * 2 + 1 < nums.length && nums[k * 2 + 1] > nums[largest]) {
        largest = k * 2 + 1;
      }
      if (k * 2 + 2 < nums.length && nums[k * 2 + 2] > nums[largest]) {
        largest = k * 2 + 2;
      }
      if (largest == k) break;
      int tmp = nums[largest];
      nums[largest] = nums[k];
      nums[k] = tmp;
      k = largest;
    }
  }

  public static void main(String[] args) {
    int[] nums = {2,3,5,7,1,7,9,3,5,9,3,10,14,18,55,100,3,23,76};
    List<Integer> res = topNinM(nums, 6);
    for (int r : res) {
       System.out.println(r);
    }
  }
}



