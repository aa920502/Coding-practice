/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * Tags: DFS, Linked list
 */
class ConvertSortedListToBST {
	// O(nlogn) time, O(n) space
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode n = head;
        ArrayList<TreeNode> nums = new ArrayList<>();
        while(n!=null){
            nums.add(new TreeNode(n.val));
            n=n.next;
        }
        return helper(nums);
    }
    public TreeNode helper (ArrayList<TreeNode> nums){
        if(nums==null||nums.size()==0) return null;
        TreeNode root = nums.get(nums.size()/2);
        ArrayList<TreeNode> l = new ArrayList<TreeNode>(nums.subList(0,nums.size()/2));
        ArrayList<TreeNode> r = new ArrayList<TreeNode>(nums.subList(nums.size()/2 +1,nums.size()));
        root.left=helper(l);
        root.right=helper(r);
        return root;
    }


    //O(nlogn) time, O(1) space
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode runner = head;
        ListNode preMid = null;
        ListNode mid = head;
        
        while(true){
            if(runner!=null && runner.next!=null){
                runner = runner.next.next;
            }else{
                break;
            }
            preMid = mid;
            mid = mid.next;
        }
        if(preMid!=null) preMid.next=null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}