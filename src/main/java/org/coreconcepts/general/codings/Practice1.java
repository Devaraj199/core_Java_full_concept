package org.coreconcepts.general.codings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        // Example 1
        String str = "DeVRaj";
        StringBuffer sb = new StringBuffer();
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)){
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(Character.toLowerCase(c));
            }
        }
//        System.out.println(sb);
        // // Example 2
        int x = 2343335;
        int giveNumber = 3;
        String s = Integer.toString(x);
        int count = 0;
        for(char c : s.toCharArray()){
            int digit = Character.getNumericValue(c);
            if(digit==giveNumber){
                count++;
            }
        }


        int[] arr = {2,3,4,4,5,4};
        long count1 = Arrays.stream(arr).filter(n -> n == giveNumber).count();
//        System.out.println("Given number is "+giveNumber + " repeated in "+count1 +" times");
       long count3 =  Arrays.stream(s.split("")).mapToInt(Integer::parseInt).filter(n->n==giveNumber).count();
//        System.out.println("Given number is "+giveNumber + " repeated in "+count3 +" times");

        int[] newArray = {4,3,5,22,3,2,3,8}; // find the index of 3 and last index
        for(int i = 0;i<newArray.length;i++){
            if(newArray[i]==3){
                System.out.println("First index of 3 is "+i);
                break;
            }
        }
        for(int i = newArray.length-1;i>0; --i){
            if(newArray[i]==3){
                System.out.println("Last index of 3 is "+i);
                break;
            }
        }
        int count5 = IntStream.range(0, newArray.length).filter(i -> newArray[i] == giveNumber).findFirst().orElse(-1);
        int count6 = IntStream.range(0,newArray.length).filter(i->newArray[i]==giveNumber).reduce((a,b)->b).orElse(-1);
        if(count5!=-1){
            System.out.println("First index of 3 is "+count5);
        }
        if(count6!=-1){
            System.out.println("Last index of 3 is "+count6);
        }

        int[] newArray1 = {2,0,-7,8,9,0,0,-3,-7};
        IntStream concat = IntStream.concat(Arrays.stream(newArray1).filter(n -> n != 0), Arrays.stream(newArray1).filter(n -> n == 0));
        int[] result = concat.toArray();
        System.out.println("Result..."+Arrays.toString(result));
    }

}
