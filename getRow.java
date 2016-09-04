//arraylist clone: a = new arraylist(b);
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList();
        List<Integer> last = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
        	if (i == 0) cur.add(1);
        	else {
        		cur.add(1);
        		for (int j = 1; j < i; j++) {
        			cur.add(last.get(j-1) + last.get(j));
        		}
        		cur.add(1);
        	}
        	last = new ArrayList(cur); //arrylist.clone() won't work here.
        	cur.clear();
        }
        return last;
    }
}