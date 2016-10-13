/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//The first pass is to pick out the candidate. If candidate knows i, then switch candidate. The second pass is to check whether the candidate is real.
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
        	if (knows(celebrity, i)) celebrity = i;
        }
        for (int i = 0; i < n; i++) {
        	if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
        }
        return celebrity;
    }
}