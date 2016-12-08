//307. Range Sum Query - Mutable
public class NumArray {
	private int[] sum;
	private int[] nums;

    public NumArray(int[] nums) {
    	sum = new int[nums.length+1];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        for (int j = i+1; j < sum.length; j += j & (-j)) {
        	sum[j] += delta;
        }
    }

    private int getSum(int i) {
    	int curSum = 0;
    	for (int j = i+1; j > 0; j -= j & (-j)) {
    		curSum += sum[j];
    	}
    	return curSum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);