package com.novikov.application;

import com.novikov.beans.Color;
import com.novikov.beans.Room;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.beans.rooms.RoomFactory;
import com.novikov.beans.toys.Car;
import com.novikov.dao.exceptions.DAOException;
import com.novikov.service.Service;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.exception.ParserException;
import com.novikov.service.serviceExtends.RoomService;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Toy> toyList = new ArrayList<>();
        //dao.resetDAO();
        // room with random toys within budget
        Room r1 = RoomFactory.createRoom(25, 15);
        //



        String toyCreate = "Doll{color=BLUE, size=LITTLE, value=25, ID=1510794155}";


        String toyFromFile = "src/main/resources/toy.txt";
        String par = "";
        Service<Room> roomService = null;
        try {
            roomService = new RoomService();
        } catch (ServiceException e) {
            System.out.println("Service error! Add correct input values");
        }
        //room with toys created from file
        try {
            Room r2 = RoomFactory.createRoom(15, roomService.createToyFromFile(toyFromFile));
        } catch (ServiceException e) {
            System.out.println("Service error! Add correct input values");
        } catch (ParserException e) {
            System.out.println("Wrong file");
        }
        //
        //room with setted toys
        Room r6 = RoomFactory.createRoom(5, toyList);


    }
}
