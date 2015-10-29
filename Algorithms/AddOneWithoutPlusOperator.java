//Plus one without operator

//Bit Manipulation
public class addOneWithoutPlusOperator {

	public static void addOne(int num) {
		// initial carry is 1
		System.out.println(addOneHelper(num, 1));
	}
	public static int addOneHelper(int num, int carry) {
		if (carry == 0) {
			return num;
		}
		// XOR
		int sum = num ^ carry;
		// AND right most bit everytime 
		int carry = (num & carry) << 1;
		return addOneHelper(sum, carry);
	}
	public static void main(String[] args){
		addOne(29);
	}
}