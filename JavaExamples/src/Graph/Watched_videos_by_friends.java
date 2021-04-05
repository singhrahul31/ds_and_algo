package Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Watched_videos_by_friends {
	
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        Map<Integer, List<Integer>> friendsList = new HashMap<>();
        int i=0;
        for(int[] friend: friends) {
        	friendsList.put(i, Arrays.stream( friend ).boxed().collect( Collectors.toList() ));
        	i++;
        }
        i=0;
        Map<Integer, List<String>> videosWatched = new HashMap<>();
        for(List<String> video: watchedVideos) {
        	videosWatched.put(i, video);
        	i++;
        }
        
        
        return null;
        
    }
    
    static List<String> listVideos(Map<Integer, List<Integer>> friendsList, Map<Integer, List<String>> videosWatched, int id) {
    	Set<String> list = new HashSet<>();
    	List<Integer> friends = friendsList.get(id);
    	for(int friend: friends) {
    		List<String> videos = videosWatched.get(friend);
    		for(String video: videos) {
    			list.add(video);
    		}
    	}
    	
    	return null;
    }

}
