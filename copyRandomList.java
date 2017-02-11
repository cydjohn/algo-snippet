/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode p = head;
        while (p != null) {
        	RandomListNode copy = new RandomListNode(p.label);
        	map.put(p, copy);
        	p = p.next;
        }
        p = head;
        while (p != null) {
        	map.get(p).next = map.get(p.next);
        	map.get(p).random = map.get(p.random);
        	p = p.next;
        }
        return map.get(head);
    }
}

//DFS
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        return dfs(head, map);
    }
    public RandomListNode dfs(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (head == null) return null;
        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        if (!map.containsKey(head.next)) {
            RandomListNode next = dfs(head.next, map);
            node.next = next;
        } else {
            node.next = map.get(head.next);
        }
        if (!map.containsKey(head.random)) {
            RandomListNode random = dfs(head.random, map);
            node.random = random;
        } else {
            node.random = map.get(head.random);
        }
        return node;
    }
}