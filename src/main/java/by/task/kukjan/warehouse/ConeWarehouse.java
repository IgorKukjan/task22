package by.task.kukjan.warehouse;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.ConeParameters;
import by.task.kukjan.exception.ConeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.HashMap;
import java.util.Map;


public class ConeWarehouse {
    private final static Logger logger = LogManager.getLogger();
    private static ConeWarehouse instance;

    private Map<Long, ConeParameters> warehouse;

    private ConeWarehouse(){
        warehouse = new HashMap<Long, ConeParameters>();
    }

    public static ConeWarehouse getInstance(){
        if(instance == null){
            instance = new ConeWarehouse();
        }
        return instance;
    }

    public ConeParameters putParameters(long coneId, ConeParameters param){
        return warehouse.put(coneId, param);
    }

    public ConeParameters getParameters(long coneId) throws ConeException {
        if(!warehouse.containsKey(coneId)){
            logger.log(Level.ERROR, "Warehouse does not contains cone with id ", coneId);
            throw new ConeException("Warehouse does not contains cone with id " + coneId);
        }
        return warehouse.get(coneId);
    }

    public ConeParameters removeParameters(long coneId){
        return warehouse.remove(coneId);
    }

    public void putAllParameters(Map<Long, ConeParameters> newConeMap){
        warehouse.putAll(newConeMap);
    }

    public boolean containsId(long coneId){
        return warehouse.containsKey(coneId);
    }

    public String toString(){
        return warehouse.toString() ;
    }

}
