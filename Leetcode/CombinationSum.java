import java.util.*;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited
 * number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * Tags: Backtracking
 */
class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0) return ret;
        
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<>(),ret);
        return ret;
    }
    public void helper(int[] candidates,int target,List<Integer> tmp,List<List<Integer>> ret){
        if(target==0){
            ret.add(tmp);
            return;
        }
        for(int i=0;i<candidates.length;i++){
            List<Integer> tmp2 = new ArrayList<>(tmp);
            if(tmp.size()>=1 && candidates[i]<tmp.get(tmp.size()-1)){
                continue;
            }
            if(candidates[i]<=target){
                tmp2.add(candidates[i]);
                helper(candidates,target-candidates[i],tmp2,ret);
            }
        }
    }
}