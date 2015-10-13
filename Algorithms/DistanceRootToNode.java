// Find distance from root to node in binary tree

public class DistanceRootToNode {

	public int getDepth(Node root, int n1) {
		if(root == null) return -1;
		if(root.data == n1) return 0;
		int left = getDepth(root.left,n1);
		int right = getDepth(root.right,n1);
		if(left==-1 && right == -1) return -1;
		return left==-1?right+1:left+1;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		DistanceRootToNode i = new DistanceRootToNode();
		System.out.println("Distance from root to 45 is : " + (i.getDepth(root, 45)));
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