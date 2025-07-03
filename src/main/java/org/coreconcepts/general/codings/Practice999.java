package org.coreconcepts.general.codings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Practice999 {
    public static void main(String[] args) {
        String[] str = {"kw","apple","banana","pineappple","jackfruit","spt"};
//        Arrays.sort(str, Comparator.comparing(String::length).reversed());
        String[] array = Arrays.stream(str).sorted(Comparator.comparing(String::length)).toArray(String[]::new);
//        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(array));
    }
}
