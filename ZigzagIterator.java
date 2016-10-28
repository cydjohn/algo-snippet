public class ZigzagIterator {
    boolean useOne;
    List<Integer> v1;
    List<Integer> v2;
    int p1;
    int p2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        useOne = true;
        this.v1 = v1;
        this.v2 = v2;
        p1 = 0;
        p2 = 0;
    }

    public int next() {
        int res = 0;
        if (useOne) {
            if (p1 < v1.size()) res = v1.get(p1++);
            else res = v2.get(p2++);
        } else {
            if (p2 < v2.size()) res = v2.get(p2++);
            else res = v1.get(p1++);
        }
        useOne = !useOne;
        return res;
    }

    public boolean hasNext() {
        return p1 < v1.size() || p2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

}