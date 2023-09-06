package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String args[]) {
        boolean result = isAnagram("abc", "cab");
        System.err.println("abc, cab = " + result);
        result = isAnagram("abc", "cad");
        System.err.println("abc, cad = " + result);
    }
    
    //O(n)
    static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> countsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countsMap.put(s.charAt(i), countsMap.getOrDefault(s.charAt(i), countsMap.get(s.charAt(i)) + 1));
            countsMap.put(t.charAt(i), countsMap.getOrDefault(t.charAt(i), countsMap.get(t.charAt(i)) - 1));
        }
        for (int c : countsMap.values()) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
