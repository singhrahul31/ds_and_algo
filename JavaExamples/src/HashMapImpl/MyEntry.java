package HashMapImpl;

public class MyEntry<K, V> {
    private K key;
    private V value;

    MyEntry(K k, V v) {
        this.key = k;
        this.value=v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;

        if (!key.equals(myEntry.key)) return false;
        return value != null ? value.equals(myEntry.value) : myEntry.value == null;
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
