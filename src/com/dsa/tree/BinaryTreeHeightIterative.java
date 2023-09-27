package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://uplevel.interviewkickstart.com/resource/rc-codingproblem-639396-1006734-1138-7053
public class BinaryTreeHeightIterative {
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
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            while (size > 0) {
                BinaryTreeNode curr = queue.poll();
                size--;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return height;
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
