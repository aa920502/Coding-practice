// 给一组id和表示每个id出现概率的数组，概率之和为1.要求随机生成id，使得随机出的id满足之前的概率数组。
// followup:如果id很多，调用这个随机生成方法的次数也很多，怎么优化


class RandomID{
	public static void main(String[] args){
		int[] id = {1, 2, 3, 4, 5};
		double[] probility = {0.2, 0.1, 0.4,0.25,0.05};
		System.out.println(getRandomID(id, probility)); 
	}
	
	private static int getRandomID(int[] id, double[] probility){ 
		int len = probility.length;
		double[] sum = new double[len];
		//the get prefix sum of the probility sum[0] = probility[0];
		for(int i = 1; i < len; i++){
			sum[i] = sum[i - 1] + probility[i];
			System.out.println(sum[i]); 
		}

		double prob = Math.random(); 
		System.out.println(prob); 
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