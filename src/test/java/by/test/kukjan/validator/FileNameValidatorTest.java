package by.test.kukjan.validator;

import by.task.kukjan.exception.ConeException;
import by.task.kukjan.validator.FileNameValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileNameValidatorTest {
    public FileNameValidator validator = FileNameValidator.getInstance();

    @Test
    public void fileExistsTest() throws ConeException {
        Assert.assertTrue(validator.validateFile("src\\test\\java\\resources\\file.txt"));
    }

    @Test
    public void fileNameEqualToNullTest() throws ConeException {
        Assert.assertFalse(validator.validateFile(null));
    }

    @Test
    public void pathIsEmptyTest() throws ConeException {
        Assert.assertFalse(validator.validateFile(""));
    }

}
