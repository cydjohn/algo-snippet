import java.util.*; 
class Node { 
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}

public class BusinessTree {
	public static class SumCnt {
	int sum;
	int cnt;
	public SumCnt(int sum, int cnt) {
		this.sum = sum;
		this.cnt = cnt;
	    }  
    }
	private static double maxAvg = Double.MIN_VALUE;
	private static Node res;
	public static Node getHighestAvgTenure(Node root) {
		if (root == null) return null;
		dfs(root);
		return res;
	}
	private static SumCnt dfs(Node root) {
		if (root.subNode == null || root.subNode.size() == 0) {
			return new SumCnt(root.value, 1);
		}
		int sum = root.value;
		int cnt = 1;
		for (Node c : root.subNode) {
			SumCnt sc = dfs(c);
			sum += sc.sum;
			cnt += sc.cnt;
		}
		double curAvg = (double) sum / cnt;
		if (curAvg > maxAvg) {
			maxAvg = curAvg;
			res = root;
		}
		return new SumCnt(sum, cnt);
	}
}