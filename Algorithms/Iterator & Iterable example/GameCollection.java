import java.util.*;

public class GameCollection implements Iterable<Integer> {
	private Vector<Integer> games;
	 
	public GameCollection() {
		games = new Vector<Integer>();
	}
	 
	public void add(Integer game) {
	  games.add(game);
	}

	@Override
	public Iterator<Integer> iterator() {
	 	//return games.iterator();
		return new CircularGamesIterator(games);
	}
}