package Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDistanceFromRoot {
	Node root;

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	List<Integer> kDistance(Node root, int k) {

		List<Integer> list = new ArrayList<>();
		if (k == 0) {
			list.add(root.data);
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int level = 1;
		while (q.size() > 0) {
			Node n = q.remove();
//			q.

			if (n.left != null) {
				if (level == k) {
					list.add(n.left.data);
				}
				q.add(n.left);
			}
			if (n.right != null) {
				if (level == k) {
					list.add(n.right.data);
				}
				q.add(n.right);
			}
			level++;
		}
		return list;
	}
	
	public static void main(String[] args) {
		KDistanceFromRoot k = new KDistanceFromRoot();
		k.root.data = 1;
//		k.root.left = new Node(2);
	}

}
