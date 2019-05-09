package com.novikov.dao.impl;

import com.novikov.beans.Room;
import com.novikov.beans.Toy;
import com.novikov.dao.DAO;
import com.novikov.dao.Specification;
import com.novikov.dao.exceptions.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomDAO implements DAO<Room>, Serializable {
    private static DAO<Room> instance;
    private static final String path = "src/main/resources/rooms.txt";
    private List<Room> rooms = new ArrayList<>();
    private Logger logger = LogManager.getLogger(RoomDAO.class);


    {
        readDB();
    }

    private RoomDAO() throws DAOException {

    }


    public static DAO<Room> getInstance() throws DAOException {
        if (instance == null) {
            instance = new RoomDAO();
        }
        return instance;
    }


    public void add(Room obj) throws DAOException {
        for (Room r : rooms) {
            if (r.getID() == obj.getID()) {
                logger.error(obj.getClass() + " Already exist");
                throw new DAOException("Room already in database");
            }
        }

        rooms.add(obj);
        try {
            update();
        } catch (DAOException e) {
            logger.error("Add room error", e);
            throw new DAOException("Add room error");
        }
    }


    public void addAll(List<Room> obj) {
        rooms.addAll(obj);
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    @Override
    public void resetDAO() throws DAOException {
        rooms.clear();
        logger.info("DB was reset");
        update();
    }

    public void remove(Room obj) throws DAOException {
        if (rooms.contains(obj)) {
            rooms.remove(obj);
        } else
            logger.error("NO element to remove by Room");
        throw new DAOException("No such element");
    }

    public void remove(long id) throws DAOException {

        if (isContain(id)) {
            Iterator<Room> iterator = rooms.iterator();
            while (iterator.hasNext()) {
                Room value = iterator.next();
                if (value.getID() == id) {
                    iterator.remove();
                    update();
                    break;
                }
            }
        } else {
            logger.error("No element to remove by id");
            throw new DAOException("No such element");
        }
    }

    public void update() throws DAOException {
        try (FileOutputStream output = new FileOutputStream(path); ObjectOutputStream objOut = new ObjectOutputStream(output)) {
            objOut.writeObject(this.rooms);
        } catch (FileNotFoundException e) {
            logger.error("File not found", e);
            throw new DAOException("File Not found", e);
        } catch (IOException e) {
            logger.error("IOException", e);
            throw new DAOException("IOException", e);
        }
    }

    public Room get(long id) throws DAOException {
        for (Room r : rooms) {
            if (r.getID() == id) {
                return r;
            }
        }
        logger.error("Ошибка БД, нет такого элемента");
        throw new DAOException("No such element");

    }

    public List<Toy> query(Specification specification) throws DAOException {
        List<Toy> result = new ArrayList<>();
        for (Room r : rooms) {
            for (Toy toy : r.getToys())
                if (specification.match(toy)) {
                    result.add(toy);
                }
        }
        if (result.size() == 0) {
            logger.error("No element in DAO by this specification" + specification.getClass());
            throw new DAOException("No such element by this criteria");
        }
        return result;
    }


    private void readDB() throws DAOException {
        File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "Rooms.txt");
        try (FileInputStream in = new FileInputStream(file); ObjectInputStream objectIn = new ObjectInputStream(in)) {
            rooms = (ArrayList<Room>) objectIn.readObject();
        } catch (FileNotFoundException e) {
            logger.error("File not found", e);
            throw new DAOException("File Not found", e);
        } catch (ClassNotFoundException e) {
            logger.error("No such Class", e);
            throw new DAOException("Class not found", e);
        } catch (IOException e) {
            logger.error("IOException", e);
            throw new DAOException("IOException", e);
        }
    }

    private boolean isContain(long id) {
        for (Room r : rooms) {
            if (r.getID() == id) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoomDAO{");
        sb.append("rooms=").append(rooms);
        sb.append('}');
        return sb.toString();
    }
}
