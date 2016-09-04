//Method 1: 2-pass conting sort

//Method 2: 1-pass in-place quick3way
public class Solution {
    public void sortColors(int[] nums) {
    	if (nums.length == 0) return;
    	int lo = 0, i = 0, gt = nums.length - 1;
    	while (i <= gt) {
    		if (nums[i] < 1) exch(nums, i++, lo++);
    		else if (nums[i] > 1) exch(nums, i, gt--);
    		else i++;
    	}
    }
    private void exch(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}

//Method 3: Formal in-place quicksort
public class Solution {
    public void sortColors(int[] nums) {
    	if (nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }
    private void quickSort(int[] nums, int lo, int hi) {
    	if (hi <= lo) return;
    	int pivot = partition(nums, lo, hi);
    	quickSort(nums, lo, pivot-1);
    	quickSort(nums, pivot+1, hi);
    }
    private int partition(int[] nums, int lo, int hi) {
    	int i = lo;
    	int j = hi+1;
    	while (true) {
    		while (nums[++i] < nums[lo]) {
    			if (i == hi) break;
    		}
    		while (nums[--j] > nums[lo]) {
    			if (j == lo) break;
    		}
    		if (i >= j) break;
    		exch(nums, i, j);
    	}
    	exch(nums, lo, j);
    	return j;
    }
    private void exch(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}

