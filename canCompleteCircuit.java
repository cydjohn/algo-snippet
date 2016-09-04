/*
1, if sum of gas is more than sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one I found is the right one).
2, The tank should never be negative, so restart whenever there is a negative number. If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s = 0, sum = 0, gsum = 0, csum = 0;
        for (int i = 0; i < gas.length; i++) {
        	gsum += gas[i]; csum += cost[i];
        	sum += gas[i] - cost[i];
        	if (sum < 0) {
        		s = i + 1;
        		sum = 0;
        	}
        }
        /*we need to cheak gsum, csum here, since there will still be no result even s finds a valid value, consider[2,4], [3,4]*/
        if (gsum < csum) return -1;
        else return s;
    }
}

//older version
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	boolean cycle = false; int first = 0;
    	int last = gas.length - 1;	
        for (int i = gas.length - 1; i >= 0 && !cycle; i--) {
        	if (gas[i] >= cost[i]) continue;
        	first = i;
        	int gSum = gas[i], cSum = cost[i];
        	while (gSum < cSum) {
        		if (i == 0) {
        			cycle = true;
        			i = gas.length - 1;
        		}
        		else i--;
        		last = i;
        		if (cycle && i <= first) break;
        		gSum += gas[i];
        		cSum += cost[i];
        	}
        }
        if (cycle && last > first) return last;
        else if (!cycle) return last;
        else return -1;
    }
}

