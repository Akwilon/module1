package com.novikov.beans.toys;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;

public class Car  extends Toy {
    public Car(Size size, Color color, int price) {
        super(size, color, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("color=").append(super.getColor());
        sb.append(", size=").append(super.getSize());
        sb.append(", value=").append(super.getValue());
        sb.append(", ID=").append(super.getID());
        sb.append('}');
        return sb.toString();
    }

}
