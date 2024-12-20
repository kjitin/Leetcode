package com.jitin.algomonster;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewsPaperSplit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> newspapersReadTimes = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int numCoworkers = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = newspapersSplit(newspapersReadTimes, numCoworkers);
        System.out.println(res);
    }

    private static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
       int low = Collections.max(newspapersReadTimes);
       int high = 0;
       int ans = -1;

       for (int readTime : newspapersReadTimes)
           high += readTime;

       while (low <= high) {
               int mid = (low+high)/2;

               if(feasible(newspapersReadTimes, numCoworkers, mid)) {
                   ans = mid;
                   high = mid -1;
               } else {
                   low = mid+1;
               }
       }
       return ans;
    }

    public static boolean feasible(List<Integer> newsPaperReadTimes, int numCoWorkers, int limit) {
        int time =0, numWorkers = 0;
        for (int readTime: newsPaperReadTimes) {
            if (time+readTime > limit) {
                time = 0;
                numWorkers++;
            }
            time += readTime;
        }
        if (time != 0) {
            numWorkers++;
        }
        return numWorkers <= numCoWorkers;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }


}
