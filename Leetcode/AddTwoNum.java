/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Tags: Linkedlist, Math
 */



class AddTwoNum{
    public ListNdoe addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummyHead = new ListNode(0); 
        ListNode d = dummyHead;
        int sum = 0; 
        while (c1 != null || c2 != null) { 
            if (c1 != null) { 
                sum += c1.val;
                c1 = c1.next; 
            }
            if (c2 != null) { 
                sum += c2.val;
                c2 = c2.next; 
            }
            d.next = new ListNode(sum % 10); // digit for current node
            sum /= 10; // carry
            d = d.next; 
        }
        if (sum == 1) d.next = new ListNode(1); // note that can have carry at the last digit
        return dummyHead.next;
    }
}