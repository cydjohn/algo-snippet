//Stack O(n)
/*
首先计算字符串s中每一个字符出现的次数，得到字典counter
遍历字符串s，记当前字符为c，将counter[c] - 1
如果c已经在栈stack中，继续遍历
将字符c与栈顶元素top进行比较，若top > c并且counter[top] > 0则弹栈，重复此过程
将c入栈
算法执行过程中，栈内元素尽可能的保持递增顺序
最后，栈中剩余元素即为所求字符串*/
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        boolean[] present = new boolean[26];
        char[] ch = s.toCharArray();
        for (char c : ch) res[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
        	int idx = c - 'a';
        	res[idx]--;
        	if (present[idx]) continue;
        	while (sb.length() > 0 && c < sb.charAt(sb.length()-1) && res[sb.charAt(sb.length()-1) - 'a'] > 0) {
        		present[sb.charAt(sb.length()-1) - 'a'] = false;
        		sb.deleteCharAt(sb.length()-1);
        	}
        	sb.append(c);
        	present[idx] = true;
        }
        return sb.toString();
    }
}