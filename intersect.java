/*What if the given array is already sorted? How would you optimize your algorithm?
Solution 1, i.e., sorting,  would be better since it does not need extra memory. 
What if nums1's size is small compared to num2's size? Which algorithm is better?
If two arrays are sorted, we could use binary search, i.e., for each element in the shorter array, search in the longer one. So the overall time complexity is O(nlogm), where n is the length of the shorter array, and m is the length of the longer array. Note that this is better than Solution 1 since the time complexity is O(n + m) in the worst case. 
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
If the two arrays have relatively the same length, we can use external sort to sort out the two arrays in the disk. Then load chunks of each array into the memory and compare, by using the method 1. 
If one array is too short while the other is long, in this case, if memory is limited and nums2 is stored in disk, partition it and send portions of nums2 piece by piece. keep a pointer for nums1 indicating the current position, and it should be working fine~
Another method is, store the larger array into disk, and for each element in the shorter array, use "Exponential Search" and search in the longer array. */

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	if(nums1.length==0 || nums2.length == 0)return new int[0];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret = new int[(len1 < len2) ? len1 : len2];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0, ptr2 = 0, cur = 0;
        while (ptr1 < len1 && ptr2 < len2) {
        	if (nums1[ptr1] < nums2[ptr2]) ptr1++;
        	else if (nums1[ptr1] > nums2[ptr2]) ptr2++;
        	else {
        		ret[cur++] = nums1[ptr1];
        		ptr1++; ptr2++;
        	}
        }
        int[] ret1 = new int[cur];
        for (int i = 0; i < cur; i++) {
        	ret1[i] = ret[i];
        }
        return ret1;
    }
}