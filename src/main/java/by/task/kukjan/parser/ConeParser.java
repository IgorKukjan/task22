package by.task.kukjan.parser;

import by.task.kukjan.exception.ConeException;

public interface ConeParser {
    double[] parse(String data) throws ConeException;
}
