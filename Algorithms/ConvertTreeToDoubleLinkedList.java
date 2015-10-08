//Convert a binary tree to a doubly linked list

class ConvertTreeToDoubleLinkedList{
	public void convertToDoubleLinkedList(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			TreeNode left = root.left;
			convertToDoubleLinkedList(left);
			while (left.right != null) {
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		if (root.right != null) {
			TreeNode right = root.right;
			convertToDoubleLinkedList(right);
			while (right.left != null) {
				right = right.left;
			}
			right.left = root;
			root.right = right;
		}
	}
}