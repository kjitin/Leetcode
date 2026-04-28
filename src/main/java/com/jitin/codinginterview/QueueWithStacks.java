package com.jitin.codinginterview;

import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueWithStacks(Stack<Integer> first, Stack<Integer> second) {
        this.first = first;
        this.second = second;
    }

    public void enqueue(int val) {
        first.push(val);
    }

    public int dequeue() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();
    }

    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        QueueWithStacks queueWithStacks = new QueueWithStacks(first, second);
        queueWithStacks.enqueue(1);
        queueWithStacks.enqueue(2);
        queueWithStacks.enqueue(3);
        System.out.println(queueWithStacks.peek());

    }
}
