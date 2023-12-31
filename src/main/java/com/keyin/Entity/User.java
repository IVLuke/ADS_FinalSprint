package com.keyin.Entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private long id;
    private String userInput;
    @Column(columnDefinition = "TEXT")
    private String tree;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }
}
