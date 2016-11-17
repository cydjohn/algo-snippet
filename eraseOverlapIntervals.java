/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//greedy
//按照end递增排序，总是把先结束的interval放在前面来考虑，给后面的留出更多可能性。start则随意排序。
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
    	if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval a, Interval b) {
        		return a.end - b.end;
        	}
        });
        Interval prev = null;
        int cnt = 0;
        for (Interval i : intervals) {
        	if (prev == null || i.start >= prev.end) {
        		prev = i;
        	} else {
        		cnt++;
        	}
        }
        return cnt;
    }
}