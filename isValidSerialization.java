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
        		root = chars.get(++i);
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