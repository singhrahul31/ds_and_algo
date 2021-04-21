package Problems;

import java.util.HashMap;
import java.util.Map;

public class Permutation_in_String {
	
    public static boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        
        if(s1len > s2len) return false;
        if(s1 == s2) return true;
        
        Map<Character, Integer> map = new HashMap<>();
        char[] s1arr = s1.toCharArray();
        for(char c: s1arr) {
            if(map.containsKey(c)) {
                int x = map.get(c);
                map.put(c, ++x);
            } else {
                map.put(c, 1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        //boolean result = false;
        for(int i=0;i<s2len;i++) {
            if(map.containsKey(s2.charAt(i))) {
                for(int j=i;j < s1len+i;j++) {
                	char c = s2.charAt(j);
                    map2.put(c, map2.getOrDefault(c, 0)+1);
                }
                if(is_same(map, map2)) {
                	return true;
                }
            }
        }
        
        
        return false;
        
    }
    
    private static boolean is_same(Map<Character, Integer> map1, Map<Character, Integer> map2) {
    	return map1.equals(map2);
    }
    
    
    public static void main(String[] args) {
    	boolean result = checkInclusion("ab", "eidbaooo");
    	System.out.println(result);
	}

}
