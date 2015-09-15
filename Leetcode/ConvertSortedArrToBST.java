/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * Tags: Tree, DFS
 */
class ConvertSortedArrToBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        TreeNode root = new TreeNode(nums[nums.length/2]);
        
        int[] l = Arrays.copyOfRange(nums,0,nums.length/2);
        int[] r = Arrays.copyOfRange(nums,nums.length/2 +1,nums.length);
        
        root.left=sortedArrayToBST(l);
        root.right=sortedArrayToBST(r);
        
        return root;
    }

}