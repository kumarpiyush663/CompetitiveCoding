package leetcode.practice;




 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Linked_List_Cycle_II {
	
	 public ListNode detectCycle(ListNode head) {
	        if(head==null) return null;
	        if(head.next == null) return null;
	        if(head.next == head) return head;
	        ListNode cycleNode = isCycle(head);
	        if(cycleNode==null) return null;
	        ListNode temp = head;
	        
	        while(temp!=cycleNode){
	            temp = temp.next;
	            cycleNode = cycleNode.next;
	        }
	        return temp;

	    }
	    
	    public ListNode isCycle(ListNode head){
	        if(head.next.next == null) return null;
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast.next!=null && fast.next.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	            if(slow == fast) return slow;
	        }
	        return null;
	    }

	    // TC O(n) , SC O(1)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
