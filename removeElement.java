//暴力覆盖
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int p = 0, len = 0;
        while (p < nums.length) {
        	if (nums[p] != val) {
        		nums[len] = nums[p];
        		len++;
        	}
        	p++;
        }
        return len;
    }
}

//window moving
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int len = nums.length;
        for (; i < len; i++) {
            if (nums[i] == val) break;
        }
        int l = i, r = i;
        for (int j = i+1; j < len; j++) {
            if (nums[j] == val) r++;//增大窗口
            else {//移动窗口
                swap(nums, j, l);
                l++; r++;
            }
        }
        return l;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}