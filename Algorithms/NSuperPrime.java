//A number a said to be super prime number if the number is prime and its position is also prime.
// Return first n super primes

class NSuperPrime{

	public int[] SuperPrime(int n){
		int count = 0; 
		int pos = 0; // prime position 
		int[] res = new int[n];

		int num = 2;
		while(count<n){
			if(isPrime(num)){
				pos++;
				if(isPrime(pos)){
					res[count++] = num;
				}
			}
			num = num+1;
		}
		return res;
	}

	public boolean isPrime(int n){
		if(n==1) return false;

		for(int i = 2; i<= n/2; i++){
			if(n%i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args){
		NSuperPrime n = new NSuperPrime();
		int[] res = n.SuperPrime(6);
		for(int i:res) System.out.println(i);
	}
}