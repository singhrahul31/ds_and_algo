package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPallindrome {

    public static String longestPalindrome(String s) {
        String long_string = " ";
        int longest = 0;
        int start = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                int pallindrome_length = check(s, i, j);
                if(pallindrome_length > 0) {
                    longest = Math.max(longest, pallindrome_length);
                    if(pallindrome_length> longest) {
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, longest);
    }

    private static int check(String s, int start, int end) {
        int len = end-start+1;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else return 0;
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("acab"));
    }
}
