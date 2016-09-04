/*This class gets the intersection of two arrays.
1. Hashset + 2 pass. O(n) 58%
2. sort + 2 pointers. O(nlogn) 96%*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1.length==0 || nums2.length == 0)return new int[0];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret = new int[len1];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0, ptr2 = 0, cur = 0;
        while (ptr1 < len1 && ptr2 < len2) {
        	if (nums1[ptr1] < nums2[ptr2]) ptr1++;
        	else if (nums1[ptr1] > nums2[ptr2]) ptr2++;
        	else {
        		if (cur == 0 || ret[cur-1] != nums1[ptr1]) 
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

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        HashSet<Integer> temp = new HashSet();
        for (int n : nums1) {
        	set.add(n);
        }
        for (int n : nums2) {
        	if (set.contains(n)) temp.add(n);
        }
        int[] res = new int[temp.size()];
        int i = 0;
        for (Integer t : temp) {
        	res[i++] = t;
        }
        return res;
    }
}