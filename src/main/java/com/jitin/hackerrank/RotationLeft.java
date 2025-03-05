package com.jitin.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotationLeft {

    public static void main(String[] args) {
        rotLeft(Arrays.asList(1,2,3,4,5), 4);
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> test = new ArrayList<>();
        int rotatingPoint = d;
        int start = 0;
        int[] rotatedList = new int[a.size()];
        while(rotatingPoint < a.size()) {
            rotatedList[start] = a.get(rotatingPoint);
            start++;
            rotatingPoint++;
        }
        rotatingPoint =0;
        while(rotatingPoint < d) {
            rotatedList[start]= a.get(rotatingPoint);
            System.out.println("In loop "+ rotatedList[start]+ " value in arraylist "+a.get(rotatingPoint));
            rotatingPoint++;
            start++;
            System.out.println("rp "+rotatingPoint);
        }

        for (int i = 0; i < rotatedList.length; i++) {
            System.out.print(rotatedList[i]);
        }
        return Arrays.stream(rotatedList).boxed().collect(Collectors.toList());

    }
}
