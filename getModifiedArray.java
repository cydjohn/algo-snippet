/*Just store every start index for each value and at end index plus one minus it

for example it will look like:

[1 , 3 , 2] , [2, 3, 3] (length = 5)

res[ 0, 2, ,0, 0 -2 ]

res[ 0 ,2, 3, 0, -5]

sum 0, 2, 5, 5, 0

res[0, 2, 5, 5, 0]*/
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        if (updates.length == 0) return res;
        for (int[] u : updates) {
        	res[u[0]] += u[2];
        	if (u[1] < length-1) res[u[1] + 1] -= u[2];
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
        	sum += res[i];
        	res[i] = sum;
        }
        return res;
    }
}