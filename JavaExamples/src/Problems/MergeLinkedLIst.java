package Problems;

import Problems.HelperClasses.Node;

import java.util.List;

public class MergeLinkedLIst {

    public Node mergeResult(Node node1, Node node2) {
        return sort(node1, node2);
    }

    private Node sort(Node a, Node b) {

        if (a == null && b == null) return null;

        Node res = null;
        while (a != null & b != null) {
            if (a.data < b.data) {
                Node temp = a.next;
//                a.next = res;
//                res = a;
                a.next = null;
                createResultNode(a, res);
                a = temp;
            } else {
                Node temp = b.next;
//                b.next = res;
//                res = b;
                createResultNode(b, res);
                b = temp;
            }
        }
        while (a != null) {
            Node temp = a.next;
//            a.next = res;
//            res = a;
            createResultNode(a, res);
            a = temp;
        }
        while (b !=null) {
            Node temp = b.next;
//            b.next = res;
//            res = b;
            createResultNode(b, res);
            b = temp;
        }

        return res;
    }

    private static void swap(Node n, Node res) {
        Node temp = n.next;
        n.next = res;
        res = n;
        n = temp;
       // return res;
    }

    private static void createResultNode(Node toBeAdded, Node res) {
        if(res == null) {
            res = new Node(toBeAdded.data);
        } else {
            Node temp = res;
            while(temp != null) temp = temp.next;
            temp.next = toBeAdded;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        //Node root1 = new Node(5);
        root1.next = new Node(10);
        root1.next.next = new Node(15);

        Node root2 = new Node(2);
        root2.next = new Node(3);
        root2.next.next = new Node(20);
        MergeLinkedLIst m = new MergeLinkedLIst();
        Node result = m.mergeResult(root1, root2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }
}


