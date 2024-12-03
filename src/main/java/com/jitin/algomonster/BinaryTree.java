package com.jitin.algomonster;

import java.util.*;
import java.util.function.Function;

public class BinaryTree {

    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static void inOrderTraversal(Node<Integer> root) {
            if (root !=null) {
                inOrderTraversal(root.left);
                System.out.println(root.val);
                inOrderTraversal(root.right);
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

        // 5 4 3 x x 8 x x 6 x x     6 x 9 x 11 x 7 x x
        //   5                        6
        //  / \                       /
        //  4  6                      9
        // /  \                       /
        // 3   8                      11
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
            scanner.close();
            //inOrderTraversal(root);
            System.out.println(treeMaxEdges(root));
        }

        // dfs(root) -1 as edge is node -1
        private static int treeMaxEdges(Node<Integer> root) {
            return (root!= null) ? dfs(root) -1 : 0;
        }

        private static int dfs(Node<Integer> root) {
            if (root == null)
                return 0;

            int left = dfs(root.left);
            int right = dfs(root.right);
            return Math.max(left, right) + 1;
        }

    }
}
