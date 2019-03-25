package codecool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CustomHashMap<K, V> {

    private class MapNode<K, V> {

        public K key;
        public V value;
        public MapNode<K, V> next;
        public MapNode<K, V> prev;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public MapNode(K key, V value, MapNode<K, V> next) {
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

        public MapNode<K, V> getNext() {
            return next;
        }

        public void setNext(MapNode<K, V> next) {
            this.next = next;
        }

        public MapNode<K, V> getPrev() {
            return prev;
        }

        public void setPrev(MapNode<K, V> prev) {
            this.prev = prev;
        }
    }

    private MapNode<K, V>[] elements;
    private int size;

    private MapNode<K, V> head;
    private MapNode<K, V> tail;

    public CustomHashMap(int size) {
        this.elements = new MapNode[size];
    }

//    public CustomHashMap() {
//        this.size = 0;
//        this.elements = new MapNode[size];
//    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        MapNode<K, V> mapNode = new MapNode<K, V>(key, value);
        int hashKey = getHashCode(key);

        if (elements[hashKey] != null) {
            MapNode<K, V> existing = elements[hashKey];
            existing.setNext(mapNode);
        } else {
            elements[hashKey] = mapNode;
        }
        this.size++;
    }

    public V getValue(K key) {
        int hashKey = getHashCode(key);
        if(elements[hashKey] == null) {
            throw new NoSuchElementException("Element not found");
        }

        MapNode<K, V> currentNode = elements[hashKey];
        MapNode<K, V> end = currentNode;

        if(currentNode.getKey().equals(key)) {
            return currentNode.getValue();
        }

        while(end.getNext() != null && end.getNext().getKey().equals(key)) {
            end = end.getNext();
        }

        if(end.getKey().equals(key)) {
            return end.getValue();
        }
        throw new NoSuchElementException("Element not found");
    }

    public boolean remove(K key) {
        int hashKey = getHashCode(key);
        if(elements[hashKey] == null) {
            throw new NoSuchElementException("Element not found");
        }


        MapNode<K,V> previous = null;
        MapNode<K,V> current = elements[hashKey];

        while(current != null){
            if(current.key.equals(key)){
                if(previous==null){  //delete first entry node.
                    elements[hashKey]=elements[hashKey].next;
                    return true;
                }
                else{
                    previous.next=current.next;
                    return true;
                }
            }
            previous=current;
            current = current.next;
        }
        this.size--;
        return false;
    }

    public void clearAll() {
        this.elements = new MapNode[this.size];
        this.size = 0;
    }

    public int getHashCode(K key) {
        int hashValue = key.hashCode();
        hashValue %= elements.length;

        if(hashValue < 0) {
            hashValue += elements.length;
        }
        return hashValue;
    }

}
