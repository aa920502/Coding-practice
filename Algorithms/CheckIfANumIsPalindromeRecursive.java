// Check if a number is palindrome recursively


class CheckIfANumIsPalindromeRecursive{

	static int duplicate;

	public static boolean isPal(int num){
		duplicate = num;
		return helper(num);
	}

	public static boolean helper(int num){
		if(num>0 && num<10)
			return num == duplicate%10;

		if(!helper(num/10)){
			return false;
		}
		else{
			duplicate = duplicate / 10;
			return num%10 == duplicate%10;
		}
	}

	public static void main(String[] args){
		int test = 101443101;
		System.out.println(isPal(test));
	}
}