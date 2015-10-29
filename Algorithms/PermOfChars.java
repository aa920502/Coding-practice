import java.util.*;

class PermOfChars{

	public List<String> getPerm(List<Character> l){
		HashSet<String> res = new HashSet<>();
		helper(0,new StringBuffer(),res,l);	
		return new LinkedList<String>(res);
	}

	public void helper (int i,StringBuffer sb, HashSet<String> res, List<Character> l){
		if(i==l.size()){
			res.add(new String(sb.toString()));
			return;
		}

		for(int j=0;j<=i;j++){
			sb.insert(j,l.get(i));
			helper(i+1,sb,res,l);
			sb.deleteCharAt(j);
		}
	}

	public static void main(String[] args){
		PermOfChars p = new PermOfChars();
		List<Character> l = new LinkedList<>();
		l.add('a'); 
		List<String> res = p.getPerm(l);
		for(String s : res){
			System.out.println(s);
		}
	}
}