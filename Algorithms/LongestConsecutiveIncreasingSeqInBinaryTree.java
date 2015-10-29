
//Find longest consecutive increasing sequence in a binary tree

class LongestConsecutiveIncreasingSeqInBinaryTree{
	int max = 0;
	public int[] getLongestSequence(TreeNode root) {
		int[] result = new int[2];
		if (root == null) {
			return result;
		}
		int leftAsc = 1;
		int leftDsc = 1;
		int rightAsc = 1;
		int rightDsc = 1;
		if (root.left != null) {
			int leftAscSub = getLongestSequence(root.left)[0];
			int leftDscSub = getLongestSequence(root.left)[1];
			if (root.val < root.left.val) {
				leftAsc = leftAscSub + 1;
				leftDsc = 1;
			} else {
				leftAsc = 1;
				leftDsc = leftDscSub + 1;
			}
		}
		if (root.right != null) {
			int rightAscSub = getLongestSequence(root.right)[0];
			int rightDscSub = getLongestSequence(root.right)[1];
			if (root.val > root.right.val) {
				rightAsc = 1;
				rightDsc = 1 + rightDscSub;
			} else {
				rightAsc = 1 + rightAscSub;
				rightDsc = 1;
			}
		}
		result[0] = Math.max(leftAsc, rightAsc);
		result[1] = Math.max(leftDsc, rightDsc);
		max = Math.max(max, Math.max(leftAsc+rightDsc-1, leftDsc+rightAsc-1));
		return result;
	}



	//Should be from parent to child
	int max = 0;
	public int[] longestConsecutive(TreeNode root) {
		int[] result = new int[2];
		if (root == null) {
			return result;
		}
		int[] leftArray = longestConsecutive(root.left);
		int[] rightArray = longestConsecutive(root.right);
		int leftAsc = leftArray[0];
		int leftDsc = leftArray[1];
		int rightAsc = rightArray[0];
		int rightDsc = rightArray[1];
		if (root.left != null && root.val > root.left.val) {
			leftAsc = 1;
			leftDsc += 1;
		} else {
			leftAsc += 1;
			leftDsc = 1;
		}

		if (root.right != null && root.val > root.right.val) {
			rightAsc = 1;
			rightDsc += 1;
		} else {
			rightAsc += 1;
			rightDsc = 1;
		}
		result[0] = Math.max(leftAsc, rightAsc);
		result[1] = Math.max(leftDsc, rightDsct);
		max = Math.max(max, Math.max(result[0], result[1]));
		return result;
	}
}