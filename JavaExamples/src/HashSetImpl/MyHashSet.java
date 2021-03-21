package HashSetImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyHashSet<T> {
    private int size;
    Map<T, Object> map;
    Object obj;

    MyHashSet() {
        map = new HashMap<>();
    }

    public boolean add(T value) {
        if(!map.containsKey(value)) {
            map.put(value, new Object());
            size++;
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        return map.containsKey(value);
    }

    public boolean isEmpty() {
        if(map.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean remove(T value) {
        if(map.containsKey(value)) {
            map.remove(value);
            size--;
            return true;
        }
        return false;
    }

    public void printList() {
        if(map != null) {
            Iterator<T> interator = map.keySet().iterator();
            while(interator.hasNext()) {
                System.out.println(interator.next());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyHashSet<?> myHashSet = (MyHashSet<?>) o;

        if (size != myHashSet.size) return false;
        if (map != null ? !map.equals(myHashSet.map) : myHashSet.map != null) return false;
        return obj != null ? obj.equals(myHashSet.obj) : myHashSet.obj == null;
    }


}
