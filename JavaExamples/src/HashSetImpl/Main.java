package HashSetImpl;

public class Main {
    public static void main(String[] args) {
        MyHashSet<String> names = new MyHashSet<>();
        names.add("Rahul");
        names.add("Swati");
        names.add("Swati M");
        names.add("Swati S");
        names.add("Swati M");
        names.add("Rahul");
        names.add("Rahul Singh");
        names.remove("Swati M");
        System.out.println(names.size());
        names.printList();
    }
}
