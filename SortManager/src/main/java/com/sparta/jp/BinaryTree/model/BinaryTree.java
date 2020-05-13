package com.sparta.jp.BinaryTree.model;


 import com.sparta.jp.BinaryTree.exceptions.ChildNotFoundException;
 import com.sparta.jp.Manager.Sorter;

/**
 * Created by keith.dauris on 26/06/2017.
 */
public interface BinaryTree extends Sorter {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();


}
