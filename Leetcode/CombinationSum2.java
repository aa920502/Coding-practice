import java.util.*;
/**
 * Given a collection of candidate numbers (C) and a target number (T), find
 * all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * 
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * Tags: Array, Backtracking
 */
class CombinationSum2 {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0) return ret;

        Arrays.sort(candidates);
        helper(0,candidates,target,new ArrayList<>(),ret);
        return ret;
    }
    public static void helper(int start,int[] candidates,int target,List<Integer> tmp,List<List<Integer>> ret){
        if(target==0){
            if(!ret.contains(tmp))
                ret.add(tmp);
            return;
        }
        for(int i=start;i<candidates.length;i++){
            List<Integer> tmp2 = new ArrayList<>(tmp);
            if(candidates[i]<=target){
                tmp2.add(candidates[i]);
                int rest = target-candidates[i];
                helper(i+1,candidates,rest,tmp2,ret);
            }
        }
    }
}