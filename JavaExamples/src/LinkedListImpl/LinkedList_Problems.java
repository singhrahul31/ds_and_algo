package LinkedListImpl;

public class LinkedList_Problems {
	 Node root;
	 
	 static class Node {
			int val;
			Node next;
			
			Node(int d) {
				val=d;
				next =null;
			}
		}
	 
	 
	// delete node without reference to the root node
	static void deleteNode(Node n) {
		n.val = n.next.val;
		n.next = n.next.next;
			
	}
	
	
	
	
	Node insert(int d) {
		Node n= new Node(d);
		if(root==null) {
			root = n;
		} else {
			n.next = root;
			root = n;
		}
		return root;
	}
	
	static void printNodes(Node root) {
		while(root!= null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList_Problems ll = new LinkedList_Problems();
		ll.root = new Node(5);
		ll.insert(10);
		ll.insert(20);
		
		
		printNodes(ll.root);
//		deleteNode(a);
//		System.out.println("\n");
//		printNodes(root);
	}
	

}


