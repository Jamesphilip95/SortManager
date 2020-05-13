package com.sparta.jp.Sorters;

import com.sparta.jp.BinaryTree.model.BinaryTreeImp;
import com.sparta.jp.Manager.Sorter;

public class BinaryTreeSorter implements Sorter {


    @Override
    public int[] sortArray(int[] unsortedArray) {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp(unsortedArray);
        binaryTreeImp.addElements(unsortedArray);
        return binaryTreeImp.getSortedTreeAsc();
    }
}
