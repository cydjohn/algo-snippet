/*这道题的要求是简化一个Unix风格下的文件的绝对路径。
字符串处理，由于”..”是返回上级目录（如果是根目录则不处理），因此可以考虑用栈记录路径名，以便于处理。需要注意几个细节：
重复连续出现的’/’，只按1个处理，即跳过重复连续出现的’/’；
如果路径名是”.”，则不处理；
如果路径名是”..”，则需要弹栈，如果栈为空，则不做处理；
如果路径名为其他字符串，入栈。
最后，再逐个取出栈中元素（即已保存的路径名），用’/’分隔并连接起来，不过要注意顺序呦。

时间复杂度：O(n)
空间复杂度：O(n)*/
public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) return "";
        Stack<String> stack = new Stack();
        int len = path.length();
        for (int i = 0; i < len; i++) {
        	while (i < len && path.charAt(i) == '/') i++;
        	int s = i;
        	while (i < len && path.charAt(i) != '/') i++;
        	String str = path.substring(s, i);
        	if (str.equals("..") && !stack.empty()) stack.pop();
        	else if (!str.equals(".") && !str.equals("..") && !str.equals("")) stack.push(str);
        }
        if (stack.empty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
        	sb.insert(0, stack.pop());
        	sb.insert(0, '/');
        }
        return sb.toString();
    }
}