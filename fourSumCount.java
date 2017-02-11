/*利用字典cnt，将A，B中各元素（笛卡尔积）的和进行分类计数。
将C，D中各元素（笛卡尔积）和的相反数在cnt中的值进行累加，即为答案。*/
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int a : A) {
        	for (int b : B) {
        		if (!map.containsKey(a+b)) {
        			map.put(a+b, 1);
        		} else {
        			map.put(a+b, map.get(a+b)+1);
        		}
        	}
        }
        for (int c : C) {
        	for (int d : D) {
        		if (map.containsKey(-(c+d))) {
        			ans += map.get(-(c+d));
        		}
        	}
        }
        return ans;
    }
}