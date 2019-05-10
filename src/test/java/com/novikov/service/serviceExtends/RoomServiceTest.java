package com.novikov.service.serviceExtends;

import com.novikov.beans.Color;
import com.novikov.beans.Room;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.beans.rooms.RoomFactory;
import com.novikov.beans.toys.Ball;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.exception.ParserException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class RoomServiceTest extends TestCase {
    RoomService service;


    @Test(expected = ServiceException.class)
    public void testAddNull() throws ServiceException {
        service = new RoomService();
        service.add(null);
    }

    @Test(expected = ServiceException.class)
    public void testAddDuplicate() throws ServiceException {
        service = new RoomService();
        Room r1 = RoomFactory.createRoom(12, 5);
        service.add(r1);
        service.add(r1);
    }

    @Test
    public void testGetID() throws ServiceException, ParserException {
        service = new RoomService();
        Room r1 = RoomFactory.createRoom(12, 5);
        service.add(r1);

        Room serviceID = service.getID(String.valueOf(r1.getID()));
        assertEquals(r1, serviceID);
    }

    @Test(expected = ParserException.class)
    public void testGetWrongString() throws ServiceException, ParserException {
        service = new RoomService();
        Room serviceID = service.getID("qrwetyttky");

    }

    @Test
    public void testCreateToyFromStringOK() throws ServiceException, ParserException {
        service = new RoomService();
        service.clearDAO();
        Toy t1 = service.createFromString("Ball{color=BLUE, size=LITTLE, value=3, ID=1510794155}");
        assertEquals(t1.getID(), new Ball(Size.LITTLE, Color.BLUE, 3).getID());

    }

    @Test (expected = ServiceException.class)
    public void testCreateToyFromStringNULL() throws ServiceException, ParserException {
        service = new RoomService();
        Toy t1 = service.createFromString(null);

    }

    @Test
    public void testCreateToyFromFileOK() throws ServiceException, ParserException {
        service = new RoomService();
        List<Toy> toys = null;
        toys = service.createToyFromFile("src/main/resources/toy.txt");
        assertEquals(12,toys.size());


    }

    @Test(expected = ServiceException.class)
    public void testCreateToyFromFileWrong() throws ServiceException, ParserException {
        service = new RoomService();
        List<Toy> toys = null;
        toys = service.createToyFromFile("safghtretw");


    }
}