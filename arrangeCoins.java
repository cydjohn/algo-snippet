public class arrangeCoins {
	public static int[] arrangeCoins(int[] coins) {
		int[] res = new int[coins.length];
		if (coins == null || coins.length == 0) return res;
		for (int i = 0; i < coins.length; i++) {
			double x = (Math.sqrt(8 * (double)(coins[i]) + 1) - 1) / 2;
			res[i] = (int)x;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] coins = {2, 5, 8, 3};
		int[] res = arrangeCoins(coins);
        for (int r : res) System.out.println(r);
	}
}