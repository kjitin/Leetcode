package com.jitin.algomonster;

import java.util.*;
import java.util.function.Function;

public class BST {

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

    public static Node<Integer> insertBst(Node<Integer> bst, int val) {
        if (bst ==null)
            return new Node<>(val);

        int compareVal = bst.val.compareTo(val);
        if (compareVal < 0) {
            bst.right = insertBst(bst.right, val);
        } else if (compareVal > 0) {
            bst.left = insertBst(bst.left, val);
        }
        return bst;
    }

    public static <T> void formatTree(Node<T> node, List<String> out) {
        if (node == null) {
            out.add("x");
            return;
        }
        out.add(node.val.toString());
        formatTree(node.left, out);
        formatTree(node.right, out);
    }

    //8 4 2 1 x x 3 x x 6 x x 12 10 x x 14 x 15 x x
    // 7
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        int val = Integer.parseInt(scanner.nextLine());
        scanner.close();
        Node<Integer> res = insertBst(root, val);
        ArrayList<String> resultArray = new ArrayList<>();
        formatTree(res, resultArray);
        System.out.println(String.join(" ",resultArray));
    }
}
