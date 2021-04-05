package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchedWords {
	static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern) {
		ArrayList<String> result = new ArrayList<>();
		String hash = getMap(pattern);
		for (String s : dict) {
			if (s.length() == pattern.length() && hash.equals(getMap(s))) {
				result.add(s);
			}
		}

		return result;

	}

	static String getMap(String s) {
		String res = "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int x = map.get(c);
				map.put(c, ++x);
			}

			res += map.get(c);
		}

		return res;
	}

	public static void main(String[] args) {
		ArrayList<String> inp = new ArrayList<>();
		inp.add("abb");// abc,xyz,xyy
		inp.add("abc");
		inp.add("xyz");
		inp.add("xyy");
		
		ArrayList<String> result = findMatchedWords(inp, "foo");
		for(String s: result) {
			System.out.println(s);
		}
	}

}
