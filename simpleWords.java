//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.*;
// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static String[] simpleWords(String[] words) {
		if (words == null || words.length == 0) return words;
		List<String> list = new ArrayList<>();
		Set<String> dict = new HashSet<>();
		for (String w : words) {
			dict.add(w);
		} 
		for (String w : words) {
			if (isSimple(w, dict)) {
				list.add(w);
			}
		}
		return list.toArray(new String[list.size()]);
	}
	private static boolean isSimple(String s, Set<String> dict) {
		if (s.length() == 0) return true;
		dict.remove(s);
		boolean[] isWord = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i+1))) {
				isWord[i] = true;
			} else {
				for (int j = 0; j <= i; j++) {
					if (isWord[j] && dict.contains(s.substring(j+1, i+1))) {
						isWord[i] = true;
						break;
					}
				}
			}
		}
		dict.add(s);
		return isWord[s.length()-1] == false;
	}
  
  public static void main(String[] args)
  {
    String[] s = {"chat", "ever", "", "snapchat" ,"snap", "salesperson" ,"per", "person", "sales" ,"son" ,"whatsoever" ,"what", "so"};
    String[] res = simpleWords(s);
    for (String r : res) {
      System.out.println(r);
    }
    
  }
}


