// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:
// For the return value, each inner list's elements must follow the lexicographic order.
// All inputs will be in lower-case.

class GroupAnagrams {
 	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if(strs==null || strs.length==0) return ret;
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String s = strs[i];
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
                temp.add(strs[map.get(key).get(k)]);
            }
            Collections.sort(temp);
            ret.add(temp);
        }
        return ret;
    }
}