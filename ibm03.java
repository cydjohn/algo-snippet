public class Solution {
	public String manageConflict(String s) {
		if (s == null) return null;
		Map<String, String> map = new HashMap();
		String[] tmp = s.split(",");
		for (int i = 0; i < s.length() - 2; i++) {
			String[] relation = tmp[i].split("->");
			map.put(relation[1], relation[0]);
		}
		List<String> boss1 = getBossList(tmp[i-2]);
		List<String> boss2 = getBossList(tmp[i-1]);
		int i = 0;
		for (; i < boss1.size(); i++) {
        	if (boss2.contains(boss1.get(i))) break;
        }
        return boss1.get(i);
	}
	private List<String> getBossList(String s) {
		if (s == null) return null;
		List<String> res = new ArrayList();
		while (map.containsKey(s)) {
			s = map.get(s);
			res.add(s);
		}
		return res;
	}
}