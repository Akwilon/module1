package com.novikov.service.toySort;

import com.novikov.beans.Toy;

import java.util.Comparator;

public class SortBySize implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getSize().compareTo(o2.getSize());
    }
}
