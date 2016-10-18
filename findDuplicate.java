/* BS分类条件变形
n+1个数分布在1-n的范围内则必有duplicate, 重复的数会使hi-lo+1 < count，由此可以分类BS缩小search的范围。
http://keithschwarz.com/interesting/code/find-duplicate/FindDuplicate.python.html*/
/*You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.*/
public class Solution {
    public int findDuplicate(int[] nums) {
    	//lo, hi means the value of nums, not the index
        int lo = 1, hi = nums.length-1;
        while (lo <= hi) {
        	int m = lo + (hi - lo)/2;
        	int cntM = 0, cntL = 0, cntH = 0;
        	for (int n : nums) {
        		if (n == m) cntM++;
        		if (n >= lo && n < m) cntL++;
        		if (n <= hi && n > m) cntH++;
        	}
        	if (cntM > 1) return m;
        	if (cntL > m - lo) hi = m - 1;
        	else if (cntH > hi - m) lo = m + 1;
        }
        return -1;
    }
}







