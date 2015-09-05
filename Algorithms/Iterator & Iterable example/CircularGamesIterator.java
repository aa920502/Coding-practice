import java.util.*;

// create custom Circular Iterator
public class CircularGamesIterator implements Iterator<Integer> {

	private Vector<Integer> list;
 	private int currentPosition;
 
	public CircularGamesIterator(Vector<Integer> games) {
  		list = games;
 	 	currentPosition = 0;
 	}
 
 	@Override
 	public boolean hasNext() {
 		return currentPosition < list.size();
 	}

 	@Override
 	public Integer next() {
 	 	Integer el = list.elementAt(currentPosition);
 	 	currentPosition = (currentPosition + 1) % list.size(); 
 	 	return el;
 	}

 	@Override
	public void remove() {}
}