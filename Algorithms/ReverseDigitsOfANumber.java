//Reverse all digits of a number.

class ReverseDigitsOfANumber{
	public static int reverse(int n){
		int ret = 0;
		while(n!=0){
			ret = ret*10 + n%10;
			n = n/10;
		}
		return ret;
	}

	//Recursive way
	static int ret = 0;
	static int base = 1;
	public static int reverseRecursion(int n){
		if(n==0) return 0;
		reverseRecursion(n/10);
		ret = ret + base*(n%10);
		base = base * 10;
		return ret;
	}

	public static void main(String[] args){
		int test = 123456;
		System.out.println(reverse(test));
	}
}