package BinarySearchTree;

public class CheckBST {
    Node prev;
    Node node;



    boolean isBST(Node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }

    public static void main(String[] args) {
        CheckBST ck = new CheckBST();
        ck.prev = null;
        ck.node = new Node(3);
        ck.node.left = new Node(2);
        ck.node.left.left = new Node(1);
        ck.node.right = new Node(5);
        ck.node.right.left = new Node(4);

        System.out.println(ck.isBST(ck.node));


    }

}

class Node {
    int data;
    Node left, right;
    Node(int d) {
        data=d;
        left = right = null;
    }
}
