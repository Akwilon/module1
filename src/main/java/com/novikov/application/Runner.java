package com.novikov.application;

import com.novikov.beans.Color;
import com.novikov.beans.Room;
import com.novikov.beans.rooms.AdultRoom;
import com.novikov.beans.rooms.YoungRoom;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.beans.toys.Ball;
import com.novikov.beans.toys.Car;
import com.novikov.dao.DAO;
import com.novikov.dao.exceptions.DAOException;
import com.novikov.dao.impl.RoomDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[]args)throws DAOException {
        DAO<Room> dao = RoomDAO.getInstance();


        Room five = new AdultRoom(250, 6);
        five.addToy(new Car(Size.BIG, Color.GREEN, 15));
        dao.add(five);
        dao.add(new YoungRoom(15, 256));
        System.out.println(five);
    }
}
