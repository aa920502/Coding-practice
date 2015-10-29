import java.util.Arrays;
import java.util.*; 
/*
* 给一个字符串，该字符串由一些可能会重复的字符组成，重新排列这个字符串使得没有相邻的字符是相同字符。如aab变成aba.
* 
* Using priority Queue, delete 2 node each time till queue is empty
*/
public class ReorderString {
    // create class to match char and its freq
    static class Node{
        char val;
        int freq;
        Node(char val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    public static String rearrage(String s){
        if (s==null || s.length()<=1) return s;
        // Build a max-freq priority queue
        char[] chs = s.toCharArray();
        int[] char_frequency = new int[128];
        Arrays.fill(char_frequency,0);
        for (char ch:chs) {
            char_frequency[ch]+=1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
        	@Override
        	public int compare(Node n1, Node n2){
        		return n2.freq - n1.freq;
        	}
        });
        //PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (int i=0; i<char_frequency.length; i++) {
            if (char_frequency[i]>0) {
                Node x = new Node((char)i,char_frequency[i]);
                pq.offer(x);
            }
        }
        //if freq of first ele > n/2+1, return false
        if (pq.peek().freq>(s.length()+1)/2)  return null;
        
        //get new string from queue
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Node first = pq.poll();
            if (pq.isEmpty()) {
                ans.append(first.val); 
                break;
            }
            Node second = pq.poll();
            ans.append(first.val+""+second.val);

            first.freq-=1;
            second.freq-=1;
            if (first.freq>0) pq.offer(first);
            if (second.freq>0) pq.offer(second);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
    // TODO Auto-generated method stub
	    System.out.println(rearrage("BCDAGAAAA"));
    }
}