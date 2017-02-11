/*排序，然后两边分别取，复杂度O(n)

注意排完序之后应该倒着来。比如[4,5,5,6]这个 数据。*/
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length - 1) / 2, t = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i % 2 == 0) ?  nums[s--] : nums[t--] ;
        }
 
        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
    }
}

//https://leetcode.com/discuss/77133/o-n-o-1-after-median-virtual-indexing
import java.util.Random;
public class Solution {
	int m = 0;
    public void wiggleSort(int[] nums) {
        if (nums.length < 2) return;
        int lt = 0, gt = nums.length-1, i = 0;
        m = (gt - 1)/2; //used for virtual index mapping, the number of items that are larger than mid should <= the number of items smaller than mid.
        int mid = quickSelect(nums, gt/2);
    	while (i <= gt) { //put the larger items in the left to handle the problem of duplicate items with the same value of mid, such as [4,5,5,6]
    		if (nums[idx(i)] > mid) swap(nums, idx(i++), idx(lt++));
    		else if (nums[idx(i)] < mid) swap(nums, idx(i), idx(gt--));
    		else i++;
    	}
    }
    private void swap(int[] nums, int x, int y) {
    	int temp = nums[x];
    	nums[x] = nums[y];
    	nums[y] = temp;
    }
    private int idx(int i) {
    	if (i <= m) return 2*i+1;
    	else return 2*(i-m-1);
    }
    private int quickSelect(int[] a, int k) {
    	randomShuffle(a);
    	int lo = 0, hi = a.length-1;
    	while (lo < hi) {
    		int i = partition(a, lo, hi);
    		if (i > k) hi = i - 1;
    		else if (i < k) lo = i + 1;
    		else return a[i];
    	}
    	return a[lo];
    }
    private int partition(int[] a, int lo, int hi) {
    	int i = lo, j = hi + 1;
    	int pivot = a[lo];
    	while(true) {
    		while(a[++i] < pivot)
    			if (i == hi) break;
    		while(a[--j] > pivot)
    			if (j == lo) break;
    		if (i >= j) break;
    		swap(a, i, j);
    	}
    	swap(a, lo, j);
    	return j;
    }
    private void randomShuffle(int[] nums) {
        Random rm = new Random();
        for(int i = 0; i < nums.length-1; i++) {
            int j = i + rm.nextInt(nums.length-i);
            swap(nums, i, j);
        }
    }
}