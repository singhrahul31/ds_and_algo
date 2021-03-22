package Bitwise;

public class BitwiseExample {

    public static void bitwise(int n) {

        for(int i=31;i>=0;i--) {
            System.out.println(n & (1<<i));
        }
    }

    public static void main(String[] args) {
        bitwise(23);
    }
}
