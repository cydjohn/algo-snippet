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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //如果到达末尾，插入＃
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        //否则按照preorder插入string中
        sb.append(root.val).append(' ');
        sb.append(serialize(root.left)).append(' ');
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] st = data.split(" ");
        //array is passed by reference
        //如果不用reference传参数，无法确定root.right的指向位置，因为preorder需要先遍历完左边才到右边
        int[] d = new int[1];
        return dfs(st, d);
    }
    private TreeNode dfs(String[] st, int[] d) {
    	if (st[d[0]].equals("#")) {
    		d[0]++;
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(st[d[0]++]));
    	root.left = dfs(st, d);
    	root.right = dfs(st, d);
    	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));