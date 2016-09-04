/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/* recurssive BS involves o(logn) call stack space, so we could improve it with interative BS, which requires o(1) space.*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }
    private int binarySearch(int start, int end) {
    	if (start > end) return start; //be careful! the return should not be -1 here.
    	int mid = start + (end - start)/2;
    	if (isBadVersion(mid)) return binarySearch(start, mid-1);
    	else return binarySearch(mid+1, end);
    }
}