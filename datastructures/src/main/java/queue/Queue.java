package queue;

/**
 * Created by poncem on 10/7/17.
 */
public class Queue {

    private Node head; // remove from head
    private Node tail; // add to tail

    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Returns true if queue is empty.
     *
     * @return true if queue is empty.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * If queue is not empty, return the String first in queue, else if queue is empty, return null.
     *
     * @return the String first in queue, else if queue is empty, return null.
     */
    public String peek() {
        if(isEmpty()) {
            return null;
        }
        return head.data;
    }

    /**
     * Add new String to the queue at the end of the queue.
     *
     * @param data the String to add at the end of the queue.
     */
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

    /**
     * If queue is not empty, remove the String first in queue by moving the second element up to the first position
     * then return the value of the String being removed. Else if queue is empty, return null.
     *
     * @return the String being removed if the queue is not empty, else return null;
     */
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
