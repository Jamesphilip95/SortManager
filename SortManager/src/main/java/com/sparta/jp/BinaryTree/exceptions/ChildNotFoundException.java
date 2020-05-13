package com.sparta.jp.BinaryTree.exceptions;

    public class ChildNotFoundException extends Exception {

        private String message;

        public ChildNotFoundException(String message) {
            this.message = message;
        }


        public String getMessage() {
            return message;
        }
    }

