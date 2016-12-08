public class Solution {
    public boolean isValidSerialization(String preorder) {
        ArrayList<String> chars = new ArrayList<String>();
        for (String c : preorder.split(",")) {
        	chars.add(c);
        }

        Stack<String> stack = new Stack<String>();
        int i = 0;
        String root = chars.get(i);

        while (true) {
        	while (!root.equals("#")) {
        		stack.push(root);
        		if (i >= chars.size()-1) break;
        		root = chars.get(++i);//注意每次取i之前要判断是否还有下一位，如果没有return false
        	} 
            
        	if (stack.isEmpty()) break;

        	String node = stack.pop();
        	if (i >= chars.size()-1) return false;
        	root = chars.get(++i);
        }

        if (i < chars.size()-1) return false;
        else return true;
    }
}

//recurssive method
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        int[] p = new int[]{0};
        if (!dfs(s, p)) return false;
        return p[0] == s.length;
    }
    private boolean dfs(String[] s, int[] p) {
        if (p[0] >= s.length) return false;
        if (s[p[0]].equals("#")) {
            p[0]++;
            return true;
        }
        p[0]++;
        if (!dfs(s, p)) return false;
        if (!dfs(s, p)) return false;
        return true;
    }
}







