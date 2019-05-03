package com.novikov.dao.impl;

import com.novikov.beans.Room;
import com.novikov.dao.DAO;
import com.novikov.dao.Specification;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class RoomDAO implements DAO<Room>, Serializable {
    private static final File file = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"Rooms.txt");










    public void add(Room obj) {

    }

    public void addAll(List<Room> obj) {

    }

    public void remove(Room obj) {

    }

    public void remove(long id) {

    }

    public void update(Room obj) {

    }

    public Room get(long id) {
        return null;
    }

    public List<Room> query(Specification specification) {
        return null;
    }
}
