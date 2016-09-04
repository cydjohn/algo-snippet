/*
Method: rewirte the Arrays.sort() method to sort arrays lexicographically. 
Corner Cases: 
1. "3" should be in front of "30";
2. input contains multiple 0, such as [0,0] should return "0" not "00";
*/

//ver1:
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return null;
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) { //lexicographical sorting is more intuitive in strings
        	strs[i] = Integer.toString(nums[i]);
        } 
        Arrays.sort(strs, new Comparator<String>() {
        	@Override
        	public int compare(String i, String j) {
        		String s1 = i + j;
        		String s2 = j + i;
        		return s2.compareTo(s1); //it will ensure a descending order
        	}
        });
        if (strs[0].equals("0")) return "0";
        StringBuilder ret = new StringBuilder();
        for (String s : strs) {
        	ret.append(s);
        }
        return ret.toString();
    }
}

//ver2 with more complex system methods:
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return null;
        String a = Arrays.toString(nums); //toString the List or Vector
        String ar[] = a.substring(1,a.length()-1).split(", ");
        Arrays.sort(ar, new Comparator<String>() {
        	@Override
        	public int compare(String i, String j) {
        		String s1 = i + j;
        		String s2 = j + i;
        		return s2.compareTo(s1); //it will ensure a descending order
        	}
        });
        if (ar[0].equals("0")) return "0";
        String ret = String.join("", ar);
        //StringBuilder ret = new StringBuilder();
        //for (String s : ar) {
        //	ret.append(s);
        //}
        return ret;
    }
}



