// https://leetcode.com/problems/balanced-binary-tree/description
// 110. Balanced Binary Tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return check(root) != -1
    }

    private fun check(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = check(node.left)
        if (leftHeight == -1) return -1

        val rightHeight = check(node.right)
        if (rightHeight == -1) return -1

        if (abs(leftHeight - rightHeight) > 1) {
            return -1
        }

        return maxOf(leftHeight, rightHeight) + 1
    }
}
