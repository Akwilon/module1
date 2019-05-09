package com.novikov.service.serviceExtends;

import com.novikov.beans.Room;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;
import com.novikov.dao.exceptions.DAOException;
import com.novikov.dao.impl.RoomDAO;
import com.novikov.dao.impl.SpecifiedByColorSize;
import com.novikov.service.Service;
import com.novikov.service.creator.ToyComparatorFactory;
import com.novikov.service.creator.ToyCreator;
import com.novikov.service.creator.ToySpecifiedFactory;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.ParametresParser;
import com.novikov.service.parser.exception.ParserException;
import com.novikov.service.validator.ToyValidator;

import java.util.Comparator;
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
    public void add(Room obj) throws ServiceException {
        if (!checkNull(obj)) {
            logger.error("Add ServiceError wrong Room type: " + obj);
            throw new ServiceException();
        }
        try {
            dao.add(obj);
        } catch (DAOException e) {
            logger.error("Add Service Exception Room: " + obj, e);
            throw new ServiceException();
        }


    }

    @Override
    public Room getID(String ID) throws ServiceException, ParserException {
        if (!checkNull(ID)) {
            logger.error("ServiceError IDGetter string: " + ID);
            throw new ServiceException();
        }
        String parsed = ParametresParser.parseLong(ID);
        long id = Long.parseLong(parsed);
        Room res = null;
        try {
            res = dao.get(id);
        } catch (DAOException e) {
            logger.error("ServiceError no Room with this ID : " + id);
            throw new ServiceException(e);
        }
        return res;
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
    public void removeByID(String ID) throws ServiceException, ParserException {
        if (!checkNull(ID)) {
            logger.error("ServiceError string: " + ID);
            throw new ServiceException();
        }
        String parsed = ParametresParser.parseLong(ID);
        long id = Long.parseLong(parsed);
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

        } else {
            specification = new ToySpecifiedFactory().createSpecified(parsed.get(0));

        }
        try {
            return dao.query(specification);
        } catch (DAOException e) {
            logger.error("ServiceError query parametres: " + parameters);
            throw new ServiceException(e);
        }


    }

    @Override
    public void sort(Room obj, String parameters) throws ServiceException {
        String[] req = parameters.split("\\s+");
        ToyComparatorFactory factory = new ToyComparatorFactory();
        Comparator<Toy> comparator = factory.createComparator(req[0]);
        for (int i = 1; i < req.length; i++) {
            comparator = comparator.thenComparing(factory.createComparator(req[i]));
        }
        List<? extends Toy> list = obj.getToys();
        list.sort(comparator);

    }


    protected static boolean checkNull(Object obj) {
        return Optional.ofNullable(obj).isPresent();
    }
}
