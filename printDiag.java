// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
//打印一个矩阵的对角元素
import java.io.*;
import java.util.*;

public class Solution {
	static List<List<Integer>> res = new ArrayList<>();
	public static List<List<Integer>> printDiag(int[][] board) {
		for (int i = 0; i < board[0].length; i++) {
			print(board, 0, i);
		}
		for (int i = 1; i < board.length; i++) {
			print(board, i, board[0].length - 1);
		}
		return res;
	}
	private static void print(int[][] board, int i, int j) {
		if (i >= board.length || j < 0) return;
		if (res.size() == i + j) res.add(new ArrayList<Integer>());
		res.get(i + j).add(board[i][j]);
		print(board, i+1, j-1);
	}
	public static void main(String[] args) {
	    int[][] board = new int[5][6];
	    board[0] = new int[]{1, 5, 5, 5, 5, 0};
	    board[1] = new int[]{0, 5, 0, 5, 5, 0};
	    board[2] = new int[]{0, 5, 0, 0, 0, 0};
	    board[3] = new int[]{0, 5, 0, 0, 5, 0};
	    board[4] = new int[]{0, 0, 0, 5, 0, 9};
	    List<List<Integer>> list = printDiag(board);
	    for (List<Integer> l : list) {
	        for (int n : l) {
	            System.out.print(n + " ");
	        }
	        System.out.println();
	    }
	} 
}