package com.novikov.dao.impl;

import com.novikov.beans.Toy;
import com.novikov.dao.Specification;

public class SpecifiedByPrice implements Specification<Toy> {
int price;

    public SpecifiedByPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean match(Toy bean) {
        return bean.getValue()== price;
    }
}
