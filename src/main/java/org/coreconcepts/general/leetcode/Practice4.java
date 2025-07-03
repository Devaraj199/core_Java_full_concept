package org.coreconcepts.general.leetcode;

import java.util.Arrays;

public class Practice4 {
    public static void main(String[] args) {
        int[] arr = {2,0,7,8,0,0,3,0,4,6,7};
//        int[] arr = {12,43,56,89,22};
        int left = 0;
        for(int i = 0;i< arr.length;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i]=arr[left];
                arr[left]=temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
