public class Solution {
    boolean[] vis;
    List<Integer>[] e;
    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0 || edges[0].length == 0) return n;
        e = (List<Integer>[]) new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) e[i] = new ArrayList();
        for (int[] ed : edges) {
            int v1 = ed[0], v2 = ed[1];
            e[v1].add(v2);
            e[v2].add(v1);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            dfs(i);
            cnt++;
        }
        return cnt;
    }
    private void dfs(int i) {
        vis[i] = true;
        for (int w : e[i]) {
            if (vis[w]) continue;
            dfs(w);
        }
    }
}