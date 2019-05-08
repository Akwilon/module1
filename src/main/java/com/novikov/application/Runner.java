package com.novikov.application;

import com.novikov.beans.Color;
import com.novikov.beans.Room;
import com.novikov.beans.rooms.AdultRoom;
import com.novikov.beans.rooms.RoomFactory;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.beans.toys.Ball;
import com.novikov.beans.toys.Car;
import com.novikov.beans.toys.Doll;
import com.novikov.beans.toys.create.Creator;
import com.novikov.dao.DAO;
import com.novikov.dao.Specification;
import com.novikov.dao.exceptions.DAOException;
import com.novikov.dao.impl.RoomDAO;
import com.novikov.dao.impl.SpecifiedByColor;
import com.novikov.dao.impl.SpecifiedByColorSize;
import com.novikov.dao.impl.SpecifiedBySize;
import com.novikov.service.creator.ToyCreator;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.ToyParser;
import com.novikov.service.parser.exception.ParserException;
import com.novikov.service.serviceExtends.RoomService;
import com.novikov.service.validator.ToyValidator;
import com.novikov.service.validator.ValidatorRes;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws DAOException, ParserException,ServiceException {
        DAO<Room> dao = RoomDAO.getInstance();
        List<Toy> toyList = new ArrayList<>();
        //dao.resetDAO();
        toyList.add(new Ball(Size.LITTLE, Color.BLUE, 25));
        toyList.add(new Doll(Size.LITTLE, Color.RED, 14));
        toyList.add(new Car(Size.MIDDLE, Color.GREEN, 21));
        Room r5 = new AdultRoom(24, toyList);
        Room r4 = RoomFactory.createRoom(25,8);
        Toy toy = new Car(Size.LITTLE, Color.BLUE, 25);
        Room r6 = RoomFactory.createRoom(5, 13);
        //dao.add(r5);
        String toyCreate = "Doll{color=BLUE, size=LITTLE, value=25, ID=1510794155}";
        String toyFromFile = "src/main/resources/toy.txt";

        String par = "";
        RoomService roomService = new RoomService();
        System.out.println(dao);
        roomService.removeByID("1645467790");
        System.out.println(r5);




    }
}
