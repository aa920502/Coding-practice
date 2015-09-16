// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

import java.util.*;


class EvaluateReversePolish{
	public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0) return -1;
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        Stack<String> st = new Stack<>();
        int res = 0;
        for(int index = 0; index<tokens.length; index++){
            if(tokens[index].equals("+")||tokens[index].equals("-")||tokens[index].equals("*")||tokens[index].equals("/")){
                if(st.size()<2) return -1;
                int i1 = Integer.parseInt(st.pop());
                int i2 = Integer.parseInt(st.pop());
                int tmpres = 0;
                if(tokens[index].equals("+")){
                    tmpres= i1+i2;
                }
                else if(tokens[index].equals("-")){
                    tmpres= i2-i1;
                }
                else if(tokens[index].equals("*")){
                    tmpres= i1*i2;
                }
                else if(tokens[index].equals("/")){
                    if(i1==0) return -1;
                    tmpres= i2/i1;
                }
                res = tmpres;
                if(st.empty()&&index==tokens.length-1) return res;
                else st.push(String.valueOf(tmpres));
            }
            else{
                st.push(tokens[index]);
            }
        }
        return -1;
    }
}