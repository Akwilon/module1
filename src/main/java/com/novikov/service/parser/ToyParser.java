package com.novikov.service.parser;

import com.novikov.beans.toys.Ball;
import com.novikov.service.parser.exception.ParserException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ToyParser {

    private static Logger logger = LogManager.getLogger(ToyParser.class);

    public static String[] parseToy(String string) throws ParserException {
        if (!string.matches("Ball\\{color=\\w+(\\s+\\w+)*, size=\\w+(\\s+\\w+)*, value=\\d+(\\.\\d+)?, ID=\\d+(\\.\\d+)?}") &&!string.matches("Car\\{color=\\w+(\\s+\\w+)*, size=\\w+(\\s+\\w+)*, value=\\d+(\\.\\d+)?, ID=\\d+(\\.\\d+)?}") && !string.matches("Cube\\{color=\\w+(\\s+\\w+)*, size=\\w+(\\s+\\w+)*, value=\\d+(\\.\\d+)?, ID=\\d+(\\.\\d+)?}") && !string.matches("Doll\\{color=\\w+(\\s+\\w+)*, size=\\w+(\\s+\\w+)*, value=\\d+(\\.\\d+)?, ID=\\d+(\\.\\d+)?}")){
            logger.error("Wrong string form " + string);
            throw new ParserException("Cannot parse input string!");
        }
        String[] res = string.split(", ");
        int lastIndex = res.length - 1;
        String[] result = new String[res.length+1];
        result[4] = res[0].substring(0,res[0].lastIndexOf("{"));
        for (int i = 0; i < lastIndex; i++) {
            result[i] = res[i].substring(res[i].lastIndexOf('=') + 1);
        }
        result[lastIndex] = res[lastIndex].substring(res[lastIndex].lastIndexOf('=') + 1, res[lastIndex].indexOf('}'));

        return result;
    }

}
