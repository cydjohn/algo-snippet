//method1
public class Vector2D implements Iterator<Integer> {
    int x;
    int y;
    List<List<Integer>> v;

    public Vector2D(List<List<Integer>> vec2d) {
        x = 0;
        y = 0;
        v = vec2d;
    }

    public Integer next() {
        Integer res = (Integer)(v.get(x).get(y++));
        if (y == v.get(x).size()) { 
            x++;
            y = 0;
        }
        return res;
    }

    public boolean hasNext() {
        if (x >= v.size()) return false;
        while (x < v.size() && v.get(x).size() == 0) x++;
        return x < v.size();
    }
}

//method2
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public Integer next() {
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext(); //j可能还没有初始化，所以要判断是否为null
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

