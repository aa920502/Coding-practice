// Given n pairs of parentheses, write a function to generate all combinations of 
// well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

// Backtracking String


import java.util.*;

class GenerateParen{
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n<1) return res;
        helper(res,"",n,n);
        return res;
    }
    
    public void helper(List<String> res, String tmp, int left, int right){
        if(left==0&&right==0){
            res.add(tmp);
            return;
        }
        
        if(left>0){
            helper(res,tmp+"(",left-1,right);
        }
        if(right>left){
            helper(res,tmp+")",left,right-1);
        }
    }
}