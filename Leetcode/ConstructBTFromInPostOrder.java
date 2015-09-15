/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Tags: Tree, Array, DFS
 */
class ConstructBTFromInPostOrder {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

    // root is at the end of postorder traversal
    // root is at the middle of inorder traversal
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0) return null;
        
        int r = postorder[postorder.length-1];
        TreeNode root = new TreeNode(r);
        int i = getIndex(root,inorder);
        
        int[] il = Arrays.copyOfRange(inorder,0,i);
        int[] ir = Arrays.copyOfRange(inorder,i+1,inorder.length);
        int[] pl = Arrays.copyOfRange(postorder,0,i);
        int[] pr = Arrays.copyOfRange(postorder,i,postorder.length-1);
        
        root.left = buildTree(il,pl);
        root.right = buildTree(ir,pr);
        
        return root;
    }
    
    public int getIndex(TreeNode root, int[] inorder){
        for(int j=0;j<inorder.length;j++){
            if(inorder[j]==root.val){
                return j;
            }
        }
        return -1;
    }
	
}