package com.bharat.algoDesignPatterns.divideandconquer;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        b.search(new int[]{1, 2, 3, 4, 5},4);
    }
    public void search(int[] arr, int element){
        Arrays.sort(arr);
        int low=0,high=arr.length-1;
        int i=-1;
        while(low<high){
            int mid = (low+high)/2;
            if(arr[mid]<element){
                low=mid;
            }else if(arr[mid]>element){
                high=mid;
            }else{
                i=mid;
                break;
            }
        }
        System.out.println("Index is:"+i);
    }
}
