package com.mihirchakma.library;

//4. User History (Singly Linked List)

public class User {
    private String name;
    private UserHistory history = new UserHistory();

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public UserHistory getHistory() { return history; }
}
