package com.novikov.service.toySort;

import com.novikov.beans.Toy;

import java.util.Comparator;

public class SortByValue implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        if (o1.getValue() > o2.getValue()) {
            return 1;
        } else if (o1.getValue() < o2.getValue()) {
            return -1;
        } else return 0;
    }
}
