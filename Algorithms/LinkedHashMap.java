import java.util.*;

class LinkedHashMap{
	public static void main(String[] args){
		LinkedHashSet<Integer> lhashSet = new LinkedHashSet<Integer>();
		lhashSet.add(2);
		lhashSet.add(1);
		lhashSet.add(2);
		lhashSet.add(3);
		lhashSet.add(1);

		for(int i:lhashSet) System.out.print(i+ " ");
	}
}