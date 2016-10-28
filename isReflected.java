public class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap();
        int maxx = Integer.MIN_VALUE, minx = Integer.MAX_VALUE;
        for (int[] p : points) {
        	if (maxx < p[0]) maxx = p[0];
        	if (minx > p[0]) minx = p[0];
        	if (!map.containsKey(p[0])) map.put(p[0], new HashSet<Integer>());
        	map.get(p[0]).add(p[1]);
        }
        double y = (maxx + minx) / 2.0;//注意int的除法会导致y改变
        for (int[] p : points) {
        	if (!map.containsKey((int)(2*y - p[0])) || !map.get((int)(2*y - p[0])).contains(p[1])) return false;
        }
        return true;
    }
}