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
