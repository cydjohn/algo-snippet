import java.util.*; 
class Node { 
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
class SumCnt {
	int sum;
	int cnt;
	public SumCnt(int sum, int cnt) {
		this.sum = sum;
		this.cnt = cnt;
	}
}
public class Company_Tree {
	private static double maxAvg = Double.MIN_VALUE;
	private static Node res;
	public static Node getHighAvg(Node root) {
		if (root == null) return null;
		dfs(root);
		return res;
	}
	private static SumCnt dfs(Node root) {
		if (root.children == null || root.children.size() == 0) {
			return new SumCnt(root.val, 1);
		}
		int sum = root.val;
		int cnt = 1;
		for (Node c : root.children) {
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
	public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node result = getHighAvg(root);
        System.out.println(result.val + " " + maxAvg);
    }
}