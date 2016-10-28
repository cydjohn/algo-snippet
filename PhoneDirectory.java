
/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
//hashmap + queue
public class PhoneDirectory {
    LinkedList<Integer> list;
    Set<Integer> set;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        list = new LinkedList();
        set = new HashSet();
        for (int i = 0; i < maxNumbers; i++) {
            list.add(i);
            set.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (set.isEmpty()) return -1;
        set.remove(list.peek());
        return list.poll();
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) return;
        list.add(number);
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
//TLE because list.contains() is linear time
public class PhoneDirectory {
    LinkedList<Integer> list;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        list = new LinkedList();
        for (int i = 0; i < maxNumbers; i++) {
            list.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        return list.poll();
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return list.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        list.add(number);
    }
}
