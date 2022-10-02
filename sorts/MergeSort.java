package sorts;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // implement merge sort
        // base case: array has only one element, nothing left to sort
        // sort the array
        // merge the sorted arrays

        int[] a = {5, 7, 6, 3, 2, 8, 7};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a) {
        int len = a.length;
        if (len < 2) {
            return; // already sorted
        }
        // divide arr into 2 arrays
        // get midpoint
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        // fill left
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }

        // fill right
        for (int i = mid; i < len; i++) {
            right[i - mid] = a[i];
        }

        mergeSort(left);
        mergeSort(right);
        // after this everything is broken into individual pieces

        // merge left and right
        merge(a, left, right);
    }

    public static void merge(int[] a, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int addIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // loop thru left and right and add elements to merged array a
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (left[leftIndex] <= right[rightIndex]) {
                a[addIndex] = left[leftIndex];
                leftIndex++;
            } else {
                a[addIndex] = right[rightIndex];
                rightIndex++;
            }
            addIndex++;
        }

        // take care of left over elements
        // we don't know which one we have leftovers so take care of both
        while (leftIndex < leftSize) {
            a[addIndex] = left[leftIndex];
            leftIndex++;
            addIndex++;
        }

        while (rightIndex < rightSize) {
            a[addIndex] = right[rightIndex];
            rightIndex++;
            addIndex++;
        }
    }

}
