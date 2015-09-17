// Follow up for H-Index: What if the citations array is sorted in ascending order? 
// Could you optimize your algorithm?

class H-Index2{
	public int hIndex2(int[] citations) {        
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=citations.length-i) 
            	return citations.length - i;
        }
        return 0;
    }
}