//注意遍历的顺序，从左到右遍历，每次复用之前的结果，保证了candy[i]一定比candy[i－1]要大，如果符合rating的要求的话
public class Solution {
    public int candy(int[] ratings) {
    	int[] candy = new int[ratings.length];
    	Arrays.fill(candy, 1);
    	for (int i = 1; i < ratings.length; i++) {
    		if (ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
    	}
    	for (int i = ratings.length-2; i >= 0; i--) {
    		if (ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i], candy[i+1] + 1);
    	}
    	int sum = 0;
    	for (int c : candy) sum += c;
    	return sum;
    }
}