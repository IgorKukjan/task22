package by.task.kukjan.filler.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.ConeParameters;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.filler.WarehouseFiller;
import by.task.kukjan.observer.ConeObserver;
import by.task.kukjan.observer.impl.ConeObserverImpl;
import by.task.kukjan.service.ConeCalculateService;
import by.task.kukjan.service.impl.ConeCalculateServiceImpl;
import by.task.kukjan.warehouse.ConeWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseFillerImpl implements WarehouseFiller {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void fillConeWarehouse(Cone cone){
        ConeWarehouse warehouse = ConeWarehouse.getInstance();
        ConeCalculateService service= new ConeCalculateServiceImpl();
        ConeObserver observer = new ConeObserverImpl();

        cone.attach(observer);
        try {
            double area = service.calculateArea(cone);
            double volume = service.calculateVolume(cone);
            ConeParameters param = new ConeParameters(area, volume);
            warehouse.putParameters(cone.getConeId(), param);
            logger.log(Level.INFO, "add to warehouse cone ", cone);
        } catch (ConeException e) {
            logger.log(Level.ERROR, "An attempt to fill warehouse with invalid cone ", cone);
        }
    }




}
