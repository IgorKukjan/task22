package by.test.kukjan.reader;

import by.task.kukjan.exception.ConeException;
import by.task.kukjan.reader.impl.ConeReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeReaderImplTest {
    private ConeReaderImpl reader;

    @BeforeClass
    public void createReader(){
        reader = new ConeReaderImpl();
    }

    @Test
    public void readFileTest() throws ConeException {
        String path = "src\\test\\java\\resources\\file.txt";
        List<String> actual = reader.readFile(path);
        List<String> expected = new ArrayList<>();
        expected.add("5 t gh h 3.6");
        expected.add("5 h 2 1 2.9");
        expected.add("7.5 3.7 5.0 9.3 1");
        expected.add("6.6 1.2 -4 4.6 1.2");
        expected.add("3.2 1.4 2.3 -1.1 -2");
        expected.add("1 2 3 4 5");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ConeException.class)
    public void readNoFileTest() throws ConeException {
        reader.readFile("src\\test\\java\\resources\\noFile.txt");
    }
}
