package by.task.kukjan.reader.impl;

import by.task.kukjan.exception.ConeException;

import by.task.kukjan.validator.ConeStringValidator;
import by.task.kukjan.validator.FileNameValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.task.kukjan.reader.ConeReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConeReaderImpl implements ConeReader {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFile(String filePathString) throws ConeException{
        Path path = Paths.get(filePathString);

        if(!Files.exists(path)){
            logger.log(Level.ERROR, "File " + filePathString + "was not found or is not available");
            throw new ConeException("File " + filePathString + "was not found or is not available");
        }
        List<String> arrayList = new ArrayList();

        try(Stream<String> lineStream = Files.lines(path)){
            FileNameValidator fileNameValidator = FileNameValidator.getInstance();
            arrayList = lineStream.collect(Collectors.toList());
        }catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file", filePathString);
            throw new ConeException("Error while reading file " + filePathString);
        }
        logger.log(Level.INFO, "Correct line was read in file:", filePathString);
        return arrayList;
    }


 }


















