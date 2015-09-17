s// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
// How would you optimize the kthSmallest routine?

// Hint:

// Try to utilize the property of a BST.
// What if you could modify the BST node's structure?
// The optimal runtime complexity is O(height of BST).


class KthSmallestElementinaBST{

	// In order traversal
	public int kthSmallest(TreeNode root, int k) {
	    ArrayList<Integer> buffer = new ArrayList<Integer>();
	    inorderSearch(root, buffer, k);
	    return buffer.get(k-1);
	}
	public void inorderSearch(TreeNode node, ArrayList<Integer> buffer, int k){
	    if(buffer.size() >= k)
	        return;
	    if(node.left != null){
	        inorderSearch(node.left, buffer, k);
	    }
	    buffer.add(node.val);
	    if(node.right != null){
	        inorderSearch(node.right, buffer, k);
	    }
	}


	//Binary Search
	public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count)
            return kthSmallest(root.left, k);
        else if (k > count + 1) 
            return kthSmallest(root.right, k-1-count); 
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}