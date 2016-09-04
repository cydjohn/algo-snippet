public class Solution {
    public String convertToTitle(int n) {
    	Stack<Character> ch = new Stack();
        while (n != 0) {
        	n = n - 1;
        	char c = (char)(n % 26 + 'A');
        	ch.push(c);
        	n /= 26;
        }
        StringBuilder builder = new StringBuilder();
        while (!ch.empty()) {
        	builder.append(ch.pop());
        }
        return builder.toString();
    }
}