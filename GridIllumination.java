public class GridIllumination {
	class Point {
		int x; 
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public List<String> checkIllumination(int n, List<List<Integer>> lamps, List<List<Integer>> queries) {
		int[] row = new int[n+1];
		int[] col = new int[n+1];
		int[] dia = new int[(n+1)*2];
		int[] rdia = new int[(n+1)*2];
		Set<Point> set = new HashSet();
		for (List<Integer> l : lamps) {
			int x = l.get(0), y = l.get(1);
			set.add(new Point(x, y));
			row[x] += 1;
			col[y] += 1;
			dia[x-y+n] += 1;
			rdia[x+y] += 1;
		}
		List<String> res = new ArrayList();
		for (List<Integer> q : queries) {
			int x = q.get(0), y = q.get(1);
			List<Point> recover = new ArrayList();
			for (int i = x-1; i <= x+1 && i > 0 && i <= n; i++) {
				for (int j = y-1; j <= y+1 && j > 0 && j <= n; j++) {
					Point cur = new Point(i, j);
					if (set.contains(cur)) {
						recover.add(cur);
						row[i] -= 1;
						col[i] -= 1;
						dia[i-j+n] -= 1;
						rdia[i+j] -= 1; 
					}
				}
			}
			if (row[x] > 0 || col[x] > 0 || dia[x-y+n] > 0 || rdia[x+y] > 0) res.add("LIGHT");
			else res.add("DARK");
			for (Point r : recover) {
				row[r.x] += 1;
				col[r.y] += 1;
				dia[r.x-r.y+n] += 1;
				rdia[r.x+r.y] += 1;
			}
		}
		return res;
	}
}