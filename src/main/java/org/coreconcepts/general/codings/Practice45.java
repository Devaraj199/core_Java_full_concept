package org.coreconcepts.general.codings;

public class Practice45 {
    public static void main(String[] args) {
        int[] values = {15, 1, 2, 3, 4,8};
        int[] values1 = {15, 7,3, 4, 5, 6};
        int[] unique = new int[values.length];
        int k = 0;
        for (int i = 0; i < values.length; i++) {
            boolean found = false;
            for (int j = 0; j < values1.length; j++) {
                if (values[i] == values1[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[k] = values[i];
                k++;
            }
        }
        System.out.print("Unique elements in first array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(unique[i] + " ");
        }

    }
}
