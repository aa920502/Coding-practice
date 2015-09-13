/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Tags: Tree, DFS
 */

class BalancedBT{
	public class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			value=x;
		}
	}

	public static boolean isBalanced(TreeNode node){
		return GetHeight(node) != -1;
	}

	public static int GetHeight(TreeNode node){
		if(node ==null)
			return 0;
		int left = GetHeight(node.left);
		int right = GetHeight(node.right);
		if(left==-1||right==-1||Math.abs(left-right)>1)
			return -1;
		return Math.max(right,left)+1;
	}
}