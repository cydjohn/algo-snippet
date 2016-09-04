//pq ver1
public class Solution {
    PriorityQueue<Tuple> pq = new PriorityQueue();
    boolean[][] vis;
    public int kthSmallest(int[][] matrix, int k) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    	vis = new boolean[matrix.length][matrix[0].length];
    	pq.add(new Tuple(0, 0, matrix[0][0]));
    	while (k > 1) {
    		Tuple cur = pq.poll();
    		addPQ(cur.x, cur.y, matrix);
    		k--;
    	}
    	return pq.poll().val;
    }
    
    private void addPQ(int x, int y, int[][] matrix) {
        if (x + 1 < matrix.length && !vis[x+1][y]) {
            pq.add(new Tuple(x + 1, y, matrix[x+1][y]));
            vis[x+1][y] = true;
        }
        if (y + 1 < matrix[0].length && !vis[x][y+1]) {
            pq.add(new Tuple(x, y + 1, matrix[x][y+1]));
            vis[x][y+1] = true;
        }
    }

    class Tuple implements Comparable<Tuple> {
    	int x, y, val;
    	public Tuple (int x, int y, int val) {
    		this.x = x;
    		this.y = y;
    		this.val = val;
    	}
    	@Override
    	public int compareTo (Tuple that) {
    		return this.val - that.val;//accending order
    	}
    }
}


//pq ver2
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));//不需要添加右边的数，因为如果右边的比下面的数小，那么右边的上边的数肯定更小，可以先添加右边的上边的数
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}