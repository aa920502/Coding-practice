//Serialize an Binary Tree, so that it can be saved into a file, also make sure it can be deserialized back

class SerializeDeserializeBinaryTree{
	public String serialize(TreeNode root) {
		// write your code here
		StringBuffer buffer = new StringBuffer(); 
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root != null){ 
			queue.offer(root); 
			buffer.append(root.val);
		}
		while(!queue.isEmpty()){ 
			int size = queue.size();
			for(int i = 0; i < size; i++){ 
				TreeNode node = queue.poll();
				if(node.left == null){ 
					buffer.append(",#");
				} 
				else { 
					buffer.append(","+node.left.val); 
					queue.offer(node.left);
				}
				if(node.right == null){ 
					buffer.append(",#");
				} 
				else { 
					buffer.append(","+node.right.val); 
					queue.offer(node.right);
				} 
			}
		}
		return buffer.toString(); 
	}

	/**
	* This method will be invoked second, the argument data is what exactly 
	* you serialized at method "serialize", that means the data is not given by 
	* system, it's given by your own serialize method. So the format of data is 
	* designed by yourself, and deserialize it here as you serialize it in
	* "serialize" method.
	*/

	public TreeNode deserialize(String data) {
		// write your code here
		if(data == null || data.length() == 0) return null; 

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		String[] arr = data.split(",");

		TreeNode root = new TreeNode(Integer.parseInt(arr[0])); 
		queue.offer(root);
		
		for(int i = 1; i < arr.length; i++){
			TreeNode left = null, right = null; 
			if(!arr[i].equals("#")){
				left = new TreeNode(Integer.parseInt(arr[i])); 
			}
			if(++i < data.length() && !arr[i].equals("#")){
				right = new TreeNode(Integer.parseInt(arr[i]));
			}
			TreeNode parent = queue.poll(); 
			parent.left = left;
			parent.right = right;
			if(left != null)
				queue.offer(left); 
			if(right != null)
				queue.offer(right); 
		}

		return root;
	}
}





