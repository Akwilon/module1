package com.novikov.dao.impl;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;

public class SpecifiedByColorSize  implements Specification<Toy> {
    Color color;
    Size size;

    public SpecifiedByColorSize(Color color, Size size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean match(Toy bean) {
        return bean.getSize().equals(size) && bean.getColor().equals(color);
    }
}
