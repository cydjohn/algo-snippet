//http://quiz.geeksforgeeks.org/remove-comments-given-cc-program/
//corner case discussion
public class Solution {
	public String removeComments(String prgm) {
		if (prgm == null) return "";
		int n = prgm.length();
		boolean scom = false;
		boolean mcom = false;
		boolean quote = false;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char ch = prgm.charAt(i);
			if (ch == '"') {
				if (quote) quote = false;
				else if (!quote && !scom && !mcom) quote = true;
			}
			if (scom && ch == '\n') scom = false;
			else if (mcom && ch == '*' && prgm.charAt(i+1) == '/') {
				mcom = false;
				i++;
			} else if (!quote && ch == '/' && prgm.charAt(i+1) == '/') {
				scom = true;
				i++;
			} else if (!quote && ch == '/' && prgm.charAt(i+1) == '*') {
				mcom = true;
				i++;
			} else res.append(ch);
		}
		return res.toString();
	}
}