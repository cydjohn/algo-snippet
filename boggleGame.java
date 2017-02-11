/*You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie?*/

//boolean[] uses about 1 byte per boolean value.
//BitSet uses about 1 bit per boolean value.
import java.io.*;
import java.util.*;

public class Solution {
  static List<String> res = new ArrayList<>();
  static List<BitSet> paths = new ArrayList<>();
  static BitSet vis;
  static int maxCnt = 0;
  public static class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
  }
  public static TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
      TrieNode p = root;
      for (char c : w.toCharArray()) {
        int i = c - 'a';
        if (p.next[i] == null) p.next[i] = new TrieNode();
        p = p.next[i]; 
      }
      p.word = w;
    }
    return root;
  }
  public static void dfs(char[][] board, int i, int j, TrieNode p) {
    char c = board[i][j];
    if (c == '#' || p.next[c-'a'] == null) return;
    vis.set(i*board.length+j);
    board[i][j] = '#';
    p = p.next[c-'a'];
    if (p.word != null) {
      res.add(p.word);
      paths.add((BitSet)vis.clone());
      p.word = null; //avoid duplicate answers
    } 
    if (i > 0) dfs(board, i - 1, j, p);
    if (j > 0) dfs(board, i, j - 1, p);
    if (i < board.length - 1) dfs(board, i + 1, j, p); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p);
    board[i][j] = c;
    vis.set(i*board.length+j, false);
  }
    public static void findWords(char[][] board, String[] words) {
      vis = new BitSet(board.length * board[0].length);
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
            dfs(board, i, j, root);
          }
        }
    }
    public static void backtrack(int cur, int cnt, BitSet tmp) {
      if (cur == res.size()) {
        maxCnt = Math.max(maxCnt, cnt);
        return;
      }
      for (int i = cur; i < res.size(); i++) {
        //包含该路径
        if (!tmp.intersects(paths.get(i))) {
          tmp.or(paths.get(i));
          backtrack(i+1, cnt+1, tmp);
          tmp.xor(paths.get(i));
        }
        //不包含该路径
        backtrack(i+1, cnt, tmp);
      }
    }
    public static void main(String[] args) {
      String[] b = new String[]{"oaan","etae","ihkr","iflv"};
      String[] words = new String[]{"oath","pea","eak","rain","ifl"};
	  char[][] board = new char[4][4];
	  for (int i = 0; i < board.length; i++) {
	    board[i] = b[i].toCharArray();
	  }

      findWords(board, words);
      backtrack(0, 0, new BitSet(4*4));
      System.out.println(maxCnt);
    }
}










