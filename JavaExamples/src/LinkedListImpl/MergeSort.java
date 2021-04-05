package LinkedListImpl;

public class MergeSort {
    Node root;
    static Node mergeSort(Node root) {

        if(root == null || root.next == null) return root;

        Node preNode = null, start=root, end=root;
        while(end != null && end.next != null) {
            preNode = start;
            start = start.next;
            end = end.next.next;
        }
        preNode.next = null;

        return merge(mergeSort(root), mergeSort(start));

    }

    static Node merge(Node a, Node b) {

        Node result = new Node(0);
        Node head = result;
        while(a!=null && b != null) {
            if(a.val < b.val) {
                head.next = a;
                a = a.next;
            } else {
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }
        while(a!=null) {
            head.next = a;
            a = a.next;
            head = head.next;
        }
        while(b!=null) {
            head.next = b;
            b = b.next;
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.root = new Node(9);
        ms.root.next = new Node(5);
        ms.root.next.next = new Node(10);
        ms.root.next.next.next = new Node(2);
        ms.root.next.next.next.next = new Node(15);
        ms.root.next.next.next.next.next = new Node(8);

        Node result = mergeSort(ms.root);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}

class Node {
    int val;
    Node next;
     Node(int d) {
         val=d;
     }
}
