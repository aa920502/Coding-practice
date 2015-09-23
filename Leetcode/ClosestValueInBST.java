// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Note:

// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.

class ClosestValueInBST{
	//Iterative
	public int closestValue(TreeNode root, double target) {
        double closest = Math.abs(root.val - target);
        int value = root.val;
        TreeNode current = root;
        while (current != null) {
            if (closest > Math.abs(current.val-target)) {
                closest = Math.abs(current.val-target);
                value = current.val;
            }
            if (current.val < target)
                current = current.right;
            else current = current.left;
        }
        return value; 
    }

    //Recursive
    //Closest is either the root's value (a) or the closest in the appropriate subtree (b).
    public int closestValue(TreeNode root, double target) {
	    int a = root.val;
	    TreeNode kid = target < a ? root.left : root.right;
	    if (kid == null) return a;
	    int b = closestValue(kid, target);
	    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}
}