import java.io.*;
import java.util.*;

public class Solution {
    //must store the index, since sort will mix up the input
    public static class Pair {
        double diff;
        int idx;
    public Pair(double diff, int idx) {
        this.diff = diff;
        this.idx = idx;
        }
    }
    public static int[] findRound(double[] input) {
        double doubleSum = 0.0;
        int floorSum = 0;
        List<Pair> list = new ArrayList<>();
        //calculate the diff
        for (int i = 0; i < input.length; i++) {
            doubleSum += input[i];
            floorSum += Math.floor(input[i]);
            list.add(new Pair(input[i] - Math.floor(input[i]), i));
        }
        //determine how many number need to round up;
        int numToCeil = (int)Math.round(doubleSum) - floorSum;
        //sort to get the number with the most smallest diff to ceil
        Collections.sort(list, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return Double.compare(b.diff, a.diff);
            }
        });
        //ceil or floor
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            if (i < numToCeil) res[p.idx] = (int)Math.ceil(input[p.idx]);
            else res[p.idx] = (int)Math.floor(input[p.idx]);
        }
        return res;
    }
    public static void main(String[] args) {
        double[] input = {30.9, 2.4, 3.9};
        int[] res = findRound(input);
        for (int r : res) {
            System.out.println(r);
        }
    }
}

