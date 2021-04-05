package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_concatenation {
	
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int concatlength = 0;
        int wordlength = words[0].length();
            
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
                
            } else {
                int n = map.get(words[i]);
                map.put(words[i], ++n);
            }
            concatlength += words[i].length(); 
        }
        
        int strlength = s.length();
        
        if(strlength < concatlength) return list;
        
        for(int i=0;i<strlength - concatlength+1;i++) {
            if(checkword(i, s.substring(i, i+concatlength), wordlength, map)) {
                list.add(i);
            }
        }
        return list;
    }
    
    static boolean checkword(int pos, String str, int len, Map<String, Integer> map) {
        Map<String, Integer> temp = new HashMap<>(map);
        for(int i=0;i<str.length();i += len) {
            String tocheck = str.substring(i, i+len);
            if(temp.containsKey(tocheck)) {
                int n = temp.get(tocheck);
                if(n == 0) {
                    return false;
                } else temp.put(tocheck, --n);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String[] words = new String[] {"bar","foo","the"};
    	List<Integer> result = findSubstring("barfoofoobarthefoobarman", words);
    	for(int i: result) System.out.println(i + " ");
	}

}
