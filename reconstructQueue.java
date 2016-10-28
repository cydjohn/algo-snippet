public class Solution {
    public int[][] reconstructQueue(int[][] people) {
    	Arrays.sort(people, new Comparator<int[]>(){
    		public int compare(int[] a, int[] b) {
    			if (a[0] == b[0]) return a[1] - b[1];
    			else return b[0] - a[0];
    		}
    	});
    	List<int[]> list = new ArrayList();
    	for (int[] cur : people) {
    		list.add(cur[1], cur);
    	}
    	return list.toArray(new int[people.length][2]);
    }
}