package org.coreconcepts.general.codings;

import java.util.*;

public class practice5 {
    public static void main(String[] args) {
        Map<String, String> treemap =
                new TreeMap<>(Collections.reverseOrder());
        treemap.put("1", "Welcome");
        treemap.put("2", "to");
        treemap.put("3", "the");
        treemap.put("4", "Geeks");
        treemap.put("5", "Community");
        Iterator<String> values = treemap.keySet().iterator();
        while (values.hasNext()){
            System.out.println(values.next());
        }

        ArrayList<String>
                list = new ArrayList<>();

        list.add("Geeks");
        list.add("For");
        list.add("ForGeeks");
        list.add("GeeksForGeeks");
        list.add("A computer portal");
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
        String arr[] = { "practice.geeksforgeeks.org",
                "www.geeksforgeeks.org",
                "code.geeksforgeeks.org" };

        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        int n = 2;
        int m = 5;

        int it = 1;

        int[][] newArr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                    newArr[i][j] = it;
                    it++;
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(newArr[i][j]+" ");
            }
            System.out.println();
        }

        int[][][] arr3d = { { { 1, 7 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

        String str = "hello world management hello   fine ";
        Map<String,Integer> map = new HashMap<>();
        for(String s: str.split(" ")){
            if(!s.isBlank()){
                map.put(s,s.length());
            }
        }
        System.out.println(map);
        int[] sortedArray = {23,45,67,89,99};// target is 99 o/p:3

        System.out.println(getIndexValue(sortedArray,58));
    }

    public static int getIndexValue(int[] sortedArray,int target) {
        int left = 0;
        int right = sortedArray.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            System.out.println(mid);
            if(sortedArray[mid]==target){
                return mid;
            }
            else if(sortedArray[mid]<target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return -1;
    }
}
