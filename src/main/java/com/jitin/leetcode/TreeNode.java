package com.jitin.leetcode;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;

        dfs(node.left);
        dfs(node.right);
        return;
    }

    public void preOrderDfs(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        preOrderDfs(node.left);
        preOrderDfs(node.right);
        return;
    }

    public void inOrderDfs(TreeNode node){
        if (node == null)
            return;

        inOrderDfs(node.left);
        System.out.println(node.val);
        inOrderDfs(node.right);
        return;
    }

    public int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left, right) +1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.left = one;
        root.right = two;

        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
