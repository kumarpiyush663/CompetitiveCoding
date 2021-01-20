package leetcode.practice;

public class Insertion_Sort_List {
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
	
	public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode i = head;
        ListNode prev_i = null;
        
        ListNode j = head.next;        
        ListNode prev_j = head;
        
        while(j!=null){
            while(i!=j){
                if(i.val>j.val){
                    if(i==head){
                        prev_j.next = j.next;
                        j.next = head;
                        head = j;
                        j = prev_j.next;
                        i = head;
                    }
                    else{
                        prev_j.next = j.next;
                        prev_i.next = j;
                        j.next = i;
                        j = prev_j.next;
                        prev_i = null;
                        i = head;
                    }
                    break;
                }
                else{
                    prev_i = i;
                    i = i.next; 
                }
            }
            if(i==j){
                
                prev_j = j;
                j=j.next;
                i = head;
                prev_i = null;
            }
        }
        return head;
    }

}

