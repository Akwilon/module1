package com.novikov.service.creator;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.beans.toys.Ball;
import com.novikov.beans.toys.Car;
import com.novikov.beans.toys.Cube;
import com.novikov.beans.toys.Doll;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.ToyParser;
import com.novikov.service.parser.exception.ParserException;
import com.novikov.service.validator.ToyValidator;
import com.novikov.service.validator.ValidatorRes;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToyCreator implements Creator {
    private Logger logger = LogManager.getLogger(ToyCreator.class);


    @Override
    public Toy createFromString(String string) throws ParserException, ServiceException {
        ValidatorRes validatorRes = null;
        String[] parsed = ToyParser.parseToy(string);
        validatorRes = ToyValidator.validateFromString(parsed);
        if (!validatorRes.isValid()) {
            logger.error("Not Valid Input " + ToyCreator.class);
            throw new ServiceException("Not valid Input");
        }
        switch (validatorRes.getToyType().toUpperCase()) {
            case "BALL":
                return new Ball(validatorRes.getSize(), validatorRes.getColor(), validatorRes.getPrice());
            case "CAR":
                return new Car(validatorRes.getSize(), validatorRes.getColor(), validatorRes.getPrice());
            case "CUBE":
                return new Cube(validatorRes.getSize(), validatorRes.getColor(), validatorRes.getPrice());
            case "DOLL":
                return new Doll(validatorRes.getSize(), validatorRes.getColor(), validatorRes.getPrice());

            default:
                logger.error("Not valid type of toy" + validatorRes.getToyType());
                throw new ParserException("Not valid type of toy");
        }
    }

    @Override
    public List<Toy> readFromFile(String path) throws ServiceException, ParserException {
        Path pathFile = Paths.get(path);
        if (!Files.exists(pathFile)) {
            logger.error("No file present!" + ToyCreator.class);
            throw new ServiceException("No file present!");
        }
        try {
            List<String> lines = Files.readAllLines(pathFile);
            List<Toy> toys = new ArrayList<>();
            for (String line : lines)
                toys.add(createFromString(line));
            return toys;
        } catch (IOException e) {
            logger.error("Cannot read from file" + ToyCreator.class);
            throw new ServiceException("Cannot read from file", e);
        }


    }
}
