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
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        } else if(lists.length == 1){
            return lists[0];
        } else{
            SortedListIterator sortedIterator = new     SortedListIterator(lists);
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(sortedIterator.hasNext()){
            temp.val = sortedIterator.next();
            temp.next = null;
            if(sortedIterator.hasNext()){
                temp.next = new ListNode();
            }
            temp = temp.next;
        }
            if(result.val == 0 && result.next==null){
                return null;
            }
        return result;
        }
    }
}

class SortedListIterator implements Iterator<Integer>{

    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    
    public SortedListIterator(ListNode[] lists){
        for(ListNode head: lists){
            if(head != null){
                pq.offer(head);   
            }
        }
    }
    
    @Override
    public boolean hasNext(){
        return !pq.isEmpty();
    }
    
    @Override
    public Integer next(){
        if(hasNext()){
            ListNode node = pq.poll();
            Integer result  = node.val;
            if(node.next != null){
                pq.offer(node.next);
            }
            return result;
        }
        return null;
    }
}