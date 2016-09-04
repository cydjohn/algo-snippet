//DFS: 计算连通子图的个数 O(mn)
//借助图的遍历算法DFS的思想，遍历该二维矩阵，每当遇到一个‘1’计数增一，同时以该坐标为起点dfs该矩阵把相邻坐标为‘1’的元素改为非1；最终计数的结果即是连通子图数量。
public class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == '1') {
        			cnt++;
        			dfs(grid, i, j);
        		}
        	}
        }
        return cnt;
    }
    private void dfs(char[][] g, int i, int j) {
    	if (i<0 || i>= g.length || j<0 || j >= g[0].length || g[i][j] != '1') return;
    	g[i][j] = '2';//改变当前元素值为非'1'
    	dfs(g, i+1, j);
    	dfs(g, i-1, j);
    	dfs(g, i, j+1);
    	dfs(g, i, j-1);
    }
}

//UnionFind
public class Solution {
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    	int[][] dis = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < uf.y; i++) {
        	for (int j = 0; j < uf.x; j++) {
        		if (grid[i][j] == '1') {
        			for (int[] d : dis) {
        				int x = i + d[0];
        				int y = j + d[1];
        				if (x >= 0 && x <uf.y && y >= 0 && y < uf.x && grid[x][y] == '1') 
        					uf.union(x*uf.x+y, i*uf.x+j);
        			}
        		}
        	}
        }
        return uf.count;
    }

    public class UnionFind {
    	private int[] id;
    	private int count = 0;
    	private int x;
    	private int y;

    	public UnionFind(char[][] grid) {
    		y = grid.length;
    		x = grid[0].length;
    		id = new int[x*y];
    		for (int i = 0; i < y; i++) {
    			for (int j = 0; j < x; j++) {
    				if(grid[i][j] == '1') {
    					id[i * x + j] = i * x + j;
    					count++;
    				}
    			}
    		}
    	}

    		public void union(int p, int q) {
    			int root1 = find(p);
    			int root2 = find(q);
    			if (root1 == root2) return;
    			id[root1] = root2;
    			count--;
    		}

    		public int find(int p) {
    			int root = p;
    			while (root != id[root]) {
    				root = id[root];
    			}
    			//path comprassion
    			while (p != root) {
    				int newP = id[p];
    				id[p] = root;
    				p = newP;
    			}
    			return root;
    		}
    }
}

