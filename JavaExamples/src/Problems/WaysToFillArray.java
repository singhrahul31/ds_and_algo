package Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: queries = [[2,6],[5,1],[73,660]]
 * Output: [4,1,50734910]
 * Explanation: Each query is independent.
 * [2,6]: There are 4 ways to fill an array of size 2 that multiply to 6: [1,6], [2,3], [3,2], [6,1].
 * [5,1]: There is 1 way to fill an array of size 5 that multiply to 1: [1,1,1,1,1].
 * [73,660]: There are 1050734917 ways to fill an array of size 73 that multiply to 660. 1050734917 modulo 109 + 7 = 50734910.
 *
 * Input: queries = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * Output: [1,2,3,10,5]
 * */
public class WaysToFillArray {

    public static int[] waysToFillArray(int[][] queries) {
        return null;
    }

    public static List<Integer> primerFactor(int num) {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        factors.add(num);
        while(num%2 == 0) {
            factors.add(2);
            num /= 2;
        }

        for(int i=3; i<= Math.sqrt(num);i+=2) {

            if(num%i==0) {
                factors.add(i);
                num /= i;
            }
        }
        if(num>2) factors.add(num);

        return factors;
    }

    

    public static void main(String[] args) {
        List<Integer> result = primerFactor(6);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }
}
