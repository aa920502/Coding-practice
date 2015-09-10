// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

// For example, given array S = {-1 2 1 -4}, and target = 1.

// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Tags Array Two Pointers

class 3SumClosest{
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3) return -1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum  = 0;
        for(int i=0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int tmpSum = nums[i]+nums[j]+nums[k];
                int tmpDiff = Math.abs(tmpSum-target);
                if(tmpDiff==0) return tmpSum;
                if(tmpDiff<diff){
                    diff = tmpDiff;
                    sum = tmpSum;
                }
                if(tmpSum>target) k--;
                else j++;
            }
        }
        return sum;
    }
}