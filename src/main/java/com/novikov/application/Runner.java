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
    public static void main(String[] args) throws DAOException, ParserException,ServiceException {
        List<Toy> toyList = new ArrayList<>();
        //dao.resetDAO();
;
        Room r4 = RoomFactory.createRoom(25,15);
        Toy toy = new Car(Size.LITTLE, Color.BLUE, 25);
        Room r6 = RoomFactory.createRoom(5, 13);

        String toyCreate = "Doll{color=BLUE, size=LITTLE, value=25, ID=1510794155}";
        String toyFromFile = "src/main/resources/toy.txt";
        String par = "";
        Service<Room> roomService = new RoomService();
        Room r1 = RoomFactory.createRoom(15,roomService.createToyFromFile(toyFromFile));
        //roomService.clearDAO();
        //roomService.add(r1);
       // roomService.add(r4);
        //roomService.add(r6);
        System.out.println(roomService.getAll());
        System.out.println(r1);
        //roomService.removeByID("59125484844461496");
       String sort = "PRICE";
       //roomService.sort(r5,sort);
        roomService.sort(r1,"PRICE COLOR");

        //System.out.println(roomService.query("BLUE"));
        //System.out.println(dao);



    }
}
