//Q: what type of data you use to compare the version? string or int?
//A: int. strings.compareTo() method is based on lexicographical sorting, so "01" > "1", but Integer.parseInt() will maintained the right comparison.
public class Solution {
    public int compareVersion(String version1, String version2) {
        //You need to escape the dot if you want to split on a literal dot
        //Otherwise you are splitting on the regex ., which means "any character".
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        int n1 = 0, n2 = 0;
        for (int i = 0; i < len; i++) {
        	if (i >= v1.length) n1 = 0;
        	else n1 = Integer.parseInt(v1[i]); 
        	if (i >= v2.length) n2 = 0;
        	else n2 = Integer.parseInt(v2[i]);
        	if (n1 > n2) return 1;
        	if (n1 < n2) return -1;
        }
        return 0;
    }
}

//wrong answer
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        String n1, n2;
        for (int i = 0; i < len; i++) {
            if (i >= v1.length) n1 = "0";
            else n1 = v1[i]; 
            if (i >= v2.length) n2 = "0";
            else n2 = v2[i];
            if (n1.compareTo(n2) > 0) return 1;
            if (n1.compareTo(n2) < 0) return -1;
        }
        return 0;
    }
}