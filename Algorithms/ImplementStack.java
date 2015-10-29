//Implement a stack with pop, push, peek, isEmpty() in O(1) time

class ImplementStack{
	ListNode head;

	public MyStack() {
		head = null;
	}

	public boolean isEmpty() {
		return head != null;
	}

	public int pop() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		int res = head.val;
		head = head.next;
	}

	public int push(int val) {
		ListNode curr = new ListNode(val);
		curr.next = head;
		head = curr;
	}

	public int peek() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return head.val;
	}
}

class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val = val;
	}
}