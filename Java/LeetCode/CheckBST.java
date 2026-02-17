// https://medium.com/@Roshan-jha/a-comprehensive-guide-to-binary-tree-traversal-in-java-74c86ee23725


package com.task;

public class CheckBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(14);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        // Initial call with the widest possible range
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, int minVal, int maxVal) {
        // Base case: An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // Check if the current node's value is within the allowed range
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }

        // Recursively check the left and right subtrees
        // For the left subtree, the maximum allowed value becomes the current node's value
        // For the right subtree, the minimum allowed value becomes the current node's value
        return isValidBSTHelper(node.left, minVal, node.val) &&
            isValidBSTHelper(node.right, node.val, maxVal);
    }

    static class TreeNode {
        final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
