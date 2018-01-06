package dataStructures.classes;

import java.util.HashMap;

public class MyLinkedHashMap<K, V> {

    class Node {
        Pair<K, V> pair;
        Node next;
        Node previous;

        Node(Node sentinel) {
            next = sentinel;
            previous = sentinel;
        }

        Node(Node sentinel, K key, V value) {
           this(sentinel);
           this.pair = new Pair<K, V>(key, value);
        }

        public Node() { }

        public Node(K key, V value) {
            pair = new Pair<K, V>(key, value);
        }

        @Override
        public String toString() {
            return (String)pair.getKey();
        }
    }

    private Node gate;
    private HashMap<K, Node> keyToNode = new HashMap<K, Node>();
    private int _size;

    public MyLinkedHashMap() {
        gate = new Node();

        //FIXME DEBUG
        gate.pair = new Pair("?GATE?", "?GATE?");
        //FIXME DEBUG

        gate.next = gate;
        gate.previous = gate;
        //TODO let just one node out of root end and sentinel
    }

    Node root() {
        return gate.next;
    }

    Node setRoot(Node node) {
        gate.next = node;
        return node;
    }

    Node end() {
        return gate.previous;
    }

    Node setEnd(Node node) {
        gate.previous = node;
        return node;
    }

    public V remove(K key) {
        Node node = keyToNode.get(key);
        V value = null;
        if (node != null) {
            _size--;
            node.next.previous = node.previous;
            node.previous.next = node.next;
            value = node.pair.getValue();
        }
        keyToNode.remove(key);
        return value;
    }

    public void insertInRoot(K key, V value) {
        Node node;
        if(keyToNode.containsKey(key)) {
            node = keyToNode.get(key);
            node.pair.setValue(value);
            node.previous = gate;
            node.next.previous = node.previous;
            node.previous.next = node.next;
            keyToNode.put(key, node);
        } else {
            _size++;
            node = new Node(key, value);
            keyToNode.put(key, node);
        }
        node.next = root();
        root().previous = node;
        node.previous = gate;
        setRoot(node);
    }

    public int size() {
        return _size;
    }

    public Pair<K, V> getLast() {
        return end().pair;
    }

    public V get(K key) {
        return keyToNode.get(key).pair.getValue();
    }

    public boolean contains(K key) {
        return keyToNode.containsKey(key);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clearAll() {
        Node node = root();
        Node aux;
        while (node != gate) {
            aux = node;
            node = aux.next;
            aux.pair = null;
            aux.previous = null;
            aux.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringB = new StringBuilder();
        for (Node node = root(); node != gate; node = node.next) {
            stringB.append(node.pair.getKey() + " ");
        }
        return stringB.toString();
    }
}
