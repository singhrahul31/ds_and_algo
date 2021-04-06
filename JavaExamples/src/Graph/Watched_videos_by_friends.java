package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Watched_videos_by_friends {
	
    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> friend_queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<String, Integer> vdo_freq = new HashMap<>();
         int current_level = 0;
        friend_queue.offer(id);
        visited.add(id);
        
        while(friend_queue.size() > 0 && current_level <= level) {
            
            int queue_size = friend_queue.size();
            for(int i=0;i<queue_size;i++) {
                int curr_val = friend_queue.poll();
                
                // save the freq if the level matches
                if(current_level == level && watchedVideos.get(curr_val).size() > 0) {
                    List<String> vdos = watchedVideos.get(curr_val);
                    for(String vdo: vdos) {
                        vdo_freq.put(vdo, vdo_freq.getOrDefault(vdo, 0) +1);
                    }
                }
                int[] friends_of_id = friends[curr_val];
                for(int frnd: friends_of_id) {
                    if(!visited.contains(frnd)) {
                        friend_queue.offer(frnd);
                        visited.add(frnd);
                    }
                }
                
            }
            current_level++;
        }
        Map<Integer, List<String>> vdo_by_name = new TreeMap<>();
        for(String vdo: vdo_freq.keySet()) {
        	vdo_by_name.putIfAbsent(vdo_freq.get(vdo), new ArrayList<>());
        	vdo_by_name.get(vdo_freq.get(vdo)).add(vdo);
        }
        for(String vdo: vdo_freq.keySet()) {
        	System.out.println(vdo+" "+vdo_freq.get(vdo));
        }
        List<String> result = new ArrayList<>();
        for(List<String> list: vdo_by_name.values()) {
        	Collections.sort(list);
        	result.addAll(list);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		String[][] videos = new String[][] {{"bjwtssmu"},{"aygr","mqls"},{"vrtxa","zxqzeqy","nbpl","qnpl"},{"r","otazhu","rsf"},{"bvcca","ayyihidz","ljc","fiq","viu"}};
		int[][] friends = new int[][] {{3,2,1,4},{0,4},{4,0},{0,4},{2,3,1,0}};
		int id=1;
		int level=1;
		List<List<String>> input = new ArrayList<>();
		for(String[] value: videos) {
			input.add(Arrays.asList(value));
		}
		List<String> result = watchedVideosByFriends(input, friends, id, level);
		for(String vdo: result) System.out.print(vdo + " ");
		
	}

}
