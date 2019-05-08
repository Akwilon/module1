package com.novikov.service;

import com.novikov.beans.Toy;
import com.novikov.dao.DAO;
import com.novikov.dao.exceptions.DAOException;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.exception.ParserException;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public abstract class Service<T> {
    protected DAO<T> dao;
    protected Logger logger = Logger.getLogger(Service.class);

    public void add(T obj) throws ServiceException {
        try {
            dao.add(obj);
        } catch (DAOException e) {
            logger.error("Add Service Exception",e);
            throw new ServiceException();
        }


    }

    public abstract Toy createFromString(String parameters) throws ServiceException, ParserException;

    public abstract List<Toy> createToyFromFile(String path)throws ServiceException, ParserException;

    public abstract void removeByID(String ID) throws ServiceException;

    public void clearDAO()throws ServiceException {
        try {
            dao.resetDAO();
        } catch (DAOException e) {
            logger.error("ServiceException on clearDAO",e );
            throw new ServiceException(e);
        }
    }

    public abstract List query(String parameters) throws ServiceException, ParserException;

    public abstract void sort(T obj, String parameters);



}
