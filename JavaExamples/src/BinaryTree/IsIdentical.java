package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsIdentical {
	
	
	static boolean isIdentical(Node root1, Node root2)
	{
		if(root1 == null && root2 == null) return true;
		
		if(root1 != null && root2 != null) {
			return (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
		}
		
		return false;
	}
	
	public static void main(String[] args) {
        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
 
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        
        System.out.println(isIdentical(root1, root2));
	}

}

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
