package stack;

/**
 * Created by poncem on 10/7/17.
 */
public class Stack {

    private Node top;

    public Stack() {
        top = null;
    }

    /**
     * Returns true if stack is empty.
     *
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * If the stack is not empty, returns the data at the top of the stack, else returns null.
     *
     * @return the data at the top of the stack if the stack is not empty, else return null.
     */
    public String peek() {
        if(!isEmpty()) {
            return top.data;
        }
        return null;
    }

    /**
     * Add data to the top of the stack. Create a new node, set its next to top then set top to node.
     *
     * @param data the data to add.
     */
    public void push(String data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    /**
     * If the stack is not empty, remove the data at the top of the stack, and return the value. If the stack is empty,
     * return null.
     *
     * @return data at the top of the stack if the stack is not empty, else return null.
     */
    public String pop() {
        if(!isEmpty()) {
            String output = top.data;
            top = top.next;
            return output;
        }
        return null;
    }

    private class Node {

        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }
    }
}
