package by.task.kukjan.reader;

import by.task.kukjan.exception.ConeException;

import java.util.List;

public interface ConeReader {
    List<String> readFile(String filePathString) throws ConeException;
}
