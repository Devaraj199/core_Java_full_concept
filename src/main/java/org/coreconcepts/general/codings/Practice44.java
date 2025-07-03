package org.coreconcepts.general.codings;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice44 {
    public static void main(String[] args) {
        int[] values = {15, 1, 2, 3, 4};
        int[] values1 = {15, 3, 4, 5, 6};
        int[] array = IntStream.concat(Arrays.stream(values), Arrays.stream(values1)).distinct().toArray();
        System.out.println(Arrays.toString(array));
        int[] common = new int[values.length];
        int k = 0;
        for(int i=0;i<values.length;i++){
            for(int j=0;j<values.length;j++) {
                if (values[i] == values1[j]) {
                    boolean alreadyExist = false;
                    for (int x = 0; x < k; x++) {
                        if (common[x] == values[i]) {
                            alreadyExist = true;
                            break;
                        }
                    }
                    if (!alreadyExist) {
                        common[k] = values[i];
                        k++;
                    }
                    break;
                }



            }

}
        System.out.print("Common elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(common[i] + " ");
        }
    }
}
