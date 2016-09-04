//for all integer calculation problems, pay attention to overflow
public class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (num % mid == 0 && mid == num / mid) return true; //use division to avoid overflow
            if (mid <= num / mid) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}