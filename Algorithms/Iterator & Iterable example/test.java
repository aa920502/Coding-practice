import java.util.*;

class test{
	public static void main(String[] args) {
		GameCollection gc = new GameCollection();
		gc.add(1);
		gc.add(2);
		gc.add(3);

		Iterator<Integer> gameIterator = gc.iterator();

		while (gameIterator.hasNext()) {
			int g = gameIterator.next();
			System.out.println(g);
		}
	}
}