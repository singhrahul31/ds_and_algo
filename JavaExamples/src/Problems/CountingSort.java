package Problems;

import java.util.Arrays;

public class CountingSort {

    public static String countSort(String arr)
    {
        char[] chars = arr.toCharArray();
        char[] output = new char[chars.length];
        int[] count = new int[26];
//        for(int i=0;i<count.length;i++) {
//            count[i] = 0;
//        }
        for(int i=0;i<count.length;++i) {
            ++count[chars[i]-'a'];
        }
        for(int i=1;i<count.length;i++) {
            count[i] += count[i-1];
        }

        for(int i=0;i<chars.length;++i) {
            output[count[chars[i]]-1] = chars[i];
            --count[chars[i]];
        }
        String result = "";
        for(int i=0;i<output.length;i++) {
            result += output[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSort("edsab"));
    }
}
