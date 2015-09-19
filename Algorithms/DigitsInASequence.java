// Numbers are serialized increasingly into a sequence in the format of 
// 0123456789101112131415..., which each digit occupies a position in the sequence. 

// For instance, the digit in the position 5 is 5, in the position 13 is 1, 
// in the position 19 is 4, and so on.

// Please write a function/method to get the digit on any given position.

class DigitsInASequence{
	int digitAtIndex(int index){
	    if(index < 0)
	        return -1;

	    int digits = 1;
	    while(true){
	        int numbers = countOfIntegers(digits);
	        if(index < numbers * digits)
	            return digitAtIndex(index, digits);

	        index -= digits * numbers;
	        digits++;
	    }
	    return -1;
	}

	//We can get the count of integers with n digits via the following function:

	int countOfIntegers(int digits)
	{
	    if(digits == 1)
	        return 10;

	    int count = 1;
	    for(int i = 1; i < digits; ++i)
	        count *= 10;
	    return 9 * count;
	}

	//After we know the digit inside an integer with m digits, we could get the digit with the following function:

	int digitAtIndex(int index, int digits)
	{
	    int number = beginNumber(digits) + index / digits;
	    int indexFromRight = digits - index % digits;
	    for(int i = 1; i < indexFromRight; ++i)
	        number /= 10;
	    return number % 10;
	}

	//In the function above, we need to know the first number with m digits. The first number with two digits is 10, and the first number with three digits is 100. These numbers can be calculated with the function below:

	int beginNumber(int digits)
	{
	    if(digits == 1)
	        return 0;

	    int begin = 1;
	    for(int i = 1; i < digits; ++i)
	        begin *= 10;
	    return begin;
	}
}