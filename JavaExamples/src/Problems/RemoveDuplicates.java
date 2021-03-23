package Problems;

import javax.swing.text.AttributeSet;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    static void removeDuplicates(String S) {
        Map<Character, Boolean> map = new HashMap<>();
        String result = "";
        for(char c: S.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, true);
                result += Character.toString(c);
            }
        }
        System.out.println("Result is: "+result);
    }

    public static void main(String[] args) {
        removeDuplicates("bvve");
    }
}
