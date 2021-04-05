/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Input: s = ""
Output: 0
 * 
 * */


package String;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Longest_Valid_Paranthesis {
	
    public static int longestValidParentheses(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Queue<Integer> open = new LinkedList<>();
        Stack<Integer> close = new Stack<>();
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == '(') {
                open.add(i);
            }
            if(chars[i] == ')') {
                close.add(i);
            }
            
        }
        
        while(open.size() > 0 && close.size() > 0) {
        	int start = open.remove();
        	int end = close.pop();
            if(checkpallindrome(s.substring(start, end + 1))) {
            	max = Math.max(max, end-start+1);
            }
        }
        return max;
    }
    
    static boolean checkpallindrome(String s) {
        int bracketcount = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') ++bracketcount;
            if(c == ')') --bracketcount;
            if(bracketcount < 0) return false;
        }
        
        return (bracketcount == 0);
    }
    
    public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
	}

}
