package Problems;

public class SwapNodes {

    public static Node swapNodes(Node n) {
        Node cur = n;
        while(cur != null) {
            Node nxt = cur.next;
            if(nxt != null) {
                Node temp = nxt.next;
                nxt.next = cur.next;
                cur.next = temp;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);

        Node res = swapNodes(n);
        while(res!=null) {
            System.out.println(res.data);
            res = res.next;
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
        next = null;
    }


}
