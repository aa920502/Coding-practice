// Given a set of ID, and probability of each ID appearing, sum of the probaility is 1, 
// Write a program ot generate IDs based on each probability

// Follow up: what if there a lot of IDs and this method is called many times, how to optimize?

class RandomID{
	public static void main(String[] args){
		int[] id = {1, 2, 3, 4, 5};
		double[] probility = {0.2, 0.1, 0.4,0.25,0.05};
		
		for(int i = 0; i< 100; i++)
			System.out.println(getRandomID(id, probility)); 
	}
	
	private static int getRandomID(int[] id, double[] probility){ 
		int len = probility.length;
		double[] sum = new double[len];
		//the get prefix sum of the probility sum[0] = probility[0];
		sum[0] = probility[0];
		for(int i = 1; i < len; i++){
			sum[i] = sum[i - 1] + probility[i];
		}

		double prob = Math.random(); 
		if(prob < sum[0]){
			return id[0]; 
		}
		//binary search
		int start = 0;
		int end = len - 1; 
		while(start + 1 < end){
			int mid = start + (end - start) / 2; 
			if(sum[mid] == prob){
				end = mid;
			}
			else if(sum[mid] > prob){
				end = mid; 
			}
			else{
				start = mid; 
			}
		}
		return id[start+1];
	}
}