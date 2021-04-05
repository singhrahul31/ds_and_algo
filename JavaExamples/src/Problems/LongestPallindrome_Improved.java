package Problems;

public class LongestPallindrome_Improved {

    public static String longestPallindrome(String s) {

        int len = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = check(s, i, i);
            int len2 = check(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }


    public static int check(String s, int start, int end) {

        if (s.length() < 1 || start > end) {
            return 0;
        }

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPallindrome("acbbca"));
    }
}
