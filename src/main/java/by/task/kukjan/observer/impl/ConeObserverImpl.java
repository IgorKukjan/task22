package by.task.kukjan.observer.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.ConeParameters;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.observer.ConeEvent;
import by.task.kukjan.observer.ConeObserver;
import by.task.kukjan.service.ConeCalculateService;
import by.task.kukjan.service.impl.ConeCalculateServiceImpl;
import by.task.kukjan.warehouse.ConeWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserverImpl implements ConeObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(ConeEvent coneEvent) {
        ConeWarehouse warehouse = ConeWarehouse.getInstance();
        ConeCalculateService service = new ConeCalculateServiceImpl();
        Cone cone = coneEvent.getSource();

        try {
            double area = service.calculateArea(cone);
            double volume = service.calculateVolume(cone);
            ConeParameters parameters = new ConeParameters(area, volume);
            warehouse.putParameters(cone.getConeId(), parameters);
            logger.log(Level.INFO, "Parameters of the Cone has been update ", cone);
        } catch (ConeException e) {
            logger.log(Level.ERROR, "Parameters of the Cone has not been update ", cone);
        }
    }
}




















