package linkedlist;

/**
 * Created by poncem on 13/7/17.
 */
public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertHead(String data) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    public void insertTail(String data) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        Node current = head;
        Node previous = null;
        while(current != null) {
            previous = current;
            current = current.next;
        }
        previous.next = node;
        size++;
    }

    public void insertAfter(String data, String target) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        for(Node current = head; current != null; current = current.next) {
            if(current.data.equals(target)) {
                node.next = current.next.next;
                current.next = node;
                return;
            }
        }
        // didn't find target
    }

    public String deleteHead() {
        if(isEmpty()) {
            return null;
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public String deleteTail() {
        return null;
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