//Heap + HashMap + queue O(nlogn)
public class Solution {
	public class Freq{
		char c;
		int f;
		public Freq(char c, int f) {
		    this.c = c;
		    this.f = f;
		}
	}
    public String rearrangeString(String str, int k) {
        if (str == null || k == 0) return str;
        char[] chs = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (char c : chs) {
        	if (map.containsKey(c)) map.put(c, map.get(c)+1);
        	else map.put(c, 1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue(new Comparator<Freq>(){
        	public int compare(Freq a, Freq b) {
        		return b.f - a.f;
        	}
        });
        for (char key : map.keySet()) {
        	pq.add(new Freq(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        Queue<Freq> wait = new LinkedList();
        while (!pq.isEmpty()) {
        	Freq cur = pq.poll();
        	sb.append(cur.c);
        	cur.f -= 1;
        	wait.offer(cur);
        	if (wait.size() < k) continue;
        	Freq front = wait.poll();
        	if (front.f > 0) pq.add(front); //put unfixed part into the heap again
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}