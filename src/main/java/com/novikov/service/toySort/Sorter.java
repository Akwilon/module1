package com.novikov.service.toySort;

import com.novikov.beans.Room;
import com.novikov.beans.Toy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public Sorter() {
    }

    public  void sortToysASC(Room room, Comparator sort){
        List<? extends Toy> toys = room.getToys();
         toys.sort(sort);
    }


    public void sortToysDESC(Room room, Comparator sort){
        List<? extends Toy> toys = room.getToys();
        toys.sort(sort);
        Collections.reverse(toys);
    }
}
