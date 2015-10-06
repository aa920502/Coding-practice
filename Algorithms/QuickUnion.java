// • Trees can get tall.
// • Find too expensive (could be N operations).

class QuickUnion{

   	private int[] id;
   	public QuickUnion(int N){
      	id = new int[N];
      	for (int i = 0; i < N; i++) id[i] = i;
   	}
   
   	private int root(int i){
      	while (i != id[i]) i = id[i];
		return i; 
	}

   	public boolean find(int p, int q){
      	return root(p) == root(q);
   	}

   	public void unite(int p, int q){
      	int i = root(p), j = root(q);
		id[i] = j; 
	}
}