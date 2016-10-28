//remove in list will cost O(1) time
/*
LRU是在OS课上有讲过。当我们访问过一个元素，设置一个元素的时候，都应该标记一下刚使用过。

我是用字典+队列实现的。要点如下

构造函数中创建一个list q和一个字典dic
get时候，如果元素存在，将q中对应的key删除，并将其插入队尾
set时候，如果元素不存在且容量过大，删除队首元素，将新插入队尾和字典。如果元素存在，只需要设置字典，和将q中对应的调到队尾即可。（先删除后插入）
*/
public class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToTail(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                map.remove(head.key);
                head = head.next;
                if (head != null) head.prev = null;
                else tail = null;
            }
            Node node = new Node(key, value);
            moveToTail(node);
            map.put(key, node);
        }else {
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            map.put(key, node);
        }        
    }

    private void moveToTail(Node node) {
        if (head == null && tail == null) {
            head = node;
            tail = node;
            return;
        }
        if (map.containsKey(node.key)) {
            if (node == tail) return;
            if (node == head) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        node.prev = tail;
        tail.next = node;
        node.next = null;
        tail = node;
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }
}










