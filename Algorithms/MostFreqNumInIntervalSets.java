// find the most frequent appeared number, given an interval set
import java.util.*;
class MostFreqNumInIntervalSets{

	static class Interval{
		int left;
		int right;
		public Interval(int left, int right){
			this.left = left;
			this.right = right;
		}
	}

	public int GetMostFrequent(ArrayList<Interval> ll){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(Interval i:ll){
			min = Math.min(min,i.left);
			max = Math.max(max,i.right);
		}
		System.out.println(min + " " + max);
		int res = -1;
		int maxFreq = Integer.MIN_VALUE;
		for(int i = min; i<=max; i++){
			int count = 0;
			for(Interval interval:ll){
				if(i>=interval.left && i<=interval.right){
					count++;
				}
			}
			if(count>=maxFreq){
				maxFreq = count;
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args){
		MostFreqNumInIntervalSets m = new MostFreqNumInIntervalSets();
		ArrayList<Interval> ll = new ArrayList<>();
		ll.add(new Interval(-3,1));
		ll.add(new Interval(-2,2));
		ll.add(new Interval(-1,3));
		ll.add(new Interval(-4,0));
		System.out.println(m.GetMostFrequent(ll));
	}
}