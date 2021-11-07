package by.test.kukjan.service;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.service.impl.ConeBaseCoordinateAxisImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeBaseCoordinateAxisTest {
    private ConeBaseCoordinateAxisImpl service;
    private Cone cone;

    @BeforeClass
    public void createBaseCoordinateAxis(){
        service = new ConeBaseCoordinateAxisImpl();
        cone = new Cone(new Point(5, 5, 0), 6, 8);
    }

    @Test
    public void testIsBaseOnCoordinateAxisXY()throws ConeException{
        boolean actual = service.isBaseOnCoordinateAxisXY(cone);
        assertTrue(actual);
    }

    @Test
    public void testIsBaseOnCoordinateAxisYZ()throws ConeException{
        boolean actual = service.isBaseOnCoordinateAxisYZ(cone);
        assertFalse(actual);
    }

    @Test
    public void testIsBaseOnCoordinateAxisXZ()throws ConeException{
        boolean actual = service.isBaseOnCoordinateAxisXZ(cone);
        assertFalse(actual);
    }
}
