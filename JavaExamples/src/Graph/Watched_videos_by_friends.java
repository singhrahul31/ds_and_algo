package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Watched_videos_by_friends {
	
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
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
        return null;
    }

}
