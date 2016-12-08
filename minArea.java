public class Solution {
	int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
	int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
	boolean[][] vis;
    public int minArea(char[][] image, int x, int y) {
    	vis = new boolean[image.length][image[0].length];
        dfs(image, x, y);
        return (maxx - minx + 1) * (maxy - miny + 1);
    }
    private void dfs(char[][] image, int x, int y) {
        if (vis[x][y] || image[x][y] == '0') return;
    	vis[x][y] = true;
    	minx = Math.min(minx, x);
    	miny = Math.min(miny, y);
    	maxx = Math.max(maxx, x);
    	maxy = Math.max(maxy, y);
    	if (x-1 >= 0) dfs(image, x - 1, y);
    	if (x+1 < image.length) dfs(image, x+1, y);
    	if (y-1 >= 0) dfs(image, x, y - 1);
    	if (y+1 < image[0].length) dfs(image, x, y+1);
    }
}