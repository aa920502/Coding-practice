// Find duplicate subtrees in a binary tree

//Check fingerprint of inorder traversal and preorder traversal
class FindDupSubtreeinBT{
    private boolean contains;
    private TreeNode node1, node2;
    
    public boolean SameSubTree(TreeNode root){
        if(root == null){
            return false;
        }
        
        contains = false;
        node1 = null;
        node2 = null;
        
        HashMap<List<Integer>, TreeNode> record = new HashMap<List<Integer>, TreeNode>();
        search(root,record);
        
        return contains;
    }
    
    private List<List<Integer>> search(TreeNode root, HashMap<List<Integer>, TreeNode> record){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null){
            res.add(new ArrayList<Integer>()); //inorder
            res.add(new ArrayList<Integer>()); //preorder
            return res;
        }
        
        List<List<Integer>> left = search(root.left, record);
        List<List<Integer>> right = search(root.right, record);
        
        List<Integer> inorder = new ArrayList<Integer>();
        List<Integer> preorder = new ArrayList<Integer>(); 
        List<Integer> key = new ArrayList<Integer>();
        
        inorder.addAll(left.get(0));
        inorder.add(root.val);
        inorder.addAll(right.get(0));
        
        preorder.add(root.val);
        preorder.addAll(left.get(1));
        preorder.addAll(right.get(1));
        
        key.addAll(inorder);
        key.addAll(preorder);
        
        if(record.containsKey(key)){
            contains = true;
            node1 = record.get(key);
            node2 = root;
        }
        
        record.put(key, root);
        res.add(inorder);
        res.add(preorder);
        return res;
    }
}