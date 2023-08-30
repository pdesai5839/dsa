package com.dsa.sort;

public class InsertionSort {
    //time: O(n^2)
    //space: O(1)
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > curValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curValue;
        }
    }
    
    // Prints the array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        InsertionSort ob = new InsertionSort();
        int arr[] = {64, 25, 12, 22, 11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
