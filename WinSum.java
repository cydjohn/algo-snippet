import java.util.*;
public class WinSum {
	public List<Integer> getSum(List<Integer> list, int k) {
		List<Integer> res = new ArrayList<>();
		if (list == null || list.size() == 0 || k <= 0) return res;
		int sum = 0, i = 0, j = 0;
		while (j <= list.size()) {
			while (k > 0) {
				sum += list.get(j++);
				k--;
			}
			res.add(sum);
			sum += list.get(j++);
			sum -= list.get(i++);
		}
		return res;
	}
}