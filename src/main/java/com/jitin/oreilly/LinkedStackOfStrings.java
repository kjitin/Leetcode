package com.jitin.oreilly;

public class LinkedStackOfStrings {

    private Node first = null;
    private class Node {
        String item;
        Node next;
    }
    public static void main(String[] args) {
        LinkedStackOfStrings linkedStackOfStrings = new LinkedStackOfStrings();
        linkedStackOfStrings.push("first");
        linkedStackOfStrings.push("second");
        linkedStackOfStrings.push("last");
        System.out.println(linkedStackOfStrings.pop());
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}
