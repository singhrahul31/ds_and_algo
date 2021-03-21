package HashMapImpl;

import java.util.LinkedList;
import java.util.List;

public class MyBucket {

    List<MyEntry> bucket;

    MyBucket() {
        bucket = new LinkedList<>();
    }

    public List<MyEntry> getEntries() {
        return bucket;
    }

    public void addEntry(MyEntry e) {
        bucket.add(e);
    }

    public void removeEntry(MyEntry e) {
        bucket.remove(e);
    }
}
