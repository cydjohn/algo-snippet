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