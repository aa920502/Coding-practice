// Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array 
// such that nums[i] = nums[j] and the difference between i and j is at most k.

class ContainsDuplicates2{
    //HashMap
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                map.put(nums[i],arr);
                map.get(nums[i]).add(i);
            }
        }
        
        for(int key:map.keySet()){
            if(map.get(key).size()>1){
                for(int i=1;i<map.get(key).size();i++){
                    if(map.get(key).get(i)-map.get(key).get(i-1)<=k) return true;
                }
            }
        }
        return false;
    }

    //Set and sliding window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0 || nums.length<2) return false;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i<nums.length; i++){
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}