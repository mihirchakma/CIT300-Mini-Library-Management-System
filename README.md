# 📚 Mini Library Management System

- **Student ID:** 22UG3-0235
- **Assessment:** Mid-Term Assignment
- **Module:** CIT300 - Data Structures and Algorithms
- **Degree program:** Bachelor of Applied Information Technology (BAIT)
- **Faculty:** Faculty of Computing and IT
- **University:** Sri Lanka Technology Campus (SLTC)

---

## 📖 Overview
This project is a **Mini Library Management System** developed as part of the **CIT300 – Data Structures and Algorithms** course.  
It demonstrates how fundamental data structures can be applied to solve real-world problems such as managing books, handling borrow requests, processing returns, and tracking user history.

The system is implemented in **Java** and showcases the following data structures:
- **Binary Search Tree (BST)** → Book Inventory
- **Queue** → Borrow Requests
- **Stack** → Return Processing
- **Singly Linked List** → User History

---

## 🎯 Objectives
- Apply theoretical knowledge of data structures in a practical system.
- Understand how different data structures map to real-world processes.
- Practice modular design and object-oriented programming in Java.
- Demonstrate insertion, deletion, traversal, and dynamic memory management.

---

## ⚙️ Features

### 1. Book Inventory (BST)
- Stores books using ISBN as the key.
- Supports:
  - **Insertion** of new books
  - **Deletion** of books
  - **In-order traversal** to display books in sorted order

### 2. Borrow Request Queue
- Models borrow requests in **FIFO** order.
- Supports:
  - **Enqueue** (add request)
  - **Dequeue** (issue book to next user)

### 3. Return Stack
- Models returned books in **LIFO** order.
- Supports:
  - **Push** (add returned book)
  - **Pop** (process most recent return)

### 4. User History (Singly Linked List)
- Tracks books borrowed by each user.
- Supports:
  - **Add book** to history
  - **Remove book** when returned
  - **Display history** of borrowed books

---

## 🛠️ Technologies Used
- **Language:** Java
- **JDK:** Java Development Kit (JDK) 17 or higher
- **Concepts:** Object-Oriented Programming, Data Structures
- **IDE:** Any Java-compatible IDE (e.g., IntelliJ IDEA, VS Code, Eclipse, NetBeans)

---

## 📂 Project Structure

```
LibraryManagementSystem/
 │
 ├── src/                           # Source code
     └── com/
         └── mihirchakma/
              └── library/
                   ├── LibrarySystem.java       # Main entry point
                   ├── Book.java                # Book node class
                   ├── BookInventoryBST.java    # BST for inventory
                   ├── BorrowRequest.java       # Queue node
                   ├── BorrowRequestQueue.java  # Queue logic
                   ├── ReturnStack.java         # Stack node & logic
                   ├── User.java                # Linked list node
                   └── UserHistory.java         # Linked list logic

```

---

## 🚀 Usage Example

After cloning the repository and compiling the project, you can run the main application:

```bash
javac -d bin src/com/mihirchakma/library/*.java
java -cp bin com.mihirchakma.library.LibrarySystem
```

### 📄 Sample Code (Main Application)

```java
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

```

### 🖥️ Expected Output

```
Books in inventory (sorted):
978-0134685991 - Effective Java
978-0135166307 - Data Structures & Algorithms
978-0596009205 - Head First Java

Issuing book 978-0134685991 to Alice
Issuing book 978-0596009205 to Bob
Processing return of 978-0596009205
Processing return of 978-0134685991

Final inventory:
978-0134685991 - (Returned)
978-0135166307 - Data Structures & Algorithms
978-0596009205 - (Returned)

Alice's history:
(no books)

Bob's history:
(no books)
```

---

## 🧠 Design Choices

- **BST** chosen for fast search and sorted display of books.
- **Queue** chosen to ensure fairness in borrow requests.
- **Stack** chosen to process returns in reverse order of arrival.
- **Linked List** chosen for flexible and dynamic user history tracking.
- Modular design ensures scalability and maintainability.

---

## 🌟 Reflection

- **Through this project, I learned:**
  - How abstract data structures directly solve practical problems.
  - The importance of selecting the right structure for each scenario.
  - How modular design improves clarity and extensibility.
  - That data structures are not just theory—they are the backbone of real systems.

---
