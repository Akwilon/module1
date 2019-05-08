package com.novikov.dao.impl;

import com.novikov.beans.Room;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;

public class SpecifiedBySize implements Specification<Toy> {
    Size size;


    public SpecifiedBySize(Size size) {
        this.size = size;
    }

    @Override
    public boolean match(Toy bean) {
        return bean.getSize().equals(size);
    }
}
