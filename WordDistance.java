public class WordDistance {
	HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap();
        for (int i = 0; i < words.length; i++) {
        	if (!map.containsKey(words[i])) {
        		map.put(words[i], new ArrayList<Integer>());
        	}
        	List<Integer> list = map.get(words[i]);//must get the list out before you add a value into it, you could not add it directly into the map
        	list.add(i);
        	map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
        	int idx1 = list1.get(i), idx2 = list2.get(j);
        	if (idx1 < idx2) {
        		min = Math.min(min, idx2 - idx1);
        		i++;
        	}else {
        		min = Math.min(min, idx1 - idx2);
        		j++;
        	}
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");