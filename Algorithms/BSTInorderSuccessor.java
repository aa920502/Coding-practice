// In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. 
// Inorder Successor is NULL for the last node in Inoorder traversal.


// Method 1 (Uses Parent Pointer) 
// In this method, we assume that every node has parent pointer.
// The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.
// Input: node, root // node is the node whose Inorder successor is needed.
// output: succ // succ is Inorder successor of node.
// 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
// Go to right subtree and return the node with minimum key value in right subtree.
// 2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
// Travel up using the parent pointer until you see a node which is left child of it’s parent. 
// The parent of such a node is the succ.

// Method 2 (Search from root) 
// Parent pointer is NOT needed in this algorithm. The Algorithm is divided into two cases on the basis of 
// right subtree of the input node being empty or not.
// Input: node, root // node is the node whose Inorder successor is needed.
// output: succ // succ is Inorder successor of node.
// 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
// Go to right subtree and return the node with minimum key value in right subtree.
// 2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
// Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
// Time Complexity: O(h) where h is height of tree.

class BSTInorderSuccessor{

	// If parent pointer is provided
	// O(h) h: height of tree
	public static Node inorderSuccessor(Node root, Node node) {
		if (node.right != null) {		// Right child exists, go look for smallest node in right subtree
			return minValue(node.right);
		}

		// use parent pointer to keep looking upward until parent value is greater than node value
		Node parent = node.parent;

		while (parent != null && node.data > parent.data) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	
	// 2） No parent pointer
	// O(h)
	public static Node inorderSuccessor2(Node root, Node node) {
		if (node.right != null) {		// Right child exists, go look for smallest node in right subtree
			return minValue(node.right);
		}
		
		Node succ = null;
		while(root != null) {
			if(root.data > node.data) {	
				succ = root;		// successor value must be greater than node value, so update succ here
				root = root.left;
			}
			else if(root.data < node.data){		
				root = root.right;
			}
			else{		// Found
				break;
			}
		}
		return succ;
	}

	/*
	 * Given a non-empty binary search tree, return the minimum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	public static Node minValue(Node node) {
		Node cur = node;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

}