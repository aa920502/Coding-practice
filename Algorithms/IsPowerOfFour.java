
//If a number is power of four, in binary, it will only have one "1" and even number of "0" on right side of "1"

class IsPowerOfFour{
	public static boolean solution(int n){
		int count = 0;
		/*Check if there is only one bit set in n*/
		if ( (n&(n&(n-1)))==0 ){
			/* count 0 bits before set bit */
			while(n > 1){
			   n >>= 1;
			   count += 1;
			}      
			/*If count is even then return true else false*/
			return (count%2 == 0)? true :false;
		}

		/* If there are more than 1 bit set then n is not a power of 4*/
		return false;
	}

	public static void main(String[] args){
		for(int n = 1; n<=257;n++){
			if(solution(n))
				System.out.println(solution(n) + " " + n);}
	}
}