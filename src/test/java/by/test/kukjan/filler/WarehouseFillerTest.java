package by.test.kukjan.filler;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.ConeParameters;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.filler.WarehouseFiller;
import by.task.kukjan.filler.impl.WarehouseFillerImpl;
import by.task.kukjan.repository.ConeRepository;
import by.task.kukjan.warehouse.ConeWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WarehouseFillerTest {
    private WarehouseFiller warehouseFiller;

    @BeforeMethod
    public void initialize(){
        warehouseFiller = new WarehouseFillerImpl();
    }

    @Test
    public void testFillConeWarehouse(){
        Cone cones = new Cone(new Point(1, 2, 3), 3, 4);

        warehouseFiller.fillConeWarehouse(cones);

        ConeWarehouse warehouse = ConeWarehouse.getInstance();


        try {
            ConeParameters actual = warehouse.getParameters(cones.getConeId());
            ConeParameters expected = new ConeParameters(75.39822368615503, 37.69911184307752);

            Assert.assertEquals(actual, expected);
        } catch (ConeException e) {
            e.printStackTrace();
        }

    }
}
