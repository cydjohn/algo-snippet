public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack();
        for (String t : tokens) {
        	if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
        		int b = stack.pop();
        		int a = stack.pop();
        		if (t.equals("+")) stack.push(a+b);
        		if (t.equals("-")) stack.push(a-b);
        		if (t.equals("*")) stack.push(a*b);
        		else stack.push(a/b);
        	}else {
        		stack.push(Integer.parseInt(t));
        	}
        }
        return stack.pop();
    }
}