package com.mihirchakma.library;

// 2. Borrow Request Queue (2)

public class BorrowRequestQueue {
    private static class Node {
        BorrowRequest request;
        Node next;
        Node(BorrowRequest r) { request = r; }
    }

    private Node front, rear;

    public void enqueue(BorrowRequest r) {
        Node node = new Node(r);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = node;
    }

    public BorrowRequest dequeue() {
        if (front == null) return null;
        BorrowRequest r = front.request;
        front = front.next;
        if (front == null) rear = null;
        return r;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
