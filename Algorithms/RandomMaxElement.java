// randomly return the index of maximal elements in the array. 
// follow up: 要求linear time 和constant space 

class RandomMaxElement{
	public int findMax(int[] arr){
	    int len = arr.length;
	    int ret =-1;
	    int max = -1;
	    int count=0;
	    for(int i=0; i<len; i++){
	        if(arr[i]==max){
	            count++;
	            int judge = new Random.nextInt(count);
	            if(judge==0){
	                ret = i;
	            }
	        }else if(max==-1 || arr[i]>max){
	            max = arr;
	            ret = i;
	            count=1;
	        }
	    }
	    return ret; 
	}
}