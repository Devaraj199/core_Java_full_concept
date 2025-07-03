package org.coreconcepts.general.leetcode;

public class Practice5 {
    public static void main(String[] args) {
        int[] arr = {12,3,2,7,8,11,13};
        for(int i=0;i<arr.length;i++){
           boolean isPrime = Practice5.checkIsPrime(arr[i]);
           if(isPrime){
               System.out.println(arr[i]+" ");
           }
        }
    }

    public static boolean checkIsPrime(int n){
        if(n==2) return true;
        for(int i = 2 ; i<Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
