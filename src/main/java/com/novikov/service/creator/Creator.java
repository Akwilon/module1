package com.novikov.service.creator;

import com.novikov.beans.Toy;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.parser.exception.ParserException;

import java.util.List;

public interface Creator<T> {
    public T createFromString(String string)throws ParserException, ServiceException;
    public List<T> readFromFile(String path)throws ParserException, ServiceException;
}
