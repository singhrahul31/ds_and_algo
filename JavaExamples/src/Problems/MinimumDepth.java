//package Problems;
//
//public class MinimumDepth {
//	
//
//		static int minDepth(Node root)
//		{
//		            // base case
//	        if (root == null) {
//	            return 0;
//	        }
//	 
//	        // find the minimum depth of the left subtree
//	        int l = minDepth(root.left);
//	 
//	        // find the minimum depth of the right subtree
//	        int r = minDepth(root.right);
//	 
//	        // if the left child does not exist, consider the depth
//	        // returned by the right subtree
//	        if (root.left == null) {
//	            return 1 + r;
//	        }
//	 
//	        // if the right child does not exist, consider the depth
//	        // returned by the left subtree
//	        if (root.right == null) {
//	            return 1 + l;
//	        }
//	 
//	        // otherwise, choose the minimum depth returned by the
//	        // left and right subtree
//	        return Integer.min(l, r) + 1;
//		}
//		
//		public static void main(String[] args) {
//			Node root = new Node(10);
//			root.left = new Node(20);
//			root.left.right = new Node(40);
//			root.right = new Node(30);
//			root.right.right = new Node(60);
//			root.right.right.left = new Node(2);
//			
//			System.out.println(MinimumDepth.minDepth(root));
//			
//		}
//		
//
//	}
//
//
//
////private class Node{
////    public Node next;
////    int data;
////    Node left;
////    Node right;
////    Node(int data){
////        this.data = data;
////        left=null;
////        right=null;
////    }
////}
