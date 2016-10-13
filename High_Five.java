//写好了一个叫Result的类，中文翻译成节点，题目是输入是一堆节点，节点里面有两个属性学生id和分数，保证每个学生至少会有5个分数，求每个人最高的5个分数的平均分。返回的是Map<Integer, Double>, key是id，value是每个人最高5个分数的平均分double是平均分。感觉就是一堆考卷登记成绩单，但为啥就挑5个呢，等遇到这题让亚马逊给出合乎逻辑的解释。
//想法就是先把各个成绩按照id聚拢起来。然后排序，高分排前面，低分打断腿，哦不，是不计了。排序就在map里面弄个list，利用Java自带的排序。而且据说会保证不会有非法数据，比如有人只有4个成绩，那么就正常去做就好啦。
import java.util.*;
public class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}
public class High_Five {
	public static Map<Integer, Double> getHighFive(Result[] results) {
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		Map<Integer, PriorityQueue<Integer>> grade = new HashMap<Integer, PriorityQueue<Integer>>();
		for (Result r : results) {
			if (!grade.containsKey(r.id)) {
				grade.put(r.id, new PriorityQueue<Integer>(5, Collections.reverseOrder()));
			}
			grade.get(r.id).add(r.value);
		}
		for (Integer id : grade.keySet()) {
			double sum = 0;
			PriorityQueue<Integer> maxFive = grade.get(id);
			for (int i = 0; i < 5; i++) {
				sum += maxFive.poll();
			}
			res.put(id, sum/5.0);
		}
		return res;
	}
	public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}