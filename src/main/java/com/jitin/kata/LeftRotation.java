package com.jitin.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(11, 12, 13, 14, 15);
        System.out.println(rotateLeft(integerList, 4));
        System.out.println(rotLeft(integerList, 4));
        System.out.println(rotRight(integerList, 4));
        System.out.println(rotateLeftOrRight(integerList, 4, "left"));
        System.out.println(rotateLeftOrRight(integerList, 4, "right"));
    }

    public static List<Integer> rotateLeft(List<Integer> a, int d) {
        List<Integer> newList = new ArrayList<>(a.size());

        for (int i = 0; i < a.size(); i++) {
            int value = a.get((i+d)%a.size());
            newList.add(i, value);
        }
        return newList;
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int rotatingPoint = d;
        int start = 0;
        int[] rotatedList = new int[a.size()];
        while(rotatingPoint < a.size()) {
            rotatedList[start] = a.get(rotatingPoint);
            start++;
            rotatingPoint++;
        }
        rotatingPoint =0;
        while(start < a.size()) {
            rotatedList[start]= a.get(rotatingPoint);
            rotatingPoint++;
            start++;
        }

        return Arrays.stream(rotatedList).boxed().collect(Collectors.toList());

    }

    public static List<Integer> rotRight(List<Integer> a, int d) {
        // Write your code here
        int rotatingPoint = a.size() - d;
        int start = 0;
        int[] rotatedList = new int[a.size()];
        while(rotatingPoint < a.size()) {
            rotatedList[start] = a.get(rotatingPoint);
            start++;
            rotatingPoint++;
        }
        rotatingPoint =0;
        while(start < a.size()) {
            rotatedList[start]= a.get(rotatingPoint);
            rotatingPoint++;
            start++;
        }

        return Arrays.stream(rotatedList).boxed().collect(Collectors.toList());

    }

    public static List<Integer> rotateLeftOrRight(List<Integer> a, int d, String rotationDirection) {
        int rotatingPoint;
        if (rotationDirection.equalsIgnoreCase("left"))
          rotatingPoint = d;
        else
           rotatingPoint = a.size() -d ;

        int start = 0;
        int[] rotatedList = new int[a.size()];
        while(rotatingPoint < a.size()) {
            rotatedList[start] = a.get(rotatingPoint);
            start++;
            rotatingPoint++;
        }
        rotatingPoint =0;
        while(start < a.size()) {
            rotatedList[start]= a.get(rotatingPoint);
            rotatingPoint++;
            start++;
        }

        return Arrays.stream(rotatedList).boxed().collect(Collectors.toList());
    }
}
