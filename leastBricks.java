class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> wa : wall) {
            int sum = 0;
            for (int i = 0; i < wa.size()-1; i++) {
                sum += wa.get(i);
                if (!map.containsKey(sum)) map.put(sum, 1);
                else map.put(sum, map.get(sum) + 1);
            }
        }
        int max = 0;
        for (int w : map.keySet()) {
            if (map.get(w) > max) max = map.get(w);
        }
        return wall.size() - max;
    }
}
