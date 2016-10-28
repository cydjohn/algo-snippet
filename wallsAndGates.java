//BFS
//DFS can't garantee the shortest path
public class Solution {
	int m, n;
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        m = rooms.length; n = rooms[0].length;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (rooms[i][j] == 0) queue.add(new int[]{i, j});
        	}
        }
        while (!queue.isEmpty()) {
        	int[] top = queue.poll();
        	int x = top[0], y = top[1];
        	if (x > 0 && rooms[x-1][y] == Integer.MAX_VALUE) {
        		rooms[x-1][y] = rooms[x][y] + 1;
        		queue.add(new int[]{x-1, y});
        	}
        	if (y > 0 && rooms[x][y-1] == Integer.MAX_VALUE) {
        		rooms[x][y-1] = rooms[x][y] + 1;
        		queue.add(new int[]{x, y-1});
        	}
        	if (x < m-1 && rooms[x+1][y] == Integer.MAX_VALUE) {
        		rooms[x+1][y] = rooms[x][y] + 1;
        		queue.add(new int[]{x+1, y});
        	}
        	if (y < n-1 && rooms[x][y+1] == Integer.MAX_VALUE) {
        		rooms[x][y+1] = rooms[x][y] + 1;
        		queue.add(new int[]{x, y+1});
        	}
        }
    }
}