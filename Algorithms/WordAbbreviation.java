//Word abbreviation problems and some expansion

class WordAbbreviation{

	static String[] dictionary;
	static HashMap<String, ArrayList<String>> map;

	// For example, convert "abcds" to "a3s"
	public static String normalConvert(String input){
		if(input == null) return null;
		if(input.length()<3) return input;

		StringBuilder sb = new StringBuilder();
		sb.append(input.charAt(0));
		sb.append(input.length()-2);
		sb.append(input.charAt(input.length()-1));
		return sb.toString();
	}

	// Prcess all strings in the dictionary based on their abbreviation
	public static ProcessDict(String[] dictionary){
		map = new HashMap<>();
		for(String str: dictionary){
			if(!map.containsKey(normalConvert(str))){
				ArrayList<String> arr = new ArrayList<>();
				arr.add(normalConvert(str));
				map.put(str,arr);
			}
			else{
				map.get(normalConvert(str)).add(str);
			}
		}
	}

	//Given a string, determine whether it is a word with unique abbreviation
	public static boolean IsUnique(String input){
		if(input==null) return false;
		if(map.containsKey(normalConvert(input)) && map.get(normalConvert(input)).size()==1)
			return true;
		return false;
	}

	// Relaxed abbreviations:
	// For example:
	// "abcde": 5, a4, 4e,ab3,3de......
	// abbreviation can only have one number 
	public static ArrayList<String> complexConvert(String input){
		ArrayList<String> res = new ArrayList<>();
		if(input==null) return res;
		res.add(input.length());

		for(int count = input.length()-1; i>0; i--){
			for(int c = 0; c<input.length()-count; c++){
				String leftTmp = input.substring(0,c);
				String rightTmp = input.substring(count+c);
				String tmp = leftTmp + count + rightTmp;
				res.add(new String(tmp);)
			}
		}
		return res;
	}

}