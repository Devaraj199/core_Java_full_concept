package org.coreconcepts.general.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
// Given a string s, find the length of the longest substring without duplicate characters.
public class Practice2 {
    public static void main(String[] args) {
        String s = "cakklmn";
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
            System.out.println(set);
        }
        for(char c: s.toCharArray()){
            set1.add(c);
        }
        System.out.println(max);
        System.out.println(set1.size());
    }
}
