//hashmap + heap + dfs
public class Solution {
	private List<String> ret = new LinkedList();
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap();
        for (String[] ticket : tickets) {
        	if (!graph.containsKey(ticket[0])) graph.put(ticket[0], new PriorityQueue<String>());
        	graph.get(ticket[0]).add(ticket[1]);
        }
        dfs(graph, "JFK");
        return ret;
    }

    private void dfs(HashMap<String, PriorityQueue<String>> graph, String s) {
    	while (graph.containsKey(s) && !graph.get(s).isEmpty()) {
    		String v = graph.get(s).poll();
    		dfs(graph, v);
    	}
    	ret.add(0, s);		
    }
}

//backtrack + array sort
public class Solution {
	boolean[] vis;
	List<String> res = new ArrayList();
    public List<String> findItinerary(String[][] tickets) {
        vis = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
        	public int compare(String[] a, String[] b) {
        		if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
        		else return a[0].compareTo(b[0]);
        	}
        });
        res.add("JFK");
        backtrack(tickets, 0);
        return res;
    }
    private boolean backtrack(String[][] t, int cur) {
    	if (cur == t.length) return true;
    	for (int i = 0; i < t.length; i++) {
    		if (!vis[i] && t[i][0].equals(res.get(res.size()-1))) {
    			vis[i] = true;
    			res.add(t[i][1]);
    			if (backtrack(t, cur+1)) return true;
    			vis[i] = false;
    			res.remove(res.size()-1);
    		}
    	}
    	return false;
    }
}