public class Solution {
    boolean[] vis;
    List<Integer>[] g;
    boolean hasCycle = false;
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        if (edges.length == 0 || edges[0].length == 0) return false;
        g = (List<Integer>[]) new List[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList();
        for (int[] e : edges) {
            int e1 = e[0], e2 = e[1];
            g[e1].add(e2);
            g[e2].add(e1);
        }
        dfs(0, -1);
        if (hasCycle) return false;
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }
    private void dfs(int i, int parent) {
        vis[i] = true;
        for (int w : g[i]) {
            if (vis[w] && w != parent) hasCycle = true;
            if (!vis[w]) {
               dfs(w, i);
            }
        }
    }
}