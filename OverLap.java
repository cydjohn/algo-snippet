//给定两个长方形左下角和右上角的坐标，判断是否有重叠，返回true或者false。
public class OverLap {
	public class Node {
		double x;
		double y;
		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	public boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {
		//if one rectangle is above other
		if (bottomRightA.y >= topLeftB.y || bottomRightB.y >= topLeftA.y) return false;
		if (bottomRightA.x >= topLeftB.x || bottomRightB.x >= topLeftA.y) return false;
		return true;
	}
}