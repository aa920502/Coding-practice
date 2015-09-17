// Given a string s and a dictionary of words dict, add spaces in s to construct 
// a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].


class WordBreak2{
	// Backtracking
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return res;
		helper(new HashSet(), s, wordDict, res, 0, "");
		return res;
	}

	public boolean helper(HashSet dirtySet, String s, Set<String> wordDict, List<String> res, int curIndex, String cur){
		boolean found = false;
		for(int i=curIndex; i<s.length(); i++){
			String tmp = s.substring(curIndex,i+1);
			if(wordDict.contains(tmp)){
				String tmp2 = cur + " " + tmp;
				if(i==s.length()-1){
					res.add(tmp2.substring(1));
					found = true;
				}
				else{
					if(dirtySet.contains(i+1)) continue;
					if(helper(dirtySet,s,wordDict,res,i+1,tmp2)) found = true;
				}
			}
		}
		if(found) return true;
	    else{
			dirtySet.add(curIndex);
			return false;
		}
	}	


	//DP
	HashMap<String,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
		if(map.containsKey(s)) return map.get(s);
		List<String> list = new LinkedList<>();
		if(wordDict.contains(s)) list.add(s);
		
		for(int i=1;i<s.length();i++){
		    String left = s.substring(0,i);
		    String right = s.substring(i);
		    if(wordDict.contains(left) && HasSuffix(right,wordDict)){
		        for(String ss : wordBreak(right,wordDict)){
		            list.add(left + " " + ss);
		        }
		    }
		}
		map.put(s,list);
		return list;
	}
	
	public boolean HasSuffix(String s, Set<String> wordDict){
	    for(int i=1;i<=s.length();i++){
	        if(wordDict.contains(s.substring(0,i))) return true;
	    }
	    return false;
	}

	//Also works from back
	HashMap<String,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
		if(map.containsKey(s)) return map.get(s);
		List<String> list = new LinkedList<>();
		if(wordDict.contains(s)) list.add(s);
		
		for(int i=s.length()-1;i>=0;i--){
		    String left = s.substring(0,i);
		    String right = s.substring(i);
		    if(wordDict.contains(right) && HasSuffix(left,wordDict)){
		        for(String ss : wordBreak(left,wordDict)){
		            list.add(ss + " " + right);
		        }
		    }
		}
		map.put(s,list);
		return list;
	}
	
	public boolean HasSuffix(String s, Set<String> wordDict){
	    for(int i=1;i<=s.length();i++){
	        if(wordDict.contains(s.substring(0,i))) return true;
	    }
	    return false;
	}

}