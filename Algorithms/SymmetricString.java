// 假设定义两个数字串 symmetric: 数字串翻转后和以前一样。例如:121 和 1221,翻转后依然是自己。 
// 同时如果 2 翻转后变成 5,5 翻转后变成 2,
// 6 和 9 互相翻转,0,1 和 8 翻转后是自己,别的数字(3,4,7)翻转后无效。
// 例如 12 翻转后是 51,71 翻 转后无效。给定一个 n,求所有长度为 n 的翻转.

import java.util.*;

class SymmetricString{
	public static void main(String[] args){
		int n = 20;
		for(String ss : getAllSystemicString(n)){System.out.println(ss); }
	}
	
	private static List<String> getAllSystemicString(int n){ 
		n = Math.abs(n);
		List<String> result = new ArrayList<String>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		map.put(0, 0);
		map.put(1, 1);
		map.put(8, 8);
		map.put(6, 9);
		map.put(9, 6);
		map.put(2, 5);
		map.put(5, 2); 
		result.add("0");
		for(int i = 0; i <= n; i++){
			String candidate = check(i); 
			if(candidate == null){
				continue; 
			}
			String transfer = convert(candidate, map); 
			if(transfer.equals(i + "")){
				result.add(candidate); 
			}
		}
		return result; 
	}

	private static String check(int num){ 
		String ss = "";
		while(num > 0){
			int digit = num % 10;
			if(digit == 4 || digit == 3 || digit == 7){
				return null; 
			}
			ss += digit;
			num = num / 10; 
		}
		return ss; 
	}

	private static String convert(String ss, HashMap<Integer, Integer> map){ 
		String result = "";
		for(int i = 0; i < ss.length(); i++){
			char ch = ss.charAt(i);
			int transfer = map.get(ch - '0'); 
			result += transfer;
		}
		return result;
	}

}




