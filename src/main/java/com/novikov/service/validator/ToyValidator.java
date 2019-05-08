package com.novikov.service.validator;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.service.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ToyValidator {

    private static Logger logger = LogManager.getLogger(ToyValidator.class);

    public static ValidatorRes validateFromString(String[] strings)throws ServiceException{
        ValidatorRes validatorRes = new ValidatorRes(false);
        int id = Integer.parseInt(strings[3]);
        Color validColor = ToyValidator.isColorValid(strings[0]);
        Size validSize = ToyValidator.isSizeValid(strings[1]);
        if(isPriceValid(strings[2]) && isTypeValid(strings[4])){
            validatorRes = new ValidatorRes(true,validColor,validSize,Integer.parseInt(strings[2]),id,strings[4]);
        }
        return validatorRes;

    }


    public static Color isColorValid(String color) throws ServiceException{
        switch (color.toUpperCase()){
            case "RED": return  Color.RED;
            case "GREEN": return  Color.GREEN;
            case "BLUE": return  Color.BLUE;
            default:
                logger.error("Validator Color exception" + color);
                throw new ServiceException("Validator Color exception");
        }
    }

    public static Size isSizeValid(String size)throws  ServiceException{
        switch (size.toUpperCase()){
            case "LITTLE": return Size.LITTLE;
            case "MIDDLE": return Size.MIDDLE;
            case "BIG": return Size.BIG;
            default:
                logger.error("Validator Size exception" + size);
                throw new ServiceException("Validator Size exception");
        }
    }




    private static boolean isTypeValid(String type)throws ServiceException{
        switch (type.toUpperCase()){
            case "BALL": return true;
            case "CAR": return true;
            case "CUBE": return true;
            case "DOLL": return true;
            default:
                logger.error("Validator Type exception" + type);
                throw new ServiceException("Validator Type exception");
        }
    }

    private static boolean isPriceValid(String price){
        int res = Integer.parseInt(price);
        if(res >  0){
            return true;
        }
        return false;
    }



}
