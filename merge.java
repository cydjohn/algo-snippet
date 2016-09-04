public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) nums1 = nums2;
        if (nums2.length == 0) return;
        int j = 0;
        for(int i = 0; i < m+n; i++) {
            if (i >= m) nums1[i] = nums2[j++];
            else if (nums1[i] > nums2[j]) {
                swap(nums1, i, nums2, j);
                Arrays.sort(nums2);
            }
        }
    }
    private void swap(int[] nums1, int i, int[] nums2, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }
}