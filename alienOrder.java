//O(V+E)
//figure out the order of "in front of"
//build total-order sequence based on partial-ordered sequence --> topological sort things
//build relation matrix List<Character>[] g, such as g[0] = (1, 2), means that 0 --> 2 (0 is in front of 2)
//visit all non-visited chars in g with post-ordered traversal, and put the reverse order of its path into a stack, which garantee that all chars that have dependency will be placed in correct causal order, and they will pop out in the correct order.
//if a cycle a exist, then return empty string.
//tricky part: how to build g?
//always compare with the char in the same index of last word: "wrf", "er": e should compare to w
//but obviously in the first row, there is no last word, we should skip the first row.
//("er", "ertt",): the last row exist, but char of the same index might not exist, in that case, we should stop comparison, and move on to next row.
//["wrtkj","wrt"] : invalid --> return ""
//["wrt", "wrf",] : g['t' - 'a'].add('f');

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        List<Integer>[] g = (List<Integer>[]) new List[256];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            char[] prev = i > 0 ? words[i-1].toCharArray() : (new char[0]);
            char[] cur = words[i].toCharArray();
            int j = 0; boolean found = false; 
            for (;j < cur.length; j++) {
                if (g[cur[j] - '0'] == null) g[cur[j] - '0'] = new ArrayList<Integer>();
                if (j < prev.length) {
                    if (!found && cur[j] != prev[j]) {
                        g[prev[j] - '0'].add(cur[j] - '0');
                        found = true;
                    }
                }  
            }
            if  (!found && j == cur.length && j < prev.length) return "";
        }
        
        boolean[] vis = new boolean[256];
        boolean[] inPath = new boolean[256];
        for (int i = 0; i < 256; i++) {
            if (vis[i] || g[i] == null) continue;
            if (hasCycle(g, stack, vis, inPath, i)) return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append((char)(stack.pop() + '0'));
        return sb.toString();
    }
    public boolean hasCycle(List<Integer>[] g, Stack<Integer> stack, boolean[] vis, boolean[] inPath, int i) {
        vis[i] = true;
        inPath[i] = true;
        for (int w : g[i]) {
            if (inPath[w]) return true;
            if (!vis[w] && hasCycle(g, stack, vis, inPath, w)) return true;
        }
        inPath[i] = false;
        stack.push(i);
        return false;
    }
}

public class Solution {
    boolean[] vis = new boolean[26];
    List<Character>[] g; //for causal relation graph
    Stack<Character> stack = new Stack(); //for reverse post-order traversal
    Set<Integer> inPath = new HashSet(); //check if topological sort has cycle
    public String alienOrder(String[] words) {
        //construct causal relation graph
        g = (List<Character>[]) new List[26];
        for (int i = 0; i < words.length; i++) {
            boolean found = false; 
            for (int j = 0; j < words[i].length(); j++) {
                char cur = words[i].charAt(j);
                if (g[cur-'a'] == null) g[cur-'a'] = new ArrayList(); //only intiate those chars in the string
                if (i > 0 && j < words[i-1].length() && !found && cur != words[i-1].charAt(j)) {
                    g[words[i-1].charAt(j)-'a'].add(cur);
                    found = true; //use found instead of break, because we still need to put chars into g, those chars might be put in random order.
                }
            }
            if (i > 0 && !found && words[i].length() < words[i-1].length()) return ""; //["wrtkj","wrt"] invalid case
        }
        //begin search
        for (int i = 0; i < 26; i++) {
            if (vis[i] || g[i] == null) continue;
            inPath.clear();
            if (!dfs(i)) return "";
        }
        //output rearrangement
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    //topological sort
    private boolean dfs(int i) {
        inPath.add(i);
        vis[i] = true;
        for (char w : g[i]) {
            if (inPath.contains(w-'a')) return false; //if has cycle, the sort is invalid
            if (vis[w-'a']) continue;//inPath check should be in front of vis check, those visited chars might involved with cycle.
            if (!dfs(w-'a')) return false;;
        }
        stack.push((char)(i+'a'));
        inPath.remove(i); //restore parent's cycle
        return true;
    }
}
