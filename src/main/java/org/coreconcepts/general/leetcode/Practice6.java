package org.coreconcepts.general.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Practice6 {
    public static void main(String[] args) {
        int[] arr = {12,25,3,45,6,23,89,9};
        int highestVal = 0 , secondHighestVal = 0, thirdHighestVal = 0;
        for(int i : arr){
            if(i>highestVal){
                thirdHighestVal = secondHighestVal;
                secondHighestVal = highestVal;
                highestVal = i;

            }
            else if(i>secondHighestVal){
                thirdHighestVal = secondHighestVal;
                secondHighestVal = i;

            }
            else if(i>thirdHighestVal){
                thirdHighestVal = i;
            }
        }
        System.out.println("Second highest value: "+secondHighestVal);
        System.out.println("Third highest value: "+thirdHighestVal);
        int max = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(max);
    }
}
