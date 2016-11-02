//gcd
//let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x and y such that ax+by=d
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (x == 0) return y == z;
        if (y == 0) return x == z;
    	//limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) return false;
        //case x or y is zero
        if (x == z || y == z || x + y == z) return true;
        //get GCD, then we can use the property of Bézout's identity
        return z % gcd(x, y) == 0;
    }
    public int gcd(int a, int b) {
    	while (b != 0) {
    		int tmp = b;
    		b = a % b;
    		a = tmp;
    	}
    	return a;
    }
}