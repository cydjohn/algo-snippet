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

//#2 O(N) one pass: reduce the operations of moving numbers and traversal

public class Solution {
    public void moveZeroes(int[] nums) {
    int zeroCount = 0;
    for(int i = 0 ; i< nums.length; i++) {
        if (nums[i] == 0) {
            zeroCount++;
        } else if (zeroCount > 0 ){
            nums[i-zeroCount] = nums[i];
            nums[i] = 0;
        }
    }	}
}
