package com.bharat.algoDesignPatterns.divideandconquer;

import java.util.Arrays;

public class MergeSort {

    //System.arrayCopy(srcArray, srcStartPos, destArray, destStartPos)
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 3, 6, 5, 7};
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEachOrdered(element -> System.out.println(element));
    }

    //recursive
    //stable algo, good for large arrays/slower for small array, non in-place algo requires additional memory of O(n), O(nlogn) time complexity
    //used for non-primitives in Arrays.sort(), always used in Collections.sort -> variant of Merge Sort called TimSort used in Java 8 onwards
    // reason -> it is a stable algo(as it copies the objects) and maintain natural order of objects using equals or comparator
    // used for linked list
    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int[] left = new int[n1];
        int n2 = end - mid;
        int[] right = new int[n2];

        System.arraycopy(arr, start, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        System.arraycopy(left, i, arr, k, n1 - i);
        System.arraycopy(right, j, arr, k, n2 - j);
    }
}
