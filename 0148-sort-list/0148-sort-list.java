/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        Queue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode node = head;
        while(node != null){
            pq.add(node);
            node = node.next;
        }
        ListNode newHead = (ListNode) pq.poll();;
        ListNode newNode = newHead;
        while(!pq.isEmpty()){
            newNode.next = pq.poll();
            newNode = newNode.next;
        }
        newNode.next = null;
        return newHead;
    }
}