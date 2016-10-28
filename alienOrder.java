public class Solution {
    boolean[] vis = new boolean[26];
    List<Character>[] g; //for adjacent graph
    Stack<Character> stack = new Stack(); //for reverse post-order traversal
    List<Integer> other = new ArrayList(); //record those master for they might have dependency 
    Set<Integer> inPath = new HashSet(); //check if topological sort has cycle
    public String alienOrder(String[] words) {
    	//construct adjancent matrix
        g = (List<Character>[]) new List[26];
        for (int i = 0; i < words.length; i++) {
            boolean found = false;
            for (int j = 0; j < words[i].length(); j++) {
                char cur = words[i].charAt(j);
                if (g[cur-'a'] == null) g[cur-'a'] = new ArrayList(); //only intiate those chars in the string
                if (i > 0 && j < words[i-1].length() && !found && cur != words[i-1].charAt(j)) {
                    g[words[i-1].charAt(j)-'a'].add(cur);
                    found = true;
                }
            }
            if (i > 0 && !found && words[i].length() < words[i-1].length()) return ""; //["wrtkj","wrt"] invalid case
        }
        //begin search
        for (int i = 0; i < 26; i++) {
            if (vis[i] || g[i] == null) continue;
            if (g[i].size() == 0) other.add(i); //store uncertain node for future use
            else {
            	inPath.clear();
            	if (!dfs(i)) return "";
            }
        }
        //output rearrangement
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        for (int i : other) {
            if (!vis[i]) sb.append((char)(i+'a'));
        }
        return sb.toString();
    }
    //topological sort
    private boolean dfs(int i) {
    	inPath.add(i);
        vis[i] = true;
        for (char w : g[i]) {
        	if (inPath.contains(w-'a')) return false; //if has cycle, the sort is invalid
            if (vis[w-'a']) continue;
            if (!dfs(w-'a')) return false;;
        }
        stack.push((char)(i+'a'));
        inPath.remove(i); //restore parent's cycle
        return true;
    }
}