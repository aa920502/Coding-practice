//Fizz Buzz (looping 1 to 100 printing "fizz" if divisible by 3, "buzz" if divisible by 7, 
//and "fizz buzz" if divisible by both) 

class FizzBuzz{
	String fizbuz(int input){
		if(input%3==0 && input%7==0) 
			return "fizz buzz";
		else if(input%3==0)
			return "fizz";
		else if(input%7==0)
			return "buzz";
		return  "";
	}

	public static void main(String[] args){
		FizzBuzz f = new FizzBuzz();
		for(int i=1;i<=100;i++){
			System.out.println(i+" "+f.fizbuz(i));
		}
	}
}