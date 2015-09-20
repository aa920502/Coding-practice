
//Bit Manipulation
public class addOneWithoutPlusOperator {
	public static void addOne(int num) {
		System.out.println(addOneHelper(num, 1));
	}
	public static int addOneHelper(int num, int carry) {
		if (carry == 0) {
			return num;
		}
		int sum = num ^ carry;
		int carry = (num & carry) << 1;
		return addOneHelper(sum, carry);
	}
	public static void main(String[] args){
		addOne(29);
	}
}