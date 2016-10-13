//DP
//The reason why we have these two cases is that we can easily compute both of them, and that is all I do. When adding a new post, we can use the same color as the last one (if allowed) or different color. If we use different color, there're k-1 options, and the outcomes shoule belong to the diffColorCounts category. If we use same color, there's only one option, and we can only do this when the last two have different colors (which is the diffColorCounts). There we have our induction step.
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int diff = k * (k - 1);
        int same = k;
        for (int i = 2; i < n; i++) {
        	int temp = diff;
        	diff = (diff + same) * (k - 1);
        	same = temp;
        }
        return diff + same;
    }
}