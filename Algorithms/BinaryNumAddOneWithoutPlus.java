// Given an integer, add its binary number by 1 without "+"

class BinaryNumAddOneWithoutPlus{

	//Suppose n is a 32-bit integer
	 public static int add(int n) {
        for(int i = 0; i < 32; i++) {
            if (((1 << i) & n) == 0){      //until we find the first 1 bit
                n = n | (1 << i);
                break;
            }
            else
                n = n & ~(1 << i); // clean bits
        }
        return n;
    }

    public static void main(String[] args){
    	System.out.println(add(77));
    }
}