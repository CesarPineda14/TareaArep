package org.escuelaIng;
import java.awt.*;
import java.util.Queue;
import java.util.LinkedList;
public class BinarySearchTree <T extends Comparable<T>> extends List {
    private class Node {
        T key;
        Node left, right;

        public Node(T item) {
            key = item;
            left = right = null;
        }
    }
    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    public void insert(T key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, T key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }


    public boolean search(T key) {
        return searchRec(root, key) != null;
    }

    private Node searchRec(Node root, T key) {
        if (root == null || root.key.equals(key)) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void delete(T key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, T key) {
        if (root == null) {
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = findMinRec(root.right).key;
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrderTraversal() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }


    public void postOrderTraversal() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    public T findMin() {
        return findMinRec(root).key;
    }

    private Node findMinRec(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    public T findMax() {
        return findMaxRec(root).key;
    }

    private Node findMaxRec(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }



    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalancedRec(root.left) && isBalancedRec(root.right);
    }

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.key + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }



    public void clear() {
        root = null;
    }


    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }








}
