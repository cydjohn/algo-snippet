public class Solution {
    public int maximumGap(int[] nums) {
    	if(nums.length < 2) return 0;
    	LSDSort(nums); //O(n)
    	int max = Integer.MIN_VALUE;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] - nums[i-1] > max) max = nums[i] - nums[i-1];
    	}
    	return max;
    }
    private void LSDSort(int[] a) {
    	int len = a.length;
    	int BITS_PER_BYTE = 8, TOTAL_BITS = 32;
    	int W = TOTAL_BITS/BITS_PER_BYTE; //4 type for a int, used as looping windows 
    	int R = 1 << BITS_PER_BYTE; //each byte is between 0 and 255
    	int MASK = R - 1;
    	int[] aux = new int[len]; 

    	for (int w = 0; w < W; w++) {
    		//caculate the frequecy of the latest (starting from the lastest sigificant side) 8 digit, i.e. count least significant 8 bits of each num in nums
    		int[] count = new int[R + 1];
    		for (int i = 0; i < len; i++) {
    			int c = (a[i] >> (w * BITS_PER_BYTE)) & MASK; // use mask to get least significant 8 bits
    			count[c+1]++; //why c+1 here?
    		}

    		// count accumulated position for each nums
    		for (int i = 0; i < R; i++) 
    			count[i+1] += count[i];

    		//for most significant 8 bits,  0 ~ 127 is pos, 128 ~ 255 is neg, so 128 ~ 255 goes first
    		if (w == W-1) {
    			int shiftLeft = count[R/2];
    			int shiftRight = count[R] - count[R/2];
    			for (int i = 0; i < R; i++) {
    				if (i < R/2) count[i] += shiftRight;
    				else count[i] -= shiftLeft;
    			}
    		}

    		//move data
    		for (int i = 0; i < len; i++) {
    			int c = (a[i] >> (w * BITS_PER_BYTE)) & MASK;
    			aux[count[c]++] = a[i];
    		}
    		//copy back
    		for (int i = 0; i < len; i++) a[i] = aux[i];
    	}

    }
}