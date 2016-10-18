public class TwoSum {
	Map<Integer, Integer> map = new HashMap();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number)) map.put(number, 1);
	    else map.put(number, map.get(number)+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int k : map.keySet()) {
	    	if (map.containsKey(value - k)) {
	    		if (value - k != k) return true;
	    		else if (map.get(k) > 1) return true;
	    	}
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);