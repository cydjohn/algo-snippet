//https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00
/*You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie?*/
public class Solution {
	List<String> res = new ArrayList();
	public class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	public TrieNode buildTrie(String[] words) {
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
	public void dfs(char[][] board, int i, int j, TrieNode p) {
		char c = board[i][j];
		if (c == '#' || p.next[c-'a'] == null) return;
		p = p.next[c-'a'];
		if (p.word != null) {
			res.add(p.word);
			p.word = null; //avoid duplicate answers
		} 
		board[i][j] = '#';
		if (i > 0) dfs(board, i - 1, j, p);
		if (j > 0) dfs(board, i, j - 1, p);
		if (i < board.length - 1) dfs(board, i + 1, j, p); 
		if (j < board[0].length - 1) dfs(board, i, j + 1, p);
		board[i][j] = c;
	}
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		dfs(board, i, j, root);
        	}
        }
        return res;
    }
}