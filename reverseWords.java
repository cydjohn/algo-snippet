/*给定一个字符串，以单词为单位对该字符串进行翻转，要求空间复杂度为O(1)；

额外要求：
单词之间最多只能有一个空格，多余空格要删除；
字符串首尾不能添加多余空格；
方法一：此题的一个简单的解法，就是，我们可以借助vector，把字符串的单词按序加入容器，然后直接反转容器，再更新元字符串即可，但是此方法不符合空间复杂度的要求。
方法二：经过两步解决，首先，反转整个字符串，然后从前向后遍历，每经过一个单词，反转该单词一次。但是该方法不好处理单词之间的间隙 */
//no in-place java solution, since you cannot reverse a String in-place in Java. To do string reverse in java, However, you can use StringBuffer or StringBuilder. You can also use Char[].
public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) return "";
        Stack<String> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
        	while (i < s.length() && s.charAt(i) == ' ') i++;
        	int k = i;
        	while (i < s.length() && s.charAt(i) != ' ') i++;
        	String str = s.substring(k, i);
        	stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
        	sb.append(stack.pop()).append(' ');
        }
        return sb.toString().trim();//This method returns a copy of the string, with leading and trailing whitespace omitted.
    }
}


