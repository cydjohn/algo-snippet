/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//因为必须要从最末尾开始计算并进位，所以需要使用stack将list倒置，然后不断进位
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Stack<Integer> s1 = new Stack();
    	Stack<Integer> s2 = new Stack();
    	while (l1 != null) {
    		s1.push(l1.val);
    		l1 = l1.next;
    	}
    	while (l2 != null) {
    		s2.push(l2.val);
    		l2 = l2.next;
    	}
    	int sum = 0;
    	ListNode list = new ListNode(0);
    	while (!s1.empty() || !s2.empty()) {
    		if (!s1.empty()) sum += s1.pop();
    		if (!s2.empty()) sum += s2.pop();
    		list.val = sum % 10;
    		//不能初始化为0，因为最后跳出循环时，head包含最高位，如果初始化为0，会失去最高位
    		ListNode head = new ListNode(sum / 10);
    		head.next = list;
    		list = head;
    		sum /= 10;
    	}
    	//如果最前一位为0，说明没有进位，可以忽略该位
    	return list.val == 0 ? list.next : list;
    }
}