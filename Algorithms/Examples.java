import java.util.*;
import java.io.*;

class Examples{
	public static void main (String[] args){
		
	}


	/**********************************************
	 Disregard upper/lower cases
	**********************************************/
	public static boolean LowerUpperSame(char c1, char c2){
		return ((char)(c1-32)==c2)||((char)(c2-32)==c1);
	}

	/**********************************************
	 ArrayList<> type iterator example
	**********************************************/
	public static void test(){
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("1");
		a1.add("2");
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("q");
		a2.add("w");
		arr.add(a1);
		arr.add(a2);

		Iterator<ArrayList<String>> outer = arr.iterator();
		while(outer.hasNext()){
			Iterator<String> Inner = outer.next().iterator();
			while(Inner.hasNext()){
				String s = Inner.next();
				if(s.equals("q")) Inner.remove();
				else System.out.println(s);
			}
		}
	}

	/**********************************************
	 HashMap iterator example
	**********************************************/
	public static void test2(){
		Map studentGrades = new HashMap<String, String>();
        studentGrades.put("Alvin", "A+");
        studentGrades.put("Alan", "A");
        studentGrades.put("Becca", "A-");
        studentGrades.put("Sheila", "B+");
        
        System.out.println("Using Iterator");
        Iterator<Map.Entry<String, String>> iterator = studentGrades.entrySet().iterator() ;
        while(iterator.hasNext()){
            Map.Entry<String, String> studentEntry = iterator.next();
            System.out.println(studentEntry.getKey() +" :: "+ studentEntry.getValue());
            //You can remove elements while iterating.
            iterator.remove();
        }
        System.out.println("Map size: " + studentGrades.size());
	}

	/**********************************************
	 Test if a number in binary only has one "1"
	**********************************************/
	public static void test3(){
        int s;
        System.out.println((s-1)&s==0); // if yes, s has only one "1"
	}

	/***************************************************
	 Parse a string into integer based on certain radix
	****************************************************/
	public static void test4(){
		String s  = "0123";
		System.out.println(Integer.parseInt(s,4)); // radix 4
	}

	/***************************************************
	 JAVA Deque:
	 		java.util.ArrayDeque
			java.util.LinkedList
	****************************************************/
	public static void test5{
		Deque<String> dequeA = new LinkedList<>();
		dequeA.add     ("element 1"); //add element at tail
		dequeA.addFirst("element 2"); //add element at head
		dequeA.addLast ("element 3"); //add element at tail
		Object firstElement = dequeA.remove();
		Object firstElement = dequeA.removeFirst();
		Object lastElement  = dequeA.removeLast();
	}








}