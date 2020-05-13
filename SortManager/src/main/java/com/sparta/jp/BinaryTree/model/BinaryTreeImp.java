package com.sparta.jp.BinaryTree.model;


import com.sparta.jp.BinaryTree.exceptions.ChildNotFoundException;
import com.sparta.jp.BinaryTree.model.BinaryTree;
import com.sparta.jp.BinaryTree.model.Node;

public class BinaryTreeImp implements BinaryTree {

    private Node root;
    private int numberOfElements = 1;
    private int[] sortedArray;
    private int count;


    public BinaryTreeImp(int [] unsortedArray) {
        this.root = new Node(unsortedArray[0]);
    }

    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public void addElement(int element) {
        addNextElement(element, root);
    }

    private void addNextElement(int element, Node current) {
        if (element > current.getValue()) {
            if (current.getRightChild() == null) {
                current.setRightChild(new Node(element));
                numberOfElements++;
            } else {
                current = current.getRightChild();
                addNextElement(element, current);
            }
        } else {
            if (current.getLeftChild() == null) {
                current.setLeftChild(new Node(element));
                numberOfElements++;
            } else {
                current = current.getLeftChild();
                addNextElement(element, current);

            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public boolean findElement(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.getValue()) {
                return true;
            } else if (value > current.getValue()) {
                current = current.getRightChild();
            } else current = current.getLeftChild();
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node current = root;
        if (!findElement(element)) {
            throw new ChildNotFoundException("This element is not in the Binary Tree");
        }
        while (current != null) {
            if (current.getValue() == element) {
                if (current.getLeftChild() != null)
                    return current.getLeftChild().getValue();
                else throw new ChildNotFoundException("There is no child.");
            } else if (current.getValue() > element) {
                current = current.getLeftChild();
            } else if (current.getValue() < element) {
                current = current.getRightChild();
            }
        }
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node current = root;
        if (!findElement(element)) {
            throw new ChildNotFoundException("This element is not in Binary Tree");
        }
        while (current != null) {
            if (current.getValue() == element) {
                if (current.getRightChild() != null)
                    return current.getRightChild().getValue();
                else throw new ChildNotFoundException("There is no child.");
            } else if (current.getValue() > element) {
                current = current.getLeftChild();
            } else if (current.getValue() < element) {
                current = current.getRightChild();
            }
        }
        return 0;
    }


    @Override
    public int[] getSortedTreeAsc() {
        sortedArray = new int[getNumberOfElements()];
        count =0;
        sortTreeAsc(root);
        return sortedArray;
    }

    public void sortTreeAsc(Node current){
        if(current!=null){
            sortTreeAsc(current.getLeftChild());
            sortedArray[count] = current.getValue();
            count++;
            sortTreeAsc(current.getRightChild());
        }
    }


    @Override
    public int[] getSortedTreeDesc() {
        sortedArray = new int[getNumberOfElements()];
        count = 0;
        sortTreeDesc(root);
        return sortedArray;
    }

    public void sortTreeDesc(Node current){
        if(current!=null){
            sortTreeDesc(current.getRightChild());
            sortedArray[count] = current.getValue();
            count++;
            sortTreeDesc(current.getLeftChild());
        }
    }

    @Override
    public int[] sortArray(int[] unsortedArray) {
        return getSortedTreeAsc();
    }
}



