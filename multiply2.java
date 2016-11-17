
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        List<List<Integer>> row = new ArrayList();
        List<List<Integer>> col = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            List<Integer> set = new ArrayList();
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) set.add(j);
            }
            row.add(set);
        }
        for (int i = 0; i < B[0].length; i++) {
            List<Integer> set = new ArrayList();
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) set.add(j);
            }
            col.add(set);
        }
        for (int i = 0; i < row.size(); i++) {
            List<Integer> list = row.get(i);
            for (int a : list) {
                for (int j = 0; j < col.size(); j++) {
                    List<Integer> list1 = col.get(j);
                    if (list1.contains(a)) {
                        res[i][j] += A[i][a] * B[a][j];
                    }
                }
            }
        }
        return res;
    }
}


public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nb = B[0].length;
        int[][] C = new int[m][nb];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < nb; j++) {
                    if (B[k][j] == 0) continue;
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}


public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nb = B[0].length;
        int[][] C = new int[m][nb];
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int k = 0; k < n; k++) {
            map.put(k, new HashMap<Integer, Integer>());
            for (int j = 0; j < nb; j++) {
                if (B[k][j] == 0) continue;
                map.get(k).put(j, B[k][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (Integer j : map.get(k).keySet()) {
                    C[i][j] += A[i][k] * map.get(k).get(j);
                }
            }
        }
        return C;
    }
}


























