package by.task.kukjan.filler.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.filler.RepositoryFiller;
import by.task.kukjan.filler.WarehouseFiller;
import by.task.kukjan.repository.ConeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepositoryFillerImpl implements RepositoryFiller {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void fillConeRepository(Cone cone){
        ConeRepository repository = ConeRepository.getInstance();
        WarehouseFiller warehouseFiller = new WarehouseFillerImpl();

        repository.add(cone);
        warehouseFiller.fillConeWarehouse(cone);
    }
}
