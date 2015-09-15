// Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
// the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

class ContainsDuplicate3{
    //The best data structure to do that is Binary Search Tree. 
    // As a result maintaining the tree of size k will result in time complexity O
	// Time complexity: O(N lg K)
	// In order to check if there exists any value of range abs(nums[i] - nums[j]) 
    // to simple queries can be executed both of time complexity O(lg K)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();

        for (int ind = 0; ind < nums.length; ind++) {
            //Floor: Returns the greatest element in this set less than or equal to the given element,
            final Integer floor = values.floor(nums[ind] + t);
            //Ceiling: Returns the least element in this set greater than or equal to the given element
            final Integer ceil = values.ceiling(nums[ind] - t);

            if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            //Keep range correct
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}