package com.model;

public class Tondeuse {
    private int x;
    private int y;
    private char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void avancer(Pelouse pelouse) {
        int newX = x, newY = y;
        switch (orientation) {
            case 'N': newY += 1; break;
            case 'E': newX += 1; break;
            case 'S': newY -= 1; break;
            case 'W': newX -= 1; break;
        }
        if (pelouse.isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void tournerGauche() {
        orientation = switch (orientation) {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> orientation;
        };
    }

    public void tournerDroite() {
        orientation = switch (orientation) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> orientation;
        };
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
