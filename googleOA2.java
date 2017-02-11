import java.util.Stack;

public class Solution{
        public static boolean isPicture(String s) {
            if (s.endsWith(".jpeg") || s.endsWith(".png") || s.endsWith(".gif")) return true;
            return false;
        }
        public static int emptySpace(String s) {
            int i = 0;
            while (s.charAt(i) == ' ') i++;
            return i;
        }
        public static int solution(String s) {
            if (s == null || s.length() == 0) return 0;
            String[] dir = s.split("\n");
            Stack<String> stack = new Stack<>();
            int curLen = 0;
            int sum = 0;
            for (int i = 0; i < dir.length; i++) {
                if (!stack.empty() && emptySpace(dir[i]) <= emptySpace(stack.peek())) {
                    curLen -= stack.peek().length() - emptySpace(stack.peek()) + 1;
                    stack.pop();
                }
                curLen += dir[i].length() - emptySpace(dir[i]) + 1;
                if (isPicture(dir[i])) sum += curLen;
                stack.push(dir[i]);
            }
            return sum;
        }
    public static void main(String []args){
        String test = "dir1\n dir11\n dir12\n  abc.jpeg";
        System.out.println(solution(test));
    }
}

//better version:
import java.util.Stack;
public class Solution {
    public static boolean isPicture(String s) {
        if (s.endsWith(".jpeg") || s.endsWith(".png") || s.endsWith(".gif")) return true;
        return false;
    }
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf(" ")+1; // number of "\t"
            while(lev < stack.size()) stack.pop(); // find parent
            if (isPicture(s)) maxLen = Math.max(maxLen, stack.empty() ? 1 : stack.peek());
            int len = s.length()-lev+1;
            if(!stack.isEmpty()) len += stack.peek(); // remove "/t", add"/"
            stack.push(len);
        }
        return maxLen;
    }
    public static void main(String []args){
        String test = "dir1\n dir11\n dir12\n  abc.jpeg";
        //String test = "abc.jpeg";  
        System.out.println(lengthLongestPath(test));
    }
}

