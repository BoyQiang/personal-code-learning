package com.study;

import java.util.Arrays;
import java.util.Objects;

public class QuickSort {

    public static void main(String[] args){
        int[] origin = {1,9,10,15,2,8,4,45};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(origin);
        Arrays.stream(origin).forEach(System.out :: println);
    }

    public void quickSort(int[] origin){
        if (!Objects.isNull(origin) && origin.length > 1) {
            subQuickSort(origin, 0, origin.length-1);
        }
    }

    private void subQuickSort(int[] origin, int start, int end){
        if (start >= end) {
            return;
        }
        int middle = findMiddleIndex(origin, start, end);
        subQuickSort(origin, start,middle-1);
        subQuickSort(origin, middle+1, end);
    }

    private int findMiddleIndex(int[] origin, int start, int end){
        int current = origin[start];
        while (start < end){
            while (start < end && current <= origin[end]){
                end--;
            }
            origin[start] = origin[end];
            while (start < end && current >= origin[start]){
                start++;
            }
            origin[end] = origin[start];
        }
        origin[start] = current;
        return start;
    }
}
