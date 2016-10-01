public class Solution {
	public String outThink(String s) {
		String[] tmp = s.split(" ");
		int n = Integer.parseInt(tmp[0]);
		int p = Integer.parseInt(tmp[1]);
		int q = Integer.parseInt(tmp[2]);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String cur = "";
			if (i % p == 0 || i % q == 0) cur += "OUT";
			String is = Integer.toString(i);
			if (is.indexOf(p) >= 0 || is.indexOf(q) >= 0) cur += "THINK";
			if (cur == "") sb.append(i);
			else sb.append(cur);
			sb.append(,);
		}
		return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
	}
}