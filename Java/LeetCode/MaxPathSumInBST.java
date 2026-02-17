package com.task;

public class MaxPathSumInBST {
    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Tree:
        //      -10
        //     /   \
        //    5     20
        //         /  \
        //        15   17
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);
        dfs(root);
        System.out.println(maxSum);
    }

    private static int dfs(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }

        // Ignore negative path sums as a negative path would only decrease the current path sum.
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));
        // This path includes the current node and potentially paths from both its children
        int currentSum = node.val + leftSum + rightSum;
        System.out.println(node.val + "+" + leftSum + "+" + rightSum + "=" + currentSum);
        // Update the global maximum path sum found so far
        maxSum = Math.max(maxSum, currentSum);

        // Return the maximum path sum that can be extended upwards from the current node
        // This path can only include one child's path (either left or right)
        return node.val + Math.max(leftSum, rightSum);
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
