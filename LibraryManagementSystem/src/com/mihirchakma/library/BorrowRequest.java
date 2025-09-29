package com.mihirchakma.library;

// 2. Borrow Request Queue (1)

public class BorrowRequest {
    private String userName;
    private String isbn;

    public BorrowRequest(String userName, String isbn) {
        this.userName = userName;
        this.isbn = isbn;
    }

    public String getUserName() { return userName; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return userName + " -> " + isbn;
    }
}
