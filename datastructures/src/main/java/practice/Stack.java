package practice;

/**
 * Created by poncem on 12/7/17.
 */
public class Stack {

    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String peek() {
        if(isEmpty()) {
            return null;
        }
        return top.data;
    }

    public void push(String data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public String pop() {
        if(isEmpty()) {
            return null;
        }
        String data = peek();
        top = top.next;
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
