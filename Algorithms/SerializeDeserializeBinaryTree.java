//Serialize/ Deserialize binary tree

class SerializeDeserializeBinaryTree{
	public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (sb.length() != 0) sb.append(" ");
        if (root == null) {
            sb.append("#");
            return;
        }
        sb.append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    public TreeNode deserialize(String data) {
        String[] labels = data.split(" ");
        int[] i = { 0 };
        return deserialize(labels, i);
    }
    
    private TreeNode deserialize(String[] labels, int[] i) { 
        String label = labels[i[0]++];
        if (label.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(label));
        root.left = deserialize(labels, i);
        root.right = deserialize(labels, i);
        return root;
    }
}