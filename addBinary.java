public class Solution {
    public String addBinary(String a, String b) {
    	if (a.equals("0") && b.equals("0")) return "0";
        Stack<Integer> stack = new Stack();
        int pa = a.length()-1, pb = b.length()-1;
        int c = 0;
        while (pa >= 0 || pb >= 0) {
        	if (pa >= 0) c += a.charAt(pa--) - '0';
        	if (pb >= 0) c += b.charAt(pb--) - '0';
        	if (c > 1) {
        		stack.push(c - 2); 
        		c = 1;
        	}
        	else {
        		stack.push(c);
        		c = 0;
        	}
        }
        if (c == 1) stack.push(c);
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
        	builder.append(stack.pop());
        }
        return builder.toString();
    }
}