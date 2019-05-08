package com.novikov.beans;

import java.io.Serializable;
import java.util.Objects;

public abstract class Toy  implements Serializable {
    private final Color color;
    private final Size size;
    private int value;
    private int ID;

    public Toy( Size size, Color color, int price) {
        setValue(price);
        this.size = size;
        this.color = color;
        this.ID  = Math.abs(hashCode());
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

    public int getValue() {
        return value;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setValue(int value) {
        if (value > 0) {
            this.value = value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (value != toy.value) return false;
        if (ID != toy.ID) return false;
        if (color != toy.color) return false;
        return size == toy.size;

    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Toy{");
        sb.append("color=").append(color);
        sb.append(", size=").append(size);
        sb.append(", value=").append(value);
        sb.append(", ID=").append(ID);
        sb.append('}');
        return sb.toString();
    }


}
