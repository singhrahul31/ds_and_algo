package LinkedListImpl;

public class MergeSort {
    Node head;
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.head = new Node(4);
        ms.head.next = new Node(2);
        ms.head.next.next = new Node(1);
        ms.head.next.next.next = new Node(3);
        Node result = mergeSort(ms.head);
        while(result != null) {
            System.out.print(result.val+ " ");
            result = result.next;
        }
    }

    private static Node mergeSort(Node head) {
        if(head==null || head.next==null) return head;
        Node prevNode=null, start = head, end=head;
        while(end !=null && end.next !=null) {
            prevNode = start;
            start = start.next;
            end = end.next.next;
        }
        prevNode.next = null;

        return merge(mergeSort(head), mergeSort(start));

    }

    private static Node merge(Node a, Node b) {
        Node result = new Node(0);
        Node root = result;
        while(a!= null && b!=null) {
            if(a.val < b.val) {
                root.next = a;
                a=a.next;
            }
            else {
                root.next = b;
                b=b.next;
            }
            root = root.next;
        }
        while(a!=null) {
            root.next = a;
            root = root.next;
        }
        while(b!=null) {
            root.next = b;
            root = root.next;
        }

        return result.next;
    }


}


class Node {
    int val;
    Node next;

    Node(int v) {
        val=v;
    }
}
