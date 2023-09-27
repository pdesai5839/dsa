package com.dsa.tree;

//https://uplevel.interviewkickstart.com/resource/rc-codingproblem-639396-1006734-1138-7053
public class BinaryTreeHeightRecursive {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        BinaryTreeNode rsub = new BinaryTreeNode(3);
        root.right = rsub;
        BinaryTreeNode rsubLeft = new BinaryTreeNode(4);
        rsub.left = rsubLeft;
        BinaryTreeNode rsubLeftLeft = new BinaryTreeNode(6);
        rsubLeft.left = rsubLeftLeft;
        rsub.right = new BinaryTreeNode(5);
        
        int height = height_of_binary_tree(root);
        System.err.println("height (expect 4) = " + height);
    }
    static Integer height_of_binary_tree(BinaryTreeNode root) {
        // Write your code here.
        return height(root);
    }
    static Integer height(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        return Math.max(heightLeft, heightRight) + 1;
    }
    
    public static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
