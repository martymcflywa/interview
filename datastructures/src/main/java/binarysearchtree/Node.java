package binarysearchtree;

/**
 * Created by marty on 3/07/2017.
 */
public class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public synchronized void setLeft(Node left) {
        this.left = left;
    }

    public synchronized void setRight(Node right) {
        this.right = right;
    }

    public synchronized Node left() {
        return left;
    }

    public synchronized Node right() {
        return right;
    }

    public synchronized int data() {
        return data;
    }
}
