//Floyd algorithm
//hashmap with the key as string, could not use array, since java array only use int as index
/*A variation of Floyd–Warshall, computing quotients instead of shortest paths. An equation A/B=k is like a graph edge A->B, and (A/B)*(B/C)*(C/D) is like the path A->B->C->D.*/
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Set<String> set = new HashSet();
        Map<String, Map<String, Double>> g = new HashMap();
        int i = 0;
        for (String[] e : equations) {
            if (!g.containsKey(e[0])) g.put(e[0], new HashMap<String, Double>());
            if (!g.containsKey(e[1])) g.put(e[1], new HashMap<String, Double>());
            g.get(e[0]).put(e[1], values[i]);
            g.get(e[1]).put(e[0], 1 / values[i++]);
            set.add(e[0]);
            set.add(e[1]);
        }
        for (String k : set) {
            g.get(k).put(k, 1.0);
            for (String s : set) {
                for (String t : set) {
                    if (g.get(s).containsKey(k) && g.get(k).containsKey(t)) {
                        double a = g.get(s).get(k);
                        double b = g.get(k).get(t);
                        g.get(s).put(t, a * b);
                    }
                }
            }
        }
        double[] res = new double[queries.length];
        i = 0;
        for (String[] q : queries) {
            if (g.containsKey(q[0]) && g.get(q[0]).containsKey(q[1])) res[i] = g.get(q[0]).get(q[1]);
            else res[i] = -1.0;
            i++;
        }
        return res;
    }
}

//Stack Overflow
public class Solution {
	Set<String> set = new HashSet();
	Map<String, Map<String, Double>> g = new HashMap();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; i++) {
        	if (!g.containsKey(equations[i][0])) g.put(equations[i][0], new HashMap<String, Double>());
        	if (!g.containsKey(equations[i][1])) g.put(equations[i][1], new HashMap<String, Double>());
        	g.get(equations[i][0]).put(equations[i][1], values[i]);
        	g.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	if (!g.containsKey(queries[i][0]) || !g.containsKey(queries[i][1])) res[i] = -1.0;
        	else if (queries[i][0] == queries[i][1]) res[i] = 1.0;
        	else {
        		res[i] = helper(queries[i][0], queries[i][1]);
        	}
        }
        return res;
    }
    private double helper(String st, String target) {
    	Map<String, Double> map = g.get(st);
    	for (String m : map.keySet()) {
    		if (m.equals(target)) return map.get(m);
    		double tmp = helper(m, target);
    		if (tmp != Integer.MIN_VALUE) return map.get(m) * tmp;
    	}
    	return Integer.MIN_VALUE;
    }
}


//wrong answer
//只适用于输入的string为单个字符时
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations.length == 0 || equations[0].length == 0) return 0;
        int n = equations.length;
        double[][] g = new double[26][26];
        Arrays.fill(g, -1.0);
        Set<Integer> set = new HashSet();
        int i = 0;
        for (String[] e : equations) {
            int x = e[0].charAt(0) - 'a';
            int y = e[1].charAt(0) - 'a';
            g[x][y] = values[i];
            g[y][x] = 1.0 / values[i++];
            set.add(x);
            set.add(y);
        }
        for (int k : set) {
            g[k][k] = 1.0;
            for (int s : set) {
                for (int t : set) {
                    if (g[s][k] > 0 && g[k][t] > 0) {
                        g[s][t] = g[s][k] * g[k][t];
                    }
                }
            }
        }
        double[] res = new double[queries.length];
        i = 0;
        for (String q : queries) {
            int x = q[0].charAt(0) - 'a';
            int y = q[1].charAt(0) - 'a';
            if (g[x][y] > 0) res[i] = g[x][y];
            else res[i] = -1.0;
            i++;
        }
        return res;
    }
}





















