package org.example;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(String message) {
        super("Неправильные данные" + message);
    }
}
