package com.sparta.jp.Manager;


import com.sparta.jp.display.Display;

public class SortManager {
    public void runSorter(int[] unsortedArray) {
        Sorter sorter = SortFactory.getInstance();
        Display display = new Display();
        display.displayUnsortedArray(unsortedArray);
        Long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        Long end = System.nanoTime();
        display.displaySortedArray(sortedArray);
        Long timeElapsed = end - start;
        System.out.println("Time taken for sort " + timeElapsed + "ns");
    }
}
