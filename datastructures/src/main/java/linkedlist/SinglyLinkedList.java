package linkedlist;

/**
 * Created by poncem on 13/7/17.
 */
public class SinglyLinkedList {

    private Node root;
    private int size;

    public SinglyLinkedList() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    /**
     * Public interface for insertFirst. Calls recursive insertFirst.
     * @param data the data to insert to the list, at the start of the list.
     */
    public void insertFirst(String data) {
        root = insertFirst(data, root);
        size++;
    }

    private Node insertFirst(String data, Node node) {
        if(isEmpty()) {
            return new Node(data);
        }
        Node insertFirst = new Node(data);
        insertFirst.next = node;
        return insertFirst;
    }

    /**
     * Public interface for insertLast. Calls recursive insertLast.
     * @param data the data to insert to the list, at the end of the list.
     */
    public void insertLast(String data) {
        root = insertLast(data, root);
        size++;
    }

    private Node insertLast(String data, Node node) {
        if(isEmpty()) {
            return new Node(data);
        }
        if(node == null) {
            node = new Node(data);
        } else {
            node.next = insertLast(data, node.next);
        }
        return node;
    }

    /**
     * Public interface for insertOrdered. Calls recursive insertOrdered.
     * @param data the data to insert to the list, in ordered fashion
     */
    public void insertOrdered(String data) {
        root = insertOrdered(data, root);
        size++;
    }

    private Node insertOrdered(String data, Node node) {
        if(isEmpty()) {
            node = new Node(data);
        } else if(node == null || data.compareTo(node.data) < 0) {
            Node insertBefore = new Node(data);
            insertBefore.next = node;
            node = insertBefore;
        } else {
            node.next = insertOrdered(data, node.next);
        }
        return node;
    }

    /**
     * Public interface for remove. Calls recursive remove.
     * @param data the data to remove, will remove the first instance.
     */
    public void remove(String data) {
        root = remove(data, root);
    }

    private Node remove(String data, Node node) {
        if(isEmpty()) {
            return node;
        }
        if(node != null) {
            if(data.equals(node.data)) {
                node = node.next;
            } else {
                node.next = remove(data, node.next);
            }
        }
        return node;
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if(isEmpty()) {
            return null;
        }
        if(node == null) {
            return "";
        } else {
            return node.data + " " + toString(node.next);
        }
    }

    private class Node {

        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            next = null;
        }
    }
}