package HashMapImpl;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, Integer> empRoll = new MyHashMap<>();
        empRoll.add("Rahul", 1232423);
        empRoll.add("Swati", 234);
        empRoll.add("Sanjay", 5567);
        empRoll.add("Rahul S", 4234532);
        empRoll.add("Abhishek", 8768);
        empRoll.add("Rahul", 2342);

        System.out.println(empRoll.getSize());
        empRoll.printList();
        empRoll.remove("Sanjay");
        System.out.println("******* After delete *********");
        empRoll.printList();
        System.out.println(empRoll.containsKey("Rahul M"));
        empRoll.add("Swati", 123);
        empRoll.printList();
    }
}
