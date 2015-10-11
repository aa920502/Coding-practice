 // Given a set of strings, return the smallest subset that contains prefixes for every string. 
 // If the list is ['foo', 'foog', 'food', 'asdf'] return ['foo', 'asdf'] 

import java.util.*;

class PrefixForEveryString{
	private static ArrayList<String> PrefixesForEveryString(ArrayList<String> strings){
		ArrayList<String> res = new ArrayList<String>();
		if(strings==null || strings.size()==0) return res;

		while(strings.size()>0){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(strings.get(0));
			//Group by same first character
			for(int i=1; i<strings.size(); i++){
				if(strings.get(0).charAt(0)==strings.get(i).charAt(0)){
					temp.add(strings.get(i));
				}
			}

			for(String s : temp) 
				strings.remove(s);

			if(temp.size() == 1){
				res.add(temp.get(0));
			}
			else{
				String commonPrefix = longestCommonPrefix(temp);
				res.add(commonPrefix);
			}
		}
		return res;
	}

	//Longest Common Prefix Subroutine
	private static String longestCommonPrefix(ArrayList<String> temp){
		String word = temp.get(0);
		int prefixlen = word.length();

		for(int i=1; i<temp.size(); i++){
			prefixlen = Math.min(prefixlen, temp.get(i).length());
			int j = 0;
			for(; j<prefixlen; j ++){
				if(word.charAt(j)!=temp.get(i).charAt(j))
					break;
			}
			prefixlen = j;
		}
		return word.substring(0,prefixlen);
	}

	public static void main(String[] args){
		ArrayList<String> test = new ArrayList<>();
		test.add("foo");
		test.add("foog");
		test.add("food");
		test.add("asdf");
		test.add("ass");
		test.add("fb");
		ArrayList<String> res = PrefixesForEveryString(test);
		for(String s : res) System.out.println(s);
	}
}