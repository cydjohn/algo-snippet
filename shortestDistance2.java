public class Solution {
	int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        int[][] reach = new int[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			int dis = 1;
        			cnt++;
        			boolean[][] vis = new boolean[m][n];
        			Queue<int[]> q = new LinkedList<int[]>();
        			q.offer(new int[]{i, j});
        			while (!q.isEmpty()) {
        				int size = q.size();
        				for (int k = 0; k < size; k++) {
        					int[] cur = q.poll();
        					for (int p = 0; p < 4; p++) {
        						int x = cur[0] + dir[p][0];
        						int y = cur[1] + dir[p][1];
        						if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !vis[x][y]) {
        							q.offer(new int[]{x, y});
        							sum[x][y] += dis;
        					        vis[x][y] = true;
        				        	reach[x][y]++;
        						}
        					}
        				}
        				dis++;
        			}
        		}
        	}
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 0 && reach[i][j] == cnt) {
        			min = Math.min(min, sum[i][j]);
        		}
        	}
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}