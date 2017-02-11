public class AllOne {
    Map<String, Integer> map;
    int maxValue, minValue;
    String maxKey, minKey;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) map.put(key, 1);
        else map.put(key, map.get(key)+1);
        if (map.get(key) > maxValue) {
            maxValue = map.get(key);
            maxKey = key;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        else map.put(key, map.get(key)-1);
        if (map.get(key) == 0) map.remove(key);
        if (map.get(key) < minValue) {
            maxValue = map.get(key);
            maxKey = key;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */