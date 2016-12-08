//Dp + greedy
/*题意：给定一个长度为n的乱序的数组arr，让你求是否有i,j,k三个数，使得 arr[i] < arr[j] < arr[k] ( 0 ≤ i < j < k ≤ n-1)
思路：
设 x1为到目前为止的最小值 ，  x2为到目前为止至少有一个数比x2小的最小的数。
初始时设置x1 = x2 = INT_MAX ，然后遍历数组,不断的更新x1和x2 具体如下
num <= x1,  此时将x1设置为num
若 x1 < num <= x2，则 把x2 设置为num
x2 < num  说明有解，返回true即可
简单的说，上述的过程就是不断的缩小x1和x2，看看是否有第三个数 比x2大。
如果出现第三个数 num > x2，则之前必定还有个数x 小于x2，就是说满足 x < x2 < num，就是说有答案啦。
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) min = n; //等号不能省，否则重复的3个数字会return true
            else if (n <= min2) min2 = n;
            else return true;
        }
        return false;
    }
}



public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int[] sub = new int[3];
        sub[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > sub[len-1]) sub[len++] = nums[i];
        	else {
        		for (int j = 0; j < len; j++) {
        			if (nums[i] <= sub[j]) {
        				sub[j] = nums[i];
        				break;
        			}
        		}
        	}
        	if (len == 3) return true;
        }
        return false;
    }
}

