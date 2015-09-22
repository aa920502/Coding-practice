// Implement an iterator to flatten a 2d vector.
// For example,
// Given 2d vector = 

// [    [1,2],    [3],    [4,5,6]  ]

// By calling next repeatedly until hasNext returns false, 
// the order of elements returned by next should be: [1,2,3,4,5,6].

class Flattern2DVector{
	public class Vector2D {
	    Iterator<List<Integer>> outterIter;
	    Iterator<Integer> innerIter = Collections.emptyIterator();

	    public Vector2D(List<List<Integer>> vec2d) {
	        outterIter = vec2d.iterator();
	    }

	    public int next() {
	        return innerIter.next();
	    }
 
	    public boolean hasNext() {
	        if(innerIter.hasNext()){
	            return true;
	        }

	        if(!outterIter.hasNext()){
	            return false;
	        }

	        innerIter = outterIter.next().iterator();

	        return hasNext();
	    }
	}
	/**
	 * Your Vector2D object will be instantiated and called as such:
	 * Vector2D i = new Vector2D(vec2d);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}