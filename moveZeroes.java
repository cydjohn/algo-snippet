//如果不需要保持非零元素的顺序
//operation数目：非零元素以及零元素的数目的最小值
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i <= j) {
            while (i <= j && nums[j] == 0) j--;
            while (i <= j && nums[i] != 0) i++;
            if (i <= j) swap(nums, i, j);
        }
    }   
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//需要保持非零元素的数目
//operation数目：非零元素的数目
//#2 O(N) one pass: reduce the operations of moving numbers and traversal
//inspired by insersion sort
public class Solution {
    public void moveZeroes(int[] nums) {
    int zeroCount = 0;
    for(int i = 0 ; i < nums.length; i++) {
        if (nums[i] == 0) zeroCount++;
        else if (zeroCount > 0) {
            nums[i-zeroCount] = nums[i];
            nums[i] = 0;
        }
    }	
}

//window moving
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int len = nums.length;
        for (; i < len; i++) {
        	if (nums[i] == 0) break;
        }
        int l = i, r = i;
        for (int j = i+1; j < len; j++) {
        	if (nums[j] == 0) r++;
        	else {
        		swap(nums, j, l);
        		l++; r++;
        	}
        }
    }
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}


//#1 O(N^2)
public class Solution {
    public void moveZeroes(int[] nums) {
    //1. initiate a pointer back to track the last non-zero number
    	int back = nums.length - 1;
    	while (back >= 0 && nums[back] == 0) {
    		back --;
    	}
    //2. search 0 from the front with pointer front, replace the context of front and back when finding a 0 
        int front = 0; 	
    	while (front < back) {
    		if (nums[front] == 0) {
    			for (int i = front; i < back; i++) {
    				nums[i] = nums[i+1];
    			}
    			nums[back] = 0;
    			back --;
    			front = 0;
    		}
    		else {
    			front ++;
    		}
    	}
    }
}

