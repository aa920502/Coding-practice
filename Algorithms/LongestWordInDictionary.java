// Given a dictionary of words, find the longest word which consists of other words in the dictionay

import java.util.*;

class LongestWordInDictionary{

	public static String GetLongestWord(String[] dict){
		Arrays.sort(dict, new Comparator<String>(){
			public int compare(String s1, String s2){
				return s2.length() - s1.length();
			}
		});

		ArrayList<String> ll = new ArrayList<>();
		for(String s:dict) ll.add(s);

		String res = "";
		while(ll.size()!=0){
			String s = ll.get(0);
			ll.remove(0);
			if(WordBreak(s,ll)){
				res = s;
				return res;
			}
		}
		return res;
	}

	//Subroutine to check if the word is consist of other words in the dictionary
	public static boolean WordBreak(String s, ArrayList<String> ll){
		if(s==null||s.length()==0) return false;
        if(ll.size()==0) return false;

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
        	for(int j=0;j<i;j++){
        		if(dp[j]&&ll.contains(s.substring(j,i))){
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[s.length()];
	}

	public static void main(String[] args){
		String[] dict = new String[]{"a","b","ab","face","book","facebook","bloomberg"};
		System.out.println(GetLongestWord(dict));
	}
}