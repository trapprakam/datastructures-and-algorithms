package main.java.datastructures.trees;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            // Empty tree
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.getData()) {
            node.setLeftChild(delete(node.getLeftChild(), value));
        } else if (value > node.getData()) {
            node.setRightChild(delete(node.getRightChild(), value));
        } else {
            // Node to delete have 0 or 1 child
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // Node to delete have 2 children
            // Replace the value to be deleted with the min value from the right
            // subtree
            node.setData(node.getRightChild().getMin());
            // Delete the node that have the smallest value in the right subtree, since its value was moved
            // and this node is no longer needed.
            node.setRightChild(delete(node.getRightChild(), node.getData()));

        }
        return node;
    }

    public TreeNode get(int value) {
        if (root == null) {
            return null;
        } else {
            return root.get(value);
        }
    }

    public int getMin() {
        if (root == null) {
            return 0x80000000;
        } else {
            return root.getMin();
        }
    }

    public int getMax() {
        if (root == null) {
            return 0x7fffffff;
        } else {
            return root.getMax();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            System.out.print("Traversing the binary tree with a InOrder Traversal: ");
            root.traverseInOrder();
        }
    }

    public void traverseLevel() {
        if (root != null) {
            System.out.print("Traversing the binary tree with a Level Traversal: " + root.getData() + ", ");
            root.traverseLevel();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            System.out.print("Traversing the binary tree with a PreOrder Traversal: ");
            root.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            System.out.print("Traversing the binary tree with a PostOrder Traversal: ");
            root.traversePostOrder();
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}
