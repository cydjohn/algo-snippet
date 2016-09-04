public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = Math.abs((A-C) * (B-D));
        int a2 = Math.abs((G-E) * (H-F));
        if (E >= C || G <= A || H <= B || F >= D) return a1 + a2;
        else return a1 + a2 - (Math.min(C, G)-Math.max(A, E)) * (Math.min(D, H)-Math.max(B, F));
    }
}

//point: 找出重合的长方形的边长
//method: 判断完全不重合比判断重合要更容易，故先排除完全不重合的情况；