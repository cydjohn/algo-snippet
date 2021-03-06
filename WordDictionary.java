//method1
public class WordDictionary {
    public class TrieNode {
        TrieNode[] next;
        boolean isWord;
        public TrieNode() {
            next = new TrieNode[26];
            isWord = false;
        }
    }
    public TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.next[c-'a'] == null) p.next[c-'a'] = new TrieNode();
            p = p.next[c-'a'];
        }
        p.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode p = root;
        return searchWith(word, p);
    }
    
    public boolean searchWith(String word, TrieNode p) {
        if (p == null) return false;
        if (word.length() == 0) {//单字母的string单substring（1）仍然存在，长度为0
            if (p != null && p.isWord) return true;
            else return false;
        }
        char c = word.charAt(0);
        if (c == '.') {
            boolean hasNext = false;
            for (int i = 0; i < 26; i++) {
                if (p.next[i] != null) {
                    hasNext = true;
                    if (searchWith(word.substring(1), p.next[i])) return true;
                }
            }
            if (!hasNext) return false;
        } else {
            return searchWith(word.substring(1), p.next[c-'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

//method2
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


class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] next;
    public TrieNode() {
        isWord = false;
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
        TrieNode x = root;
        for (int i = 0; i < word.length(); i++) {
            int p = word.charAt(i) - 'a';
            if (x.next[p] == null) x.next[p] = new TrieNode();
            x = x.next[p];
        }
        x.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word, TrieNode x) {
        if (word.length() == 0 && x.isWord) return true;//终止条件
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (x.next[j] == null) continue;
                    if (search(word.substring(i+1), x.next[j])) return true;
                }
                return false;
            }else {
                if (x.next[c-'a'] == null) return false;
                else return search(word.substring(i+1), x.next[c-'a']);
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
