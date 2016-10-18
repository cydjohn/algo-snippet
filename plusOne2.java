/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Method 1:recurssive
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        int carry = helper(head);
        if (carry == 1) {
        	ListNode newHead = new ListNode(1);
        	newHead.next = head;
        	return newHead;
        }
        return head;
    }
    private int helper(ListNode node) {
    	if (node == null) return 1;
    	int carry = helper(node.next);
    	int sum = node.val + carry;
    	node.val = sum % 10;
    	return sum/10;
    }
}

//Method2: reverse * 2
//Method3: 
/*遍历链表，找到第一个不为9的数字，如果找不这样的数字，说明所有数字均为9，那么在表头新建一个值为0的新节点，进行加1处理，然后把右边所有的数字都置为0即可。举例来说：

比如1->2->3，那么第一个不为9的数字为3，对3进行加1，变成4，右边没有节点了，所以不做处理，返回1->2->4。

再比如说8->9->9，找第一个不为9的数字为8，进行加1处理变成了9，然后把后面的数字都置0，得到结果9->0->0。

再来看9->9->9的情况，找不到不为9的数字，那么再前面新建一个值为0的节点，进行加1处理变成了1，把后面的数字都置0，得到1->0->0->0。*/