// After robbing those houses on that street, the thief has found himself a new place for his thievery 
// so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
// That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain 
// the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, 
// determine the maximum amount of money you can rob tonight without alerting the police.


class HouseRobber2{
	public int rob(int[] num) {
	    if(num == null || num.length == 0)
	        return 0;
	    int len = num.length;
	    if(len == 1)
	        return num[0];
	    // Divide into two subsets
	    return Math.max(robInt(num, 0, len - 2), robInt(num, 1, len - 1));
	}

	private int robInt(int[] num, int low, int high){
	    int pre = 0, cur = 0;
	    for(int i = low; i <= high; i++){
	        int next = Math.max(pre + num[i], cur);
	        pre = cur;
	        cur = next;
	    }
	    return cur;
	}
}