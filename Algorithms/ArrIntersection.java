/*
 * Given two sorted arrays. Write a method that returns the intersection of the arrays. 
 * Ex. [2,4,3,6] and [8,9,2,4] would return [2,4]. 
 */
public class ArrIntersection {
	static ArrayList<Integer> findIntersection(int[] a, int[] b) {
        int i = 0, j = 0; //Two Pointers
		ArrayList<Integer> res = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                res.add(a[i]);
                i++;
                j++;
            } 
            else if (a[i] > b[j]) j++;
            else if (a[i] < b[j]) i++;
        }
        return res;
    }
}
