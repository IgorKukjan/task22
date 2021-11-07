package by.task.kukjan.validator;

import by.task.kukjan.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileNameValidator {
    static Logger logger = LogManager.getLogger(FileNameValidator.class);

    private static final FileNameValidator instance = new FileNameValidator();

    private FileNameValidator(){
    }

    public static FileNameValidator getInstance(){
        return instance;
    }

    public boolean validateFile(String path) throws ConeException {
        if(path == null){
            logger.error("The path equal to null");
            return false;
        }
        if(path.isBlank()){
            logger.error("The name of the path is empty");
            return false;
        }
        File file = new File(path);
        return file.exists() && file.length() > 0 && file.canRead() && file.isFile();
    }
}
