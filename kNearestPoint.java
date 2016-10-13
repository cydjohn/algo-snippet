import java.util.*;
import java.lang.Math;

public class kNearestPoint{
	public point[] kNearestPoint(Point[] arr, Point origin, int k) {
		Point[] res = new Point[k];
		PriorityQueue<Point> pq = new PriorityQueue(k, new Comparator<Point>(){
			public int compare(Point a, Point b) {
				return (int)(getDis(a, origin) - getDis(b, origin));
			}
		});
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		return res;
	}
	private double getDis(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
}