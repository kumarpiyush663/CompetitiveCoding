package leetcode.practice;


 
public class Merge_Sort_List {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {}

    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) return head;
        
        ListNode middle = getMiddleNode(head);
        
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        
        ListNode leftSorted = sortList(left);
        ListNode rightSorted = sortList(right);
        
        ListNode mergedList = mergeListNode(leftSorted,rightSorted);
        
        return mergedList;
    }
    
    public static ListNode mergeListNode(ListNode a, ListNode b){
        if(a==null) return b;
        if(b==null) return a;
        
        ListNode result;
        if(a.val<=b.val){
            result = a;
            result.next = mergeListNode(a.next,b);
        }
        else{
            result = b;
            result.next = mergeListNode(a,b.next);
        }
        return result;
    }
    
    
    public static ListNode getMiddleNode(ListNode head){
        if(head==null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
