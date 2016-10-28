public class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null && words.size() == 0) return true;
        int i = 0;
        while(i < words.size() && i < words.get(i).length()) {
        	String a = words.get(i).substring(i);
        	StringBuilder sb = new StringBuilder();
        	for (int j = i; j < words.size(); j++) {
        		if (i < words.get(j).length()) sb.append(words.get(j).charAt(i));
        	}
        	String b = sb.toString();
        	if (!a.equals(b)) return false;
        	i++;
        }
        return true;
    }
}