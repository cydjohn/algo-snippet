import java.util.*;
public class Subsequence {
	static List<String> list = new ArrayList<>(); 
	static StringBuilder sb = new StringBuilder();
	public static String[] build(String s) {
		if (s == null || s.length() == 0) return null; 
		backtrack(s, 0);
		String[] res = new String[list.size()];
		list.toArray(res);
		return res;
	}
	private static void backtrack(String s, int cur) {
		if (cur <= s.length()) {
			if (cur != 0) list.add(sb.toString());
			if (cur == s.length()) return;
		} 
		for (int i = cur; i < s.length(); i++) {
			sb.append(s.charAt(i));
			backtrack(s, i+1);
			sb.delete(sb.length()-1, sb.length());
			while (i < s.length()-1 && s.charAt(i+1) == s.charAt(i)) i++;
		}
	}
	public static void main(String[] args) {
		String s = "abbc";
		String[] res = build(s);
		for (String r : res) System.out.println(r);
	}
}