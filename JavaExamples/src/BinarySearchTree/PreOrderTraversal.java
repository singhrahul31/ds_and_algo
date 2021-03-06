package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    Node root;
    int length =0;
    List<Integer> values;

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int d) {
            data=d;
            left = right = null;
        }
    }

    void insert(int value) {
        Node n = new Node(value);
        length++;
        if(root == null) {
            root = n;
            return;
        } else {
            Node current = root;
            while(current != null) {
                if(value <= current.data) {
                    if(current.left == null) {
                        current.left = n;
                        return;
                    }
                    current = current.left;
                } else {
                    if(current.right == null) {
                        current.right = n;
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }

    void printPreOrderInterative() {
        if(root == null) {
            return;
        } else {
            Stack<Node> stack = new Stack<>();
            Node current = root;
            while(current != null || stack.size() > 0) {

                while(current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                System.out.println(current.data + " ");

                current = current.right;
            }

        }
    }

    List<Integer> printPreOrderRecursive() {
        List<Integer> list = new ArrayList<>();
        preOrderRecursive(root, list);
        return list;
    }

    void preOrderRecursive(Node root, List<Integer> list) {

        if(root == null) return;
        list.add(root.data);
        preOrderRecursive(root.left, list);
        preOrderRecursive(root.right, list);
    }

    int getSize() {
        return length;
    }

    public static void main(String[] args) {
        PreOrderTraversal bst = new PreOrderTraversal();
        bst.insert(8);
        bst.insert(10);
        bst.insert(5);
        bst.insert(12);
        bst.insert(18);
        bst.insert(15);
        System.out.println(bst.getSize());
        bst.printPreOrderInterative();
        List<Integer> result = bst.printPreOrderRecursive();
        for(int i: result) {
            System.out.println(i);
        }

    }
}
