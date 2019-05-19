package com.study.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
        int[] origin = {1,9,10,15,2,8,4,45};
        MergeSort mergeSort = new MergeSort();
        Arrays.stream(mergeSort.sort(origin, 0, origin.length - 1))
                .forEach(System.out :: println);
    }


    public int[] sort(int[] origin, int low, int high){
        int middle = (low + high) / 2;
        if (low < high) {
            sort(origin, low, middle);
            sort(origin, middle+1, high);
            merge(origin, low, middle, high);
        }
        return origin;
    }

    private void merge(int[] origin, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (origin[i] <= origin[j]) {
                temp[k++] = origin[i++];
            } else {
                temp[k++] = origin[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = origin[i++];
         }
        while (j <= high) {
            temp[k++] = origin[j++];
        }
        for (int x=0; x<temp.length; x++) {
            origin[x + low] = temp[x];
        }
    }
}
