package LinkedListImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        MyLinkedList list = new MyLinkedList();
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        System.out.println(list.pop());
        System.out.println(list.printList());
        //list.pop();
       // list.printList();
    }
}
