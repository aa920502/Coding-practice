// • Trees can get tall.
// • Find too expensive (could be N operations).

//Iprovement: weighting + path compression

class QuickUnion{

   	private int[] id;
      private int[] sz; // size array for weighting


   	public QuickUnion(int N){
      	id = new int[N];
      	for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
   	}
   
   	private int root(int i){
      	while (i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
         }
		return i; 
	}

   	public boolean find(int p, int q){
      	return root(p) == root(q);
   	}

   	public void unite(int p, int q){
      	int i = root(p), j = root(q);

         if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
         }
         else{
            id[j] = i;
            sz[i] += sz[j]; 
         }
	}
}