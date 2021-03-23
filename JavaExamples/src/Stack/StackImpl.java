package Stack;


import java.util.ArrayList;
import java.util.List;

// it is a LIFO data structure
public class StackImpl<T> {

    List<T> list;
    int length;
    public StackImpl() {
        list = new ArrayList<>();
        length = 0;
    }

    // adding the value at the top of the stack
    public void push(T value) {
        list.add(value);
        length++;
    }

    //removing the value from the top of the stack
    public T pop() {
        length--;
        return list.remove(list.size()-1);
    }

    // display the item at the top of the stack
    public void peek() {
        System.out.println(list.get(length-1));
    }

    public void printStack() {
        for(T val: list) {
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        StackImpl<Integer> st = new StackImpl<>();
        st.push(23);
        st.push(12);
        st.push(98);
        st.push(49);
        st.push(38);
        st.push(56);

        st.printStack();
        st.pop();
        System.out.println("*****");
        st.printStack();
        st.pop();
        st.pop();
        System.out.println("****");
        st.peek();
        System.out.println("****");
        st.printStack();
    }


}
