package com.novikov.beans;

import java.util.Objects;

public abstract class Toy {
    private final Color color;
    private final Size size;
    private int ID = Math.abs(hashCode());

    public Toy( Size size, Color color) {
        this.size = size;
        this.color = color;
    }


    public Size getSize() {
        return size;
    }

    public int getID() {
        return ID;
    }
    public Color getColor() {
        return color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return ID == toy.ID &&
                color == toy.color &&
                size == toy.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, ID);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "color=" + color +
                ", size=" + size +
                ", ID=" + ID +
                '}';
    }
}
