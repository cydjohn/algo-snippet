class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> function = new Stack<>();
        Stack<Integer> start = new Stack<>();
        int[] res = new int[n];
        for (String l : logs) {
            String[] log = l.split(":");
            if (log[1].equals("end")) {
                int endTime = Integer.valueOf(log[2]);
                res[function.pop()] += endTime - start.pop() + 1;
                if (!function.empty()) start.push(endTime + 1);
            } else {
                int startTime = Integer.valueOf(log[2]);
                if (!start.empty()) res[function.peek()] += startTime - start.pop();
                function.push(Integer.valueOf(log[0]));
                start.push(startTime);
            }
        }
        return res;
    }
}
