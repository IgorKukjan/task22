package by.test.kukjan.factory;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.factory.ConeFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ConeFactoryTest {
    @DataProvider(name = "validData")
    public Object[][] createConeData() {
        return new Object[][] {
                {new double[]{1.0, 1.0, 0.0, 6.0, 4.0}, new Cone(new Point(1.0, 1.0, 0.0), 6.0, 4.0)},
                {new double[]{2.0, 3.0, 4.0, 7.0, 8.0}, new Cone(new Point(2.0, 3.0, 4.0), 7.0, 8.0)},
                {new double[]{2.0, 3.0, 4.0, 7.0, 8.0}, new Cone(new Point(2.0, 3.0, 4.0), 7.0, 8.0)}
        };
    }

    @Test(dataProvider = "validData")
    public void createCone(double[] parameters, Cone expected) throws ConeException {
        Cone actual = ConeFactory.createCone(parameters);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "validDataList")
    public Object[][] createConeDataList() {
        return new Object[][] {
                {Arrays.asList( new double[]{1.0, 1.0, 0.0, 6.0, 4.0}), Arrays.asList(new Cone(new Point(1.0, 1.0, 0.0), 6.0, 4.0))},
                {Arrays.asList( new double[]{2.0, 3.0, 4.0, 7.0, 2.0}), Arrays.asList(new Cone(new Point(2.0, 3.0, 4.0), 7.0, 2.0))}
        };
    }
}
