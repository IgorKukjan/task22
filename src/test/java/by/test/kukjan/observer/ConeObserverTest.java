package by.test.kukjan.observer;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.ConeParameters;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.observer.impl.ConeObserverImpl;
import by.task.kukjan.service.ConeCalculateService;
import by.task.kukjan.service.impl.ConeCalculateServiceImpl;
import by.task.kukjan.warehouse.ConeWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConeObserverTest {
    private Cone cone;
    private ConeWarehouse warehouse = ConeWarehouse.getInstance();

    @BeforeTest
    public void setUp() throws ConeException{
        cone = new Cone(new Point(0, 5, 0), 3,4 );
        cone.attach(new ConeObserverImpl());
        ConeCalculateService service = new ConeCalculateServiceImpl();
        double area = service.calculateArea(cone);
        double volume = service.calculateVolume(cone);
        ConeParameters coneParameters = new ConeParameters(area, volume);
        warehouse.putParameters(cone.getConeId(), coneParameters);
    }

    @Test
    public void testUpdateArea() throws ConeException{
        cone.setRadius(5);
        ConeCalculateService service = new ConeCalculateServiceImpl();
        double expectedArea = service.calculateArea(cone);
        ConeParameters param = warehouse.getParameters(cone.getConeId());
        double actualArea = param.getArea();
        Assert.assertEquals(expectedArea, actualArea);
    }

    @Test
    public void testUpdateVolume() throws ConeException{
        cone.setRadius(5);
        ConeCalculateService service = new ConeCalculateServiceImpl();
        double expectedVolume = service.calculateVolume(cone);
        ConeParameters param = warehouse.getParameters(cone.getConeId());
        double actualVolume = param.getVolume();
        Assert.assertEquals(expectedVolume, actualVolume);
    }

}
