package com.sparta.jp.display;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Display {
    private Scanner scanner = new Scanner(System.in);

    public void displayUnsortedArray(int[] unsortedArray) {
        System.out.println("Your Unsorted Array: " + Arrays.toString(unsortedArray));
    }

    public String displayTerminalSortTypeRequest(String path) {
        System.out.println("Enter the number of the sorter you wish to use ");
        String[] sortNames = getMenuItems(path);
        String sortType = scanner.nextLine();
        System.out.println("You selected the " + sortNames[Integer.parseInt(sortType) - 1].substring(0,sortNames[Integer.parseInt(sortType) - 1].indexOf('.')));
        return sortNames[Integer.parseInt(sortType) - 1];
    }

    private String [] getMenuItems(String path) {
        File sortDirectory = new File(path);
        String[] names = sortDirectory.list();
        Arrays.sort(names != null ? names : new String[0]);
        int index = 1;
        for (String name : names) {
            name = name.substring(0, name.indexOf('.'));
            System.out.println(index + "." + name);
            index++;
        }
        return names;
    }

    public void displaySortedArray(int[] sortedArray) {
        System.out.println("Your Sorted Array: " + Arrays.toString(sortedArray));
    }
}
