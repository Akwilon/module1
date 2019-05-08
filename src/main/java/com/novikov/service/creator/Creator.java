package com.novikov.service.creator;

import com.novikov.beans.Toy;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.exception.ParserException;

import java.util.List;

public interface Creator {
    public Toy createFromString(String string)throws ParserException, ServiceException;
    public List<Toy> readFromFile(String path)throws ParserException, ServiceException;
}
