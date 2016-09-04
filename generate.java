//find pattern
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < numRows; i++) {
        	List<Integer> temp = new ArrayList();
        	if (i == 0) temp.add(1);
        	else {
        		List<Integer> last = res.get(i-1);
        		temp.add(last.get(0));
        		for (int j = 1; j < i; j++) {
        			temp.add(last.get(j-1) + last.get(j));
        		}
        		temp.add(last.get(i-1));
        	}
        	res.add(temp);
        }
        return res;
    }
}