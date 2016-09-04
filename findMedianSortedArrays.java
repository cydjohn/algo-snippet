//https://discuss.leetcode.com/topic/28602/concise-java-solution-based-on-binary-search
/*The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B:
if (aMid < bMid) Keep [aRight + bLeft]
else Keep [bRight + aLeft]*/
public class Solution {
	int m = 0, n = 0;
    public double findMedianSortedArrays(int[] numsa, int[] numsb) {
        m = numsa.length; n = numsb.length;
        /* get the medians. l and r are the medians.
           when n + m is even, l + 1 == r
           when n + m is odd, l == r*/
        int l = (m + n + 1)/2, r = (m + n + 2)/2;
        return (getKth(numsa, 0, numsb, 0, l) + getKth(numsa, 0, numsb, 0, r)) / 2.0;
    }
    private double getKth(int[] a, int sa, int[] b, int sb, int k) {
    	if (sa > m-1) return b[sb+k-1];
    	if (sb > n-1) return a[sa+k-1];
    	/*stop condition: If K == 1, that means we need find the min value of nums1 and nums2.*/
    	if (k == 1) return Math.min(a[sa], b[sb]);
    	/* get the medians of current arrays
    	   if a has not enough k/2 elements, the overall median of two current arrays must located in the current active part of b. 
    	   so we set the median of a to MAX_VAL for convinence of merging the corner cases to regular causes. */
    	int am = (sa + k/2 -1 < m) ? a[sa+k/2-1] : Integer.MAX_VALUE;
    	int bm = (sb + k/2 -1 < n) ? b[sb+k/2-1] : Integer.MAX_VALUE;
    	/* if nums1[k/2-1] < nums2[k/2-1]
           or nums2 has not enough K/2 elements
           then nums1 = nums[k/2,end] (delete nums1[0,k/2-1])*/
        /* we can guarantee nums1[0,k/2-1] is smaller than the top Kth    element. Now we only need to find the top K-K/2 element in the rest of nums1(deleted k/2 elements) and nums2*/
    	if (am < bm) return getKth(a, sa+k/2, b, sb, k-k/2);
    	else return getKth(a, sa, b, sb+k/2, k-k/2);
    }
}

