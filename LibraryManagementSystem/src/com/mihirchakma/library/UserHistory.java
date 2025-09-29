package com.mihirchakma.library;

// 4. User History (Singly Linked List)

public class UserHistory {
    private static class Node {
        String isbn;
        Node next;
        Node(String isbn) { this.isbn = isbn; }
    }

    private Node head;

    // Add to history (push front)
    public void add(String isbn) {
        Node node = new Node(isbn);
        node.next = head;
        head = node;
    }

    // Remove from history (delete first match)
    public void remove(String isbn) {
        Node dummy = new Node("");
        dummy.next = head;
        Node prev = dummy;
        while (prev.next != null) {
            if (prev.next.isbn.equals(isbn)) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
        head = dummy.next;
    }

    // Display history
    public void display() {
        Node curr = head;
        System.out.print("History: ");
        while (curr != null) {
            System.out.print(curr.isbn + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
