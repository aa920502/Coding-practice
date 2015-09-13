// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
// The integer division should truncate toward zero.

// You may assume that the given expression is always valid.

// Some examples:
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5

class BasicCalculatorII{
	public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> st = new Stack<>();
        int number = 0;
        char sign = '+';
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10 + (int)(c-'0');
            }
            if(c!=' '&&!Character.isDigit(c) || i==s.length()-1){
                if(sign=='+') st.push(number);
                else if(sign=='-') st.push(-number);
                else if(sign=='*') st.push(st.pop()*number);
                else if(sign=='/') st.push(st.pop()/number);
                number = 0;
                sign = c;
            }
        }
        int res = 0;
        for(int i: st){
            res += i;
        }
        return res;
    }
}