// You are a professional robber planning to rob houses along a street. 
// Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them 
// is that adjacent houses have security system connected and it will automatically contact the police 
// if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, 
// determine the maximum amount of money you can rob tonight without alerting the police.

class HouseRobber{
    //DP
	public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }


    //O(1) space

    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;   
        int pre =0;
        int cur =0;
        for(int i=0;i<=nums.length-1;i++){
            int next = Math.max(pre+nums[i],cur);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}