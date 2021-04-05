package Graph;

import java.util.*;

public class GraphImpl<T> {

    private Map<T, List<T>> map = new HashMap<>();

    /**
     * Add vertex to the Graph
     * */
    public void addVertex(T v) {
        map.put(v, new LinkedList<>());
    }

    /**
     * Add an Edge to the Graph
     * */
    public void addEdge(T source, T destination, boolean biDirectional) {

        if(!map.containsKey(source)) addVertex(source);
        if(!map.containsKey(destination)) addVertex(destination);

        map.get(source).add(destination);
        if(biDirectional) map.get(destination).add(source);
    }

    /**
     * Return the total number of the Vertex in the graph
     * */
    public int getVertexCount() {
        return map.keySet().size();
    }

    /**
     * returns the total edges in the graph
     * */
    public int getEdgeCount(boolean biDirectional) {
        int count=0;
        for(T v: map.keySet()) {
            count += map.get(v).size();
        }

        if(biDirectional) count = count/2;

        return count;
    }

    public boolean hasVertex(T name) {
        return map.containsKey(name);
    }

    public boolean hasEdge(T source, T dest) {
        return map.get(source).contains(dest);
    }

    public List<T> getFriends(T name) {
        return map.get(name);
    }
    /**
     * friend suggestion for a particular vertex
     * */
    public List<T> suggestFriends(T name) {
        List<T> fSuggestions = new ArrayList<>();
        List<T> names = map.get(name);
        for(T n: names) {
            List<T> fNames = map.get(n);
            for(T fn: fNames) {
                if(!names.contains(fn) && !fn.equals(name)) {
                    fSuggestions.add(fn);
                }
            }
        }
        return fSuggestions;
    }

    public static void main(String[] args) {
        GraphImpl<String> friends = new GraphImpl();
        friends.addVertex("Rahul");
        friends.addVertex("Swati");
        friends.addVertex("Powell");
        friends.addVertex("Mahim");
        friends.addVertex("Shreya");
        friends.addEdge("Rahul", "Swati", true);
        friends.addEdge("Swati", "Shreya", true);
        friends.addEdge("Powell", "Rahul", true);
        friends.addEdge("Powell", "Swati", true);
        friends.addEdge("Rahul", "Mahim", true);
        List<String> friendsOf = friends.suggestFriends("Shreya");
        for(String s: friendsOf) {
            System.out.println(s);
        }

    }
}
