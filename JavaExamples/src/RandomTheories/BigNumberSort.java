package RandomTheories;

import java.util.Arrays;

public class BigNumberSort {

    public static void main(String[] args) {
        String[] value =new String[]{"123","32423","4234","12321","52657657646576476858769843","232","54354"};
        Arrays.sort(value, (a,b) -> a.length() == b.length() ? a.compareTo(b) : Integer.compare(a.length(),b.length()));
        for(String i: value) System.out.print(i +" ");
    }
}
