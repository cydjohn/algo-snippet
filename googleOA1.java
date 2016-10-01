public class HelloWorld{
    public static int solution(int x) {
		int prev = x % 10;//the last num stored for comparison
		int left = x / 10;//the num before current comparison
		int right = 0;// the num after current comparison
		int min = Integer.MAX_VALUE;
		int tens = 1;
		while (left != 0) {
			int cur = left % 10;//current num
			left /= 10;
			int tmp = (left * 10 + Math.max(prev, cur)) * tens + right;
			if (tmp < min) min = tmp;
			right = right + prev * tens;
			prev = cur;//move forward
			tens *= 10;
		}
		return min;
	 }
    public static void main(String []args){
        System.out.println(solution(233614));
    }
}
