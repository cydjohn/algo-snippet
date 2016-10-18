public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int pa = a.length()-1, pb = b.length()-1;
        int sum = 0;
        while (pa >= 0 || pb >= 0) {
        	if (pa >= 0) sum += a.charAt(pa--) - '0';
        	if (pb >= 0) sum += b.charAt(pb--) - '0';
        	if (sum > 1) {
        		sb.insert(0, sum-2);
        		sum = 1;
        	}
        	else {
        		sb.insert(0, sum);
        		sum = 0;
        	}
        }
        if (sum == 1) sb.insert(0, 1);
        return sb.toString();
    }
}