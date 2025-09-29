package com.mihirchakma.library;

// 1. Book Inventory (Binary Search Tree)

public class BookInventoryBST {
    private class Node {
        Book book;
        Node left, right;
        Node(Book b) { book = b; }
    }

    private Node root;

    // Insert a new book by ISBN key
    public void insert(Book b) {
        root = insertRec(root, b);
    }

    private Node insertRec(Node node, Book b) {
        if (node == null) return new Node(b);
        if (b.getIsbn().compareTo(node.book.getIsbn()) < 0)
            node.left = insertRec(node.left, b);
        else if (b.getIsbn().compareTo(node.book.getIsbn()) > 0)
            node.right = insertRec(node.right, b);
        return node;
    }

    // Delete a book by ISBN
    public void delete(String isbn) {
        root = deleteRec(root, isbn);
    }

    private Node deleteRec(Node node, String isbn) {
        if (node == null) return null;
        if (isbn.compareTo(node.book.getIsbn()) < 0)
            node.left = deleteRec(node.left, isbn);
        else if (isbn.compareTo(node.book.getIsbn()) > 0)
            node.right = deleteRec(node.right, isbn);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = findMin(node.right);
            node.book = successor.book;
            node.right = deleteRec(node.right, successor.book.getIsbn());
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node node) {
        if (node == null) return;
        inorderRec(node.left);
        System.out.println(node.book);
        inorderRec(node.right);
    }
}
