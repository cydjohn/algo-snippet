/*问题一个走迷宫问题。给了一个矩阵，"1"代表起点，位于左上角；"9"代表重点，位于右下角；"0"代表通路，"5"代表墙。
矩阵长得是这样. 
[
  [1, 5, 5, 5, 5, 0],
  [0, 5, 0, 5, 5, 0],
  [0, 5, 0, 0, 0, 0],
  [0, 5, 0, 0, 5, 0],
  [0, 0, 0, 5, 0, 9]
]
设计一个算法，看看这个迷宫能不能从起点走到重点。*/
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.io.*;
import java.util.*;

public class Solution {
	static int[] xChange = {0, 0, -1, 1};
	static int[] yChange = {-1, 1, 0, 0};
 	public static boolean maze(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) return dfs(board, i, j);
			}
		}
		return false;
	}
	private static boolean dfs(int[][] board, int x, int y) {
		if (board[x][y] == 9) return true;
		board[x][y] = 5;
		for (int k = 0; k < 4; k++) {
			int i = x + xChange[k];
			int j = y + yChange[k];
			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 5) continue;
			if (dfs(board, i, j)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
	    int[][] board = new int[5][6];
	    board[0] = new int[]{1, 5, 5, 5, 5, 0};
	    board[1] = new int[]{0, 5, 0, 5, 5, 0};
	    board[2] = new int[]{0, 5, 0, 0, 0, 0};
	    board[3] = new int[]{0, 5, 0, 0, 5, 0};
	    board[4] = new int[]{0, 0, 0, 5, 0, 9};
	    System.out.println(maze(board));
	} 
}

//输出可行的路径
public class Solution {
	static int[] xChange = {0, 0, -1, 1};
	static int[] yChange = {-1, 1, 0, 0};
	static List<Integer> list = new ArrayList<>();
 	public static List<Integer> maze(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					list.add(i);
					list.add(j);
					dfs(board, i, j);
					return list;
				}
			}
		}
		return list;
	}
	private static boolean dfs(int[][] board, int x, int y) {
		if (board[x][y] == 9) return true;
		board[x][y] = 5;
		for (int k = 0; k < 4; k++) {
			int i = x + xChange[k];
			int j = y + yChange[k];
			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 5) continue;
			list.add(i);
			list.add(j);
			if (dfs(board, i, j)) return true;
			list.remove(list.size()-1);
			list.remove(list.size()-1);
		}
		return false;
	}
	public static void main(String[] args) {
	    int[][] board = new int[5][6];
	    board[0] = new int[]{1, 5, 5, 5, 5, 0};
	    board[1] = new int[]{0, 5, 0, 5, 5, 0};
	    board[2] = new int[]{0, 5, 0, 0, 0, 0};
	    board[3] = new int[]{0, 5, 0, 0, 5, 0};
	    board[4] = new int[]{0, 0, 0, 5, 0, 9};
	    List<Integer> list = maze(board);
	    for (int i = 0; i < list.size(); i += 2){
	    	System.out.println("["+ list.get(i) + " , " + list.get(i+1) + "]");
	    }
	} 
}