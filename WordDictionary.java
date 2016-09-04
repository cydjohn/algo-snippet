class TrieNode {
    // Initialize your data structure here.
    int val;
    TrieNode[] next;
    public TrieNode() {
    	val = 0;
    	next = new TrieNode[26];
    }
}

public class WordDictionary {
	private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
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
    	if (c == '.') {
    		for (int i = 0; i < 26; i++) {
    			TrieNode temp = get(x.next[i], key, d+1);
    			if (temp != null && temp.val != 0) return temp;
    		}
    		return null;
    	}
    	else return get(x.next[c-'a'], key, d+1);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");