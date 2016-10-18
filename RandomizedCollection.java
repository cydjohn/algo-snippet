public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap();
        list = new ArrayList();       
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        if (!map.containsKey(val)) {
            map.put(val, new HashSet());
            res = true;
        }
        map.get(val).add(list.size());
        list.add(val);
        return res;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        if (!map.get(val).contains(list.size()-1)) {
            int idx = map.get(val).iterator().next();
            int last = list.get(list.size()-1);
            map.get(last).remove(list.size()-1);
            map.get(last).add(idx);
            map.get(val).remove(idx);
            list.set(idx, last);
            map.get(val).add(list.size()-1);
        }
        map.get(val).remove(list.size()-1);
        list.remove(list.size()-1);//remove the last node of list takes O(1);
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */