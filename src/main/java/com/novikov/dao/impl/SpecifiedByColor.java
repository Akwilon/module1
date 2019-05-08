package com.novikov.dao.impl;

import com.novikov.beans.Color;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;

public class SpecifiedByColor implements Specification<Toy> {
    Color color;


    public SpecifiedByColor(Color color) {
        this.color = color;

    }

    @Override
    public boolean match(Toy bean) {
        return bean.getColor().equals(color);
    }
}