package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPallindrome {

    public static String longestPalindrome(String s) {
        int start =0;
        int max=0;
        if(s.length() <= 2) {
            return Character.toString(s.charAt(0));
        }
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++) {

            if(map.containsKey(s.charAt(i))) {
                String subStr = s.substring(map.get(s.charAt(i)), i+1);
                boolean result = isPallindrome(subStr);
                if(result) {
                    max = Math.max(max, subStr.length());
                    list.add(subStr);
                }

            }
            map.put(s.charAt(i), i);
        }
        for(String st: list) {
            if(st.length() == max) {
                return st;
            }
        }
        return null;
    }

    public static boolean isPallindrome(String s) {
        int start =0;
        int end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbabbabb"));
    }
}
