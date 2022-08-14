package _20220814_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Node> table;
    private Node head;
    private Node tail;
    private int size;
    private final int capacity;

    public LRUCache(int capacity) {
        this.table = new HashMap<>(capacity);
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (table.containsKey(key)) {
            Node node = table.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (table.containsKey(key)) {
            Node node = table.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }

        if (size == capacity) {
            // remove from table
            table.remove(tail.key);
            if (capacity == 1) {
                tail = null;
                head = null;
            } else {
                // remove tail
                tail = tail.prev;
                tail.next = null;
            }
        }

        Node node = new Node(key, value);
        table.put(key, node);
        insertHead(node);

        if (size < capacity) {
            size += 1;
        }
    }

    private void insertHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            replaceHead(node);
        }
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }

        if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        replaceHead(node);
    }

    private void replaceHead(Node node) {
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

}
