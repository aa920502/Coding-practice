//Check if array A is subset of array B

class OneArrayIsSubsetOfAnother{
	//Use HashMap
	// O(n) space, O(n) time
	public boolean isSubSet(int[] A, int[] B){
		if(A.length>B.length) return false;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i : B){
			if(!map.containsKey(i)){
				map.put(i,1);
			}
			else{
				map.put(i,map.get(i)+1);
			}
		}

		for(int j : A){
			if(!map.containsKey(j) || map.get(j) == 0) return false;
			else{
				map.put(j,map.get(j)-1);
			}
		}
		return true;
	}

	//No extra space, O(nlogn) time
	public boolean isSubSet(int[] A, int[] B){
		if(A.length>B.length) return false;
		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		int j = 0;
		while(i<B.length){
			if(B[i]==A[j]){
				j++;
				if(j==A.length) return true;
			}
			else{
				i++;
			}
		}
		return false;
	}
}