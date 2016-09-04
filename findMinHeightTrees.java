//Solution 1: remove the leaves with BFS
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {        
        List<Integer>[] graph = (List<Integer>[]) new List[n];
        List<Integer> leaf = new ArrayList();
        if (edges == null || edges.length == 0) {
        	for (int i = 0; i< n; i++) 
        		leaf.add(i);
        	return leaf;
        }

        for (int i = 0; i < edges.length; i++) {
        	int from = edges[i][0];
        	int to = edges[i][1];
        	if (graph[from] == null) graph[from] = new ArrayList();
        	if (graph[to] == null) graph[to] = new ArrayList();
        	graph[from].add(to);
        	graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
        	if (graph[i].size() == 1) {
        		leaf.add(i);
        	}
        }
        
        while (n > 2) {
        	n = n - leaf.size();
        	List<Integer> newLeaf = new ArrayList();
        	for (int i : leaf) {
        		int adj = graph[i].get(0);
        		graph[adj].remove(graph[adj].indexOf(i));
        		if(graph[adj].size() == 1) newLeaf.add(adj);
        	}
        	leaf = newLeaf;
        }

        return leaf;
    }
}

//Solution2: Time Limited Error
public class Solution {
	private int max = 0;
	private int[] distTo;
	private int[] edgeTo;
	private boolean[] marked;
	private static final int INFINITY = Integer.MAX_VALUE;	
	List<Integer> ret = new ArrayList<Integer>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {  	
        if (edges == null || edges.length == 0) return null;       
        marked = new boolean[n];
        distTo = new int[n];
        edgeTo = new int[n];

        List<Integer>[] graph = (List<Integer>[]) new List[n];
        for (int i = 0; i < edges.length; i++) {
        	int s = edges[i][0];
        	int t = edges[i][1];
        	if (graph[s] == null) graph[s] = new ArrayList<Integer>();
        	if (graph[t] == null) graph[t] = new ArrayList<Integer>();
        	graph[s].add(t);
        	graph[t].add(s);
        }

        for (int i = 0; i < n; i++) {
        	if (graph[i].size() == 1) {
        		//initiate the traversal info
        		Arrays.fill(edgeTo, INFINITY);
        		Arrays.fill(distTo, INFINITY);
        		Arrays.fill(marked, false);
        	    bfs(graph, i);
        	}       	
        }
        return ret;
    }

    private void bfs(List<Integer>[] graph, int s) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	distTo[s] = 0;
    	edgeTo[s] = 0;
    	marked[s] = true;
    	if (graph[s] != null) queue.offer(s);
    	boolean changed = false;
    	int key = 0;

    	while (!queue.isEmpty()) {
    		int v = queue.poll();
    		for (int w : graph[v]) {
    			if (!marked[w]) {
    		    marked[w] = true;
    			edgeTo[w] = v;
    			distTo[w] = distTo[v] + 1;
    			if (graph[w] != null) queue.offer(w);
    			if (max < distTo[w] && graph[w].size() == 1) {
    				changed = true;
    				max = distTo[w];
    				key = w;
    			}
    			}

    		}
    	}

    	if (changed) {
    		ret.clear();
    		if (max%2 == 0) {
    			int back = max/2;
    			for (int k = 0; k < back; k++) {
    				key = edgeTo[key];
    			}
    			ret.add(key);
    		}
    		else {
    			int back = (max-1)/2;
    			for (int k = 0; k < back; k++) {
    				key = edgeTo[key];
    			}
    			ret.add(key);
    			ret.add(edgeTo[key]);
    		}
    	}
    }
}