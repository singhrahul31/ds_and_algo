package Problems;

/**
 * Given an integer N, return the greatest integer which can be made by prefixing '5' to the number
 *
 * 268 => 5268
 * 670 => 6750
 * 0 => 50
 * */
public class LongestNumber {

    public static void main(String[] args) {
        System.out.println(compute(670));
    }

    static int compute(int num) {
        String number = String.valueOf(num);
        int result = -1;
        for(int i=0; i < number.length();i++) {
            if(Character.getNumericValue(number.charAt(i)) < 5) {
                result = (5 * getExp(i-1)) + num;
            }
        }
        return result;
    }

    static int getExp(int n) {
        return (int) Math.pow(10,n);
    }
}
