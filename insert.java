//分类讨论，arraylist有add(pos, item)的函数可将item添加到指定位置，所以我们需要（1）讨论newInterval的overlap的三种情况；（2）确定pos的位置。可以通过1-pass的遍历处理。

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList();
        int size = intervals.size();
        int pos = 0;
        for (int i = 0; i < size; i++) {
        	Interval cur = intervals.get(i); //为什么能用arraylist，而不是linkedlist?
        	if (newInterval.start > cur.end) {
        		pos++;
        		ret.add(cur);
        	} 
        	else if (newInterval.end < cur.start) {
        		ret.add(cur);
        	}
        	else {
        		newInterval.start = Math.min(cur.start, newInterval.start);
        		newInterval.end = Math.max(cur.end, newInterval.end);
        	}
        }
        ret.add(pos, newInterval);
        return ret;
    }
}