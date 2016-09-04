//rewrite Collections.sort(obj, comparator) method to sort objects.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//remove() is slow, so an improvement for the solution is to create a new arraylist ret to store the result wile traversal.
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size < 2) return intervals;
        List<Interval> res = new ArrayList();

        Collections.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval x, Interval y) {
        		return x.start - y.start;
        	}
        });

        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
        	if (intervals.get(i).start <= res.get(res.size()-1).end) {
        		res.get(res.size()-1).end = Math.max(intervals.get(i).end, res.get(res.size()-1).end);
        	}
        	else res.add(intervals.get(i));
        }
        return res;
    }
}
