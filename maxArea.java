//two pointers
public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
        	int w = j - i;
        	/*always choose the direction while might get a greater max*/
        	int h = (height[i] < height[j]) ? height[i++] : height[j--];
        	max = Math.max(max, h * w);
        }
        return max;
    }
}