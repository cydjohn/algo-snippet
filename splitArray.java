/*将数组nums拆分成m个子数组，每个子数组的和不小于sum(nums) / m，不大于sum(nums)
又因为数组nums中只包含非负整数，因此可以通过二分法在上下界内枚举答案。
时间复杂度O(n * log m)，其中n是数组nums的长度，m为数组nums的和*/
public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0) return 0;
        long hi = 0; //有加法的地方都要注意Integer溢出
        for (int n : nums) hi += n;
        long lo = hi / m;
        while (lo <= hi) {
        	long mid = lo + (hi - lo)/2;
        	boolean isValid = true;
        	long sum = 0; int n = m;
        	for (int num : nums) {
        		if (num > mid) {
        			isValid = false;
        			break;
        		} 
        		if (sum + num > mid) {
        			sum = 0;
        			n--;
        		}
        		sum += num;
        		if (n == 0) {
        			isValid = false;
        			break;
        		}
        	}
        	if (isValid) hi = mid - 1;
        	else lo = mid + 1;
        }
        return (int)lo;
    }
}