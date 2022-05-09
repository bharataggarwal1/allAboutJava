package com.bharat.algoDesignPatterns.divideandconquer;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = {1, 3, 2, 6, 7};
        q.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEachOrdered(System.out::println);
    }

    //Inplace
    //used in Arrays.sort() for primitives -> Dual Pivot
    //cant be used for linked list
    //unstable if duplicates present
    //worst case can be improved by using median as pivot -> O(n2) to O(nlogn)
    void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low; j<high; j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
