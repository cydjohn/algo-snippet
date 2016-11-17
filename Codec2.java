/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //用stack保证root左边的点总是先被访问，然后再访问右边的节点
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
        	TreeNode cur = stack.pop();
        	sb.append(cur.val).append(" ");
        	//stack是反过来pop的，所以总是先把右边的点放进去
        	if (cur.right != null) stack.push(cur.right);
        	if (cur.left != null) stack.push(cur.left);
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	//检查边界
        if (data.length() == 0) return null;
        String[] strs = data.split(" ");
        return buildBST(strs, 0, strs.length - 1);
    }
    private TreeNode buildBST(String[] strs, int st, int end) {
    	if (st > end) return null;
    	//以第一个点作为root，之后跟着一批小于root点点作为左孩子，然后跟着一批大于root点点作为右孩子
    	TreeNode root = new TreeNode(Integer.valueOf(strs[st]));
    	int l = st + 1, r = end;
    	while (l <= r) {
    		int mid = (r - l)/2 + l;
    		if (Integer.valueOf(strs[mid]) <= root.val) l = mid + 1;
    		else r = mid - 1;
    	}
    	root.left = buildBST(strs, st+1, r);
    	root.right = buildBST(strs, l, end);
    	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));