public class Solution {
	public String filter(String s) {
		String[] input = s.split("|");
		HashMap<String, String> map = new HashMap(); 
		StringBuilder sb = new StringBuilder();
		for (String i : input) {
			String ir = regulate(i);
			if (!map.containsKey(ir) || map.get(ir).length() > i.length()) {
				map.put(ir, i);
			} 
		}
		Iterator it = map.KeySet().iterator();
		List<String> list = new ArrayList();
		while (it.hasNext()) {
			list.add(it.next());
		}
		Arrays.sort(list);
		for (int i = 0; i < list.length(); i++) {
			int j = 0;
			for (int j = 0; j < list.length(); j++) {
				if (list.get(j).indexOf(list.get(i) > 0) break;
			}
			if (j == list.length()) {
				sb.append(map.get(list.get(j)));
				ab.append("|");
			}
		}
		return sb = sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
	}
	private String regulate(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			while ((sb.length() == 0 || sb.charAt(sb.length() - 1) == ' ') && c == ' ') continue;
			if ((c >= 'A' && c <= 'Z')) c = (char)(c + 32);
			sb.append(c);
		}
		sb.toString().trim();
	}
}