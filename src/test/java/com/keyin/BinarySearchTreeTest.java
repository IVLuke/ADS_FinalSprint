package com.keyin;

import com.keyin.BinarySearchTree.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    @Test
    public void testInsert(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        Assertions.assertEquals(70, binarySearchTree.getRoot().getValue());
        Assertions.assertEquals(60, binarySearchTree.getRoot().getLeft().getValue());
        Assertions.assertEquals(80, binarySearchTree.getRoot().getRight().getValue());
    }

}
