package com.jitin.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class NewYearChaos {

    public static void main(String[] args) throws IOException {

        List<Integer> q = Arrays.asList(1 ,2 ,5, 3, 7, 8, 6, 4);
        List<Integer> q1 = Arrays.asList(1 ,2 ,5, 3, 7, 8, 6, 4);
        NewYearChaos.minimumBribesForward(q);
        NewYearChaos.minimumBribes(q1);
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribeCount =0;
        for (int i = q.size() -1; i >=0 ; i--) {

            if (q.get(i) != i+1) {
                if (((i-1) >=0) && q.get(i-1) == (i+1)) {
                    bribeCount++;
                    swap(q, i, i-1);
                } else if (((i-2) >=0) && q.get(i-2) == (i+1)) {
                    bribeCount+=2;
                    swap(q, i-2, i-1);
                    swap(q, i-1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }

            }
        }
        System.out.println(bribeCount);

    }

    public static void minimumBribesForward(List<Integer> q) {
        // Write your code here
        int bribeCount =0;
        for (int i = 0; i <= q.size()-1 ; i++) {

            if (q.get(i) != i+1) {
                if (((i+1) <= q.size() -1) && q.get(i+1) == (i+1)) {
                    bribeCount++;
                    swap(q, i, i+1);
                } else if (((i+2) <= q.size() -1) && q.get(i+2) == (i+1)) {
                    bribeCount+=2;
                    swap(q, i+2, i+1);
                    swap(q, i+1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }

            }
        }
        System.out.println(bribeCount);

    }

    public static void minimumBribesSimple(List<Integer> q) {
        // Write your code here
        int minimumBribes = 0;
        for(int i =0; i< q.size(); i++) {
            if(i+1 < q.size() && q.get(i) != i+1) {
                minimumBribes = q.get(i) - q.get(i+1);
                swap(q, i, i+1);
                if(minimumBribes >= 3) {
                    System.out.println("Too chaotic");
                    break;
                }
            }
        }
        System.out.println(minimumBribes);

    }

    public static void swap(List<Integer> list, int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);

    }

}
