package LinkedListImpl;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    int length;
    Node head;
    Node tail;

    public MyLinkedList() {
        this.length =0;
    }

    class Node {
        int val;
        Node next;

        Node(int value) {
            this.val = value;
            this.next = null;
        }
    }

    public void push(int value) {
        Node n = new Node(value);
        this.length++;
        if(this.head == null) {
            this.head = n;
            this.tail = n;
        } else {
            this.tail.next = n;
            this.tail = n;
        }
    }

    public Node pop() {
        Node deletedNode =null;
        if(this.length > 0) {
            if(this.length == 1) {
                deletedNode= this.head;
            } else {
                Node current = this.head;
                Node prevNode = this.head;
                while(current != this.tail) {
                    prevNode = current;
                    current = current.next;
                }
                prevNode.next = null;
                deletedNode = this.tail;
                this.tail = prevNode;

            }
        }
        this.length--;
        return deletedNode;
    }

    public List<Integer> printList() {
        List<Integer> list = new ArrayList<>();
        if(this.length > 0) {
            Node current = this.head;
            while(current != null) {
                list.add((current.val));
                current = current.next;
            }
        }
        return list;
    }

    public int size() {
        return this.length;
    }
}
