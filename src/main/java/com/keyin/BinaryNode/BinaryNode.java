package com.keyin.BinaryNode;

import javax.persistence.*;

@Entity
public class BinaryNode {
    @Id
    @SequenceGenerator(name = "node_sequence", sequenceName = "node_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "node_sequence")
    private Long Id;

    private int value;

    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
