package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAnagrams {

	public List<List<String>> Anagrams(String[] string_list) {

		Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

		// traverse over the strings
		for (String s : string_list) {
			Map<Character, Integer> charMap = new HashMap<>();

			// add chars to the map with the string
			for (char c : s.toCharArray()) {
				if (!charMap.containsKey(c)) {
					charMap.put(c, 1);
				} else {
					int n = charMap.get(c);
					charMap.put(c, ++n);
				}
			}

//			tempStr.add(s);

			
			// check if the the map is already present in the main map
			if (!map.containsKey(charMap)) {
				List<String> tempStr = new ArrayList<>();
				tempStr.add(s);
				map.put(charMap, tempStr);
			} else {
				map.get(charMap).add(s);
//				tempStr.add(s);
			}

		}
		
		// add the map values into result array
		List<List<String>> result = new ArrayList<>();
		for(Map<Character, Integer> key: map.keySet()) {
			result.add(map.get(key));
		}
		return result;

	}
	
	public static void main(String[] args) {
		PrintAnagrams pa = new PrintAnagrams();
		List<List<String>> result = pa.Anagrams(new String[]{"act", "god", "cat", "dog", "tac"});
//		List<List<String>> result = pa.Anagrams(new String[]{"no", "on", "is"});
		for(List<String> str: result) {
			for(String s: str) {
				System.out.print(s + " ");
			}
			System.out.println("\n");
		}
		
	}

}
