/**
 * Sort a linked list using insertion sort.
 * 
 * Tags: Linkedlist, Sort
 */
class InsertionSortList {

	//In place solution
	//In real interview, better copy to array and sort
	public static ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null) return head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode prev = head;
		ListNode pos = head.next;
		
		while(pos!=null){
			for(ListNode cur = pre; cur!=pos; cur = cur.next){
				if(cur.next.val>pos.val){
					prev.next = pos.next;
					pos.next = cur.next;
					cur.next = pos;
					pos=prev;
					break;
				}
			}
			prev = pos;
			pos=pos.next;
		}
		return pre.next;
	}
}