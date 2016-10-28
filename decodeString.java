public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() ==  0) return "";
        Stack<String> stack = new Stack();
        for (String c : s.split("")) {
        	if (c.equals("]")) {
        		StringBuilder sb = new StringBuilder();
        		while (!stack.peek().equals("[")) {
        			sb.insert(0, stack.pop());
        		}
        		stack.pop();
        		String num = "";
        		while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
        		    num = stack.pop() + num;
        		}
        		int n = Integer.parseInt(num);
        		StringBuilder sb2 = new StringBuilder();
        		for (int i = 0; i < n; i++) {
        			sb2.append(sb);
        		}
        		stack.push(sb2.toString());
        	}
        	else stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
        	res.insert(0, stack.pop());
        }
        return res.toString();
    }
}