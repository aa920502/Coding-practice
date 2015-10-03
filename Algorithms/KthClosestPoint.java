//Given a list of points, return the kth closest point to the origin

import java.util.*;

class KthClosestPoint {

	static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static Point solve(Point[] list, int k) throws Exception {
		if (list == null || list.length < k) {
			System.out.println("input error, need a list with size more than k");
			return null;	
		}
		// Descending order of distance
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				int distP1 = p1.x * p1.x + p1.y * p1.y;
				int distP2 = p2.x * p2.x + p2.y * p2.y;
				return distP2-distP1;
			}
		});
		for (Point p : list) {
			if (queue.size() < k) {
				queue.add(p);
			}
			else {
				Point top = queue.peek();
				if (closerThan(p, top)) {
					queue.poll();
					queue.add(p);
				}
			}
		}
		return queue.poll();
	}

	public static void main(String[] args) throws Exception{
		Point[] p = new Point[5];
		p[0] = new Point(7,8);
		p[1] = new Point(4,4);
		p[2] = new Point(5,5);
		p[3] = new Point(5,4);
		p[4] = new Point(6,6);
		Point res = solve(p,2);
		System.out.println(res.x+" " + res.y);
	}
}