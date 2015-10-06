//Print a binary tree in level order using DFS

class PrintTreeLevelOrderDFS{

	public static void printLevelOrderDFS(TreeNode root){
        int height = maxHeight(root);
        for( int  i = 0; i < height; i++){
            printLevel(root, i);
            System.out.println();
        }
    }
    
    public static void printLevel(TreeNode node, int level){
        if(node == null)
            return;
        if(level == 0){
            System.out.print(node.data+" ");
        }else{
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }
    
    public static int maxHeight(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }	
}