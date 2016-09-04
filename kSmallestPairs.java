public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList();
        if (nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<Tuple> pq = new PriorityQueue();
        boolean[][] vis = new boolean[nums1.length][nums2.length];
        pq.add(new Tuple(0, 0, nums1[0]+nums2[0]));
        k = Math.min(k, nums1.length * nums2.length);
        while (k > 0) {
        	Tuple t = pq.poll();
        	res.add(new int[]{nums1[t.a], nums2[t.b]});
        	if (t.a + 1 < nums1.length && !vis[t.a+1][t.b]) {
        	    pq.add(new Tuple(t.a+1, t.b, nums1[t.a+1]+nums2[t.b]));
        	    vis[t.a+1][t.b] = true;
        	}
        	if (t.b + 1 < nums2.length && !vis[t.a][t.b+1]) {
        	    pq.add(new Tuple(t.a, t.b+1, nums1[t.a]+nums2[t.b+1]));
        	    vis[t.a][t.b+1] = true;
        	}
        	k--;
        }
        return res;
    }

    class Tuple implements Comparable<Tuple> {
    	int a, b, sum;
    	public Tuple(int a, int b, int sum) {
    		this.a = a;
    		this.b = b;
    		this.sum = sum;
    	}
    	@Override
    	public int compareTo(Tuple that) {
    		return this.sum - that.sum;
    	}
    }
}

//point:用vis数组来记录曾经访问过的tuple，不管是否已经被pq poll出