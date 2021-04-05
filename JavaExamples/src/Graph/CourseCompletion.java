package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseCompletion {

	public boolean checkCourseCompletion(int numCourse, int[][] prerequisites) {

		// edge case
		if (numCourse == 0 || prerequisites.length == 0) {
			return true;
		}

		// prepare graph
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < numCourse; i++) {
			map.put(i, new LinkedList<>());
		}

		// add values to the graph
		for (int[] req : prerequisites) {
			map.get(req[1]).add(req[0]);
		}

		// create the visited array
		int[] visited = new int[numCourse];

		// traverse the graph
		for (int i = 0; i < numCourse; i++) {
			if (!isCyclic(map, i, visited)) {
				return false;
			}
		}

		return true;
	}

	private boolean isCyclic(Map<Integer, List<Integer>> map, int i, int[] visited) {

		// if a node is already been visited. then it should not be checked
		if (visited[i] == 1) {
			return true;
		}

		// if a node is already getting processed, them it should not be part of any
		// other node.
		if (visited[i] == -1) {
			return false;
		}

		visited[i] = -1;
		for (int j : map.get(i)) {
			if (!isCyclic(map, j, visited)) {
				return false;
			}
		}
		visited[i] = 1;
		return true;
	}

	public static void main(String[] args) {
		CourseCompletion cc = new CourseCompletion();
		boolean result = cc.checkCourseCompletion(4, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 0, 3 } });
		System.out.println(result);
	}
}
