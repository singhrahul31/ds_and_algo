package Problems;

import java.util.HashMap;
import java.util.Map;

public class BalancedStrings {

    public static int balancedStringSplit(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count =0;
        for(char c:s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int x= map.get(c);
                map.put(c, ++x);
            }
            if(map.get('R') == map.get('L')) {
                count++;
                map.remove('R');
                map.remove('L');
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = balancedStringSplit("RLRRRLLRLL");
        System.out.println(result);
    }
}
