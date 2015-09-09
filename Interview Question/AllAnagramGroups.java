// Problem 2:

// Implement a function all_anagram_groups() that, given many input strings, will identify and group words that are anagrams of each other. 
// An anagram is word that is just a re-arrangement of the characters of another word, like "reap" and "pear" and "a per" 
// (whitespace is ignored). But "pear" and "rep" are not, since "rep" does not have an "a". 
// Also, "the" and "thee" are not anagrams, because "the" only has one "e". 

// Given this example input:

// [ "pear","dirty room","amleth","reap","tinsel","tesla","hamlet","dormitory","listen","silent" ]

// The output should be an array-of-arrays (or list-of-lists)

// [
//   ["pear","reap"],
//   ["dirty room","dormitory"],
//   ["amleth","hamlet"],
//   ["tinsel","listen","silent"],
//   ["tesla"]
// ]


import java.util.*;

class AllAnagramGroups{
	public static ArrayList<ArrayList<String>> all_anagram_groups(String[] arr){
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		if(arr==null || arr.length==0) return ret;
		HashMap<String,ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i<arr.length; i++){
			String s = arr[i];
			s = getRidOfSpace(s);
			char[] tmp = s.toCharArray();
			Arrays.sort(tmp);
			String str = String.valueOf(tmp);
			if(map.containsKey(str)){
				map.get(str).add(i);
			}
			else{
				ArrayList<Integer> array = new ArrayList<>();
				array.add(i);
				map.put(str,array);
			}
		}

		for(String key: map.keySet()){
			ArrayList<String> temp = new ArrayList<>();
			for(int k =0;k<map.get(key).size();k++){
				temp.add(arr[map.get(key).get(k)]);
			}
			ret.add(temp);
		}
		return ret;
	}

	public static String getRidOfSpace(String s){
		StringBuffer sb = new StringBuffer();
		if(!s.contains(" ")) return s;
		else{
			for(int i = 0; i<s.length();i++){
				if(s.charAt(i)!=' ') sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}


	public static void main(String[] args){
		String[] testarr = new String[]{ "pear","dirty room","amleth","reap","tinsel","tesla","hamlet","dormitory","listen","silent"};
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		ret = all_anagram_groups(testarr);
		for(int i = 0; i<ret.size();i++){
			for(int j = 0; j<ret.get(i).size(); j++){
				System.out.print(ret.get(i).get(j)+",");
			}
			System.out.println();
		}		
	}
}