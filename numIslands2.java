//Union Find
public class Solution {
	private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind2D islands = new UnionFind2D(m, n);
        List<Integer> res = new ArrayList();
        for (int[] position : positions) {
        	int x = position[0], y = position[1];
        	int p = islands.add(x, y);
        	for (int[] d : dir) {
        		int q = islands.getId(x + d[0], y + d[1]);
        		if (q > 0 && (islands.find(p) != islands.find(q))) {
        			islands.unite(p, q);
        		}
        	}
        	res.add(islands.cnt);
        }
        return res;
    }

}

class UnionFind2D {
	private int[] id;
	private int[] sz;
	public int m, n, cnt;

	public UnionFind2D(int m, int n) {
		cnt = 0;
		this.m = m;
		this.n = n;
		id = new int[m * n + 1];//初始化时id都为0，表示不是一个岛，所以id = 0不应该被占用，所以应该使用mn+1作为长度
		sz = new int[m * n + 1];
	}
	public int index(int x, int y) {
		return x * n + y + 1;
	}
	public int getId(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n) return -1;
		return id[index(x, y)];
	}
	public int add(int x, int y) {
		int i = index(x, y);
		id[i] = i;
		sz[i] = 1;
		cnt++;
		return i;
	}
	public int find(int p) {
		int root = p;
		while (root != id[root]) root = id[root];
		while (p != root) {
			int newp = id[p];
			id[p] = root;
			p = newp;
		}
		return root;
	}
	public void unite(int p, int q) {
		int i = find(p), j = find(q);
		if (i == j) return;
		if (sz[i] < sz[j]) {
			id[i] = j; 
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		cnt--;
	}
}