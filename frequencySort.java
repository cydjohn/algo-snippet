public class Solution {
	public class Pair {
		char c;
		int cnt;
		public Pair(char c, int cnt){
			this.c = c;
			this.cnt = cnt;
		}
	}
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
        	if (!map.containsKey(c)) map.put(c, 1);
        	else map.put(c, map.get(c)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>(){
        	public int compare(Pair a, Pair b) {
        		return b.cnt - a.cnt;
        	}
        });
        for (Character c : map.keySet()) {
        	Pair p = new Pair(c, map.get(c));
        	pq.add(p);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
        	Pair cur = pq.poll();
        	for (int i = 0; i < cur.cnt; i++) {
        		sb.append(cur.c);
        	}
        }
        return sb.toString();
    }
}