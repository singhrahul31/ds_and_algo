package BinarySearchTree;

import java.util.*;

public class BinarySearchTree {

    Node head;
    int length;
    List<Integer> values;


    public BinarySearchTree() {
        values = new ArrayList<>();
    }

    // define single elements as node
    class Node {
        Node left;
        Node right;
        int data;

        public Node(int d) {
            data=d;
            left = right = null;
        }
    }


    public void insert(int value) {
        //create a node
        Node n = new Node(value);
        //if the head doesnt exist then assign the ndoe to head

        if(head == null) {
            head =n;
            values.add(head.data);
        } else {
            if(value <= head.data) {
                if(head.left == null) {
                    head.left = n;
                    values.add(head.left.data);
                } else {
                    head = head.left;
                    insert(head.data);
                }
            } else {
                if(head.right == null) {
                    head.right = n;
                    values.add(head.right.data);
                } else {
                    head = head.right;
                    insert(head.data);
                }
            }
        }
        // if head exist
            // check the value is less than or equal to head
                //check if left node exists
            // if greter than
                // check if right node exist
        // inc the length
        length++;
    }

    public void printNodes() {

        if(length > 0) {
            for(int i: values) {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(10);
        bst.insert(5);
//        bst.insert(12);
//        bst.insert(18);
//        bst.insert(15);
        System.out.println(bst.length);
        bst.printNodes();

    }


}
