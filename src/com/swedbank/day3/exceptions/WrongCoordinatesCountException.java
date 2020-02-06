package com.swedbank.day3.exceptions;

public class WrongCoordinatesCountException extends Exception {

    private int count;

    public WrongCoordinatesCountException(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
