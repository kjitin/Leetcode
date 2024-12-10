package com.jitin.algomonster;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

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

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();

        if (root == null)
            return result;

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> newLevel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                newLevel.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(newLevel);
        }
        return result;


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
        List<List<Integer>> res = levelOrderTraversal(root);

        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
