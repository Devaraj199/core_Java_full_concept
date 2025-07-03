package org.coreconcepts.interview.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice1 {
    public static void main(String[] args) {
        String str = "kaabbccee";
        System.out.println(isPalindrome(str));

    }
    public static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c: str.toCharArray()){
            stringBuilder.append(c);
        }
        stringBuilder.reverse();
        if(str.contentEquals(stringBuilder))  return true;
        return isPalindromePossible(str);
    }

    public static boolean isPalindromePossible(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int oddCount = 0;
        for(int count : map.values()){
            if(count%2!=0) oddCount++;
            if(oddCount>1){
                return false;
            }
        }
        return true;
    }
}
