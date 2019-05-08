package com.novikov.service.serviceExtends;

import com.novikov.beans.Color;
import com.novikov.beans.Room;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;
import com.novikov.dao.exceptions.DAOException;
import com.novikov.dao.impl.*;
import com.novikov.service.Service;
import com.novikov.service.creator.ToyCreator;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.ParametresParser;
import com.novikov.service.parser.exception.ParserException;
import com.novikov.service.validator.ToyValidator;

import java.util.List;
import java.util.Optional;

public class RoomService extends Service<Room> {


    public RoomService() throws ServiceException {
        try {
            dao = RoomDAO.getInstance();
        } catch (DAOException e) {
            logger.error("DAO getInstance exception", e);
            throw new ServiceException("Service Constructor Error");

        }
    }

    @Override
    public Toy createFromString(String parameters) throws ServiceException, ParserException {
        if (!checkNull(parameters)) {
            logger.error("CreateFromString ServiceError");
            throw new ServiceException();
        }
        return new ToyCreator().createFromString(parameters);


    }

    @Override
    public List<Toy> createToyFromFile(String path) throws ServiceException, ParserException {
        if (!checkNull(path)) {
            logger.error("ServiceError string: " + path);
            throw new ServiceException();
        }
        return new ToyCreator().readFromFile(path);
    }

    @Override
    public void removeByID(String ID) throws ServiceException {
        if (!checkNull(ID)) {
            logger.error("ServiceError string: " + ID);
            throw new ServiceException();
        }
        long id = Long.parseLong(ID);
        try {
            dao.remove(id);
        } catch (DAOException e) {
            logger.error("ServiceError no Room with this ID : " + id);
            throw new ServiceException(e);
        }

    }

    @Override
    public List query(String parameters) throws ServiceException, ParserException {
        if (!checkNull(parameters)) {
            logger.error("ServiceError string: " + parameters);
            throw new ServiceException();
        }
        List<String> parsed = ParametresParser.parsePar(parameters);
        if ((parsed.size() > 2)) {
            logger.error("Wrong query parametres: " + parameters);
            throw new ServiceException("Wrong parametres");
        }
        Specification<Toy> specification = null;

        if (parsed.size() == 2) {
            specification = new SpecifiedByColorSize(ToyValidator.isColorValid(parsed.get(0)), ToyValidator.isSizeValid(parsed.get(1)));

        } else
            switch (parsed.get(0).toUpperCase()) {
                case "RED":
                    specification = new SpecifiedByColor(Color.RED);
                    break;
                case "GREEN":
                    specification = new SpecifiedByColor(Color.GREEN);
                    break;
                case "BLUE":
                    specification = new SpecifiedByColor(Color.BLUE);
                    break;
                case "LITTLE":
                    specification = new SpecifiedBySize(Size.LITTLE);
                    break;
                case "MIDDLE":
                    specification = new SpecifiedBySize(Size.MIDDLE);
                    break;
                case "BIG":
                    specification = new SpecifiedBySize(Size.BIG);
                    break;
                default:
                    specification = new SpecifiedByPrice(Integer.parseInt(parsed.get(1)));

        }
        try {
            return dao.query(specification);
        } catch (DAOException e) {
            logger.error("ServiceError query parametres: " + parameters);
            throw new ServiceException(e);
        }


    }

    @Override
    public void sort(Room obj, String parameters) {


    }


    protected static boolean checkNull(Object obj) {
        return Optional.ofNullable(obj).isPresent();
    }
}
