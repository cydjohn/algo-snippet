//After rain, at the left from the summit, every line is no lower than its next left, and every line at the right side is no lower than its next right. Reflecting to the array, at the left side of the maximum, every number is no less than its left, and at the right side every number is no less than its right.The total increase is the volume of the water trapped.
//two direction traversal
public class Solution {
    public int trap(int[] height) {
        int pre = 0, ret = 0, maxPos = 0, len = height.length;
        //find the summit
        for (int i = 0; i < len; i++) {
        	if (height[i] > height[maxPos]) maxPos = i;
        }
        //process the left side
        for (int i = 0; i < maxPos; i++) {
        	if (height[i] < pre) ret += pre - height[i];
        	else pre = height[i];
        }
        //process the right side
        pre = 0;
        for (int i = len-1; i > maxPos; i--) {
        	if (height[i] < pre) ret += pre - height[i];
        	else pre = height[i];
        }
        return ret;
    }
}