package by.test.kukjan.service;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.service.impl.ConeCalculateServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeCalculateServiceImplTest {
    private ConeCalculateServiceImpl service;
    private Cone cone;

    @BeforeClass
    public void createCalculateService(){
        service = new ConeCalculateServiceImpl();
        cone = new Cone(new Point(5, 5, -4), 6, 8);
    }

    @Test
    public void testCalculateVolume()throws ConeException {
        double actual = service.calculateVolume(cone);
        double expected = 301.59289474462014;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateLateralSurfaceArea()throws ConeException {
        double actual = service.calculateLateralSurfaceArea(cone);
        double expected = 188.49555921538757;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateArea()throws ConeException {
        double actual = service.calculateArea(cone);
        double expected = 301.59289474462014;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolumeRatio()throws ConeException {
        double actual = service.calculateVolumeRatio(cone);
        double expected = 0.14285714285714285;
        Assert.assertEquals(actual, expected);
    }

}
