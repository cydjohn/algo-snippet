import java.util.*;

public class Solution {
	public static String stringCompression(String s) {
		if (s == null || s.length() == 0) return s;
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i-1)) {
				sb.append(num);
				sb.append(s.charAt(i-1));
				num = 1;
			} else {
				num++;
			}
		}
		sb.append(num);
		sb.append(s.charAt(s.length()-1));
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(stringCompression("abcd"));
	}
}