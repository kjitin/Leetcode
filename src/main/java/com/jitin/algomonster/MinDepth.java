package com.jitin.algomonster;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinDepth {

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

    public static int minDepth(Node<Integer> root) {
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = -1;

        while (queue.size() > 0) {
            int n = queue.size();
            depth++;
            for (int i=0; i< n; i++) {
                Node<Integer> node = queue.pop();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;

    }

    // 1 2 4 x 7 x x 5 x x 3 x 6 x x
    //     1
    //   /  \
    //   2     3
    //   / \      \
    //  4   5      6
    //   \
    //    7

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        int res = minDepth(root);

        System.out.println(res);
    }
}
