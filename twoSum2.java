public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
        	if (numbers[l] + numbers[r] == target) return new int[]{l, r};
        	else if (numbers[l] + numbers[r] > target) r--;
        	else l++;
        }
        return new int[]{l, r};
    }
}