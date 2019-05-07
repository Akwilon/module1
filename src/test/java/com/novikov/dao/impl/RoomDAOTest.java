package com.novikov.dao.impl;

import com.novikov.beans.Room;
import com.novikov.beans.rooms.AdultRoom;
import com.novikov.dao.DAO;
import com.novikov.dao.exceptions.DAOException;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RoomDAOTest extends TestCase {
        DAO<Room> dao;


    public void testAddOK() throws DAOException {
        dao = RoomDAO.getInstance();
       Room r1 = new AdultRoom(14,23);
       dao.add(r1);
        Assert.assertEquals(r1,dao.get(r1.getID()));
    }

    public void testRemove() {
    }

    public void testRemove1() {
    }

    public void testGet() {
    }
}