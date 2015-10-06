/** 
* In a party of N people, only one person is known to everyone.  
* Such a person may be present in the party,  
* if yes, (s)he doesn’t know anyone in the party.  
* We can only ask questions like “does A know B? “.  
* Find the stranger (celebrity) in minimum number of questions. 
*/ 

class CelebrityProblem{

	public static int celebrityUsingStack(int[][] matrix,int size){  
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<size;i++){
			stack.push(i);
		}
		int A = stack.pop();
		int B = stack.pop();
		
		while(stack.size()!=1){
			//If A knows B, A is not a celebrity
			if(matrix[A][B]==1){
				A=stack.pop();
			}
			else{ // If A doesn't know B, B is not a celebrity
				B = stack.pop();
			}
		}

		int C = stack.pop();

		//If C knows A, C is not celebrity
		if(matrix[C][A]==1){
			C = A;
		}
		if(matrix[C][B]==1){
			C = B;
		}

		// If not guaranteed that there must be one solution, need to check the matrix again to make
		// sure C doesn't know anyone
		return C;
	}
}