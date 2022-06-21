package ru.skypro;

public class Main {

    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    private static void method() throws MyException {
        throw new MyException();
    }

    private static class MyException extends Exception {

    }
}
