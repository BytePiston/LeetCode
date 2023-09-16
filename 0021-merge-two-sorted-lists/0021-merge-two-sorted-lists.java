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

 //Iterative Approch
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode result = new ListNode();
       ListNode r = result;
       while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                r.next = list1;
                list1 = list1.next;
                r = r.next;
            } else{
                r.next = list2;
                list2 = list2.next;
                r = r.next;
            }
       }
       while(list1 != null){
            r.next = list1;
            list1 = list1.next;
            r = r.next;
        }
        while(list2 != null){
            r.next = list2;
            list2 = list2.next;
            r = r.next;
        }       
    return result.next;    
    }
}