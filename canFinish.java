//topological sort 
//dfs inPath check
public class Solution {
	boolean[] vis;
    boolean[] inPath;
    List<Integer>[] g;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	vis = new boolean[numCourses];
    	inPath =  new boolean[numCourses];
    	//represent the g with adjacency list
    	g = (List<Integer>[]) new List[numCourses];
    	//all n shoule be initiated in graph list, otherwise code will crash in "for (int w : g[s])", since g[s] might be null (not empty).
    	for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<Integer>();
    	for (int i = 0; i < prerequisites.length; i++) {
    		g[prerequisites[i][1]].add(prerequisites[i][0]);
    	}
    	for (int i = 0; i < numCourses; i++) {
    		if (!vis[i] && hasCycle(i)) return false;
    	}
    	return true;
    }
    private boolean hasCycle(int s) {
    	vis[s] = true;
    	inPath[s] = true;
    	for (int w : g[s]) {
    		if (inPath[w]) return true;
    		if (!vis[w] && hasCycle(w)) return true;		
    	}
    	inPath[s] = false; //delete s from current path
    	return false;
    }
}