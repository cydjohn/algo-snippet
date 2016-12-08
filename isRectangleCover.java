/**
 * 核心思想就是:能够正好围成一个矩形的情况就是:
 * 有且只有:
 *   - 最左下 最左上 最右下 最右上 的四个点只出现过一次,其他肯定是成对出现的(保证完全覆盖)
 *   - 上面四个点围成的面积,正好等于所有子矩形的面积之和(保证不重复)
 * Created by MebiuW on 16/8/29.
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int left = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE, top = Integer.MIN_VALUE;
        int area = 0;
        Set<String> set = new HashSet();
        for (int[] r : rectangles) {
        	if (r[0] < left) left = r[0];
        	if (r[1] < bottom) bottom = r[1];
        	if (r[2] > right) right = r[2];
        	if (r[3] > top) top = r[3];
        	area += (r[2]-r[0])*(r[3]-r[1]);
        	String lb = r[0]+" "+r[1];
        	String lt = r[0]+" "+r[3];
        	String rb = r[2]+" "+r[1];
        	String rt = r[2]+" "+r[3];
        	if (!set.contains(lb)) set.add(lb);//hastset内不能用int[]或者list<>因为需要比较的是整个int[]必然要新生成一个int[],他们的地址不一样，在hashset看来是不一样的
            else set.remove(lb);
            if (!set.contains(lt)) set.add(lt);
            else set.remove(lt);
            if (!set.contains(rb)) set.add(rb);
            else set.remove(rb);
            if (!set.contains(rt)) set.add(rt);
            else set.remove(rt);
        }
        if (set.size() == 4 && set.contains(left+" "+bottom) && set.contains(left+" "+top) && set.contains(right+" "+bottom) && set.contains(right+" "+top)) {
        	return area == (right - left) * (top - bottom);
        }
        return false;
    }
}