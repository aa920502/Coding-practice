
// Given an array comprises of 0 or 1, flip a subarray (0 becomes 1, 1 becomes 0), 
// get an array with most 1s.


//Solution: find an suarray with largest 0,1 difference
class FlipSubArray{
	int flip(int[] input){
		int globalDiff = 0;
		int localDiff = 0;

		int start=0, end=0;
		int globalstart=0, globalend=0;

		for(int i=0;i<input.length;i++){
			if(input[i]==1){
				if(localDiff>0){ 
					localDiff--;
					end++;
				}
				else{ //localDiff = 0
					start = i;
					end = i;
				}
			}
			else{ // input[i] == 0
				localDiff ++;
				end ++;
			}
			//Update global
			if (globalDiff < localDiff){
				globalDiff = localDiff;
				globalstart = start;
				globalend = end;
			}
		}

		for(int i=globalstart;i<globalend;i++){
			if(input[i]==1) input[i]=0;
			else input[i]=1;
		}
		for(int i =0;i<input.length;i++) 
			System.out.print(input[i]+",");
		return globalDiff;
	}

	public static void main(String[] args){
		FlipSubArray f = new FlipSubArray();
		int[] test  = new int[]{0,1,0,0,0,1,0,0,1,0};
		for(int i =0;i<test.length;i++) 
			System.out.print(test[i]+",");

		System.out.println();
		f.flip(test);
	}
}