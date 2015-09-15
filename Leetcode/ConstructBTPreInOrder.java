/**
 * Given preorder and inorder traversal of a tree, construct the binary tree
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Tags: Tree, Array, DFS
 */
class ConstructBTPreInOrder {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

    // root is at the head of preorder traversal
    // root is at the middle of inorder traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0||preorder.length==0) return null;
        
        int r = preorder[0];
        TreeNode root = new TreeNode(r);
        int i = getIndex(root,inorder);
        
        int[] il = Arrays.copyOfRange(inorder,0,i);
        int[] ir = Arrays.copyOfRange(inorder,i+1,inorder.length);
        int[] pl = Arrays.copyOfRange(preorder,1,i+1);
        int[] pr = Arrays.copyOfRange(preorder,i+1,preorder.length);
        
        root.left = buildTree(pl,il);
        root.right = buildTree(pr,ir);
        
        return root;
    }
    
    public int getIndex(TreeNode root, int[] inorder){
        for(int j=0;j<inorder.length;j++){
            if(inorder[j]==root.val)
                return j;
        }
        return -1;
    }
}