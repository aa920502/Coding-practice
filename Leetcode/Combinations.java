import java.util.List;
import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * Tags: Backtracking
 */
class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(k<0 || k>n) return ret;
        List<Integer> tmp = new ArrayList<>();
        helper(1,n,k,ret,tmp);
        return ret;
    }
    
    public void helper(int startNumber, int n,int k,List<List<Integer>> ret,List<Integer> tmp){
        if(k==0){
            ret.add(tmp);
            return;
        }
        for(int i=startNumber;i<=n;i++){
            List<Integer> tmp2 = new ArrayList<>(tmp);
            tmp2.add(i);
            helper(i+1,n,k-1,ret,tmp2);
        }
    }
}