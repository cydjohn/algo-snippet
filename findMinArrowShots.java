//greedy o(nlogn)
//排序后，总是将当前的interval与之前的合并，如果没有重合的酒实在没办法只能再用新的针
public class Solution {
    public int findMinArrowShots(int[][] points) {
    	if (points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b) {
        		return a[0] - b[0];
        	}
        });
        int cnt = 1, st = points[0][0], end = points[0][1];
        for (int[] p : points) {
        	if (p[0] <= end) {
        		st = p[0];
        		end = Math.min(p[1], end);
        	} else {
        		cnt++;
        		st = p[0];
        		end = p[1];
        	}
        }
        return cnt;
    }
}