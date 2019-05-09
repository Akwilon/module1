package com.novikov.service.creator;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;
import com.novikov.dao.impl.SpecifiedByColor;
import com.novikov.dao.impl.SpecifiedByPrice;
import com.novikov.dao.impl.SpecifiedBySize;
import com.novikov.service.exception.ServiceException;
import com.novikov.service.toySort.SortByColor;
import com.novikov.service.toySort.SortBySize;
import com.novikov.service.toySort.SortByValue;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class ToyComparatorFactory {
    private Logger logger = LogManager.getLogger(ToyComparatorFactory.class);

    public Comparator<Toy> createComparator(String type)throws ServiceException {
        Comparator<Toy> comparator = null;
        switch (type.toUpperCase()) {
            case "COLOR":
                comparator = new SortByColor();
                break;
            case "SIZE":
                comparator = new SortBySize();
                break;
            case "PRICE":
                comparator = new SortByValue();
                break;

            default:
                logger.error("ToyComparatorFactory exception wrong type to compare: " + type + "\n" + ToyComparatorFactory.class);
                throw new ServiceException(" wrong type to compare");
        }
        return comparator;
    }
}
