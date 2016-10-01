public class ValidWordAbbr {
	HashMap<String, String> map = new HashMap();
    public ValidWordAbbr(String[] dictionary) {
        for (String d : dictionary) {
            String a = abbr(d);
        	if (!map.containsKey(a)) {
        	    map.put(a, d);
        	}else {
        	    if (!map.get(a).euquals(d)) {
        	    	map.put(a, "");
        	    }
        	}
        }
    }

    public boolean isUnique(String word) {
        String a = abbr(word);
        if (map.containsKey(a) && !map.get(a).euqals(word)) return false;
        else return true;
    }

    private String abbr(String s) {
        if (s.length() <= 2) return s;
        return s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length()-1);
    } 
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");