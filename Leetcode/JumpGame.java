/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * Tags: Array, Greedy, DP
 */
class JumpGame {
    //Greedy
	public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) return false;
        int far = nums[0];
        for(int index = 1; index<nums.length; index++){
            if(index<=far)
                far=Math.max(far,index+nums[index]);
            else
                return false;
        }
        return far>=nums.length-1;
    }

    //DP
    public static boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length == 1) return true; // already reach last index
        if (A[0] == 0) return false; // note its important cause we start from 1
        int maxJump = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            maxJump = Math.max(maxJump - 1, A[i]);
            if (maxJump == 0) return false;
        }
        return true;
    }

}