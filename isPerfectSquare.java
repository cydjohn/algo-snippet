public class Solution {
    public boolean isPerfectSquare(int num) {
    	if (num == 1) return true;
        int left = 0, right = num;
        while (left <= right) {
        	int mid = (right - left) / 2 + left;
        	if (num % mid == 0 && mid == num / mid) return true; //use division to avoid overflow
        	if (mid <= num / mid) left = mid + 1;
        	else right = mid - 1;
        }
        return false;
    }
}