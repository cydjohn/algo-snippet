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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        Arrays.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval a, Interval b) {
        		return a.start - b.start;
        	}
        });
        int cnt = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (pq.isEmpty() || pq.peek() > intervals[i].start) {
        		cnt++;
        	} else {
        		pq.poll();
        	}
        	pq.offer(intervals[i].end);
        }
        return cnt;
    }
}