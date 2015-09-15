// Find all possible combinations of k numbers that add up to a number n, 
// given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

// Ensure that numbers within the set are sorted in ascending order.


// Example 1:

// Input: k = 3, n = 7

// Output:

// [[1,2,4]]

// Example 2:

// Input: k = 3, n = 9

// Output:

// [[1,2,6], [1,3,5], [2,3,4]]

class CombinationSum3{
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        findCombo( res, k, n, 1, new ArrayList<Integer>() );
        return res;
    }
    public void findCombo(List<List<Integer>> res, int times, int target, int startNum, List<Integer> list){
        if(times == 1){
            if(target < startNum || target > 9) return;
            list.add( target );
            res.add( list );
            return;
        }
        for(int i = startNum; i < 10; i++){
            List<Integer> subList = new ArrayList<Integer>(list);
            subList.add(i);
            findCombo( res, times - 1, target - i, i + 1, subList );
        }
    }
}