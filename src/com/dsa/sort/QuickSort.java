package com.dsa.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    //time: O(n log n)
    //space: O(n)
    public ArrayList<Integer> quick_sort(ArrayList<Integer> arr) {
        mergeHelper(arr, 0, arr.size() - 1);
        return arr;
    }
    
    private static void mergeHelper(ArrayList<Integer> arr, int startIndex, int endIndex) {
        //leaf node
        if (startIndex >= endIndex) {
            return;
        }
        //internal node worker
        // randomize pivot
        int randomPivot = new Random().nextInt((endIndex - startIndex) + 1) + startIndex;
        Collections.swap(arr, startIndex, randomPivot);
        
        int smaller = startIndex;
        int pivot = arr.get(startIndex);
        
        for (int bigger = startIndex + 1; bigger <= endIndex; bigger++) {
            if (arr.get(bigger) < pivot) {
                smaller++;
                Collections.swap(arr, smaller, bigger);
            }
        }
        Collections.swap(arr, startIndex, smaller);
        
        mergeHelper(arr, startIndex, smaller - 1);
        mergeHelper(arr, smaller + 1, endIndex);
    }

    public static void main(String args[]) {
        QuickSort ob = new QuickSort();
        int array[] = {64, 25, 12, 22, 11};
        ArrayList<Integer> listToSort = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            listToSort.add(array[i]);
        }
        ArrayList<Integer> merged = ob.quick_sort(listToSort);
        System.err.println("ik quick sort = " + merged);
    }
}
