 // Binary Tree求and操作。例如：
 //        *               *                    *
 //      /   \           /   \                /    \
 //     1    *   and    *     0       =      *      0
 //         /  \             / \            /  \
 //        0   1            1   0          1   0
 
// Follow up: deepCopy(tree)
// Follow up2: 如何合并结果中出现的情况？
//   * 
// /   \    =>      0
// 0    0


// 这道题的意思是，每个树包含中间node和leaf node，其中leaf node可以是0或者1, internal node没有具体值，只是用于构成tree的结构。
// 当两个tree求AND关系的时候，从root开始，如果都是internal node，那么结果的数也是internal node；如果其中一个是leaf node并且值为1，
// 那么结果为另外一棵树的相同位置的subtree；如果其中一个节点是leaf并且值为0，那么结果对应的位置也为leaf并且值也为0.

// 另一个例子是：
//          *                     *                          *                        *
//        /   \                 /  \                       /  \                      / \
//       *    *     and        *    *       =              *  *            =        *    0
//     /  \   / \            / \    / \                  / \  / \                  / \
//     1   0 0  1            1  0   *  0                1  0  0  0                1   0
//                                    /\
//                                    1 0


class BinaryTreeAND{

	TreeNode BTAnd(TreeNode n1, TreeNode n2){
		//n1 is leaf
		if(n1.left==null && n1.right==null){
			if(n1.val == 1){
				n1.left = n2.left;
				n1.right = n2.right;
				n1.val = n2.val;
			}
		}
		//n2 is leaf
		if(n2.left==null && n2.right==null){
			if(n2.val == 1){
				n2.left = n1.left;
				n2.right = n1.right;
				n2.val = n1.val;
			}
		}
		//Neither is leaf
		if(n1.left!=null) BTAnd(n1.left, n2.left);
		if(n1.right!=null) BTAnd(n1.right,n2.right);

		return n1;
	}
}