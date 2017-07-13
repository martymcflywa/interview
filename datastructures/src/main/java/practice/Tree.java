package practice;

/**
 * Created by poncem on 13/7/17.
 */
public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(String data) {
        root = insert(data, root);
    }

    private Node insert(String data, Node node) {
        if(node == null) {
            node = new Node(data);
        } else if(data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        } else if(data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
        }
        return node;
    }

    public String find(String data) {
        return dataAt(find(data, root));
    }

    private Node find(String data, Node node) {
        if(node == null) {
            return null;
        }
        if(data.compareTo(node.data) < 0) {
            return find(data, node.left);
        } else if(data.compareTo(node.data) > 0) {
            return find(data, node.right);
        } else {
            return node;
        }
    }

    public void remove(String data) {
        root = remove(data, root);
    }

    private Node remove(String data, Node node) {
        if(node == null) {
            return null;
        }
        if(data.compareTo(node.data) < 0) {
            node.left = remove(data, node.left);
        } else if(data.compareTo(node.data) > 0) {
            node.right = remove(data, node.right);
        } else if(node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        } else {
            node = node.left;
            if(node != null) {
                node = node.right;
            }
        }
        return node;
    }

    public String findMin() {
        return dataAt(findMin(root));
    }

    private Node findMin(Node node) {
        if(node == null) {
            return null;
        } else if(node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public String findMax() {
        return dataAt(findMax(root));
    }

    private Node findMax(Node node) {
        if(node == null) {
            return null;
        } else if(node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    private String dataAt(Node node) {
        if(node == null) {
            return null;
        }
        return node.data;
    }

    private class Node {

        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
