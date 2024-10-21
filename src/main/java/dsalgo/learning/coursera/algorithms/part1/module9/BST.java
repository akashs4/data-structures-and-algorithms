package dsalgo.learning.coursera.algorithms.part1.module9;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    /**
     * Iterative version
     * Number of compares: 1 + depth of node position
     */
    public Value get(Key key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }
        return null;
    }

    public Value recursiveGet(Key key) {
        Node searchResult = recursiveGet(root, key);
        return searchResult == null ? null : searchResult.val;
    }

    private Node recursiveGet(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return recursiveGet(node.left, key);
        else if (cmp > 0)
            return recursiveGet(node.right, key);
        else return node;
    }

    public void put(Key key, Value val) {
        this.root = putHelper(this.root, key, val);
    }

    /**
     * put 5
     *              7
     *           4      10
     *
     * Number of compares: 1 + depth of node position
     * */
    private Node putHelper(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return putHelper(node.left, key, val);
        else if (cmp > 0)
            return putHelper(node.right, key, val);
        else
            node.val = val;
        return node;
    }

    /**
     * If node found : remove the link
     * If node not found : nothing to do
     * */
    public void delete(Key key) {

    }

    public Iterable<Key> iterator() {
        return null;
    }

    private class Node {
        Key key;
        Value val;
        Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}
