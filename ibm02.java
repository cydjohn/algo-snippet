public class Solution {
	public String superStr(String s) {
		String[] tmp = s.split("|");
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList();
		for (String t : tmp) {
			String tr = regulate(t);
			boolean isSuper = true;
			for (String l : list) {
				if (l.contains(tr)) {
					isSuper = false;
					break;
				}
				else if (tr.contains(l)) {
					list.remove(l);
					map.remove(l);
				}
			}
			if (isSuper) {
				list.add(tr);
				if (!map.containsKey(tr) || map.get(tr).length() > t.length()) {
					map.put(tr, t);
				}
			}	
		}
		List res = map.values();
		for (String r : res) {
			sb.append(r);
			ab.append("|");
		}
		return sb.substring(0, sb.length() - 1);
	}
	private String regulate(String s) {
		if (s == null) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			while (sb.length() != 0 && ch == ' ' && s.charAt(i-1) == ' ') continue; 
			if (!((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')||(ch >= '0' && ch <= '9')||(ch == ' '))) continue;
			if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
			sb.append(ch);
		}
		return sb.toString().trim();
	}
}