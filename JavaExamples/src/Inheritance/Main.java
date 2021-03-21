package Inheritance;

public class Main {

    public static void main(String[] args) {
        B bObj = new B();
        bObj.someAMethod();
        A aObj = new A();
        aObj.someAMethod();

        A inheritObj = new B();
        inheritObj.someAMethod();
    }
}
