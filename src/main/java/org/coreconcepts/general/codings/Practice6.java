package org.coreconcepts.general.codings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(23,3,6,5));
        List<Integer> list1 = Arrays.asList(6,3,9,3);
        list.retainAll(list1);
        System.out.println(list);
    }
}
