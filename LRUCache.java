//deque + hashmap (TLE)
//remove in list will cost linear time
/*
LRU是在OS课上有讲过。当我们访问过一个元素，设置一个元素的时候，都应该标记一下刚使用过。

我是用字典+队列实现的。要点如下

构造函数中创建一个list q和一个字典dic
get时候，如果元素存在，将q中对应的key删除，并将其插入队尾
set时候，如果元素不存在且容量过大，删除队首元素，将新插入队尾和字典。如果元素存在，只需要设置字典，和将q中对应的调到队尾即可。（先删除后插入）
*/
public class LRUCache {
    Deque<Integer> dq;
    Map<Integer, Integer> map;
    int capacity;
    
    public LRUCache(int capacity) {
        dq = new LinkedList();
        map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!dq.contains(key)) return -1;
        dq.remove(new Integer(key));
        dq.addLast(key);
        return map.get(key);
    }
    
    public void set(int key, int value) {
    	if (!dq.contains(key)) {
    		dq.addLast(key);
    		if (dq.size() > capacity) dq.removeFirst();
    	}else {
    		dq.remove(new Integer(key));
            dq.addLast(key);
    	}
        map.put(key, value);
    }
}