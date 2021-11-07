package by.test.kukjan.validator;


import by.task.kukjan.validator.ConeStringValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConeStringValidatorTest {
    private ConeStringValidator validator;

    @BeforeClass
    public void createValidator(){
        validator = new ConeStringValidator();
    }

    @DataProvider(name = "providerStringValidator")
    public Object[][] createData(){
        return new Object[][]{
                {"5 t gh h 3.6", false},
                {"5 h 2 1 2.9", false},
                {"7.5 3.7 5.0 9.3 1", true},
                {"6.6 1.2 -4 4.6 1.2", true},
                {"3.2 1.4 2.3 -1.1 -2", false},
                {"1 2 3 4 5", true},
        };
    }

    @Test(dataProvider =  "providerStringValidator")
    public void validateStringTest(String str, boolean expected){
        boolean actual = validator.isStringValid(str);
        Assert.assertEquals(actual, expected);
    }


}
