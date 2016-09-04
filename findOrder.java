//topological sort 
//inPath check
//stack dfs postorder
public class Solution {
	boolean[] vis;
    boolean[] inPath;
    List<Integer>[] g;
    Stack<Integer> stack = new Stack();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	vis = new boolean[numCourses];
    	inPath =  new boolean[numCourses];
    	g = (List<Integer>[]) new List[numCourses];
    	for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<Integer>();
    	for (int i = 0; i < prerequisites.length; i++) {
    		g[prerequisites[i][1]].add(prerequisites[i][0]);
    	}
    	int[] res = new int[numCourses];
    	for (int i = 0; i < numCourses; i++) {
    		if (!vis[i] && hasCycle(i)) return new int[0];
    	}
    	int i = 0;
    	while (!stack.empty()) res[i++] = stack.pop();
    	return res;
    }
    private boolean hasCycle(int s) {
    	vis[s] = true;
    	inPath[s] = true;
    	for (int w : g[s]) {
    		if (inPath[w]) return true;
    		if (!vis[w] && hasCycle(w)) return true;		
    	}
    	stack.push(s);
    	inPath[s] = false; //delete s from current path
    	return false;
    }
}