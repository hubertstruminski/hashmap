package codecool;

import java.util.LinkedList;

public class CustomHashMap<K, V> {

    private class KeyValue<K, V> {

        public K key;
        public V value;
        public KeyValue<K, V> next;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public KeyValue(K key, V value, KeyValue<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
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

        public KeyValue<K, V> getNext() {
            return next;
        }

        public void setNext(KeyValue<K, V> next) {
            this.next = next;
        }
    }

    private LinkedList<KeyValue>[] elements = new LinkedList[0];
    private int size = 0;
    private KeyValue<K, V>[] bucket;

    public CustomHashMap() {
        this.elements = new LinkedList[size];
        this.size = 0;
    }

    public void add(K key, V value) {
        KeyValue<K, V> keyValue = new KeyValue<K, V>(key, value);

        int hashKey = getHashCode(key);

    }

    public int getHashCode(K key) {
        int hashValue = key.hashCode();
        hashValue %= bucket.length;

        if(hashValue < 0) {
            hashValue += bucket.length;
        }
        return hashValue;
    }
}
