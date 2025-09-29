package com.mihirchakma.library;

// Main Application

public class LibrarySystem {

    public static void main(String[] args) {

        // Initialize structures
        BookInventoryBST inventory = new BookInventoryBST();
        BorrowRequestQueue queue = new BorrowRequestQueue();
        ReturnStack stack = new ReturnStack();

        User alice = new User("Alice");
        User bob = new User("Bob");

        // 1. Populate book inventory
        inventory.insert(new Book("978-0135166307", "Data Structures & Algorithms"));
        inventory.insert(new Book("978-0134685991", "Effective Java"));
        inventory.insert(new Book("978-0596009205", "Head First Java"));

        System.out.println("Books in inventory (sorted):");
        inventory.inorder();
        System.out.println();

        // 2. Users request books
        queue.enqueue(new BorrowRequest(alice.getName(), "978-0134685991"));
        queue.enqueue(new BorrowRequest(bob.getName(), "978-0596009205"));

        // 3. Process borrow requests
        while (!queue.isEmpty()) {
            BorrowRequest req = queue.dequeue();
            System.out.println("Issuing book " + req.getIsbn() + " to " + req.getUserName());
            inventory.delete(req.getIsbn());

            if (req.getUserName().equals(alice.getName())) {
                alice.getHistory().add(req.getIsbn());
            } else {
                bob.getHistory().add(req.getIsbn());
            }
        }

        // 4. Simulate returns
        stack.push("978-0134685991"); // Alice returns
        stack.push("978-0596009205"); // Bob returns

        while (!stack.isEmpty()) {
            String isbn = stack.pop();
            System.out.println("Processing return of " + isbn);

            // Add book back to inventory
            inventory.insert(new Book(isbn, "(Returned)"));
            alice.getHistory().remove(isbn);
            bob.getHistory().remove(isbn);
        }

        // Final states
        System.out.println("\nFinal inventory:");
        inventory.inorder();

        System.out.println("\nAlice's history:");
        alice.getHistory().display();

        System.out.println("\nBob's history:");
        bob.getHistory().display();
    }
}
