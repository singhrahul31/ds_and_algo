package BinarySearchTree;

import java.util.*;

public class MinElement {

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

    int minElement() {
        Node curr = root;
        int min = Integer.MAX_VALUE;
        while(curr !=null) {
            min = curr.data;
            curr = curr.left;
        }

        return min;
    }

    int getSize() {
        return length;
    }

    public static void main(String[] args) {
        MinElement bst = new MinElement();
        bst.insert(8);
        bst.insert(10);
        bst.insert(5);
        bst.insert(12);
        bst.insert(18);
        bst.insert(15);
        System.out.println(bst.getSize());
        System.out.println(bst.minElement());

    }


}
