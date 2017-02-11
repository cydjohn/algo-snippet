public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
        	Map<Integer, Integer> map = new HashMap<>();
        	for (int j = 0; j < points.length; j++) {
        		if (i == j) continue;
        		int dist = getDist(points, i, j);
        		if (!map.containsKey(dist)) {
        			map.put(dist, 1);
        		} else {
        			map.put(dist, map.get(dist)+1);
        		}
        	}
        	for (int key : map.keySet()) {
        		int size = map.get(key);
        		if (size >= 2) cnt += size * (size-1);
        	}
        }
        return cnt;
    }
    public int getDist(int[][] points, int i, int j) {
    	return (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
    }
}