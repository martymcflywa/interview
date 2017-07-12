package practice;

/**
 * Created by poncem on 12/7/17.
 */
public class Queue {

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public String peek() {
        if(isEmpty()) {
            return null;
        }
        return head.data;
    }

    public void add(String data) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = node;
        }
        if(tail != null) {
            tail.next = node;
        }
        tail = node;
    }

    public String remove() {
        if(isEmpty()) {
            return null;
        }
        String data = peek();
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return data;
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
