package com.bharat.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayFeatures {
    public static void main(String[] args) {
        //Arrays.sort
        //Arrays.fill
        //Arrays.binarySearch(arr,key)
        //Arrays.copyOf(arr,newLength)
        //Arrays.equals(arr1,arr2)
        //Arrays.deepEquals(arr1,arr2)
        //Arrays.toString()
        ArrayFeatures ap = new ArrayFeatures();
        boolean isAnagram = ap.checkAnagramUsingSorting("listen", "sentil");
        boolean isAnagram2 = ap.checkAnagramUsingCounter("listen", "sentil");
        System.out.println(isAnagram + " " + isAnagram2);
        System.out.println(ap.caesarCipher("bhazat"));
        //Array problems
        int[] arr = {2, 1, -4, -5, -3, 0, 7, 4};
        numbersWithSumClosestToZero(arr);
        arr = new int[]{2, 1, 6, -4, -5, -3, 0, 7, 8, 4};
        secondHighestInArray(arr);
        printSubsets(new char[]{'a', 'b', 'c'});
        //subarray with given sum i=0 to n and j=i to n -> O(n^2)
    }

    static void printSubsets(char set[]) {
        int n = set.length;
        // For array of length n-> subsets are 2^n or (1<<n)
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++){
                // logical & of
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
            }
            System.out.println("}");
        }
    }

    private static void secondHighestInArray(int[] arr) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = highest;
        for (int j : arr) {
            if (j > highest) {
                secondHighest = highest;
                highest = j;
            } else if (j > secondHighest) {
                secondHighest = j;
            }
        }

        System.out.println("Highest:" + highest + ",Second Highest:" + secondHighest);
    }

    private static void numbersWithSumClosestToZero(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int temp = arr[i] + arr[j];
        int index1 = 0, index2 = j;
        while (i < j && temp != 0) {
            if (temp < 0 && (Math.abs(arr[i + 1] + arr[j]) < Math.abs(temp)) && (i + 1) != j) {
                i++;
            } else if (Math.abs(arr[i] + arr[j - 1]) < Math.abs(temp) && i != (j - 1)) {
                j--;
            } else {
                i++;
                j--;
            }
            if (Math.abs(temp) > Math.abs((arr[i] + arr[j]))) {
                temp = arr[i] + arr[j];
                index1 = i;
                index2 = j;
            }
        }
        System.out.println("Numbers are " + arr[index1] + " " + arr[index2] + " Sum is " + temp);
    }

    private boolean checkAnagramUsingSorting(String s1, String s2) {
        char[] a = s1.toCharArray();
        Arrays.sort(a);
        char[] b = s2.toCharArray();
        Arrays.sort(b);
        return new String(a).equals(new String(b));
    }

    private boolean checkAnagramUsingCounter(String s1, String s2) {
        int[] count = new int[256];
        Arrays.fill(count, 0);
        s1.chars().forEach(ch -> count[ch] = count[ch] + 1);
        s2.chars().forEach(ch -> count[ch] = count[ch] - 1);
        return Arrays.stream(count).allMatch(i -> i == 0);
    }

    char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String caesarCipher(String s) {
        return s.chars()
                .mapToObj(c -> Character.toString(encrypt(c - 'a')))
                .collect(Collectors.joining());
    }

    private char encrypt(int c) {
        return alphabets[(c + 3) % 26];
    }
}
