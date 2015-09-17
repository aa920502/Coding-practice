// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

class IntToRoman{
	public String intToRoman(int num) {
		int[] intDict =new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String[] romanDict = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    	String ret = "";
    	int i = 0;
    	while(i<intDict.length && num>0){
    		if(num>=intDict[i]){
    			num-=intDict[i];
    			ret+=romanDict[i];
    		}else{
    			i++;
    		}
    	}
    	return ret;
	}
}