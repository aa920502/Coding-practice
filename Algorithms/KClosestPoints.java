//Given a list of points, return the k/kth closest points to the origin


import java.util.*;
class KClosestPoints{
	public static class Point {
	    public double x;
	    public double y;
	    public Point(final double x, final double y) {
	        this.x = x;
	        this.y = y;
	    }
	}

	//Quick select: O(n)    return kth largest value in the array
	public static double kthSmallest(final double[] A, final int lo, final int high, final int k) {
        int i = lo, j= high - 1;
        double pivot = A[high];
        while(i<=j){
        	if(A[i]>pivot){
        		swap(A,i,j);
        		j--;
        	}
        	else i++;
        }
        swap(A,i,high);

        final int m = i - lo + 1;
        if (m == k) {
            return A[i];
        } else if (m > k) {
            return kthSmallest(A, lo, i - 1, k);
        } else {
            return kthSmallest(A, i + 1, high, k - m);
        }
	}

	public static Point[] closestkWithOrderStatistics(final Point points[], final int k) {
	    final int n = points.length;
	    final double[] dist = new double[n];
	    for (int i = 0; i < n; i++) {
	        dist[i] = GetDist(points[i]);
	    }
	    final double kthMin = kthSmallest(dist, 0, n - 1, k);

	    final Point[] result = new Point[k];
	    for (int i = 0, j = 0; i < n && j < k; i++) {
	        final double d = GetDist(points[i]);
	        if (d <= kthMin) {
	            result[j++] = points[i];
	        }
	    }

	    return result;
	}

	private static double GetDist(Point p){
		return p.x * p.x + p.y * p.y;
	}


	private static void swap(final double input[], final int i, final int j) {
	    final double temp = input[i];
	    input[i] = input[j];
	    input[j] = temp;
	}


	public static void main(String[] args) throws Exception{
		Point[] p = new Point[8];
		p[0] = new Point(7,8);
		p[1] = new Point(4,4);
		p[2] = new Point(5,5);
		p[3] = new Point(5,4);
		p[4] = new Point(6,6);
		p[5] = new Point(3,3);
		p[6] = new Point(4.5,4);
		p[7] = new Point(4.5,4.5);
		Point[] res = closestkWithOrderStatistics(p,3);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i].x + " " + res[i].y);
		}

		Point pp = solve(p,5);
		System.out.println("5th closest: "+pp.x+","+pp.y);
	}


	/*************************************************************
	*  Priority Queue to find kth closest, O(nlogk), not optimal
	**************************************************************/
	public static Point solve(Point[] list, int k) throws Exception {
		if (list == null || list.length < k) {
			System.out.println("input error, need a list with size more than k");
			return null;	
		}
		// Max Heap of size k
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return (int)(GetDist(p2) - GetDist(p1));
			}
		});
		
		for (Point p : list) {
			if (queue.size() < k) {
				queue.add(p);
			}
			else {
				Point top = queue.peek();
				if (GetDist(top)>GetDist(p)) {
					queue.poll();
					queue.add(p);
				}
			}
		}
		return queue.poll();
	}
	
}