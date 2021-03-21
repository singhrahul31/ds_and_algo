package HashMapImpl;

import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> {

    int capacity =10;
    MyBucket[] buckets;
    private int size;

    MyHashMap() {
        buckets = new MyBucket[capacity];
        size=0;
    }

    public void add(K k, V v) {
        if(containsKey(k)) {
            MyEntry entry = getEntry(k);
            entry.setValue(v);
        } else {
            MyEntry entry = new MyEntry(k, v);
            int hash = getHash(k);
            buckets[hash] = new MyBucket();
//            bucket.addEntry(entry);
            buckets[hash].addEntry(entry);
            size++;
        }

    }

    public void remove(K k) {
        if(containsKey(k)) {
            MyEntry entry = getEntry(k);
            int hash = getHash(k);
            buckets[hash].removeEntry(entry);
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean containsKey(K k) {
        int hashVal = getHash(k);
        return !Objects.isNull(buckets[hashVal]);
    }

    public void printList() {
        int bucketLength = getSize();
        if(bucketLength > 0) {
            for(MyBucket bucket: buckets) {
                if(bucket != null) {
                    for(MyEntry entry: bucket.getEntries()) {
                        System.out.println(entry);
                    }
                }
            }
        }
    }

    private int getHash(K k) {
        return Math.abs((31 * k.hashCode()) % capacity);
    }

    private MyEntry getEntry(K k) {
        int hashVal = getHash(k);

        List<MyEntry> list = buckets[hashVal].getEntries();
        for(MyEntry entry: list) {
            if(entry.getKey() == k) {
                return entry;
            }
        }
        return null;
    }
}
