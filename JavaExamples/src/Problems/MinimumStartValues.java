/**
 * Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.

Input: nums = [-3,2,-3,4,2]
Output: 5


Input: nums = [1,2]
Output: 1


Input: nums = [1,-2,-3]
Output: 5
 * 
 * */

package Problems;

public class MinimumStartValues {
	
	static int minStartValue(int[] nums) {
        
        int start_val = 1;
  
        while(true) {
        	int sum = start_val;
        	boolean check = true;
        	for(int j:nums) {
        		sum+=j;
        		if(sum  < 1) {
        			check = false;
        			break;
        		}
        	}
        	if(check) {
        		return start_val;
        	}
        	start_val++;
            
         }
	}
	
    public int minStartValue1(int[] nums) {
        int min = 0;
        int sum = 0;
        
        for(int num: nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        
        return 1 - min;
    }
	
	public static void main(String[] args) {
		int result = minStartValue(new int[] {-3,2,-3,4,2});
		System.out.println(result);
	}

}
