import java.util.Iterator;
import java.util.TreeSet;
 
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Dog> dset = new TreeSet<Dog>();
		dset.add(new Dog(2));
		dset.add(new Dog(1));
		dset.add(new Dog(3));
 
		Iterator<Dog> iterator = dset.iterator();
 
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

	static class Dog implements Comparable<Dog>{
		int size;
	 
		public Dog(int s) {
			size = s;
		}
	 
		public String toString() {
			return size + "";
		}
	 
		@Override
		public int compareTo(Dog o) {
		        return size - o.size;
		}
	}
}