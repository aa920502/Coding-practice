// Optimization over quick union


class WeightedQuickUnionWithPathCompression{
	private int[] id;
	private int[] size;

   	public QuickUnion(int N){
      	id = new int[N];
      	for (int i = 0; i < N; i++) {
      		id[i] = i;
      	}
   	}
   
   	private int root(int i){
      	while (i != id[i]{
      		i = id[i];
      		//Standard implementation: add second loop to root() to set the id of each examined node to the root.
      		//Simpler one-pass variant: halve the path length by making every other node in path point to its grandparent
      		id[i] = id[id[i]];
      	}
		return i; 
	}

   	public boolean find(int p, int q){
      	return root(p) == root(q);
   	}

   	public void unite(int p, int q){
      	int i = root(p), j = root(q);
      	if  (size[i] < size[j]) { id[i] = j; size[j] += size[i]; }
		else { id[j] = i; size[i] += size[j]; }
	}
}