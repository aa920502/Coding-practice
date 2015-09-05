
public class AggregateNumber{
	public boolean isAggregrateNumber(String num) {
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (isMatch(num, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean isMatch(String num, int first, int second) {
        try {
            int num1 = Integer.parseInt(num.substring(0, first));
            int num2 = Integer.parseInt(num.substring(first, second));
            StringBuilder builder = new StringBuilder();
            builder.append(num1);
            builder.append(num2);

            while (builder.length() < num.length()) {
                int num3 = num1 + num2;
                builder.append(num3);
                num1 = num2;
                num2 = num3;
            }
            return num.equals(builder.toString());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args){
    	AggregateNumber ag = new AggregateNumber();
    	System.out.println(ag.isAggregrateNumber("11132437"));	
    }
}