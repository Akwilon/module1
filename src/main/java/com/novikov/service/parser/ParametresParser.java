package com.novikov.service.parser;

import com.novikov.service.parser.exception.ParserException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ParametresParser {
    private static Logger logger = LogManager.getLogger(ParametresParser.class);

    public static List<String> parsePar(String string) throws ParserException {
        if (!string.matches("^[a\\-zA-Z0-9_]+( [a\\-zA-Z0-9_]+)*$")) {
            logger.error("Wrong string form " + string);
            throw new ParserException("Cannot parse input string!");
        }
        String[] split = string.split(" ");
        return Arrays.asList(split);
    }

    public static String parseLong(String string) throws ParserException {
        if (!string.matches("^\\d+$")) {
            logger.error("Wrong string form " + string);
            throw new ParserException("Cannot parse input string!");
        }
        return string;

    }
}
