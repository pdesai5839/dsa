package com.dsa.sort;

import java.util.ArrayList;

public class MergeSort {
    //time: O(n log n)
    //space: O(n)
    public ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        divide(arr, 0, arr.size() - 1);
        return arr;
    }

    private static void divide(ArrayList<Integer> arr, int startIndex, int endIndex) {
      //leaf
        if (startIndex == endIndex) {
            return;
        }
        int midIndex = startIndex + ((endIndex - startIndex) / 2);
        divide(arr, startIndex, midIndex);
        divide(arr, midIndex + 1, endIndex);
        mergeHelper(arr, startIndex, midIndex, endIndex);
    }

    private static void mergeHelper(ArrayList<Integer> arr, int startIndex, int midIndex, int endIndex) {
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;
        
        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (arr.get(leftIndex) <= arr.get(rightIndex)) {
                mergedSortedArray.add(arr.get(leftIndex));
                leftIndex++;
            }
            else {
                mergedSortedArray.add(arr.get(rightIndex));
                rightIndex++;
            }
        }
        //add remaining
        while (leftIndex <= midIndex) {
            mergedSortedArray.add(arr.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex <= endIndex) {
            mergedSortedArray.add(arr.get(rightIndex));
            rightIndex++;
        }
        
        //copy merged list into original
        int i = 0;
        int j = startIndex;
        while(i < mergedSortedArray.size()){
            arr.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

    public static void main(String args[]) {
        MergeSort ob = new MergeSort();
        int array[] = {64, 25, 12, 22, 11};
        ArrayList<Integer> listToSort = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            listToSort.add(array[i]);
        }
        ArrayList<Integer> merged = ob.merge_sort(listToSort);
        System.err.println("ik merge sort = " + merged);
    }
}
