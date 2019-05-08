package com.novikov.service.validator;

import com.novikov.beans.Color;
import com.novikov.beans.Size;

public class ValidatorRes {
    private boolean isValid;
    private Color color;
    private Size size;
    private String toyType;
    private int price;
    private int ID;

    public ValidatorRes(boolean isValid) {
        this.isValid = isValid;
    }


    public ValidatorRes(boolean isValid, Color color, Size size,int price, int ID, String toyType) {
        this.price = price;
        this.toyType = toyType;
        this.isValid = isValid;
        this.color = color;
        this.size = size;
        this.ID = ID;
    }

    public boolean isValid() {
        return isValid;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getToyType() {
        return toyType;
    }

    public int getID() {
        return ID;
    }
}
