// Given a string with parentheses, return a string with balanced parentheses by removing the fewest characters possible. 
// You cannot add anything to the string.

// Examples:
// balance("()") -> "()"
// balance(")(") -> ""
// balance("(((((") -> ""
// balance("(()()(") -> "()()"
// balance(")(())(") -> "(())"
// balance(")(())(") != "()()"

class BalanceParentheses{
	// Stack stores indexes of invalid parentheses
	public static String balance(String s) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(s);

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(stack.isEmpty() || c == '(') {
				stack.push(i);
			} 
			else {
				int top = stack.peek();
				if(s.charAt(top) == ')') {
					stack.push(i);
				} else {
					stack.pop();
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.deleteCharAt(stack.pop());
		}
		return sb.toString();
	}

}