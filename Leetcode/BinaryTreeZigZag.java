/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * Tags: Tree, BFS, Stack
 */
class BinaryTreeZigZag {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root==null) return ret;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int leftToRight = 1;
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                
                if(leftToRight==1) tmp.add(n.val);
                else if(leftToRight!=1) tmp.add(0,n.val);

                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            ret.add(tmp);
            leftToRight*=-1;
        }
        return ret;
    }
}