import java.util.*;

class GroupAnagrams{

	static List<ArrayList<String>> group (ArrayList<String> input){
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		for (String s : input){
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String cur = new String(arr);
			if (map.containsKey(cur)){
				map.get(cur).add(s);
			}else{
				ArrayList<String> tmp = new ArrayList<>();
				tmp.add(s);
				map.put(cur,tmp);
			}
		}

		for (String key: map.keySet()){
			if (map.get(key).size()>=1){
				ArrayList<String> arr = new ArrayList<>();
				arr.addAll(map.get(key));
				result.add(arr);
			}
		}

		return result;
	}

	public static void main (String[] args){
		ArrayList<String> test = new ArrayList<>();
		test.add("abc");
		test.add("red");
		test.add("dre");
		test.add("cba");
		test.add("nba");
		test.add("acb");

		List<ArrayList<String>> result = group(test);
			
		for (int i =0; i<result.size(); i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}