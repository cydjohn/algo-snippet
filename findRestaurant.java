import java.util.*;

public class Solution {
	public class Restaurant {
		String name;
		int rating;
	}
	public static String findRestaurant(List<Restaurant> a, List<Restaurant> b) {
		if (a == null || a.length() == 0 || b == null || b.length() == 0) return "yelpwhat";
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			map.put(a.name, i);
		}
		String prefer = "";
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < b.size(); i++) {
			if (map.containsey(b.name)) {
				if (min > map.get(b.name) + i) {
					min = map.get(b.name) + i;
					prefer = b.name;
				}
			}
		}
		return prefer.length() == 0 ? "yelpwhat" : prefer;
	}
}