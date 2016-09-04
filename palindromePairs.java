//https://discuss.leetcode.com/topic/39585/o-n-k-2-java-solution-with-trie-structure-n-total-number-of-words-k-average-length-of-each-word
class TrieNode {
    int val;
    TrieNode[] next;
    List<Integer> list;
    public TrieNode() {
    	val = -1;
    	next = new TrieNode[26];
    	list = new ArrayList();
    }
}

public class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
        	put(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
        	get(words, i, root);
        }
        return res;
    }
    private void put(TrieNode x, String key, int val) {
    	for (int i = key.length()-1; i >= 0; i--) {
    		char c = key.charAt(i);
    		if (x.next[c-'a'] == null) x.next[c-'a'] = new TrieNode();
    		if (isPalindrome(key, 0, i)) x.list.add(val);
    		x = x.next[c-'a'];
    	}
    	x.list.add(val);
    	x.val = val;
    }
    private void get(String[] words, int i, TrieNode x) {
    	for (int j = 0; j < words[i].length(); j++) {
    		if (x.val >= 0 && x.val != i && isPalindrome(words[i], j, words[i].length()-1)) {
    			res.add(Arrays.asList(i, x.val));
    		}
    		x = x.next[words[i].charAt(j) - 'a'];
    		if (x == null) return;
    	}
    	for (int j : x.list) {
    		if (i == j) continue;
    		res.add(Arrays.asList(i, j));
    	}
    }
    private boolean isPalindrome(String s, int i, int j) {
    	while (i < j) {
    		if (s.charAt(i++) != s.charAt(j--)) return false;
    	}
    	return true;
    }
}