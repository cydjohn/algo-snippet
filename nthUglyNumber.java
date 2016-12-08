public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> a = new ArrayList();
        a.add(1);//排队队列
        int[] b = new int[3];//指针
        int[] c = {2,3,5};//乘数
        int res = 1;
        while (n > 1) {
            //可能出现重复的数字，但是由于每次选当前最小，重复的数字会保证同时出现，然后在for循环中同时被加1
            res = Math.min(Math.min(a.get(b[0])*2, a.get(b[1])*3), a.get(b[2])*5);
            a.add(res);
            n--;
            for (int i = 0; i < 3; i++) {
                if (res == a.get(b[i])*c[i]) b[i]++;
            }
        }
        return res;
    }
}

//WRONG ANSWER
public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        Set<Integer> set = new HashSet();
        nt[] c = {2,3,5};
        pq.add(1);
        set.add(1);
        int cur = 1;
        while (n > 1) {
            int cur = pq.poll();
            n--;
            for (int i = 0; i < 3; i++) {
                if (set.contains(cur * c[i])) continue;
                pq.add(cur * c[i]);
                set.add(cur * c[i]);
            }
        }
        return cur;
    }
}