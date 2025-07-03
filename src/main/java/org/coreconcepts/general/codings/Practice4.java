package org.coreconcepts.general.codings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Practice4 {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
              List.of(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
         IntStream intStream = listOfLists.stream().flatMapToInt(list -> list.stream().mapToInt(Integer::intValue));
         Integer[] list = listOfLists.stream().flatMap(List::stream).toArray(Integer[]::new);
    }
}
