package com.novikov.service.toySort;

import com.novikov.beans.Toy;

import java.util.Comparator;

public class SortByColor implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
