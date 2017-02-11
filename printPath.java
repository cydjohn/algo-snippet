// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
/*然后出题，给一个board（n * n）, 然后给一个m，m ＝ 至多能过当前点的次数。返回任意起点的可能的所有路径。即board中每个点走过［1，m］遍。

举例：
12
34. 
m ＝ 2.

可能的路径为：
1243
124342
124213
......
*/
import java.io.*;
import java.util.*;

public class Solution {
	static List<List<Integer>> res = new ArrayList<>();
	static List<Integer> list = new ArrayList<>();
	static int[] xChange = {0, 0, 1, -1};
	static int[] yChange = {1, -1, 0, 0};
	public static List<List<Integer>> printPath(int[][] board, int m) {
		int n = board.length;
		int[][] vis = new int[n][n];
		for (int[] v : vis) {
			Arrays.fill(v, m);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
			    list.add(board[i][j]);
			    vis[i][j]--;
				dfs(board, vis, m, i, j);
				list.remove(0);
				vis[i][j]++;
			}
		}
		return res;
	}
	public static void dfs(int[][] board, int[][] vis, int m, int x, int y) {
		boolean ok = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (vis[i][j] == m) ok = false;
			}
		}
		if (ok) {
			res.add(new ArrayList<Integer>(list));
		}
		for (int k = 0; k < 4; k++) {
			int i = x + xChange[k];
			int j = y + yChange[k];
			if (i < 0 || i >= board.length || j < 0 || j >= board.length || vis[i][j] == 0) continue;
			vis[i][j]--;
			list.add(board[i][j]);
			dfs(board, vis, m, i, j);
			vis[i][j]++;
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
	    int[][] board = new int[2][2];
	    board[0][0] = 1;
	    board[0][1] = 2;
	    board[1][0] = 3;
	    board[1][1] = 4;
	    List<List<Integer>> res = printPath(board, 2);
	    int i = 0;
	    for (List<Integer> r : res) {
	        i++;
	        for (int n : r) {
	            System.out.print(n);
	        }
	        System.out.println();
	    }
	    System.out.println(i);
	}
}