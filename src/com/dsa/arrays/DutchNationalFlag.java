package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DutchNationalFlag {
    public static void main(String args[]) {
//        ArrayList<Character> charList = new ArrayList<>(Arrays.asList('G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'));
        ArrayList<Character> charList = new ArrayList<>(Arrays.asList('R', 'B', 'G', 'R', 'B'));
        dutch_flag_sort(charList);
//        dutch_flag_sort2(charList);
        System.err.println("charlist = " + charList);
        
        int[] nums = new int[] {2,0,2,1,1,0,1,2,0,0};
        System.err.println("orig  = " + Arrays.toString(nums));
        sortColors(nums);
        System.err.println("after = " + Arrays.toString(nums));
    }
    
    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        // Write your code here.
        //sanity checks
        if ((balls == null) || balls.isEmpty() || (balls.size() == 1)) {
            return balls;
        }
        //use 3 pointers technique
        //start: at 0th index, acts as a boundary of R's, meaning everything to it's left is an R
        //middle: at 0th index, acts as a loop variable
        //end: at size-1, acts as a boundary of B's, meaning everything to it's right is a B
        //loop as long as middle and end do not cross
        //a. if middle points to R: 
        //      swap start with middle since we want all R's to be at left
        //      move start forward by 1 to adjust the boundary of R's
        //      move middle forward by 1 to consider the next element
        //b. else if middle points to B:
        //      swap end with middle since we want all B's to be at right
        //      move end backward by 1 to adjust the boundary of B's
        //      do not move middle forward by 1 since the new value (after wap) at middle could be R or G
        //c. else if middle points to G:
        //      no swapping needed, just move middle forward by 1 to consider the next element
        int start = 0;
        int middle = 0;
        int end = balls.size() - 1;
        
        while (middle <= end) {
            if (balls.get(middle).equals('R')) {
                Collections.swap(balls, middle, start);
                start++;
                middle++;
            }
            else if (balls.get(middle).equals('B')) {
                Collections.swap(balls, middle, end);
                end--;
            }
            else if (balls.get(middle).equals('G')) {
                middle++;
            }
        }
        return balls;
    }
    
    static ArrayList<Character> dutch_flag_sort2(ArrayList<Character> balls) {
        int left = 0;
        int right = balls.size() - 1;
        System.err.println("before wap = " + balls);
        
        while (left < right) {
            if (balls.get(left).equals('R')) {
                System.err.println(left + " R = " + balls.get(left));
                left++;
            }
            else if (balls.get(right).equals('B') || balls.get(right).equals('G')) {
                System.err.println(right + " B/G = " + balls.get(right));
                right--;
            }
            else {
                Collections.swap(balls, left, right);
                System.err.println("after wap = " + balls);
            }
        }
        
        left = 0;
        right = balls.size() - 1;
        System.err.println("before wap 2 = " + balls);
        
        while (left < right) {
            if (balls.get(left).equals('R') || balls.get(left).equals('G')) {
                System.err.println(left + " R/G = " + balls.get(left));
                left++;
            }
            else if (balls.get(right).equals('B')) {
                System.err.println(right + " B = " + balls.get(right));
                right--;
            }
            else {
                Collections.swap(balls, left, right);
                System.err.println("after wap = " + balls);
            }
        }
        // Write your code here.
        return new ArrayList();
    }
    
    //O(n) time, O(1) space
    static void sortColors(int[] nums) {
        int start = 0;
        int middle = 0;
        int end = nums.length - 1;
        while (middle <= end) {
            if (nums[middle] == 2) {
                swap(nums, middle, end);
                end--;
            }
            else if (nums[middle] == 0) {
                swap(nums, middle, start);
                start++;
                middle++;
            }
            else if (nums[middle] == 1) {
                middle++;
            }
        }
    }
    
    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
