class TrieNode {
    // Initialize your data structure here.
    int val;
    TrieNode[] next;
    public TrieNode() {
    	val = 0;
    	next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = put(root, word, 1, 0);
    }

    private TrieNode put(TrieNode x, String key, int val, int d) {
    	if (x == null) x = new TrieNode();
    	if (d == key.length()) {
    		x.val = val;
    		return x;
    	}
    	char c = key.charAt(d);
    	x.next[c-'a'] = put(x.next[c-'a'], key, val, d+1);
    	return x;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return get(word) > 0;
    }

    private int get(String key) {
    	TrieNode x = get(root, key, 0);
    	if (x == null) return -1;
    	return x.val;
    }

    private TrieNode get(TrieNode x, String key, int d) {
    	if (x == null) return null;
    	if (d == key.length()) return x;
    	char c = key.charAt(d);
    	return get(x.next[c-'a'], key, d+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode x = get(root, prefix, 0);
        if (x == null) return false;
        else return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");