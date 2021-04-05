package String;

import java.util.HashMap;
import java.util.Map;

public class BalancedString {

    public static int balancedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q',0);
        map.put('W',0);
        map.put('E',0);
        map.put('R',0);
        int count =0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int x = map.get(c);
                map.put(c, ++x);
            }
        }
        for(int i: map.values()) {
            if(i > s.length()/4) {
                count += i- s.length()/4;
            }
        }
        return count;
    }

    public static void getCharCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q',0);
        map.put('W',0);
        map.put('E',0);
        map.put('R',0);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int x = map.get(c);
                map.put(c, ++x);
            }
        }
        map.forEach((key, value) -> {
            System.out.println(key + "-" + value);
        });
    }

    public static void main(String[] args) {
        int result = balancedString("WWEQERQWQWWRWWERQWEQ");
        System.out.println(result);
        getCharCount("WWEQERQWQWWRWWERQWEQ");
    }
}
