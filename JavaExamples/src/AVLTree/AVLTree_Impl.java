package AVLTree;

public class AVLTree_Impl {
	Node root;

	private int height(Node root) {
		if(root == null) {
			return 0;
		}
		return root.height;
	}

	private int setHeight(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+ Math.max(height(root.left), height(root.right));
	}

	private Node leftRotate(Node root) {
		Node x = root.right;
		root.right = x.left;
		x.left = root;
		x.height = setHeight(x);
		root.height = setHeight(root);
		return x;
	}

	private Node rightRotate(Node root) {
		Node x = root.left;
		root.left = x.right;
		x.right = root;
		x.height = setHeight(x);
		root.height = setHeight(root);
		return x;
	}

	private Node setBalance(Node root, int key) {
		if(root==null) return root;
		root.height = setHeight(root);
		int balance = height(root.left) - height(root.right);

		if(balance > 1 && key < root.left.value) {
			return rightRotate(root);
		}
		if(balance < -1 && key > root.right.value) {
			return leftRotate(root);
		}

		if(balance > 1 && key > root.left.value) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if(balance < -1 && key < root.right.value) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	Node minValue(Node root) {
		Node cur = root;
		while(cur.left != null) cur = cur.left;

		return cur;
	}

	Node insert(Node root, int key) {

		if(root==null) return (new Node(key));

		if(key < root.value) {
			root.left = insert(root.left, key);
		} else if(key > root.value) root.right = insert(root.right, key);
		else return root;

		root = setBalance(root, key);

		return root;
	}

	Node delete(Node root, int key) {

		if(root==null) return null;
		if(key< root.value) root.left = delete(root.left, key);
		else if(key > root.value) root.right = delete(root.right, key);
		else {
			if(root.left==null || root.right==null) {
				Node temp = null;
				if(root.left == null) {
					temp = root.right;
				} else temp = root.left;

				if(temp==null) root = null;
				else root = temp;
			} else {
				Node temp = minValue(root.right);
				root.value = temp.value;
				root.right = delete(root.right, temp.value);
			}
		}

		root = setBalance(root, key);
		return root;
	}

	static void printNodes(Node root) {

		if(root !=null) {
			System.out.print(root.value + " ");
			printNodes(root.left);
			printNodes(root.right);
		}
	}

	public static void main(String[] args) {
		AVLTree_Impl av = new AVLTree_Impl();
		av.root = av.insert(av.root, 9);
		av.root = av.insert(av.root, 5);
		av.root = av.insert(av.root, 10);
		av.root = av.insert(av.root, 0);
		av.root = av.insert(av.root, 6);
		av.root = av.insert(av.root, 11);
		av.root = av.insert(av.root, -1);
		av.root = av.insert(av.root, 1);
		av.root = av.insert(av.root, 2);

		printNodes(av.root);
		av.delete(av.root, 9);
		System.out.println("\n");
		printNodes(av.root);


	}
}

class Node {
	int height;
	int value;
	Node left;
	Node right;
	
	public Node(int d) {
		value = d;
		height=1;
	}
}
