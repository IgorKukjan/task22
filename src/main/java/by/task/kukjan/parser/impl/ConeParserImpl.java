package by.task.kukjan.parser.impl;

import by.task.kukjan.exception.ConeException;
import by.task.kukjan.parser.ConeParser;
import by.task.kukjan.validator.ConeStringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ConeParserImpl implements ConeParser {
    private final static Logger logger = LogManager.getLogger();

    private final String SPACE_REGEX = "\\s+";

    @Override
    public double[] parse(String data) throws ConeException{
        if(!ConeStringValidator.isStringValid(data)){
            logger.log(Level.ERROR, "wrong data "+data);
            throw new ConeException("wrong data " + data);
        }
        String[] lineElements = data.split(SPACE_REGEX);
        double[] array = new double[lineElements.length];
        for(int i = 0; i < lineElements.length; i++){
            array[i] = Double.parseDouble(lineElements[i]);
        }
        logger.log(Level.INFO, "Method parse returns " + Arrays.toString(array));
        return  array;
    }
}
