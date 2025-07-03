package org.coreconcepts.interview.practice;

public class Practice2 {
    public static void main(String[] args) {
        int[] arr = {5,5,10};
        int lcm = arr[0];
       for(int i=1;i<arr.length;i++){
           lcm = findLCM(lcm, arr[i]);
       }
        System.out.println(lcm);
    }

    private static int findLCM(int a, int b) {
        return (a*b)/findGCF(a,b);
    }

    private static int findGCF(int a,int b) {
        if(b==0){
            return a;
        }
        return findGCF(b,a%b);
    }
}
