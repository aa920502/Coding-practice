// Give rand5() function: randomly generate [0,1,2,3,4]
// Use rand5() to build rand7() and rand21()

class Rand5{
	public int rand7(){  //random number from 0 - 6
		int r = 0;
		do{
			int a = rand(5); //uniformly at random from 0 to 4
       		int b = rand(5);  //uniformly at random from 0 to 4
       		r = 5*b + a;  //uniformly at random from 0 to 24
		}
		while(r>=21);

		return r % 7; 
	}


	public int rand21(){  //random number from 0 - 20
		int r = 0;
		do{
			int a = rand(5); //uniformly at random from 0 to 4
       		int b = rand(5);  //uniformly at random from 0 to 4
       		r = 5*b + a;  //uniformly at random from 0 to 24
		}
		while(r>=21);

		return r;
	}
}