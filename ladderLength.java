/*思路: 这个就是图论算法中的单源最短路, 求单源最短路比较通用的算法是BFS和Dijkstra, 其区别是BFS不能用于带权重的图中, 而后者可以, 可以看出在本题中两个字符串之间是无权重的, 也就是如果连通就是1, 不联通就是无穷. BFS和Dijkstra的区别是前者的时间复杂度是O(n), 后者最多优化到O(m log n), 所以如果条件成立一般选择BFS要更好.

其思路就是先把起点加到队列中, 然后每次将字典中与队首距离为1的字符串加进队列, 直到最后出队列的是终点字符串, 为确保终点字符串存在, 我们可以先在字典中加进去终点字符串.*/
public class Solution {
    public class Pair {
        String word;
        int dis;
        public Pair (String word, int dis) {
            this.word = word;
            this.dis = dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Set<String> set = new HashSet<>();
        for (String w : wordList) {
            set.add(w);
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.word.equals(endWord)) return cur.dis;
            for (int i = 0; i < cur.word.length(); i++) {
                String str = cur.word;
                for (int j = 0; j < 26; j++) {
                    char c = (char)((str.charAt(i) + j) > 'z' ? (str.charAt(i) + j - 26) : (str.charAt(i) + j));
                    String s = str.substring(0, i) + c + str.substring(i+1);
                    if (set.contains(s)) {
                        q.offer(new Pair(s, cur.dis+1));
                        set.remove(s);
                    }
                }
            }
        }
        return 0;
    }
}
