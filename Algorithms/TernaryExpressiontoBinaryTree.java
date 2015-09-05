// needs the ternary expression to be converted into a Binary tree structure.

//      a?b:c 

//        a
//       / \
//      b   c

//   a?b?c:d:e

//      a
//     / \
//    b   e
//   / \
//  c   d

class TernaryExpressiontoBinaryTree{
	// When I see a '?', it's my left child, so add to my left and go left.

	// If I see ':', then:

	// Go to my parent
	// If right is not null and parent is not not null, keep going to my parent
	// My right child is empty. Add right. Go to right.
	// Note: You will never go back to the root if it has a right child.

	public NodeC convertTtoBT (char[] values) {
	    NodeC n = new NodeC (values[0]);

	    for (int i = 1; i < values.length; i += 2) {
	        if (values[i] == '?') {
	            n.left = new NodeC (values[i + 1]);
	            n = n.left;
	        }
	        else if (values[i] == ':') {
	            n = n.parent;
	            while (n.right != null && n.parent != null ) {
	                n = n.parent;
	            }                    
	            n.right = new NodeC (values[i + 1]);
	            n = n.right;
	        }
	    }
	    return n;
	}


	// This one would be without using parent node. But using stack.

    public NodeC convertTtoBT (char[] values) {
	    char xx = values[0];
	    NodeC n = new NodeC(xx);
	    Stack<NodeC> a =  new Stack<NodeC>();
	    for (int i = 1; i < values.length; i += 2) {
	        if (values[i] == '?') {
	            n.left = new NodeC (values[i + 1]);
	            a.add(n);
	            n = n.left;

	        }
	        else if (values[i] == ':') {
	            n = a.pop();
	            while (n.right != null) {
	                n = a.pop();
	            }             
	            n.right = new NodeC (values[i + 1]);
	            a.add(n);
	            n = n.right;
	        }
	    }
	    return n;
	}
}