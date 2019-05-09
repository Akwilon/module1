package com.novikov.service.toySort;

import com.novikov.beans.Toy;

import java.util.Comparator;

public class ToyComparator {
    public static Comparator<Toy> ToyCompare(){
         Comparator<Toy> comparator = new SortByValue().thenComparing(new SortByColor().thenComparing(new SortBySize()));
         return  comparator;
    }

}
