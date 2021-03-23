package Problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static List<String> generatePara(int n) {
        List<String> finalResult = new ArrayList<>();
        generate("", 0,0,n, finalResult);
        return finalResult;
    }

    public static void generate(String startString,int open, int close, int total, List<String> finalResult) {
        if(startString.length() == total *2) {
            finalResult.add(startString);
            return;
        }
        if(open<total) {
            generate(startString.concat("("), open+1, close, total, finalResult);
        }
        if(close < open) {
            generate(startString.concat(")"), open, close+1, total, finalResult);
        }
    }

    public static void main(String[] args) {
        List<String> result = generatePara(12);
        for(String s: result) {
            System.out.println(s);
        }
    }
}
