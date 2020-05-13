package com.sparta.jp.Sorters;


import com.sparta.jp.Manager.Sorter;

public class BubbleSorter implements Sorter {

    @Override
    public int [] sortArray(int[] intArray) {
        int temp;
        boolean notInOrder = true;
        while (notInOrder) {
            notInOrder = false;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    temp = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = temp;
                    notInOrder = true;
                }
            }
        }
        return intArray;
    }

//    @Override
//    public String toString() {
//        return "BubbleSorter";
//    }
}