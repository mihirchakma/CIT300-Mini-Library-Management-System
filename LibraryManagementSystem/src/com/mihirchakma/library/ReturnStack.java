package com.mihirchakma.library;

import java.util.EmptyStackException;

// 3. Return Stack

public class ReturnStack {
    private static class Node {
        String isbn;
        Node next;
        Node(String isbn) { this.isbn = isbn; }
    }

    private Node top;

    public void push(String isbn) {
        Node node = new Node(isbn);
        node.next = top;
        top = node;
    }

    public String pop() {
        if (top == null) throw new EmptyStackException();
        String isbn = top.isbn;
        top = top.next;
        return isbn;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
