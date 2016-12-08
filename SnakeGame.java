/*那这道题该如何设计呢？大家可能一上来就建了个二维数组来代表格子，但这样的话缺点是我们不好维护蛇精目前占据的格子。例如蛇精每走一步，它的屁股就要离开当前格子，我们不太好track蛇精屁股的位置。其实用一个链表维护蛇的位置就可以了，这样每次记录蛇的移动，只需要把屁股位置去掉，再把新的头的位置加上就好。另外再建一个链表，用来维护所有的食物坐标。*/
public class SnakeGame {
    class Pos{
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int w, h;
    int score = 0;
    Deque<Pos> dq = new LinkedList();
    Queue<Pos> foods = new LinkedList();
    Set<Integer> set = new HashSet();

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        for (int[] f : food) {
            foods.offer(new Pos(f[0], f[1]));
        }
        dq.offer(new Pos(0, 0));
        set.add(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Pos front = dq.getFirst();
        if (direction.equals("U")) {
            if (front.x - 1 < 0) return -1;
            dq.addFirst(new Pos(front.x-1, front.y));
        } else if (direction.equals("D")) {
            if (front.x + 1 >= h) return -1;
            dq.addFirst(new Pos(front.x+1, front.y));
        } else if (direction.equals("L")) {
            if (front.y - 1 < 0) return -1;
            dq.addFirst(new Pos(front.x, front.y-1));
        } else {
            if (front.y + 1 >= w) return -1;
            dq.addFirst(new Pos(front.x, front.y+1));            
        }
        front = dq.getFirst();
        Pos food = foods.peek();
        if (food != null && front.x == food.x && front.y == food.y) {
            foods.poll();
            score++;
        } else {
            Pos tail = dq.removeLast();
            set.remove(tail.x * w + tail.y);
        }
        if (!set.add(front.x * w + front.y)) return -1;
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */