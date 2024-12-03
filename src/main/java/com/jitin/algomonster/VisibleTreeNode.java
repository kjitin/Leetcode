package com.jitin.algomonster;

import java.util.*;
import java.util.function.Function;

public class VisibleTreeNode {
    public static class Node<T> {
       public T val;
       public Node<T> left;
       public Node<T> right;

       public Node(T val) {
           this(val, null, null);
       }
       public Node(T val, Node<T> left, Node<T> right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> function) {
        String value = iter.next();
        if (value.equals("x"))
            return null;

        Node<T> left = buildTree(iter, function);
        Node<T> right = buildTree(iter, function);
        return new Node<T>(function.apply(value), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList(): Arrays.asList(s.split(" "));
    }

    public static int visibleTreeNode(Node<Integer> root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(Node<Integer> root, int maxSoFar) {
        if (root == null)
            return 0;
        int total  =0;
        if (root.val >= maxSoFar) {
            total++;
        }

        total += dfs(root.left, Math.max(maxSoFar, root.val));
        total += dfs(root.right, Math.max(maxSoFar, root.val));

        return total;
    }

    // 5 4 3 x x 8 x x 6 x x     6 x 9 x 11 x 7 x x
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VisibleTreeNode.Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        int res = visibleTreeNode(root);
        System.out.println(res);
    }
}
