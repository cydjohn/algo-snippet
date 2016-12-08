public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> res = new ArrayList();
        if (nums.length == 0) return res;
        for (int n : nums) {
        	if (nums[Math.abs(n)-1] > 0) nums[Math.abs(n)-1] *= -1;
        }
        //再次遍历，如果该数字没有被mark为负，说明其不存在于原来的数组中
        for (int i = 1; i <= nums.length; i++) {
        	if (nums[i-1] > 0) res.add(i);
        }
        return res;        
    }
}