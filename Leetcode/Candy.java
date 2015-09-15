// There are N children standing in a line. Each child is assigned a rating value.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// What is the minimum candies you must give?

//Note: [1,2,2] should return 4 instead of 5

class Candy{

	// This solution picks each element from the input array only once. 
	// First, we give a candy to the first child. Then for each child we have three cases:

	// His/her rating is equal to the previous one -> give 1 candy.
	// His/her rating is greater than the previous one -> give him (previous + 1) candies.
	// His/her rating is less than the previous one -> don't know what to do yet, 
	// let's just count the number of such consequent cases.
	// When we enter 1 or 2 condition we can check our count from 3. 
	// If it's not zero then we know that we were descending before and we have everything 
	// to update our total candies amount: number of children in descending sequence of 
	// raitings - coundDown, number of candies given at peak - prev 
	// (we don't update prev when descending). 
	// Total number of candies for "descending" children can be found through arithmetic progression
	// formula (1+2+...+countDown). 
	// Plus we need to update our peak child if his number of candies is less then or equal to 
	// countDown.

	// One pass solution
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0) return 0;
        int total = 1;
        int pre = 1;
        int countdown = 0;
        for(int i=1;i<ratings.length;i++){
            //if current rating is >= than previous rating
            if(ratings[i]>=ratings[i-1]){
                if(countdown > 0){
                    total += countdown * (countdown+1)/2;
                    if(countdown >= pre) total += countdown-pre+1;
                    countdown = 0;
                    pre = 1;
                }
                pre = ratings[i]==ratings[i-1]?1:pre+1;
                total += pre;
            }
            //if current rating is < than previous rating
            else{
                countdown++;
            }
        }

        if(countdown > 0){
            total += countdown * (countdown+1)/2;
            if(countdown >= pre) total += countdown-pre+1;
        }
        return total;       
    }

    //Another solution
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0) return 0;
        int[] temp = new int[ratings.length];
        for(int i=0; i<temp.length; i++) temp[i] = 1;
        
        for(int i=0;i<temp.length-1; i++){
            if(ratings[i]<ratings[i+1]){
                temp[i+1] = temp[i] + 1;
            }
        }
        
        for(int i = temp.length-1; i>0; i--){
            if(ratings[i-1]>ratings[i]){
                temp[i-1] = Math.max(temp[i-1],temp[i]+1);
            }
        }
        
        int sum = 0;
        for(int i:temp) sum += i;
        return sum;
    }

}