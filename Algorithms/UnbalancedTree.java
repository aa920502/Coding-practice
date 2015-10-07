//  Given an unbalanced tree, sort all paths and find smallest path  Time:O(n)
//           5
//        /     \
//       10      3
//     /   \   /
//    1     7  8
// Path:  5 10 1 ； 5 10 7 ； 5 3 8
// After Sort:  1 5 10 ； 5 7 10 ； 3 5 8；
// Order:  1 5 10 < 3 5 8 < 5 7 10；


class UnbalancedTree{
	class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
	}

	class Result{
        int min;
        ArrayList<Integer> list;
        public Result(){
            min = Integer.MAX_VALUE;
            list = new ArrayList<Integer>();
        }
	}

	public Result findMinimumNumber(TreeNode root){
        if(root == null){
            return new Result();
        }
        if(root.left == null && root.right == null){
            Result r = new Result();
            r.min = root.value;
            r.list.add(root.value);
            return r;
        }

        Result left = findMinimumNumber(root.left);
        Result right = findMinimumNumber(root.right);
        Result r = new Result();
        r.list.add(root.value);
        if(left.min < right.min){
            r.list.addAll(left.list);
        }
        else{
            r.list.addAll(right.list);
        }
        // Reset min in new Result
        r.min = Math.min(root.value, Math.min(left.min, right.min));
        return r;
	}

}