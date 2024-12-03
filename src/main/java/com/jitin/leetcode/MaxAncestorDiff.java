package com.jitin.leetcode;

public class MaxAncestorDiff {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(10);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(6);
        treeNode.left.right.left = new TreeNode(4);
        treeNode.left.right.right = new TreeNode(7);
        treeNode.right.right = new TreeNode(14);
        treeNode.right.right.left = new TreeNode(18);
        print(treeNode);
        System.out.println(maxAncestorDiff(treeNode));
    }

    private static int maxAncestorDiff(TreeNode treeNode) {
        if (treeNode == null)
            return 0;

        return helper(treeNode, treeNode.val, treeNode.val);
    }

    private static int helper(TreeNode root, int curMax, int curMin) {
        if (root == null) {
            return curMax -curMin;
        }

        curMax = Math.max(root.val, curMax);
        curMin = Math.min(root.val, curMin);
        int left = helper(root.left, curMax, curMin);
        int right = helper(root.right, curMax, curMin);

        return Math.max(left, right);
    }

    private static void print(TreeNode treeNode) {
        if (treeNode == null)
            return;

        System.out.println(treeNode.val);
        print(treeNode.left);
        print(treeNode.right);
    }
}
