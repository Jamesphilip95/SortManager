package com.sparta.jp;


import com.sparta.jp.Manager.SortFactory;
import com.sparta.jp.Manager.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private int[] unsortedArray;
    private Sorter sorter;

    @BeforeEach
    public void setup() {
        System.out.println("In Setup");
        sorter = SortFactory.getInstance();
        System.out.println("Testing using the " + sorter.toString());
        unsortedArray = new int[]{23, 5, 12, 7, 9};
    }


    @Test
    public void testIfArraySorted() {
        int [] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(new int[]{5, 7, 9, 12, 23}));

    }

    @Test
    public void testSizeOfArray() {
        System.out.println(Arrays.toString(unsortedArray));
    }

    private int [] createArray(int size){
        Random random = new Random();
        unsortedArray = new int [size];
        for (int i = 0; i<size; i++){
        unsortedArray[i] = random.nextInt(i) +1;
        }
        return unsortedArray;
    }
}