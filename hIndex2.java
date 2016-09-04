//binary search
//O(logn) 71%
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len-1;
        while (lo <= hi) { //interative BS
        	int mid = lo + (hi - lo)/2;
        	if (citations[mid] == len - mid) return len - mid; //临界
        	else if (citations[mid] < len - mid) lo = mid + 1;
        	else hi = mid - 1;
        }
        return len - lo; //找不到citations[mid] == len - mid，此时citations[lo] > len - lo, citations[hi] < len - hi, 所以最优解为len - lo
    }
}