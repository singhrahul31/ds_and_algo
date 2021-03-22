package Problems;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubstring {

    static void distinctString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start =0;
        int max=0;
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)));
            }

            map.put(s.charAt(i), i+1);
            max = Math.max(max, i-start+1);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        distinctString("pwwkew");
    }
}
