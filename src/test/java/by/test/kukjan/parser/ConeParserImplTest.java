package by.test.kukjan.parser;


import by.task.kukjan.exception.ConeException;
import by.task.kukjan.parser.impl.ConeParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeParserImplTest {
    private  ConeParserImpl parser;

    @BeforeClass
   public void createParser(){
        parser = new ConeParserImpl();
    }

    @Test
    public void parseTest() throws ConeException {
        double[] actual = new double[]{4.9, -6.3, 5, 1.0, 2.1};
        double[] expected = parser.parse("4.9 -6.3 5 1.0 2.10");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ConeException.class)
        public void parseTestException() throws ConeException {
        double[] actual = new double[]{4.9, 6.3, 5, 1.0, 2.1};
        double[] expected = parser.parse("4.9 6.3 5c 1.0 2.10");
        Assert.assertEquals(actual, expected);
    }
}
