public class Solution {
	public int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser, int minLikeThreshold) {
		Set<Integer> set = new HashSet();
		Map<Integer, Integer> map = new HashMap();
		for (int[] f : followGraph_edges) {
			if (f[0] == targetUser) {
				set.add(f[1]);
			}
		}
		List<Integer> res = new ArrayList();
		for (int[] l : likeGraph_edges) {
			if (!set.contains(l[0])) continue;
			if (!map.containsKey(l[1])) {
				map.put(l[1], 1);
			} else if (map.get(l[1]) < minLikeThreshold) {
				map.put(l[1], map.get(l[1])+1);
			} 
			if (map.get(key) == minLikeThreshold) {
				res.add(key);
			} else continue;
		}
		int result = res.toArray(new int[res.size()]);
		return res;
	}
}

4 3
1 2
1 3
1 4
5 6
2 10
3 10
4 10
2 11
3 12
4 11
1
2
