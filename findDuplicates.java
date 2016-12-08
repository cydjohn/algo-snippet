/*遍历nums，记当前数字为n（取绝对值），将数字n视为下标（因为a[i]∈[1, n]）

当n首次出现时，nums[n - 1]乘以-1

当n再次出现时，则nums[n - 1]一定＜0，将n加入答案*/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res = new ArrayList();
        if (nums.length == 0) return res;
        for (int n : nums) {
        	if (nums[Math.abs(n)-1] < 0) res.add(Math.abs(n));
        	else nums[Math.abs(n)-1] *= -1;
        }
        return res;
    }
}

//fail when the size of array is bigger than 32
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res = new ArrayList();
        if (nums.length == 0) return res;
        int vis = 0, vis2 = 0;
        for (int n : nums) {
        	if ((1 & (vis >> (n-1))) == 1 && (1 & (vis2 >> (n-1))) == 0) {
        		res.add(n);
        		vis2 |= (1 << (n-1));
        	}
        	else if ((1 & (vis >> (n-1))) == 0) {
        		vis |= (1 << (n-1));
        	}
        }
        return res;
    }
}