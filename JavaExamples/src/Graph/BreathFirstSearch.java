package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreathFirstSearch {
	
	Map<Integer, List<Integer>> map;
	
	public BreathFirstSearch() {
		map = new HashMap<>();
	}
	
	
	void addVertex(int d) {
		if(!map.containsKey(d)) {
			map.put(d, new ArrayList<>());
		} 
	}
	
	// assuming it is undirected graph
	void addEdge(int from, int to) {

		if(!map.containsKey(from)) addVertex(from);
		if(!map.containsKey(to)) addVertex(to);
		
		map.get(from).add(to);
		map.get(to).add(from);
	}
	
	List<Integer> bfs(int vertex) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		q.add(vertex);
		visited.add(vertex);
		while(q.size()>0) {
			int val = q.poll();	
			result.add(val);
			List<Integer> list = map.get(val);
			for(int num: list) {
				if(!visited.contains(num)) {
					q.add(num);
					visited.add(num);
				}
			}
		}
		return result;

	}
	

	
	public static void main(String[] args) {
		BreathFirstSearch bf = new BreathFirstSearch();
		int[] vertices = new int[] {1,2,3,4,5};
		int[][] edges = new int[][] {{1,3},{1,5},{2,3},{4,5}};
		
		for(int i: vertices) {
			bf.addVertex(i);
		}
		
		for(int[] edge: edges) {
			bf.addEdge(edge[0], edge[1]);
		}
		
		List<Integer> result= bf.bfs(1);
		for(int i: result) {
			System.out.print(i + " ");
		}

	}

}
