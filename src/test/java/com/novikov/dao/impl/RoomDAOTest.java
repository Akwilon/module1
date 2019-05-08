package com.novikov.dao.impl;

import com.novikov.beans.Room;
import com.novikov.beans.rooms.AdultRoom;
import com.novikov.beans.rooms.RoomFactory;
import com.novikov.dao.DAO;
import com.novikov.dao.Specification;
import com.novikov.dao.exceptions.DAOException;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class RoomDAOTest extends TestCase {
    DAO<Room> dao;

    @Test (expected = DAOException.class)
    public void testRemove() throws DAOException {
        dao = RoomDAO.getInstance();
        Room r3 = RoomFactory.createRoom(14, 23);
        dao.add(r3);
        dao.remove(r3);
        dao.get(r3.getID());


    }

    @Test
    public void testIDSearch() throws DAOException {
        dao = RoomDAO.getInstance();
        Room r1 = new AdultRoom(14, 23);
        dao.add(r1);
        Assert.assertEquals(r1, dao.get(r1.getID()));


    }

    public void testRemove1() {
    }

    @Test
    public void testSpecifiedByName() throws DAOException {

    }
}