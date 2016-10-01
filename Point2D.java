public class Point2D {
	int x;
	int y;
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public double dis2D(Point2D p) {
		double sum = (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y)
		Math.sqrt(sum);
	} 
	public void printDistance(double d) {
		System.out.println((int)Math.ceil(d));
	}
}

public class Point3D extends Point2D {
	int z;
	public Point3D(int z) {
		super();
		this.z = z;
	}
	public double dis3D(Point3D p) {
		double sum = (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) + (z - p.z) * (z - p.z);
		Math.sqrt(sum);
	} 
}