// you can also use imports, for example:
import java.util.*;

// Give an array, see if there exist equi3 pair, 
// 0<X, X+1<Y<len 
// where sum(0,X-1) = sum(X+1,Y-1) = sum(Y+1,len-1)
// sum are all inclusive, for example, sum(a,b) = arr[a] + arr[a+1] + ... + arr[b]

class Equi3Pair {
    public int solution(int[] A) {
        if(A==null || A.length<6) return 0;
        int len = A.length;
        
        int[] sumArr = new int[len];
        sumArr[0] = A[0];
        for(int i=1;i<len;i++){
            sumArr[i] = A[i] + sumArr[i-1];
        }
        
        int totalSum = sumArr[len-1];
        
        //Use hashMap to store element value and corresponding indexes
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(A[i],temp);
            }
            else{
                map.get(A[i]).add(i);   
            }
        }
                
        // My solution: In order to have an equi-3 pair,
        // we must have: totalsum = sum(0,x-1) * 3 + A[x] + A[y]
        // so everytime we check if there is a potential candiate y index
        // given xindex and sum(0,x-1), check time is O(1)
        // if so, we first need to make sure that y>x-1, then we need to make sure
        // sum(y+1,len-1) is same as sum(0,x-1), if this is the case, this means
        // sum(x+1,y-1) is same as the other two as well
        
        // Prove: take sum(0,x-1) * 3 = num * 3, we already have 1 num, now we have another number b
        // equal to num, then the rest is num*3 -num -num = num. So we will have an equi-3 pair
        
        
        for(int xIndex = 1; xIndex<len-3;xIndex++){
            //0<X, X+1<Y<N-1
            int sum = getSum(sumArr,0,xIndex-1);
            int yVal = totalSum - sum*3 - A[xIndex];
            if(!map.containsKey(yVal)) continue;
            else{
                for(int yIndex: map.get(yVal)){
                    if(yIndex > (xIndex+1) && getSum(sumArr,yIndex+1,len-1)==sum){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    
    
    //O(1) time method
    public int getSum(int[] sumArr, int left, int right){
        if(left==right){
            if(left==0) return sumArr[0];
            else{
                return sumArr[left]-sumArr[left-1];
            }
        }
        // left != right
        else{
            if(left==0){
                return sumArr[right];   
            }
            else{
                return sumArr[right]-sumArr[left-1];   
            }
        }
    }
}