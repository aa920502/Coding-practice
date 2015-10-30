// Find deepest node in the binary tree

class DeepestNode{
	int deepestlevel;
	int value;

	public int Deep(Node root) {
		find(root, 0);
		return value;
	}

	public void find(Node root, int level) {
		if (root != null) {
			find(root.left, ++level);
			if (level > deepestlevel) {
				value = root.data;
				deepestlevel = level;
			}
			find(root.right, level);
		}
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}