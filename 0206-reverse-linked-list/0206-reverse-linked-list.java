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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = null;
        ListNode next = head;
        while(next != null){
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next =temp;
        }
        head = curr;
        return head;
    }
}