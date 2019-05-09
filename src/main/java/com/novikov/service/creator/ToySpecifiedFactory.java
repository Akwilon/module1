package com.novikov.service.creator;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.dao.Specification;
import com.novikov.dao.impl.SpecifiedByColor;
import com.novikov.dao.impl.SpecifiedByPrice;
import com.novikov.dao.impl.SpecifiedBySize;

public class ToySpecifiedFactory {

    public Specification createSpecified(String type) {
        Specification<Toy> specification = null;
        switch (type.toUpperCase()) {
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
                specification = new SpecifiedByPrice(Integer.parseInt(type));
        }
        return specification;
    }

}

