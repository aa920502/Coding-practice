import java.util.Comparator;
import java.util.PriorityQueue;

class MaxHeap{
	//Descending order comparator
	static class newComp implements Comparator<Integer>{
		public int compare(Integer i1, Integer i2){
			return Integer.compare(i2,i1);
		}
	}

	public static void main(String[] args){
		PriorityQueue<Integer> pq = new PriorityQueue<>(new newComp());
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		for (int x : ia) {
			pq.offer(x);
		}
		System.out.println("pq: " + pq);

		while(!pq.isEmpty()){
			System.out.println("poll: " + pq.poll());
		}
	}
}



