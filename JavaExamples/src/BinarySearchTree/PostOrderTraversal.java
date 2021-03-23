package BinarySearchTree;

import java.util.*;

public class PostOrderTraversal {

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

     List<Integer> postOrderTraversal() {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        } else {
            Stack<Node> stack = new Stack();
            Stack<Node> mainStack = new Stack();
            Node current = root;
            stack.push(current);
            while(!stack.empty()) {
                Node temp = stack.pop();
                mainStack.push(temp);

                if(temp.left != null) stack.push(temp.left);
                if(temp.right != null) stack.push(temp.right);
            }
            while(!mainStack.empty()) {
                list.add(mainStack.pop().data);
            }
        }
        return list;
    }
    int getSize() {
        return length;
    }

    public static void main(String[] args) {
        PostOrderTraversal bst = new PostOrderTraversal();
        bst.insert(8);
        bst.insert(10);
        bst.insert(5);
        bst.insert(12);
        bst.insert(18);
        bst.insert(15);
        System.out.println(bst.getSize());
        List<Integer> list = bst.postOrderTraversal();
        for(Integer i: list) {
            System.out.println(i);
        }

    }


}
