package binarysearchtree;

/**
 * Created by marty on 3/07/2017.
 */
public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    /**
     * Adds data to tree. If root is null, create new node, else call node's put method to recursively find correct
     * place to add node.
     * @param data the int to add
     */
    public synchronized void put(int data) {
        if(root == null) {
            root = new Node(data);
        } else {
            traversePut(data, root);
        }
    }

    /**
     * Adds node to tree. If data less than this.data, add as new left node if null, else recursively call until next
     * left null is found. If data is greater than this.data, do the same but for right node.
     * @param data the data to add
     * @param node the node to start at, start with root
     */
    public synchronized void traversePut(int data, Node node) {
        if(node == null) {
            node = new Node(data);
            return;
        } else {
            if(data < node.data()) {
                if(node.left() == null) {
                    node.setLeft(new Node(data));
                } else {
                    traversePut(data, node.left());
                }
            } else {
                if(node.right() == null) {
                    node.setRight(new Node(data));
                } else {
                    traversePut(data, node.right());
                }
            }
        }
    }

    /**
     * Public interface for Tree#get(). Recursively calls Tree#traverseGet() to find target int.
     * @param target the int to find
     * @return the node containing the target
     */
    public synchronized Node get(int target) {
        return traverseGet(target, root);
    }

    /**
     * Recursively called to find int target. If target less than node value, move to left node, else move to right.
     * @param target the int to find
     * @param node the node to start the search, start at root
     * @return the node containing data that matches target
     */
    private synchronized Node traverseGet(int target, Node node) {
        if(node == null) {
            return null;
        }
        if(target == node.data()) {
            return node;
        }
        Node left = traverseGet(target, node.left());
        Node right = traverseGet(target, node.right());
        if(left != null) {
            return left;
        }
        return right;
    }

    /**
     * Traverse tree preorder. Calls traversePreOrder recursively.
     * @return the string representing the preorder traversal
     */
    public synchronized String preOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRE-ORDER:\n");
        return traversePreOrder(root, sb).toString();
    }

    /**
     * Traverse tree preorder. Recursively traverses via: visit node, left node, right node.
     * @param node the node to start the traversal, start at root
     * @param sb the stringbuilder to append the traversal string to
     * @return the string representing the preorder traversal
     */
    private synchronized StringBuilder traversePreOrder(Node node, StringBuilder sb) {
        if(node == null) {
            return null;
        }
        sb.append(Integer.toString(node.data())).append(" ");
        traversePreOrder(node.left(), sb);
        traversePreOrder(node.right(), sb);
        return sb;
    }

    /**
     * Traverse tree inorder. Calls traverseInOrder recursively.
     * @return the string representing the inorder traversal
     */
    public synchronized String inOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("IN-ORDER:\n");
        return traverseInOrder(root, sb).toString();
    }

    /**
     * Traverse tree inorder. Recursively traverses via: left node, visit node, right node.
     * @param node the node to start the traversal, start at root
     * @param sb the stringbuilder to append the traversal string to
     * @return the string representing the inorder traversal
     */
    private synchronized StringBuilder traverseInOrder(Node node, StringBuilder sb) {
        if(node == null) {
            return null;
        }
        traverseInOrder(node.left(), sb);
        sb.append(Integer.toString(node.data())).append(" ");
        traverseInOrder(node.right(), sb);
        return sb;
    }

    /**
     * Traverse tree postorder. Calls traversePostOrder recursively.
     * @return the string representing the inorder traversal
     */
    public synchronized String postOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("POST-ORDER:\n");
        return traversePostOrder(root, sb).toString();
    }

    /**
     * Traverse tree postorder. Recursively traverses via: left node, right node, visit node.
     * @param node the node to start the traversal, start at root
     * @param sb the stringbuilder to append the traversal string to
     * @return the string representing the postorder traversal
     */
    private synchronized StringBuilder traversePostOrder(Node node, StringBuilder sb) {
        if(node == null) {
            return null;
        }
        traversePostOrder(node.left(), sb);
        traversePostOrder(node.right(), sb);
        sb.append(Integer.toString(node.data())).append(" ");
        return sb;
    }
}
