package com.jitin.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class NewYearChaos {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                NewYearChaos.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
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

    public static void swap(List<Integer> list, int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);

    }

}
