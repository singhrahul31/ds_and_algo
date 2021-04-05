package Problems.HackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Sample Input
 *
 * STDIN       Function
 * -----       --------
 * 2           t = 2
 * 4           money = 4
 * 5           cost[] size n = 5
 * 1 4 5 3 2   cost = [1, 4, 5, 3, 2]
 * 4           money = 4
 * 4           cost[] size n = 4
 * 2 2 4 3     cost = [2, 2, 4, 3]
 *
 * Sample Output
 *
 * 1 4
 * 1 2
 *
 *
 * */
public class IceCreamParlor {

    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> values = new HashMap<>();
        for(int i=0;i<cost.length;i++) {
            if(values.containsKey(money - cost[i])) {
                System.out.println(values.get(money - cost[i]) + 1 + " " + ++i);
                return;
            }
            values.put(cost[i], i);
        }
    }

    public static void main(String[] args) {
        whatFlavors(new int[]{4, 3, 2, 5, 7}, 8);
    }

}
