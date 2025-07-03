package org.coreconcepts.general.leetcode;

public class Practice3 {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        String result = longestCommonPrefix(str);
        System.out.println(result);
    }


    public static String longestCommonPrefix(String[] strs) {
           String prefix = strs[0];
            for(String s: strs){
                while(!s.contains(prefix)){
                    prefix = prefix.substring(0,prefix.length()-1);
                    if(prefix.isEmpty()) return "";
                }
            }
        return prefix;
    }
}
