package com.jitin.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MovingAverage {
    int size;
    List<Integer> queue = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();
    int dequeueWindowSum = 0, count =0;
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        int windowSum =0;
        for (int i = Math.max(0, queue.size() - size); i < queue.size(); i++) {
            windowSum += (int)queue.get(i);
        }
        return windowSum*1.0/ Math.min(queue.size(), size);
    }

    public double dequeueNext(int val) {
        ++count;
        deque.add(val);
        int tail = count > size ? (int)deque.poll() : 0;
        dequeueWindowSum = dequeueWindowSum -tail + val;
        return dequeueWindowSum * 1.0/ Math.min(size, count);
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.dequeueNext(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.dequeueNext(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.dequeueNext(3));
        System.out.println(movingAverage.next(5));
        System.out.println(movingAverage.dequeueNext(5));
    }
}
