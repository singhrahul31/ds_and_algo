package Heap;

public class SortUsingNode {
    ListNode head;
    public ListNode sortList(ListNode head) {
        createHeap(head);
        return head;
    }

    private void createHeap(ListNode head) {
        if(head == null) {
            return;
        }
        if(head.next != null) {
            if(head.val > head.next.val) {
                swap(head);
            } else createHeap(head.next);
        }
    }

    private void swap(ListNode root) {
        ListNode temp = root.next;
        root.next.val = root.val;
        root.val = temp.val;

    }

    public static void main(String[] args) {
        SortUsingNode sn = new SortUsingNode();
        sn.head = new ListNode(4);
        sn.head.next = new ListNode(2);
        sn.head.next.next = new ListNode(1);
        sn.head.next.next.next = new ListNode(3);

        ListNode n = sn.sortList(sn.head);
        ListNode cur = n;
        while(cur != null) {
            System.out.print(cur.val +" ");
            cur = cur.next;
        }

    }
}


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
