import java.util.*;

class TreeMap{
	public static void main(String[] args){
		int[] a1 = new int[]{1, 2, 3, 5, 6, 2, 7};
		int[] a2 = new int[]{2, 5, 2, 8, 9, 4};

		TreeMap tm = new TreeMap();

		for(int i:a1){
			if(tm.containsKey(i)){
				tm.put(i,tm.get(i)+1);
			}
			else tm.put(i,1);
		}

		Set set = tm.entrySet();
      	// Get an iterator
      	Iterator i = set.iterator();
      	// Display elements
      	while(i.hasNext()) {

      		System.out.println(i.next().key);
      	}
	}
}