package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DepthFirstsearch {
	
	Map<Integer, List<Integer>> map;
	
	public DepthFirstsearch() {
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
	
	List<Integer> dfs(int vertex) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		stack.add(vertex);
		visited.add(vertex);
		while(!stack.empty()) {
			int val = stack.pop();
			result.add(val);
			List<Integer> values = map.get(val);
			for(int i: values) {
				if(!visited.contains(i)) {
					stack.add(i);
					visited.add(i);
				}
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		DepthFirstsearch df = new DepthFirstsearch();
		int[] vertices = new int[] {1,2,3,4,5};
		int[][] edges = new int[][] {{1,3},{1,5},{2,3},{4,5}};
		
		for(int i: vertices) {
			df.addVertex(i);
		}
		
		for(int[] edge: edges) {
			df.addEdge(edge[0], edge[1]);
		}
		

		List<Integer> result1= df.dfs(1);
		for(int i: result1) {
			System.out.print(i + " ");
		}
	}

}
