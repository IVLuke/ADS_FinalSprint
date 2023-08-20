package com.keyin.BinarySearchTree;

public class BinarySearchTree {
    private Node root;
    public static class Node{
        private int value;

        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }



    public BinarySearchTree() {
       this.root = null;
    }
    private Node insertRecursive(Node current, int value){
        if(current == null){
            return new Node(value);
        }
        if (value < current.value){
            current.left = insertRecursive(current.left,value);
        }else if (value > current.value){
            current.right = insertRecursive(current.right,value);
        }
        return current;
    }
    public void insert(int value){
        root = insertRecursive(root,value);
    }

    public Node getRoot() {
        return root;
    }
    public String toJsonRecursive(Node current, int row){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        String indentation = "  ".repeat(row +1);
        String commaNewLine = ",\n";

        jsonBuilder.append(indentation).append("\"Value\":").append(current.getValue());
    // Left
        if (current.getLeft() != null){
        jsonBuilder.append(commaNewLine).append(indentation).append("\"Left\":").append(toJsonRecursive(current.getLeft(),row +1));}
        else{
            jsonBuilder.append(commaNewLine).append(indentation).append("\"Left\":null");
        }
    // Right
        if (current.getRight() != null){
            jsonBuilder.append(commaNewLine).append(indentation).append("\"Right\":").append(toJsonRecursive(current.getRight(),row +1));}
        else{
            jsonBuilder.append(commaNewLine).append(indentation).append("\"Right\":null");
        }
    // Close
        jsonBuilder.append("\n").append(" ".repeat(row)).append("}");

        return jsonBuilder.toString();
    }

    public String toJson() {
        if(root==null){
            return "{}";
        }
        return"{\n\"Root\":" + toJsonRecursive(root,0) + "\n}";
    }
}
