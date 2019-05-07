package com.novikov.dao.impl;

import com.novikov.beans.Room;
import com.novikov.dao.DAO;
import com.novikov.dao.Specification;
import com.novikov.dao.exceptions.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomDAO implements DAO<Room>, Serializable {
    private  static DAO<Room> instance;
    private static final String path = "src/main/resources/rooms.txt";
    private List<Room> rooms;
    private Logger logger = LogManager.getLogger(RoomDAO.class);



    {
       readDB();
    }

    private RoomDAO( ) throws DAOException {

    }




    public static DAO<Room> getInstance() throws DAOException{
        if(instance == null){
            instance = new RoomDAO();
        }
        return instance;
    }





    public void add(Room obj) throws DAOException {
        rooms.add(obj);
        try {
            update();
        } catch (DAOException e) {
            logger.error("Add room error",e);
            throw new DAOException();
        }
    }


    public void addAll(List<Room> obj) {
        rooms.addAll(obj);
    }

    public void remove(Room obj) {
        if (rooms.contains(obj)){
            rooms.remove(obj);
        }
    }

    public void remove(long id) {
      for( Room r : rooms){
          if(r.getID() == id){
              rooms.remove(r);
          }
      }
    }

    public void update() throws DAOException{
        try(FileOutputStream output = new FileOutputStream(path); ObjectOutputStream objOut = new ObjectOutputStream(output)){
            objOut.writeObject(this.rooms);
        }catch (FileNotFoundException e) {
            logger.error("File not found", e);
            throw new DAOException("File Not found", e);
        }catch (IOException e) {
            logger.error("IOException",e);
            throw new DAOException("IOException", e);
        }
    }

    public Room get(long id) throws DAOException {
        for (Room r : rooms){
            if(r.getID() == id){
                return r;
            }
        }
        logger.error("Ошибка БД, нет такого элемента");
        throw new DAOException("No such element");

    }

    public List<Room> query(Specification specification) {
        return null;
    }



    private void readDB() throws DAOException{
        File file = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"Rooms.txt");
        try (FileInputStream in = new FileInputStream(file); ObjectInputStream objectIn = new ObjectInputStream(in)) {
            rooms = (ArrayList<Room>)objectIn.readObject();
        } catch (FileNotFoundException e) {
            logger.error("File not found",e);
            throw new DAOException("File Not found", e);
        } catch (ClassNotFoundException e) {
            logger.error("No such Class",e);
            throw new DAOException("Class not found", e);
        } catch (IOException e) {
            logger.error("IOException",e);
            throw new DAOException("IOException", e);
        }
    }


}
