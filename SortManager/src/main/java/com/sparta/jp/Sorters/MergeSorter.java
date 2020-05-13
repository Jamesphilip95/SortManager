package com.sparta.jp.Sorters;

import com.sparta.jp.Manager.Sorter;

public class MergeSorter implements Sorter {
    @Override
    public int [] sortArray(int []unsortedArray){

        merge(unsortedArray);
        return unsortedArray;
    }


    public void merge(int[] unsortedArray) {
        if (unsortedArray.length < 2) return;

        int midpoint = unsortedArray.length / 2;
        int[] left = populateSplitArray(midpoint, 0, unsortedArray);
        int[] right = populateSplitArray(unsortedArray.length - midpoint,midpoint, unsortedArray);

        merge(left);
        merge(right);

        int [] combinedArray = mergeArray(left, right);
        System.arraycopy(combinedArray, 0, unsortedArray, 0, unsortedArray.length);
    }


    private int[] populateSplitArray(int length, int startIndex, int[] inputArray) {

        int[] splitArray = new int[length];
        int index = 0;
        for (int k = startIndex; k < length +startIndex; k++) {
            splitArray[index] = inputArray[k];
            index++;
        }
        return splitArray;
    }

    public static int[] mergeArray(int[] leftSide, int[] rightSide){

        int[] joinedArray = new int [leftSide.length + rightSide.length];
        int indexL = 0, indexR = 0;

        for(int i =0; i<joinedArray.length; i++) {

            if(indexL == leftSide.length){
                joinedArray[i] =  rightSide[indexR];
                indexR ++;
            }
            else if (indexR == rightSide.length){
                joinedArray[i] =  leftSide[indexL];
                indexL ++;
            } else if (leftSide[indexL] <= rightSide[indexR]) {
                joinedArray[i] = leftSide[indexL];
                indexL++;
            }
            else {
                joinedArray[i] = rightSide[indexR];
                indexR++;
            }
        }

        return joinedArray;
    }

}
