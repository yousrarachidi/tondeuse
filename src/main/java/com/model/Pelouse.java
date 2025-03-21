package com.model;

public class Pelouse {
    private int maxX;
    private int maxY;

    public Pelouse(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x <= maxX && y <= maxY;
    }
}
