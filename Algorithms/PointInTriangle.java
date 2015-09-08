// Test if a point is in a triangle in 2D space

class PointInTriangle{
	static class PointF{
		float x;
		float y;
		public PointF(float x, float y){
			this.x = x;
			this.y = y;
		}
	}

	private static float sign(PointF p1, PointF p2, PointF p3) {
    	return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
	}

	private static boolean pointInTriangle(PointF pt, PointF v1, PointF v2, PointF v3) {
	    boolean b1, b2, b3;
	    b1 = sign(pt, v1, v2) < 0.0f;
	    b2 = sign(pt, v2, v3) < 0.0f;
	    b3 = sign(pt, v3, v1) < 0.0f;
	    return ((b1 == b2) && (b2 == b3));
	}

	public static void main(String[] args){
		PointF A = new PointF(0,0);
		PointF B = new PointF(5,0);
		PointF C = new PointF(0,5);

		PointF p = new PointF(4.1f,1);

		boolean result = pointInTriangle(p,A,B,C);
		System.out.println("In triangle?"+result);
	}
}