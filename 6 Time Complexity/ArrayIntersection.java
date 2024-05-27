import java.util.Arrays;

class Solution {
    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        mergeSortTypeApproach(arr1, arr2);
    }

    public static void mergeSortTypeApproach(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                ++i;
                ++j;
            }

            else if (arr1[i] < arr2[j])
                ++i;

            else
                ++j;
        }

        // if (i < arr1.length) {
        //     while (i < arr1.length) {
        //         if (arr1[i] == arr2[j])
        //             System.out.println(arr1[i] + " ");

        //         ++i;
        //     }
        // }

        // if (j < arr2.length) {
        //     while (j < arr2.length) {
        //         if (arr1[i] == arr2[j])
        //             System.out.println(arr1[i] + " ");

        //         ++j;
        //     }
        // }

    }
}

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = { 2, 6, 1, 2 };
        int[] arr2 = { 1, 2, 3, 4, 2  };
        Solution.intersection(arr1, arr2);
    }
}