package org.coreconcepts.general.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice1 {
    public static void main(String[] args) {
        int[] nums = {11,15,2,7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
    public static int[] twoSum(int[] num,int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<num.length;i++){
            int complement = target-num[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement),i};
            }
            map.put(num[i],i);
            System.out.println(map);
        }

     throw new IllegalArgumentException("No two sum solution");

    }
}
